package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import com.example.cabinetorthophone.modules.*;
import com.sun.jdi.IntegerValue;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class AjouterFicheController implements Initializable {
    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Fiche newFiche;
    @FXML private Button Back;
    @FXML private TextField objectifs;
    @FXML private Button finish;
    @FXML private Label errorText;
    private  Dossier dossiercourrant;
    private Objectif newobjectif;

    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }



    @FXML
    protected void Finish(ActionEvent event) throws IOException {

        //ajouter la fiche a liste fiches du dossier
        //recuperer lobjectif suivan le nuton jfjfnejnvj

       // newobjectif; blablablaa
        newFiche.ajouterObjectif(newobjectif);

        ArrayList<Fiche> fiches = new ArrayList<>();

        // Add the updated Fiche to the ArrayList
        fiches.add(newFiche);
        dossiercourrant.setFiche(fiches);
        ArrayList<Dossier> dossiers = new ArrayList<>();
        dossiers.add(dossiercourrant);
        orthogone.setDossiers(dossiers);

        //aller a homeDossier
        Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void AjouterObjectif(ActionEvent event) throws IOException{

        //aller a ajouterObjectif
        Parent root = FXMLLoader.load(getClass().getResource("Fiches.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
    }//hmmmmm  what to write here ....? get dossiercourrant?

    public void Suivant(ActionEvent actionEvent) {
    }

    public void ajouterobjectiif(ActionEvent actionEvent) {
    }
}
