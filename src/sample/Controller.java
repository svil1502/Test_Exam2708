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

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;








//public class Controller implements Initializable {
    public class Controller  {
    // public LoginModel LoginModel = new LoginModel();

    //   @FXML
    //   private Label isConnected;

    @FXML
    private TableView<Viborka> tableVopros;

    @FXML
    private TableColumn<Viborka, String> column_id;

    @FXML
    private TableColumn<Viborka, String> column_textv;


    @FXML
    private TableView<Viborka> tableOtvet;

    @FXML
    private TableColumn<Viborka, String> column_id_o;

    @FXML
    private TableColumn<Viborka, String> column_text;





    @FXML
    private Button btnLoad;

    private ObservableList<Viborka> data;
    private ObservableList<Viborka> data2;

    private FirebirdConnection dc;
    private FirebirdConnection dc2;

/*
    @Override

    public void initialize(URL location, ResourceBundle resources) {

        if (LoginModel.isDbConnected()) {
            isConnected.setText("Connected");
        } else {
            isConnected.setText("Not Connected");


        }
    }
*/

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

        try {
            Connection conn2 = dc2.Connector();
            data2 = FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs2 = conn2.createStatement().executeQuery("SELECT * FROM otvet");
            while (rs2.next()) {
                //get string from db,whichever way
                data2.add(new Viborka(rs2.getString(4), rs2.getString(6)));
            }

        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }

        //Set cell value factory to tableview.
        //NB.PropertyValue Factory must be the same with the one set in model class.

        column_id.setCellValueFactory(new PropertyValueFactory<>("idv"));
        column_textv.setCellValueFactory(new PropertyValueFactory<>("textv"));

        column_id_o.setCellValueFactory(new PropertyValueFactory<>("id_o"));
        column_text.setCellValueFactory(new PropertyValueFactory<>("text"));

        tableVopros.setItems(null);
        tableVopros.setItems(data);

        tableOtvet.setItems(null);
        tableOtvet.setItems(data2);

    }



}
