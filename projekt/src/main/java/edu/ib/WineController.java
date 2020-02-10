//package edu.ib;
//
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//public class WineController {
//
//    @FXML // ResourceBundle that was given to the FXMLLoader
//    private ResourceBundle resources;
//
//    @FXML // URL location of the FXML file that was given to the FXMLLoader
//    private URL location;
//
//    @FXML // fx:id="userTextField"
//    private TextField userTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="passwordTextField"
//    private PasswordField passwordTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="connectButton"
//    private Button connectButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="disconnectButton"
//    private Button disconnectButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="consoleTextArea"
//    private Text consoleTextArea; // Value injected by FXMLLoader
//
//    @FXML // fx:id="wineNameToAddTextField"
//    private TextField jednostkaInsertTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="addWineButton"
//    private Button addWineButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="selectWineNameTextField"
//    private TextField selectWineNameTextField; // Value injected by FXMLLoader
//
//    @FXML // fx:id="selectWineButton"
//    private Button selectWineButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="showWinesButton"
//    private Button showWinesButton; // Value injected by FXMLLoader
//
//    @FXML // fx:id="wineTable"
//    private TableView wineTable; // Value injected by FXMLLoader
//
//    @FXML
//    private TableColumn<Jednostka_krwi, Integer> jednostka_idCol;
//
//    @FXML
//    private TableColumn<Jednostka_krwi, String> PESELCol;
//
//    @FXML
//    private TableColumn<Jednostka_krwi, Integer> placowka_idCol;
//
//    @FXML
//    private TableColumn<Jednostka_krwi, String> data_pobraniaCol;
//
//    @FXML
//    private TableColumn<Jednostka_krwi, String> grupaCol;
//
//    @FXML
//    private TableColumn<Jednostka_krwi, String> rhCol;
//
//    private DBUtil dbUtil;
//    private Jednostka_krwiDAO Jednostka_krwiDAO;
//
//    @FXML
//    void addWineButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        try {
//
//            if (!jednostkaInsertTextField.getText().equals(null)) {
//
//                Jednostka_krwiDAO.insertJednostka(jednostkaInsertTextField.getText(),1,"2020-01-19","0","+");
//                consoleTextArea.setText("Jednostka_krwi " + jednostkaInsertTextField.getText() + " inserted." + "\n");
//
//            }
//        } catch (SQLException e) {
//            consoleTextArea.setText("Error occurred while inserting Jednostka_krwi.\n");
//            throw e;
//        }
//
//    }
//
//    @FXML
//    void connectButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        dbUtil = new DBUtil(userTextField.getText(), passwordTextField.getText(), consoleTextArea);
//        Jednostka_krwiDAO = new Jednostka_krwiDAO(dbUtil, consoleTextArea);
//
//        dbUtil.dbConnect();
//
//        consoleTextArea.setText("Access granted for user \"" + userTextField.getText() + "\"." + "\n");
//        connectButton.setDisable(true);
//        disconnectButton.setDisable(false);
//        addWineButton.setDisable(false);
//        selectWineButton.setDisable(false);
//        showWinesButton.setDisable(false);
//
//        selectWineNameTextField.setDisable(false);
//        jednostkaInsertTextField.setDisable(false);
//
//    }
//
//    @FXML
//    void disconnectButtonPressed(ActionEvent event) throws SQLException {
//
//        dbUtil.dbDisconnect();
//        connectButton.setDisable(false);
//        disconnectButton.setDisable(true);
//        addWineButton.setDisable(true);
//        selectWineButton.setDisable(true);
//        showWinesButton.setDisable(true);
//        selectWineNameTextField.setDisable(true);
//        selectWineNameTextField.setText("");
//        selectWineNameTextField.setPromptText("Podaj nazwę");
//        jednostkaInsertTextField.setDisable(true);
//        jednostkaInsertTextField.setText("");
//        jednostkaInsertTextField.setPromptText("Podaj nazwę");
//        wineTable.getItems().clear();
//
//    }
//
//    @FXML
//    void selectWineButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        try {
//
//            if (!selectWineNameTextField.getText().equals(null)) {
//
//                wineTable.getItems().clear();
//                ObservableList<Jednostka_krwi> wineData = Jednostka_krwiDAO.znajdzJednostke("0","+");
//                populateWines(wineData);
////
//            }
//        } catch (SQLException e) {
//            consoleTextArea.setText("Error occurred while getting wines from DB.\n");
//            throw e;
//        }
//
//    }
//
//    @FXML
//    void showWinesButtonPressed(ActionEvent event) throws SQLException, ClassNotFoundException {
//
//        try {
//
//            wineTable.getItems().clear();
//            ObservableList<Jednostka_krwi> wineData = Jednostka_krwiDAO.pokazWszystkieJednostki();
//            populateWines(wineData);
//
//        } catch (SQLException e) {
//            consoleTextArea.setText("Error occurred while getting wines from DB.\n");
//            throw e;
//        }
//
//    }
//
//    private void populateWines(ObservableList<Jednostka_krwi> wineData) {
//        wineTable.setItems(wineData);
//    }
//
//
//    @FXML
//        // This method is called by the FXMLLoader when initialization is complete
//    void initialize() {
//        assert userTextField != null : "fx:id=\"userTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert connectButton != null : "fx:id=\"connectButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert disconnectButton != null : "fx:id=\"disconnectButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert consoleTextArea != null : "fx:id=\"consoleTextArea\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert jednostkaInsertTextField != null : "fx:id=\"jednostkaInsertTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert addWineButton != null : "fx:id=\"addWineButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert selectWineNameTextField != null : "fx:id=\"selectWineNameTextField\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert selectWineButton != null : "fx:id=\"selectWineButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert showWinesButton != null : "fx:id=\"showWinesButton\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert wineTable != null : "fx:id=\"wineTable\" was not injected: check your FXML file 'dbFX.fxml'.";
//
//        assert PESELCol != null : "fx:id=\"PESELCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert placowka_idCol != null : "fx:id=\"countryCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert data_pobraniaCol != null : "fx:id=\"colorCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//        assert grupaCol != null : "fx:id=\"sweetnessCol\" was not injected: check your FXML file 'dbFX.fxml'.";
//
//    }
//}