package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArchiwumDAO {

     DBUtil dbUtil;


    public ArchiwumDAO(DBUtil dbUtil) {
        this.dbUtil=dbUtil;

    }

    public ObservableList<Archiwum> pokazArchiwum() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM archiwum;";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Archiwum> jednostkiList = getJednostkiList(resultSet);

            return jednostkiList;


        } catch (SQLException e) {

            throw e;
        }

    }

    private ObservableList<Archiwum> getJednostkiList(ResultSet rs) throws SQLException {

        ObservableList<Archiwum> jednostkiList = FXCollections.observableArrayList();

        while (rs.next()) {
            Archiwum a = new Archiwum();
            a.setData_pobrania(rs.getString("data_pobrania"));
            a.setJednostka_id(rs.getInt("jednostka_id"));
            a.setPlacowka_ID(rs.getInt("placowka_ID"));
            jednostkiList.add(a);
        }

        return jednostkiList;
    }


    
}
