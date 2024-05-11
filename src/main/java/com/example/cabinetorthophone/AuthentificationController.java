package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class AuthentificationController {



    @FXML
    protected void connexion(ActionEvent event){
        FXMLLoader loader =new FXMLLoader(getClass().getResource("connexion.fxml"));
    }

    @FXML
    protected void creation(ActionEvent event){
        FXMLLoader loader =new FXMLLoader(getClass().getResource("creation.fxml"));

    }

}
