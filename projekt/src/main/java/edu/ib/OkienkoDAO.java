package edu.ib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OkienkoDAO {

     DBUtil dbUtil;


    public OkienkoDAO(DBUtil dbUtil) {
        this.dbUtil=dbUtil;

    }

    public ObservableList<Filia> pokazWszystkiePlacowki() throws SQLException, ClassNotFoundException {

        String selectStmt = "SELECT * FROM placowka;";

        try {

            ResultSet resultSet = dbUtil.dbExecuteQuery(selectStmt);

            ObservableList<Filia> filieList = getFilieList(resultSet);

            return filieList;


        } catch (SQLException e) {

            throw e;
        }

    }

    private ObservableList<Filia> getFilieList(ResultSet rs) throws SQLException {

        ObservableList<Filia> filieList = FXCollections.observableArrayList();

        while (rs.next()) {

//            String nazwa, String ulica; int placowka_id, int numer,String telefon, String strona;

            Filia f = new Filia();
            f.setNazwa(rs.getString("nazwa"));
            f.setMiasto(rs.getString("miasto"));
            f.setUlica(rs.getString("ulica"));
            f.setPlacowka_id(rs.getInt("placowka_id"));
            f.setNumer(rs.getString("numer"));
            f.setTelefon(rs.getString("telefon"));
            f.setStrona(rs.getString("strona"));

            filieList.add(f);
        }

        return filieList;
    }


    
}
