package edu.ib;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Archiwum {

    private StringProperty data_pobrania;
    private IntegerProperty jednostka_id;
    private IntegerProperty placowka_ID;

    public Archiwum() {

        data_pobrania = new SimpleStringProperty();
        placowka_ID = new SimpleIntegerProperty();
        jednostka_id = new SimpleIntegerProperty();


    }

    public String getData_pobrania() {
        return data_pobrania.get();
    }

    public StringProperty data_pobraniaProperty() {
        return data_pobrania;
    }

    public void setData_pobrania(String data_pobrania) {
        this.data_pobrania.set(data_pobrania);
    }

    public int getJednostka_id() {
        return jednostka_id.get();
    }

    public IntegerProperty jednostka_idProperty() {
        return jednostka_id;
    }

    public void setJednostka_id(int jednostka_id) {
        this.jednostka_id.set(jednostka_id);
    }

    public int getPlacowka_ID() {
        return placowka_ID.get();
    }

    public IntegerProperty placowka_IDProperty() {
        return placowka_ID;
    }

    public void setPlacowka_ID(int placowka_ID) {
        this.placowka_ID.set(placowka_ID);
    }
}
