package com.example.cabinetorthophone;

import javafx.scene.control.CheckBox;
import javafx.scene.input.MouseEvent;
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

public class VisualiserExerciceController implements Initializable{
    private Stage stage;
    private Scene scene;
    @FXML TextField materiel;
    @FXML TextField consigne;
    @FXML TextField score;
    @FXML CheckBox inclus;
    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static Test test;
    private static Test_Exo testExo;
    private static Epreuve epreuve;
    private static Patient patientCurrant;
    private static Exercice exerciceCurrant;
    private static boolean inclus0 ;

    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("VisualiserTestExoDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();

        initiate();

    }

    protected void initiate(){


        this.materiel.setText(exerciceCurrant.getMaterial());
        this.consigne.setText(exerciceCurrant.getConsigne());
        this.score.setText(String.valueOf(exerciceCurrant.getScore()));
        this.inclus.setSelected(inclus0);
    }

}
