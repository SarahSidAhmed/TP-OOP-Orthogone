package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Logiciel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Logiciel log;
    @FXML
    protected void onHelloButtonClick() {
        log.chargerUtilisateurs();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"))
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}