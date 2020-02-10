package edu.ib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankKrwiApp extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        //nazwa katalogu z resources
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("logowanie.fxml"));
        primaryStage.setTitle("Aplikacja banku krwi");
        Scene scene = new Scene(root, 536, 275); //nowa odslona w oparciu o obiekt klasy parent
        primaryStage.setScene(scene);
        primaryStage.show();




    }

}
