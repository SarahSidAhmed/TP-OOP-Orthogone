package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.smartcardio.Card;
import java.io.IOException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeStatistiqueController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;


    @FXML Label nbPatient;
    @FXML Label nbRV;
    @FXML Label nbSuivi;
    @FXML Label nbAtelier;

    @FXML Chart chart;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();

        int nombrePatient = orthogone.getPatients().size();
        int nombreRV = orthogone.getAgenda().getRendezVous().size();


        int nombreSuivi = orthogone.getAgenda().getSuivi().size();
        int nombreAtelier = orthogone.getAgenda().getAtelier().size();


        this.nbPatient.setText(String.valueOf(nombrePatient));
        this.nbAtelier.setText(String.valueOf(nombreAtelier));
        this.nbRV.setText(String.valueOf(nombreRV));
        this.nbSuivi.setText(String.valueOf(nombreSuivi));

    }



    @FXML
    public void AgendaCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeAgenda.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML public void PatientsCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML protected void AmneseCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeAmneseEnfant.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Logiciel.sauvegarderUsers();
        Parent root= FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }


    @FXML
    protected void ProfileCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
}
