package edu.ib;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Jednostka_krwi {


    private StringProperty PESEL;
    private IntegerProperty jednostka_id;
    private IntegerProperty placowka_id;
    private StringProperty data_pobrania;
    private StringProperty grupaRh;
    private StringProperty status;

    public Jednostka_krwi() {

        PESEL = new SimpleStringProperty();
        PESEL = new SimpleStringProperty();
        jednostka_id = new SimpleIntegerProperty();
        placowka_id = new SimpleIntegerProperty();
        data_pobrania = new SimpleStringProperty();
        grupaRh = new SimpleStringProperty();
        status = new SimpleStringProperty();

    }

    public String getPESEL() {
        return PESEL.get();
    }

    public StringProperty PESELProperty() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL.set(PESEL);
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

    public int getPlacowka_id() {
        return placowka_id.get();
    }

    public IntegerProperty placowka_idProperty() {
        return placowka_id;
    }

    public void setPlacowka_id(int placowka_id) {
        this.placowka_id.set(placowka_id);
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

    public String getGrupaRh() {
        return grupaRh.get();
    }

    public StringProperty grupaRhProperty() {
        return grupaRh;
    }

    public void setGrupaRh(String grupaRh) {
        this.grupaRh.set(grupaRh);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
