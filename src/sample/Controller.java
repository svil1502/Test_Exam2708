package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.*;




//public class Controller implements Initializable {
    public class Controller {

    //первая таблица
    //
    @FXML
//    private TableView<Viborka> tableVopros;
    TableView<Viborka> tableVopros;

    @FXML
    TableColumn<Viborka, String> column_id;

    @FXML
    TableColumn<Viborka, String> column_textv;

    // вторая таблица
    @FXML
    TableView<ViborkaOtvet> tableOtvet;

    @FXML
    TableColumn<ViborkaOtvet, String> column_id_o;

    @FXML
    TableColumn<ViborkaOtvet, String> column_text;

    @FXML
    TableColumn<ViborkaOtvet, String> column_id_v;

    private ObservableList<ViborkaOtvet> id_v = FXCollections.observableArrayList();
    private ObservableList<ViborkaOtvet> id_o = FXCollections.observableArrayList();
    private ObservableList<ViborkaOtvet> text = FXCollections.observableArrayList();


    @FXML
    private Button btnLoad;
    private ObservableList<Viborka> data;
    private FirebirdConnection dc;
    private ObservableList<ViborkaOtvet> datao;
    private FirebirdConnection dco;




    @FXML
    private void loadDataFromDatabase(ActionEvent event) {
        try {
            Connection conn = dc.Connector();
            data = FXCollections.observableArrayList();

            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM vopros");
            while (rs.next()) {
                //get string from db,whichever way
                data.add(new Viborka(rs.getString(1), rs.getString(3)));
            }

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }




        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.

        column_id.setCellValueFactory(new PropertyValueFactory<>("idv"));
        column_textv.setCellValueFactory(new PropertyValueFactory<>("textv"));
    //    column_id_o.setCellValueFactory(new PropertyValueFactory<>("id_o"));
      //  column_text.setCellValueFactory(new PropertyValueFactory<>("text"));

        tableVopros.setItems(null);
        tableVopros.setItems(data);
    //    tableOtvet.setItems(null);
      //  tableOtvet.setItems(datao);

    }




        @FXML
        private void clickCatalogList(MouseEvent event) {
            try {

                Viborka selGroups = (Viborka)  tableVopros.getSelectionModel().getSelectedItem();
                showListChildrenCatalog(selGroups.getidv()); //это вызов нужной функции по заполнению и передача параметров в нее


            } catch (Exception e) {

            }

            tableOtvet.setItems(id_v); // дб внешний ключ?
        }


//заполняем вторую таблицу
   // private void showListChildrenCatalog(String thCatalog) { //Это сама функция заполнения таблицы.

private void showListChildrenCatalog(String thCatalog) {
    try {

        Connection conn = dco.Connector();
        datao = FXCollections.observableArrayList();
        ResultSet rs = conn.createStatement().executeQuery("SELECT ID_V, ID_O, TEXT FROM otvet where ID_V='" + thCatalog + "'");
        while (rs.next()) {
            //get string from db,whichever way
            datao.add(new ViborkaOtvet(rs.getString(2), rs.getString(4), rs.getString(6)));
        }

    } catch (SQLException ex) {
        System.err.println("Error" + ex);
    }
    column_id_v.setCellValueFactory(new PropertyValueFactory<>("id_v"));

    column_id_o.setCellValueFactory(new PropertyValueFactory<>("id_o"));
    column_text.setCellValueFactory(new PropertyValueFactory<>("text"));

    tableOtvet.setItems(null);
    tableOtvet.setItems(datao);


    }


}









