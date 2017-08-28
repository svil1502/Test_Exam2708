package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Viborka {

    private final StringProperty idv;
    private final StringProperty textv;

    private final StringProperty id_o;
    private final StringProperty text;

        //Default constructor

        public Viborka(String idv, String textv, String id_o, String text) {

            this.idv = new SimpleStringProperty(idv);
            this.textv = new SimpleStringProperty(textv);

            this.id_o = new SimpleStringProperty(id_o);
            this.text = new SimpleStringProperty(text);


        }

        //Getters

        public String getidv() {
            return idv.get();
        }
        public String gettextv() {
            return textv.get();
        }

        public String getid_o() {
        return id_o.get();
    }
        public String gettext() {
        return text.get();
    }


        //Setters

        public void setid(String value) {
            idv.set(value);
        }
        public void settextv(String value) {
            textv.set(value);
        }

    public void setid_o(String value) {
        id_o.set(value);
    }
    public void settext(String value) {
        text.set(value);
    }



        //Property values
        public StringProperty id_oProperty() {
            return id_o;
        }
        public StringProperty textProperty() {
            return text;
        }



    }
