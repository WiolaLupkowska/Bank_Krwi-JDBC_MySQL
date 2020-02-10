package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DawcaDAO {

     DBUtil dbUtil;


    public DawcaDAO(DBUtil dbUtil) {
        this.dbUtil=dbUtil;

    }






    public void insertDawca(String PESEL,String imie,String nazwisko,String miejscowosc,String kod_pocztowy,int nr_domu, int nr_lokalu,int waga,String telefon,String ulica) throws SQLException, ClassNotFoundException {


        //StringBuilder sb = new StringBuilder("INSERT INTO dawca (PESEL,imię,nazwisko,miejscowość,kod_pocztowy,nr_domu,nr_lokalu,waga,telefon,ulica) VALUES('");

        StringBuilder sb = new StringBuilder("INSERT INTO dawca (PESEL,imię,nazwisko,miejscowość,kod_pocztowy,nr_domu,nr_lokalu,waga,telefon,ulica) VALUES('");
        sb.append(PESEL);
        sb.append("','");
        sb.append(imie);
        sb.append("','");
        sb.append(nazwisko);
        sb.append("','");
        sb.append(miejscowosc);
        sb.append("','");
        sb.append(kod_pocztowy);
        sb.append("',");
        sb.append(nr_domu);
        sb.append(",");
        sb.append(nr_lokalu);
        sb.append(",");
        sb.append(waga);
        sb.append(",'");
        sb.append(telefon);
        sb.append("','");
        sb.append(ulica);
        sb.append("');");
        System.out.println(sb);
        String insertStmt = sb.toString();

        try {

            dbUtil.dbExecuteUpdate(insertStmt);


        } catch (SQLException e) {

            throw e;
        }

    }



    public void transfuzjaJednostka(String grupa,String rh,int placowka_id) throws SQLException, ClassNotFoundException {


        StringBuilder sb = new StringBuilder("DELETE jednostka_krwi WHERE grupa='");
        sb.append(grupa);
        sb.append("' AND ");
        sb.append(rh);
        sb.append("='");
        sb.append(rh);
        sb.append("' AND placowka_id=");
        sb.append(placowka_id);
        sb.append(" ORDER BY data_pobrania ASC LIMIT 1;");

        System.out.println(sb);
        String insertStmt = sb.toString();

        try {

            dbUtil.dbExecuteUpdate(insertStmt);


        } catch (SQLException e) {

            throw e;
        }

    }

}
