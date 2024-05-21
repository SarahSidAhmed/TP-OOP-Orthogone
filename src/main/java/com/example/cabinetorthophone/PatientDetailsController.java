package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class PatientDetailsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private static Patient patientCurrant;
    private static Orthogone orthogone;

    @FXML TextField nom;
    @FXML TextField prenom;
    @FXML TextField address;
    @FXML TextField tel;
    @FXML TextField age;
    @FXML TextField profession;
    @FXML TextField diplome;
    @FXML Label textProfession;
    @FXML Label textDiplome;


    protected void initiate(){
        this.nom.setText(patientCurrant.getNom());
        this.prenom.setText(patientCurrant.getPrenom());
        this.address.setText(patientCurrant.getAdresse());
        this.tel.setText(patientCurrant.getTel());
        this.age.setText(String.valueOf(patientCurrant.getAge()));
        if (patientCurrant instanceof Adulte) {
            this.profession.setText(((Adulte) patientCurrant).getProfession());
            this.diplome.setText(((Adulte) patientCurrant).getDiplome());
        } else if (patientCurrant instanceof Enfant) {
            this.profession.setText(((Enfant) patientCurrant).getEtude());
            this.diplome.setVisible(false);
            this.textProfession.setText("Etude:");
            this.profession.setPromptText("Etude");
            this.textDiplome.setVisible(false);
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        patientCurrant = Logiciel.getPatientCurrant();
        initiate();

    }

    @FXML
    protected void consulterDossier(ActionEvent event) throws IOException{

        Logiciel.setDossierCourrant(orthogone.getDossierByNum(patientCurrant.getNum_dossier()));

        Parent root = FXMLLoader.load(getClass().getResource("DossierChoice.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void programmerRV(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ProgrammerRendezVous.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void retour(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
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

    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
}
