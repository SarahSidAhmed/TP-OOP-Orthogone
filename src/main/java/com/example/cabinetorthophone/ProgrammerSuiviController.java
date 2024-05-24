package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class ProgrammerSuiviController implements Initializable {
    private static Patient patient;
    private static Orthogone orthogone;



    private ZonedDateTime dateFocus;

    private int year;
    private int month;

    private Stage stage;
    private Scene scene;


    @FXML private TextField jour;
    @FXML private TextField mois;
    @FXML private TextField annee;
    @FXML private TextField heure;
    @FXML private TextField minute;
    @FXML private CheckBox presentBool;

    @FXML private Label errorText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dateFocus = ZonedDateTime.now();
        year = dateFocus.getYear();
        month = dateFocus.getMonth().getValue();


        errorText.setVisible(false);
        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();

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


            //CHECKING IF THERE ARE NO ILLOGICAL ENTRIES
            //YESSSSS
            if (annee < year || mois < month || jour > 31 || jour < 1 || heure < 0 || heure > 23 || minute < 0 || minute > 59)  { //My god
                errorText.setVisible(true);
            } else {
                //GETTING THE ZONEDATETIME READY
                ZonedDateTime time = ZonedDateTime.of(annee, mois, jour, heure, minute, 0, 0, dateFocus.getZone());
                Suivi c = new Suivi(time, Type_RV.SUIVI, "//", patient.getNum_dossier(), presentBool.isSelected());
                orthogone.programmerRendezVous(c);
                orthogone.getDossierByNum(patient.getNum_dossier()).getListeRendezVous().add(c);

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
