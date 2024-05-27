package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import com.example.cabinetorthophone.modules.*;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AjouterTestQuestionController implements Initializable{

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Test newtest;
    @FXML private Button Back;
    @FXML private TextField enonce;
    @FXML private TextField score;
    @FXML private Button finish;
    @FXML private Label errorText;
    private Test currentTest;
    private Epreuve currentEpreuve=Logiciel.getEpreuveCourrant();
    private Bo currentBo=Logiciel.getBoCourrant();
    private Dossier currentDossier=Logiciel.getDossierCourrant();
    private QCU newqcu;
    private QCM newqcm;
    private Question_Libre newqstlibre;
    private Test_Question test_question;
    // for current question
    private Question qstCourrant;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterTest.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public void libre(ActionEvent actionEvent) throws IOException {

//        qstCourrant.setEnonce(enonce.getText());
//        qstCourrant.setScore(Integer.valueOf(score.getText()));




//        test_question.ajouterQuestion(qst);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterQuestionLibre.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void qcm(ActionEvent actionEvent) throws IOException {

//        qstCourrant.setEnonce(enonce.getText());
//        qstCourrant.setScore(Integer.valueOf(score.getText()));




//        test_question.ajouterQuestion(qst);
//        currentEpreuve.addTest(test_question);
//        ArrayList<Epreuve> epreuves = new ArrayList<>();
//        epreuves.add(currentEpreuve);
//        currentBo.setEpreuves(epreuves);
//        ArrayList<Bo> bos = new ArrayList<>();
//        bos.add(currentBo);
//        currentDossier.setBo(bos);
//        ArrayList<Dossier> dossiers = new ArrayList<>();
//        dossiers.add(currentDossier);
//        orthogone.setDossiers(dossiers);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterQCM.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void qcu(ActionEvent actionEvent) throws IOException {

//        qstCourrant.setEnonce(enonce.getText());
//        qstCourrant.setScore(Integer.valueOf(score.getText()));



//        test_question.ajouterQuestion(qst);
//        currentEpreuve.addTest(test_question);
//        ArrayList<Epreuve> epreuves = new ArrayList<>();
//        epreuves.add(currentEpreuve);
//        currentBo.setEpreuves(epreuves);
//        ArrayList<Bo> bos = new ArrayList<>();
//        bos.add(currentBo);
//        currentDossier.setBo(bos);
//        ArrayList<Dossier> dossiers = new ArrayList<>();
//        dossiers.add(currentDossier);
//        orthogone.setDossiers(dossiers);

        //aller a
        Parent root = FXMLLoader.load(getClass().getResource("ajouterQCU.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void question_suivant(ActionEvent actionEvent) throws IOException {

        for (int i = 0; i < currentTest.getCapacite();i++) {

            //ajouter la question a test question
            qstCourrant.setEnonce(enonce.getText());
            qstCourrant.setScore(Integer.valueOf(score.getText()));
            test_question.ajouterQuestion(qstCourrant);
            currentEpreuve.addTest(test_question);
            ArrayList<Epreuve> epreuves = new ArrayList<>();
            epreuves.add(currentEpreuve);
            currentBo.setEpreuves(epreuves);
            ArrayList<Bo> bos = new ArrayList<>();
            bos.add(currentBo);
            currentDossier.setBo(bos);
            ArrayList<Dossier> dossiers = new ArrayList<>();
            dossiers.add(currentDossier);
            orthogone.setDossiers(dossiers);
            //aller a
            Parent root = FXMLLoader.load(getClass().getResource("ajouterTestQuestion.fxml"));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        currentTest= (Test_Question) Logiciel.getTestCourant();
        currentTest=test_question;





    }
}
