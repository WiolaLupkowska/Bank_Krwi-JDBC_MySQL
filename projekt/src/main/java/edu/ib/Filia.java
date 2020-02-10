package edu.ib;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Filia {

    private StringProperty nazwa;
    private StringProperty ulica;
    private StringProperty miasto;
    private IntegerProperty placowka_id;
    private StringProperty numer;
    private StringProperty telefon;
    private StringProperty strona;

    public Filia() {

        nazwa = new SimpleStringProperty();
        placowka_id = new SimpleIntegerProperty();
        numer = new SimpleStringProperty();
        telefon = new SimpleStringProperty();
        miasto = new SimpleStringProperty();
        strona = new SimpleStringProperty();
        ulica = new SimpleStringProperty();

    }

    public String getNazwa() {
        return nazwa.get();
    }

    public StringProperty nazwaProperty() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa.set(nazwa);
    }

    public String getUlica() {
        return ulica.get();
    }

    public StringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }

    public String getMiasto() {
        return miasto.get();
    }

    public StringProperty miastoProperty() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto.set(miasto);
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

    public String getNumer() {
        return numer.get();
    }

    public StringProperty numerProperty() {
        return numer;
    }

    public void setNumer(String numer) {
        this.numer.set(numer);
    }

    public String getTelefon() {
        return telefon.get();
    }

    public StringProperty telefonProperty() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon.set(telefon);
    }

    public String getStrona() {
        return strona.get();
    }

    public StringProperty stronaProperty() {
        return strona;
    }

    public void setStrona(String strona) {
        this.strona.set(strona);
    }
}