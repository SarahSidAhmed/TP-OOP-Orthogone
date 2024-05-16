package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Enfant;
import com.example.cabinetorthophone.modules.Logiciel;
import com.example.cabinetorthophone.modules.Orthogone;
import com.example.cabinetorthophone.modules.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeControllerPatients implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;


    @FXML TableView<Patient> tableViewPatient;
    @FXML TableColumn<Patient, String> tableColumnNom;
    @FXML TableColumn<Patient, String> tableColumnPrenom;
    @FXML TableColumn<Patient, Integer> tableColumnAge;
    @FXML TableColumn<Patient, Integer> tableColumnNum;
    @FXML TableColumn<Patient, Integer> tableColumnRV;
    @FXML TableColumn<Patient, Button> tableColumnCheck;




    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
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
    protected void ajouterPatient(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AjouterPatient.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        tableColumnNom.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
        tableColumnPrenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
        tableColumnAge.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        tableColumnRV.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("nb_rv"));
        //tableColumnCheck.setCellValueFactory(new PropertyValueFactory<Patient, Button>("BUTTON"));
        tableColumnNum.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("num_dossier"));

        Patient p = new Enfant("Sarah", "Sid", 10, "Alger", "ESI", "07796953");
        Patient p1 = new Enfant("Hic", "Sid", 3, "Alger", "ESI", "07796953");
        Patient p2 = new Enfant("Djamel", "Sid", 5, "Alger", "ESI", "07796953");
        Patient p3 = new Enfant("Sora", "Sid", 0, "Alger", "ESI", "07796953");
        Patient p4 = new Enfant("Lyna", "Benahmed", 1, "Alger", "ESI", "07796953");
        Patient p5 = new Enfant("Fatima", "Senouci", 2, "Alger", "ESI", "07796953");

        orthogone.ajouterPatient(p, p.getNum_dossier());
        orthogone.ajouterPatient(p1, p1.getNum_dossier());
        orthogone.ajouterPatient(p2, p2.getNum_dossier());
        orthogone.ajouterPatient(p3, p3.getNum_dossier());
        orthogone.ajouterPatient(p4, p4.getNum_dossier());
        orthogone.ajouterPatient(p5, p5.getNum_dossier());

        List<Patient> oo = new ArrayList<>(orthogone.getPatients());
        ObservableList<Patient> o = FXCollections.observableArrayList(oo);



        tableViewPatient.setItems(o);

    }
}
