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

public class AjouterQuestionLibreController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Patient newPatient;

    private Epreuve currentEpreuve =Logiciel.getEpreuveCourrant();
    private Bo currentBo=Logiciel.getBoCourrant();
    private Dossier currentDossier=Logiciel.getDossierCourrant();
    private Test_Question currentTestQuestion=Logiciel.getTestQuestionCourrant();
    private Question_Libre newqst;

    @FXML private Button Back;
    @FXML private TextField reponse;

    @FXML private Button finish;
    @FXML private Label errorText;

    private int ageInt;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("AjouterTestQuestion.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    //not finished
    @FXML
    protected void Finish(ActionEvent event) throws IOException {


        //ajouter la question au test

        newqst.setReponse(reponse.getText());
        currentTestQuestion.ajouterQuestion(newqst);
        currentEpreuve.addTest(currentTestQuestion);
        ArrayList<Epreuve> epreuves = new ArrayList<>();
        epreuves.add(currentEpreuve);
        currentBo.setEpreuves(epreuves);
        ArrayList<Bo> bos = new ArrayList<>();
        bos.add(currentBo);
        currentDossier.setBo(bos);
        ArrayList<Dossier> dossiers = new ArrayList<>();
        dossiers.add(currentDossier);
        orthogone.setDossiers(dossiers);

            //aller a ajouter TestQuestion
            Parent root = FXMLLoader.load(getClass().getResource("AjouterTestQuestion.fxml"));
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
