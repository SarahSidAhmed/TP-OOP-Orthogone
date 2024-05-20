package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import com.example.cabinetorthophone.modules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ObjectifsController implements Initializable{
    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Dossier dossierCurrant;
    private static Fiche fiche;
    private static Objectif objectifCurrant;
    @FXML TextField nom;
    @FXML TextField note;

    public void Back(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("Fiches.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

      //  objectifCurrant = Logiciel.getObjectifCurrant();
        initiate();
        //orthogone = Logiciel.getOrthogoneCourrant();
        List<Objectif> oo = new ArrayList<Objectif>(fiche.getObjectifs());
        ObservableList<Objectif> o = FXCollections.observableArrayList(oo);
        //editDate();

    }

    protected void initiate(){

        this.nom.setText(objectifCurrant.getNom());
        this.note.setText(String.valueOf(objectifCurrant.getNote()));

    }
}
