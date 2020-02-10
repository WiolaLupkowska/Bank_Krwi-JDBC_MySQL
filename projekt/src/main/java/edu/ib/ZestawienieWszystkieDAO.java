package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZestawienieWszystkieDAO {

     DBUtil dbUtil;

    public ZestawienieWszystkieDAO(DBUtil dbUtil) {
        this.dbUtil=dbUtil;
    }



    public ObservableList<ZestawienieWszystkie> pokazWszystkieJednostki() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM zestawienieWszystkie";
        try {
            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);
            ObservableList<ZestawienieWszystkie> jednostkiList = getJednostkiList(resultSet);
            return jednostkiList;
        } catch (SQLException e) {
            throw e;
        }
    }

    private ObservableList<ZestawienieWszystkie> getJednostkiList(ResultSet rs) throws SQLException {
        ObservableList<ZestawienieWszystkie> jednostkiList = FXCollections.observableArrayList();
        while (rs.next()) {
            ZestawienieWszystkie z = new ZestawienieWszystkie();
            z.setGrupaRh(rs.getString("grupaRh"));
            z.setLiczba(rs.getInt("liczba"));

            jednostkiList.add(z);
        }
        return jednostkiList;
    }
}
