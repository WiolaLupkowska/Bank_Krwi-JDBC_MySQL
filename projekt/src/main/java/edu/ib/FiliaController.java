package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class FiliaController {

    private DBUtil dbUtilFilia;
    private Jednostka_krwiDAO jednostka_krwiDAO;
    private ZestawienieWszystkieDAO zestawienieWszystkieDAO;
    String grupaRh;
    int placowka;

    ObservableList listGrupaKrwiRh = FXCollections.observableArrayList( "A+","A-","B+","B-","AB+","AB-","0+","0-");
    ObservableList listNrPlacowki = FXCollections.observableArrayList(1,2,3,4,5,6,7);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<?, ?> col_Id_parametry;

    @FXML
    private TableColumn<?, ?> col_pesel_parametry;

    @FXML
    private TableColumn<?, ?> col_data_parametry;

    @FXML
    private TableColumn<?, ?> col_grupaRh_parametry;

    @FXML
    private TableColumn<?, ?> col_liczbaJednostek_wszystkie;

    @FXML
    private TableColumn<?, ?> col_grupaRh_wszystkie;


    @FXML
    private TableView<Jednostka_krwi> tableZestawienieParametry;

    @FXML
    private TableView<ZestawienieWszystkie> tableZestawienieWszystkich;

    @FXML
    private ChoiceBox<Integer> choiceBoxNrPlacowki;

    @FXML
    private ChoiceBox<String> choiceBoxGrupaKrwiRh;


    @FXML
    private Button buttonZestawienieParametry;

    @FXML
    private Button buttonPobierzDoTransfuzji;

    @FXML
    private Button buttonZestawienieWszystkie;



    private void zapelnijJednoskiParametry(ObservableList<Jednostka_krwi> jednostkiParametryData) {
        this.tableZestawienieParametry.setItems(jednostkiParametryData);
    }

    private void zapelnijJednoskiWszystkie(ObservableList<ZestawienieWszystkie> jednostkiWszystkieData) {
        this.tableZestawienieWszystkich.setItems(jednostkiWszystkieData);
    }


    @FXML
    private Button buttonArchiwum;

    @FXML
    void buttonArchiwumPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("archiwum.fxml"),resources);
            Stage stage = new Stage();

            stage.setTitle("Archiwum");
            stage.setScene(new Scene(root, 370, 214));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void buttonPobierzDoTransfuzjiPressed(ActionEvent event) throws SQLException, ClassNotFoundException {

        grupaRh=choiceBoxGrupaKrwiRh.getValue();
        jednostka_krwiDAO.transfuzja(grupaRh);
    }


    @FXML
    void buttonZestawienieWszystkiePressed(ActionEvent event) throws SQLException, ClassNotFoundException {

        jednostka_krwiDAO.sprawdzZdatnosc();
        tableZestawienieWszystkich.getItems().clear();
        ObservableList<ZestawienieWszystkie> jednostkiWszystkieData = zestawienieWszystkieDAO.pokazWszystkieJednostki();
        zapelnijJednoskiWszystkie(jednostkiWszystkieData);
    }


    @FXML
    void buttonZestawienieParametryPressed(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        grupaRh=choiceBoxGrupaKrwiRh.getValue();
        placowka=choiceBoxNrPlacowki.getValue();

        jednostka_krwiDAO.sprawdzZdatnosc();
        tableZestawienieParametry.getItems().clear();
        ObservableList<Jednostka_krwi> jednostkiParametryData = jednostka_krwiDAO.znajdzJednostke(grupaRh, placowka);
        zapelnijJednoskiParametry(jednostkiParametryData);
    }

    @FXML
    void initialize() {

        dbUtilFilia= new DBUtil("filia","filia");
        jednostka_krwiDAO=new Jednostka_krwiDAO(dbUtilFilia);
        zestawienieWszystkieDAO=new ZestawienieWszystkieDAO(dbUtilFilia);

        assert tableZestawienieParametry != null : "fx:id=\"tableZestawienieParametry\" was not injected: check your FXML file 'filia.fxml'.";
        assert tableZestawienieWszystkich != null : "fx:id=\"tableZestawienieWszystkich\" was not injected: check your FXML file 'filia.fxml'.";
        assert choiceBoxNrPlacowki != null : "fx:id=\"choiceBoxNrPlacowki\" was not injected: check your FXML file 'filia.fxml'.";
        assert choiceBoxGrupaKrwiRh != null : "fx:id=\"choiceBoxGrupaKrwiRh\" was not injected: check your FXML file 'filia.fxml'.";
        assert buttonZestawienieParametry != null : "fx:id=\"buttonZestawienieParametry\" was not injected: check your FXML file 'filia.fxml'.";
        assert buttonPobierzDoTransfuzji != null : "fx:id=\"buttonPobierzDoTransfuzji\" was not injected: check your FXML file 'filia.fxml'.";
        assert buttonZestawienieWszystkie != null : "fx:id=\"buttonZestawienieWszystkie\" was not injected: check your FXML file 'filia.fxml'.";
        assert buttonArchiwum != null : "fx:id=\"buttonArchiwum\" was not injected: check your FXML file 'filia.fxml'.";

        choiceBoxGrupaKrwiRh.setItems(listGrupaKrwiRh);
        choiceBoxNrPlacowki.setItems(listNrPlacowki);

    }



}
