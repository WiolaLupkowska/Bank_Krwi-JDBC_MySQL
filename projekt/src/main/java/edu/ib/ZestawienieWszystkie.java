package edu.ib;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ZestawienieWszystkie {

    private StringProperty grupaRh;
    private IntegerProperty liczba;


    public ZestawienieWszystkie() {

        grupaRh = new SimpleStringProperty();
        liczba = new SimpleIntegerProperty();

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

    public int getLiczba() {
        return liczba.get();
    }

    public IntegerProperty liczbaProperty() {
        return liczba;
    }

    public void setLiczba(int liczba) {
        this.liczba.set(liczba);
    }
}