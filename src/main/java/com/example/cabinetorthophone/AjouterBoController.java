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

public class AjouterBoController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Bo newBo;

    @FXML private Button Back;
    @FXML private TextField observations;
    @FXML private TextField thematique;

    @FXML private Button finish;
    @FXML private Button ajouterepreuve;
    @FXML private Button ajouterdiagnostique;
    @FXML private Label errorText;
    private Dossier dossiercourant;
    private Patient patientcourant;



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

        if (!this.thematique.getText().isEmpty()) {
            Bo b = new Bo();
            b.setThematique(thematique.getText());
            // for epreuves and diagnostique they will be sent by their repective ajouter?


            // Add the updated Fiche to the ArrayList
            this.dossiercourant.getBo().add(newBo);

//        ArrayList<Dossier> dossiers = new ArrayList<>();
//        dossiers.add(dossiercourant);
//        orthogone.setDossiers(dossiers);

            //aller a homeDossier
            Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }


    @FXML
    protected void ajouterEpreuve(ActionEvent event) throws IOException {

        //aller a ajouter epreuve
        Parent root = FXMLLoader.load(getClass().getResource("ajouterEpreuve.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouterdiagnostique(ActionEvent event) throws IOException {

        //aller a ajouter diagnostique
        Parent root = FXMLLoader.load(getClass().getResource("ajouterDiagnostique.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        if (Logiciel.getBoCourrant() == null){
            Bo b = new Bo();
            ajouterepreuve.isDisable();
            ajouterdiagnostique.isDisable();
        }else {
            this.newBo = Logiciel.getBoCourrant();
            this.thematique.setText( newBo.getThematique());
        }
    }
}
