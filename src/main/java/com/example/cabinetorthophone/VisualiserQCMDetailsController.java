package com.example.cabinetorthophone;

import javafx.scene.input.MouseEvent;
import com.example.cabinetorthophone.modules.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class VisualiserQCMDetailsController implements Initializable{

    private Stage stage;
    private Scene scene;
    @FXML TextField enonce;
    @FXML TextField reponse;
    @FXML TextField score;
    @FXML TextField choix;

    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static ArrayList<Test> test;
    private static Test_Question testQuestion;
    private static Epreuve epreuve;
    private static Patient patientCurrant;
    private static QCM questionCurrant;
    private static Question qst;


    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("VisualiserTestQuestionDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        dossier = Logiciel.getDossierCourrant();
        bo =Logiciel.getBoCourrant();
        epreuve=Logiciel.getEpreuveCourrant();
        testQuestion= (Test_Question) Logiciel.getTestCourant();
        questionCurrant= (QCM) Logiciel.getQuestionCourant();

        initiate();


    }

    protected void initiate(){
        this.enonce.setText(questionCurrant.getEnonce());
        this.reponse.setText(String.valueOf(questionCurrant.getReponse()));
        this.score.setText(String.valueOf(questionCurrant.getScore()));
        this.choix.setText(Arrays.toString(questionCurrant.getChoix()));

    }
}


