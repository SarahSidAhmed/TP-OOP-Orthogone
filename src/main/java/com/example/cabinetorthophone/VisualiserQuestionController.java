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

public class VisualiserQuestionController implements Initializable{

    private Stage stage;
    private Scene scene;
    @FXML TextField enonce;
    @FXML TextField reponse;
    @FXML TextField score;

    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static Test test;
    private static Test_Exo testExo;
    private static Epreuve epreuve;
    private static Patient patientCurrant;
    private static Question_Libre questionCurrant;
    private static Test_Question testQuestion;

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
        questionCurrant= (Question_Libre) Logiciel.getQuestionCourant();
        initiate();

    }

    protected void initiate(){
        this.enonce.setText(questionCurrant.getEnonce());
        this.reponse.setText(questionCurrant.getReponse());
        this.score.setText(String.valueOf(questionCurrant.getScore()));

    }
}
