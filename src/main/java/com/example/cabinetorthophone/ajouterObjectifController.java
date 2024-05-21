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

public class ajouterObjectifController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Patient currentPatient=Logiciel.getPatientCurrant();
    private Dossier currentDossier=Logiciel.getDossierCourrant();
    private Objectif newObjectif;
    private Fiche currentFiche=Logiciel.getFicheCourrant();



    @FXML private Button Back;
    @FXML private TextField nom;
    @FXML private TextField note;
    @FXML private TextField terme;

    @FXML private Button finish;
    private int Intnote;
    private Type_Terme Typeterme;

    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterFiche.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }



    @FXML
    protected void Finish(ActionEvent event) throws IOException, NoteException {


        //ajouter l'objectif dans la liste des objectifs de la Fiche

        Intnote = Integer.valueOf(note.getText());
        Typeterme = Type_Terme.valueOf(terme.getText());
        newObjectif.setTerme(Typeterme);
        newObjectif.setNote(Intnote);
        newObjectif.setNom(nom.getText());
        currentFiche.ajouterObjectif(newObjectif);
        ArrayList<Fiche> fiches = new ArrayList<>();

        // Add the updated Fiche to the ArrayList
        fiches.add(currentFiche);
        currentDossier.setFiche(fiches);
        ArrayList<Dossier> dossiers = new ArrayList<>();
        dossiers.add(currentDossier);
        orthogone.setDossiers(dossiers);

            //aller a ajouterFiche
            Parent root = FXMLLoader.load(getClass().getResource("ajouterFiche.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();


    }
}
