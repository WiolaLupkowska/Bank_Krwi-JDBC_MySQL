package edu.ib;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CentralaController{

    private DBUtil dbUtilCentrala;
    private Jednostka_krwiDAO jednostka_krwiDAO;
    private DawcaDAO dawcaDAO;


    ObservableList listGrupaKrwi = FXCollections.observableArrayList( "A+","A-","B+","B-","AB+","AB-","0+","0-");
    ObservableList listNrPlacowki = FXCollections.observableArrayList(1,2,3,4,5,6,7);


    private String imie;
    private String nazwisko;
    private String PESEL;
    private String miasto;
    private int nrDomu;
    private int nrLokalu;
    private String kodPocztowy;
    private String telefon;
    private String ulica;
    private int waga;
    private String dataPobrania;
    private int nrPlacowki;
    private String grupaRh;




    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField tekstPESEL;

    @FXML
    private DatePicker datePickerDataPobrania;


    @FXML
    private ChoiceBox<String> choiceBoxGrupaKrwiRh;

    @FXML
    private TextField tekstImie;

    @FXML
    private TextField tekstNazwisko;

    @FXML
    private TextField tekstNrDomu;

    @FXML
    private TextField tekstMiasto;

    @FXML
    private TextField tekstWaga;

    @FXML
    private TextField tekstNrLokalu;

    @FXML
    private TextField tekstUlica;

    @FXML
    private TextField tekstTelefon;

    @FXML
    private TextField tekstKodPocztowy;

    @FXML
    private Button buttonDodajJednostkeKrwi;

    @FXML
    private ChoiceBox<Integer> choiceBoxNrPlacowki;

    @FXML
    private Text textWynikDodania;

    @FXML
    private Button buttonPokazPlacowki;

    @FXML
    private ChoiceBox<?> choiceBoxWybierzParametr;

    @FXML
    void buttonPokazPlacowkiPressed(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("okienko.fxml"), resources);
            Stage stage = new Stage();

            stage.setTitle("Dostępne placówki obsługiwane przez bank.");
            stage.setScene(new Scene(root, 738, 214));
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    void buttonDodajJednostkePressed(ActionEvent event) throws SQLException, ClassNotFoundException {

        PESEL=tekstPESEL.getText();
        imie=tekstImie.getText();
        nazwisko=tekstNazwisko.getText();
        miasto=tekstMiasto.getText();
        nrDomu= Integer.parseInt(tekstNrDomu.getText());
        nrLokalu = Integer.parseInt(tekstNrLokalu.getText());
        kodPocztowy = tekstKodPocztowy.getText();
        telefon = tekstTelefon.getText();
        ulica = tekstUlica.getText();
        waga = Integer.parseInt(tekstWaga.getText());
        nrPlacowki = choiceBoxNrPlacowki.getValue();
        dataPobrania=datePickerDataPobrania.getValue().toString();
        System.out.println(dataPobrania);
        grupaRh=choiceBoxGrupaKrwiRh.getValue();


        if( PESEL!=null && imie!=null && nazwisko != null &&
                miasto!= null && nrDomu!=0 &&  nrLokalu!=0 &&
                kodPocztowy !=null &&telefon!=null &&ulica!=null&&
                waga!=0 && nrPlacowki!=0 && dataPobrania!=null &&
                grupaRh!= null) {

            dawcaDAO.insertDawca(PESEL,imie,nazwisko,miasto,kodPocztowy,nrDomu,nrLokalu,waga,telefon,ulica);
            jednostka_krwiDAO.insertJednostka(PESEL, nrPlacowki, dataPobrania, grupaRh);
            textWynikDodania.setText("Dodano.");
            System.out.println(jednostka_krwiDAO.dbUtil+" tutaj");
        }else{
            textWynikDodania.setText("Błąd.");
        }



    }


    @FXML
    void initialize() {
        assert tekstPESEL != null : "fx:id=\"tekstPESEL\" was not injected: check your FXML file 'centrala.fxml'.";
        assert datePickerDataPobrania != null : "fx:id=\"datePickerDataPobrania\" was not injected: check your FXML file 'centrala.fxml'.";
        assert choiceBoxGrupaKrwiRh != null : "fx:id=\"choiceBoxGrupaKrwi\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstImie != null : "fx:id=\"tekstImie\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstNazwisko != null : "fx:id=\"tekstNazwisko\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstNrDomu != null : "fx:id=\"tekstNrDomu\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstMiasto != null : "fx:id=\"tekstMiasto\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstWaga != null : "fx:id=\"tekstWaga\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstNrLokalu != null : "fx:id=\"tekstNrLokalu\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstUlica != null : "fx:id=\"tekstUlica\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstTelefon != null : "fx:id=\"tekstTelefon\" was not injected: check your FXML file 'centrala.fxml'.";
        assert tekstKodPocztowy != null : "fx:id=\"tekstKodPocztowy\" was not injected: check your FXML file 'centrala.fxml'.";
        assert buttonDodajJednostkeKrwi != null : "fx:id=\"buttonDodajJednostkeKrwi\" was not injected: check your FXML file 'centrala.fxml'.";
        assert choiceBoxNrPlacowki != null : "fx:id=\"choiceBoxNrPlacowki\" was not injected: check your FXML file 'centrala.fxml'.";
        assert buttonPokazPlacowki != null : "fx:id=\"buttonPokazPlacowki\" was not injected: check your FXML file 'centrala.fxml'.";

        choiceBoxGrupaKrwiRh.setItems(listGrupaKrwi);
        choiceBoxNrPlacowki.setItems(listNrPlacowki);

        dbUtilCentrala= new DBUtil("centrala","centrala");
        System.out.println(dbUtilCentrala + "tutaj2");
        jednostka_krwiDAO=new Jednostka_krwiDAO(dbUtilCentrala);
        dawcaDAO=new DawcaDAO(dbUtilCentrala);

    }
}
