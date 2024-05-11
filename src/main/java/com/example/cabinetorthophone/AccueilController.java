package com.example.cabinetorthophone;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXML;

import java.io.IOException;

public class AccueilController {

//private Logiciel log;
private Stage stage;
private Scene scene;
private Parent root;


    @FXML
    protected void commencer(ActionEvent event) throws IOException {

        //log.chargeUsers();
        Parent root = FXMLLoader.load(getClass().getResource("authentification.fxml"));


    }
}
