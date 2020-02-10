package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Jednostka_krwiDAO {

     DBUtil dbUtil;

    public Jednostka_krwiDAO(DBUtil dbUtil) {
        this.dbUtil=dbUtil;
    }

    public void insertJednostka(String PESEL,int placowka_id, String data_pobrania,String grupaRh) throws SQLException, ClassNotFoundException {
        //StringBuilder sb = new StringBuilder("INSERT INTO jednostka_krwi (PESEL,placowka_id,data_pobrania,grupa,rh) VALUES('");
        //call dodaj('87062300576',6,'2020-02-02','B','-');
        StringBuilder sb = new StringBuilder("call dodajJednostke('");
        sb.append(PESEL);
        sb.append("',");
        sb.append(placowka_id);
        sb.append(",'");
        sb.append(data_pobrania);
        sb.append("','");
        sb.append(grupaRh);
        sb.append("');");
        System.out.println(sb);
        String insertStmt = sb.toString();

        try {
            dbUtil.dbExecuteUpdate(insertStmt);
        } catch (SQLException e) {
            throw e;
        }
    }


    public ObservableList<Jednostka_krwi> znajdzJednostke(String grupaRh, int placowka_id) throws SQLException, ClassNotFoundException {

        StringBuilder sb = new StringBuilder("SELECT * FROM jednostka_krwi WHERE (grupaRh='");
        sb.append(grupaRh);
        sb.append("' and placowka_id=");
        sb.append(placowka_id);
        sb.append(");");
        System.out.println(sb);
        String selectStmt = sb.toString();

        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<Jednostka_krwi> jednostkiList = getJednostkiList(resultSet);
            return jednostkiList;
        } catch (SQLException e) {
            throw e;
        }

    }

    public ObservableList<Jednostka_krwi> pokazWszystkieJednostki() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM zestawienieWszystkie";
        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<Jednostka_krwi> jednostkiList = getJednostkiList(resultSet);
            return jednostkiList;
        } catch (SQLException e) {
            throw e;
        }
    }

    private ObservableList<Jednostka_krwi> getJednostkiList(ResultSet rs) throws SQLException {
        ObservableList<Jednostka_krwi> jednostkiList = FXCollections.observableArrayList();
        while (rs.next()) {
            Jednostka_krwi d = new Jednostka_krwi();
            d.setPESEL(rs.getString("PESEL"));
            d.setJednostka_id(rs.getInt("jednostka_id"));
            d.setPlacowka_id(rs.getInt("placowka_id"));
            d.setData_pobrania(rs.getString("data_pobrania"));
            d.setGrupaRh(rs.getString("grupaRh"));

            jednostkiList.add(d);
        }
        return jednostkiList;
    }


    public void transfuzja(String grupaRh) throws SQLException, ClassNotFoundException {

        StringBuilder sb = new StringBuilder("call transfuzja('");
        sb.append(grupaRh);
        sb.append("');");
        System.out.println(sb);
        String insertStmt = sb.toString();

        try {
            dbUtil.dbExecuteUpdate(insertStmt);
        } catch (SQLException e) {
            throw e;
        }
    }




    public void sprawdzZdatnosc() throws SQLException, ClassNotFoundException {

        StringBuilder sb = new StringBuilder("call sprawdzZdatnosc;");

        System.out.println(sb);
        String insertStmt = sb.toString();

        try {
            dbUtil.dbExecuteUpdate(insertStmt);
        } catch (SQLException e) {
            throw e;
        }
    }
}
