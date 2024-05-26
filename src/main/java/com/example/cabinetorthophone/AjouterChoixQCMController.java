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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AjouterChoixQCMController implements Initializable{

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Patient patientCourrant;
    private Dossier currentDossier=Logiciel.getDossierCourrant();
    private Bo currentBo=Logiciel.getBoCourrant();
    private Epreuve currentEpreuve=Logiciel.getEpreuveCourrant();
    private Test_Question currentTestQuestion = Logiciel.getTestQuestionCourrant();
    //private QCM currentQCM = Logiciel.getQCMCourrant();



    @FXML private Button Back;
    @FXML private TextField choix;

    @FXML private Button finish;
    @FXML private Label errorText;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("AjouterQCM.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    //not finished
    @FXML
    protected void Finish(ActionEvent event) throws IOException {

        //currentQCM.addChoix(choix.getText());

        //aller a ajouterQCM
        Parent root = FXMLLoader.load(getClass().getResource("AjouterQCM.fxml"));
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

