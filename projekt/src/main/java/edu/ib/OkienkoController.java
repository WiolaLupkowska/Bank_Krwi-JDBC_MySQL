package edu.ib;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OkienkoController {

    private DBUtil dbUtilOkienko;
    private OkienkoDAO okienkoDAO;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Filia> tableFilie;

    @FXML
    private TableColumn<?, ?> placowka_idCol;

    @FXML
    private TableColumn<?, ?> nazwaCol;

    @FXML
    private TableColumn<?, ?> ulicaCol;

    @FXML
    private TableColumn<?, ?> numerCol;

    @FXML
    private TableColumn<?, ?> miastoCol;

    @FXML
    private TableColumn<?, ?> telefonCol;

    @FXML
    private TableColumn<?, ?> stronaCol;


    private void zapelnijFilie(ObservableList<Filia> filieData) {
        this.tableFilie.setItems(filieData);
    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {




        assert tableFilie != null : "fx:id=\"tableFilie\" was not injected: check your FXML file 'okienko.fxml'.";
        assert placowka_idCol != null : "fx:id=\"placowka_idCol\" was not injected: check your FXML file 'okienko.fxml'.";
        assert nazwaCol != null : "fx:id=\"nazwaCol\" was not injected: check your FXML file 'okienko.fxml'.";
        assert ulicaCol != null : "fx:id=\"ulicaCol\" was not injected: check your FXML file 'okienko.fxml'.";
        assert numerCol != null : "fx:id=\"numerCol\" was not injected: check your FXML file 'okienko.fxml'.";
        assert miastoCol != null : "fx:id=\"miastoCol\" was not injected: check your FXML file 'okienko.fxml'.";
        assert telefonCol != null : "fx:id=\"telefonCol\" was not injected: check your FXML file 'okienko.fxml'.";
        assert stronaCol != null : "fx:id=\"stronaCol\" was not injected: check your FXML file 'okienko.fxml'.";

        dbUtilOkienko= new DBUtil("centrala","centrala");
        okienkoDAO=new OkienkoDAO(dbUtilOkienko);
        //tableFilie.getItems().clear();
        ObservableList<Filia> filieData = okienkoDAO.pokazWszystkiePlacowki();
        zapelnijFilie(filieData);
        System.out.println(filieData);



    }
}
