package edu.ib;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LogowanieController {


    String stop ="IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII";
    public DBUtil dbUtil;
    private Jednostka_krwiDAO jednostka_krwiDAO;
    private Clock clock;
    boolean connected;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text textWitamy;

    @FXML
    private TextField textFieldLogin;

    @FXML
    private TextField textFieldHaslo;

    @FXML
    private Button buttonPotwierdz;

    @FXML
    private Text textLogowanie;

    @FXML
    private Text textIII;

    @FXML
    private Text textWeryfikacja;

    @FXML
    private Button buttonPrzejdzDalej;


    @FXML
    private ImageView imageLewa;

    @FXML
    void buttonPrzejdzDalejPressed(ActionEvent event) {

        String filia = "filia";
        String centrala="centrala";

        if (textFieldLogin.getText().equals(filia)) {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("filia.fxml"), resources);
                Stage stage = new Stage();
                stage.setTitle("Filia");
                stage.setScene(new Scene(root, 450, 450));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (textFieldLogin.getText().equals(centrala)) {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getClassLoader().getResource("centrala.fxml"), resources);
                Stage stage = new Stage();
                stage.setTitle("Centrala");
                stage.setScene(new Scene(root, 648, 395));
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node) (event.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


//---------------------------------------------------------------------------------------------------------------
    @FXML
    void buttonPotwierdzPressed(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {


        dbUtil = new DBUtil(textFieldLogin.getText(), textFieldHaslo.getText(), buttonPrzejdzDalej);

        connected=dbUtil.dbConnect();
        System.out.println(connected);

        textWeryfikacja.setText("Weryfikacja");
        clock = new Clock(textIII,buttonPrzejdzDalej,connected);
        clock.start();















    }

    @FXML
    void initialize() {
        assert textWitamy != null : "fx:id=\"textWitamy\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert textFieldLogin != null : "fx:id=\"textFieldLogin\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert textFieldHaslo != null : "fx:id=\"textFieldHaslo\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert buttonPotwierdz != null : "fx:id=\"buttonPotwierdz\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert textLogowanie != null : "fx:id=\"textLogowanie\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert textIII != null : "fx:id=\"textIII\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert textWeryfikacja != null : "fx:id=\"textWeryfikacja\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert buttonPrzejdzDalej != null : "fx:id=\"buttonPrzejdzDalej\" was not injected: check your FXML file 'logowanie.fxml'.";
        assert imageLewa != null : "fx:id=\"imageLewa\" was not injected: check your FXML file 'logowanie.fxml'.";



    }



}
