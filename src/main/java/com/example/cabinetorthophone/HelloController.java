package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Logiciel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    protected void commencer(ActionEvent event) throws IOException {
        Logiciel.chargerUtilisateurs();
        Parent root= FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        //welcomeText.setText("Welcome to JavaFX Application!");
//        if (age > 18){
//            Adulte a = new Adulte(nom ,pren.....);
//            AccueilController accueilController =loader.getController();
//            accueilController.addPatient();
//        }
    }

}