package edu.ib;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Dawca {


    private StringProperty PESEL;
    private StringProperty imie;
    private StringProperty nazwisko;
    private StringProperty miejscowosc;
    private StringProperty kodPocztowy;
    private IntegerProperty nrDomu;
    private IntegerProperty nrLokalu;
    private IntegerProperty waga;
    private StringProperty telefon;
    private StringProperty ulica;

    public Dawca() {

        PESEL = new SimpleStringProperty();
        nrDomu = new SimpleIntegerProperty();
        nrLokalu = new SimpleIntegerProperty();
        waga = new SimpleIntegerProperty();
        telefon = new SimpleStringProperty();
        imie = new SimpleStringProperty();
        nazwisko = new SimpleStringProperty();
        miejscowosc = new SimpleStringProperty();
        kodPocztowy = new SimpleStringProperty();
        ulica = new SimpleStringProperty();
        miejscowosc = new SimpleStringProperty();

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

    public String getImie() {
        return imie.get();
    }

    public StringProperty imieProperty() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie.set(imie);
    }

    public String getNazwisko() {
        return nazwisko.get();
    }

    public StringProperty nazwiskoProperty() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko.set(nazwisko);
    }

    public String getMiejscowosc() {
        return miejscowosc.get();
    }

    public StringProperty miejscowoscProperty() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc.set(miejscowosc);
    }

    public String getKodPocztowy() {
        return kodPocztowy.get();
    }

    public StringProperty kodPocztowyProperty() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy.set(kodPocztowy);
    }

    public int getNrDomu() {
        return nrDomu.get();
    }

    public IntegerProperty nrDomuProperty() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu.set(nrDomu);
    }

    public int getNrLokalu() {
        return nrLokalu.get();
    }

    public IntegerProperty nrLokaluProperty() {
        return nrLokalu;
    }

    public void setNrLokalu(int nrLokalu) {
        this.nrLokalu.set(nrLokalu);
    }

    public int getWaga() {
        return waga.get();
    }

    public IntegerProperty wagaProperty() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga.set(waga);
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

    public String getUlica() {
        return ulica.get();
    }

    public StringProperty ulicaProperty() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica.set(ulica);
    }
}
