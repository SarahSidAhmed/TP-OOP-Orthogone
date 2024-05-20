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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;



public class dossier_controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patientCurrant;
    private static Dossier dossierCurrant;

    @FXML
    TextField numdossier;
    @FXML TextField date;
    @FXML TextField lieu;



    public void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("PatientDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //dossierCurrant = Logiciel.getDossierCurrant;
        initiate();
        //editDate();

    }

    private void initiate() {

            this.numdossier.setText(String.valueOf(dossierCurrant.getNumDossier()));
            this.date.setText(dossierCurrant.getDate_naissance());
            this.lieu.setText(dossierCurrant.getLieu_naissance());
    }


    public void Fiche(ActionEvent event) throws IOException{
            Parent root = FXMLLoader.load(getClass().getResource("Fiches.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }


    public void Bo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Bo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }





    }