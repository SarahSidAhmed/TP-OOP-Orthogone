package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import com.example.cabinetorthophone.modules.*;
import com.sun.jdi.IntegerValue;
import javafx.application.Preloader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AjouterTestQuestionController implements Initializable{

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Test newtest;
    @FXML private Button Back;
    @FXML private TextField type;
    @FXML private TextField nom;
    @FXML private TextField capacite;
    @FXML private Button finish;
    @FXML private Label errorText;
    private Test currentTest;
    private Epreuve currentEpreuve=Logiciel.getEpreuveCourrant();
    private Bo currentBo=Logiciel.getBoCourrant();
    private Dossier currentDossier=Logiciel.getDossierCourrant();

    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterTest.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void libre(ActionEvent actionEvent) throws IOException {

        //ajouter la question a testquestion

        //une boucle de capacite du testexo
        currentEpreuve.addTest(currentTest);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterQuestionLibre.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void qcm(ActionEvent actionEvent) throws IOException {


        //une boucle de capacite du testexo
        currentEpreuve.addTest(currentTest);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterQCM.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void qcu(ActionEvent actionEvent) throws IOException {


        //une boucle de capacite du testexo
        currentEpreuve.addTest(currentTest);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterQCU.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void question_suivant(ActionEvent actionEvent) throws IOException {
        //une boucle de capacite du testexo
        currentEpreuve.addTest(currentTest);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterTestQuestion.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
