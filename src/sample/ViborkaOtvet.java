package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by svetlanailina on 29.08.17.
 */
public class ViborkaOtvet {



        private final StringProperty id_o;
        //private final StringProperty id_v;
        private final StringProperty text;
    private final StringProperty id_v;


        //Default constructor

        public ViborkaOtvet(String id_o, String text, String id_v) {

            this.id_o = new SimpleStringProperty(id_o);
            this.text = new SimpleStringProperty(text);
            this.id_v = new SimpleStringProperty(id_v);


        }

        //Getters

        public String getid_o() {
            return id_o.get();
        }
        public String gettext() {
            return text.get();
        }
        public String getid_v() {
        return id_v.get();
    }


        //Setters

        public void setid_o(String value) {
            id_o.set(value);
        }
        public void settext(String value) {
            text.set(value);
        }
        public void setid_v(String value) {
        id_v.set(value);
    }


        //Property values

        public StringProperty id_oProperty() {return id_o;}
        public StringProperty textProperty() {
            return text;
        }
        public StringProperty id_vProperty() {return id_v;}


    }

