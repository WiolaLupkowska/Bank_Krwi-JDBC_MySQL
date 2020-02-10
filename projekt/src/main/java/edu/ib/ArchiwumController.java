package edu.ib;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ArchiwumController {


    private DBUtil dbUtilArchiwum;
    private ArchiwumDAO archiwumDAO;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Archiwum> tableArchiwum;

    @FXML
    private TableColumn<?, ?> col_jednostka;

    @FXML
    private TableColumn<?, ?> col_placowka;

    @FXML
    private TableColumn<?, ?> col_data_pobrania;

    private void zapelnijArchiwum(ObservableList<Archiwum> archiwumData) {
        this.tableArchiwum.setItems(archiwumData);
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        assert tableArchiwum != null : "fx:id=\"tableArchiwum\" was not injected: check your FXML file 'archiwum.fxml'.";
        assert col_jednostka != null : "fx:id=\"col_jednostka\" was not injected: check your FXML file 'archiwum.fxml'.";
        assert col_placowka != null : "fx:id=\"col_placowka\" was not injected: check your FXML file 'archiwum.fxml'.";
        assert col_data_pobrania != null : "fx:id=\"col_data_pobrania\" was not injected: check your FXML file 'archiwum.fxml'.";

        dbUtilArchiwum= new DBUtil("filia","filia");
        archiwumDAO=new ArchiwumDAO(dbUtilArchiwum);
        //tableFilie.getItems().clear();
        ObservableList<Archiwum> archiwumData = archiwumDAO.pokazArchiwum();
        zapelnijArchiwum(archiwumData);



    }
}
