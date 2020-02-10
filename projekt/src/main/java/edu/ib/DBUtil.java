package edu.ib;


import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.sql.*;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;


public class DBUtil {

    private String userName;
    private String userPassword;
    private Button button;
    boolean connected;


    private Connection conn = null;

    public DBUtil(String userName, String userPassword, Button button) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.button = button;

    }

    public DBUtil(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;

    }

    public DBUtil() {
    }

    public boolean dbConnect() throws SQLException, ClassNotFoundException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            this.connected=false;

        }

        try {
            conn = DriverManager.getConnection(createURL());
            this.connected=true;

        } catch (SQLException e) {
            this.connected=false;

        }
        return connected;

    }

    public void dbDisconnect() throws SQLException {

        try {

            if (conn != null && !conn.isClosed()) {

                conn.close();


            }
        } catch (Exception e) {
            throw e;
        }
    }

    private String createURL() {

        StringBuilder urlSB = new StringBuilder("jdbc:mysql://");
        urlSB.append("localhost:3306/");
        urlSB.append("bank?");
        urlSB.append("useUnicode=true&characterEncoding=utf-8");
        urlSB.append("&user=");
        urlSB.append(userName);
        urlSB.append("&password=");
        urlSB.append(userPassword);
        urlSB.append("&serverTimezone=CET");

        return urlSB.toString();
    }

    public ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {

        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet crs;
        //CachedRowSetImpl crs;

        try {

            dbConnect();

            stmt = conn.prepareStatement(queryStmt);

            resultSet = stmt.executeQuery(queryStmt);

            crs = new CachedRowSetWrapper();
            //crs = new CachedRowSetImpl();

            crs.populate(resultSet);
        } catch (SQLException e) {
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }

        return crs;
    }

    public  void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {

        Statement stmt = null;
        try {
            dbConnect();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt);

        } catch (SQLException e) {

            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
    }

}
