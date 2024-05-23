package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
import com.sun.jdi.IntegerValue;
import javafx.application.Preloader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjouterPatientController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Patient newPatient;

    @FXML private Button Back;
    @FXML private TextField nom;
    @FXML private TextField prenom;
    @FXML private TextField address;
    @FXML private TextField tel;
    @FXML private TextField age;
    @FXML private TextField profession;
    @FXML private TextField diplome;
    @FXML private Label textProfession;
    @FXML private Button finish;
    @FXML private Label errorText;

    private int ageInt;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void Suivant(ActionEvent event) throws IOException {


        if (!age.getText().isEmpty() && !nom.getText().isEmpty() &&
            !prenom.getText().isEmpty() && !address.getText().isEmpty()
            && !tel.getText().isEmpty()) {
             ageInt = Integer.valueOf(age.getText());
            finish.setDisable(false);
            if (ageInt >= 18) {
                profession.setDisable(false);
                diplome.setDisable(false);
                textProfession.setVisible(true);
                profession.setPromptText("Profession");
                textProfession.setText("Profession:");
            } else {
                profession.setDisable(false);
                diplome.setDisable(true);
                profession.setPromptText("Niveau Etude");
                textProfession.setText("Niveau Etude:");
            }
        }else {
            errorText.setText("Champs ne peuvent pas etre vide!");
        }

    }

    @FXML
    protected void Finish(ActionEvent event) throws IOException {

        if (!profession.getText().isEmpty() || (!profession.getText().isEmpty() && !diplome.getText().isEmpty())){
            if (ageInt>=18){
                //c'est un adulte
                newPatient = new Adulte(nom.getText(), prenom.getText(), ageInt, address.getText(), diplome.getText(), tel.getText(), profession.getText());
            }else {
                //c'est un enfant
                newPatient = new Enfant(nom.getText(), prenom.getText(), ageInt, address.getText(), profession.getText(), tel.getText());
            }

            //ajouter le patient dans la liste des patients de l'orthophoniste
            orthogone.ajouterPatient(newPatient, newPatient.getNum_dossier());

            //aller a homePatients
            Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        else {
            errorText.setText("Champs ne peuvent pas etre vide!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();

    }
}
