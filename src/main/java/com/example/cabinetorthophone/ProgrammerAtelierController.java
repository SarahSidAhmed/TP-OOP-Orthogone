package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.*;

public class ProgrammerAtelierController implements Initializable {

    private static Patient patient;
    private static Orthogone orthogone;

    private Stage stage;
    private Scene scene;

    private ZonedDateTime dateFocus;

    private int year;
    private int month;


    @FXML private TextField jour;
    @FXML private TextField mois;
    @FXML private TextField annee;
    @FXML private TextField heure;
    @FXML private TextField minute;

    @FXML private Label errorText;

    @FXML private TextField thematique;
    @FXML TableView tableAtelier;

    @FXML TableColumn tableAtelierNum;
    @FXML TableColumn tableDate;
    @FXML TableColumn tableNumPatient;

    @FXML ChoiceBox<Integer> choiceAtelier;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();

        dateFocus = ZonedDateTime.now();
        year = dateFocus.getYear();
        month = dateFocus.getMonth().getValue();

        ArrayList<RendezVous> listRV = orthogone.getAgenda().getRendezVous();
        ObservableList<Integer> ateliers = FXCollections.observableArrayList();
        //GETTING ALL THE OBJECTS RENDEZ VOUS THAT ACTUALLY ATELIER TYPE
        int i = 0;
        for (RendezVous rv : listRV){
            if (rv instanceof Atelier) ateliers.add(((Atelier) rv).getId());
        }

        choiceAtelier.setItems(ateliers);
        errorText.setVisible(false);

        tableDate.setCellValueFactory(new PropertyValueFactory<Atelier, ZonedDateTime>("date"));
        tableAtelierNum.setCellValueFactory(new PropertyValueFactory<Atelier, Integer>("id"));
        tableNumPatient.setCellValueFactory(new PropertyValueFactory<Atelier, Integer>("numPatient"));

        ArrayList<Atelier> as  = orthogone.getAgenda().getAtelier();
        ObservableList<Atelier> atliersAgenda = FXCollections.observableArrayList(as);


        tableAtelier.setItems(atliersAgenda);
    }

    @FXML
    protected void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ProgrammerRendezVous.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML protected void AjouterAtelier(ActionEvent event) throws IOException {
        Integer id = this.choiceAtelier.getValue();
        Atelier a = orthogone.getAgenda().findAtelierById(id);

        if (a.rechercherPatientByNum(patient.getNum_dossier())== null) {

            a.addPatient(patient);
            a.setNumPatient(a.getNumPatient() + 1);
            orthogone.getDossierByNum(patient.getNum_dossier()).getListeRendezVous().add(a);

            Parent root = FXMLLoader.load(getClass().getResource("ProgrammerRendezVous.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        else errorText.setVisible(true);
    }

    @FXML
    private void Confirmer(ActionEvent event) throws IOException {

        //IF ONE OF THE FIELDS ARE EMPTY
        if (!this.annee.getText().isEmpty() && !this.mois.getText().isEmpty() &&
                !this.jour.getText().isEmpty() && !this.heure.getText().isEmpty() &&
                !this.minute.getText().isEmpty()) {//OOF!!

            int jour = Integer.parseInt(this.jour.getText());
            int mois = Integer.parseInt(this.mois.getText());
            int annee = Integer.parseInt(this.annee.getText());
            int heure = Integer.parseInt(this.heure.getText());
            int minute = Integer.parseInt(this.minute.getText());
            String thematique = this.thematique.getText();


            //CHECKING IF THERE ARE NO ILLOGICAL ENTRIES
            //YESSSSS
            if (annee < year || mois < month || jour > 31 || jour < 1 || heure < 0 || heure > 23 || minute < 0 || minute > 59)  { //My god
                errorText.setVisible(true);
            } else {

                HashSet<Patient> ps = new HashSet<>(Collections.singleton(patient));
                //GETTING THE ZONEDATETIME READY
                ZonedDateTime time = ZonedDateTime.of(annee, mois, jour, heure, minute, 0, 0, dateFocus.getZone());
                Atelier c = new Atelier(time, "", ps, thematique);
                orthogone.programmerRendezVous(c);
                orthogone.getDossierByNum(patient.getNum_dossier()).getListeRendezVous().add(c);
                c.addPatient(patient);

                c.setNumPatient(c.getNumPatient()+1);

                //GOING BACK AFTER SUCCESS
                errorText.setVisible(false);
                Parent root = FXMLLoader.load(getClass().getResource("ProgrammerRendezVous.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }
        }
    }
}
