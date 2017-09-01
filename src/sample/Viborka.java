package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Viborka {

    private final StringProperty idv;
    private final StringProperty textv;


        //Default constructor

        public Viborka(String idv, String textv) {

            this.idv = new SimpleStringProperty(idv);
            this.textv = new SimpleStringProperty(textv);



        }

        //Getters

        public String getidv() {
            return idv.get();
        }
        public String gettextv() {
            return textv.get();
        }



        //Setters

        public void setidv(String value) {
            idv.set(value);
        }
        public void settextv(String value) {
            textv.set(value);
        }



        //Property values

    public StringProperty idvProperty() {return idv;}
    public StringProperty textvProperty() {
        return textv;
    }



    }
