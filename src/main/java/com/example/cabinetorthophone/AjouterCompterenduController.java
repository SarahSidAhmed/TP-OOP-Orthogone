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
import java.util.HashMap;
import java.util.ResourceBundle;


public class AjouterCompterenduController implements Initializable {


    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Compte_Rendu newCompte;
    private Dossier dossiercourrant =Logiciel.getDossierCourrant();
    private Bo bocourrant = Logiciel.getBoCourrant();
    private Epreuve epreuvecourant =Logiciel.getEpreuveCourrant();
    private Question newquestion;
    private Exercice newexo;
    private Test currentTest = Logiciel.getTestCourant();
    private HashMap<Test,Compte_Rendu> hash = new HashMap<>();

    @FXML private Button Back;
    @FXML private TextField categorie;
    @FXML private TextField enonce;
    @FXML private TextField score;
    @FXML private TextField consigne;
    @FXML private TextField materiele;
    @FXML private Button ajouterquestion;
    @FXML private Button ajouterexercice;
    @FXML private Button finish;
    @FXML private Button suivant;
    @FXML private Label errorText;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterEpreuve.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    protected void Finish(ActionEvent event) throws IOException {

        hash.put(currentTest,newCompte);
        epreuvecourant.addTest(hash);

        //aller a homeDossier
        Parent root = FXMLLoader.load(getClass().getResource("ajouterEpreuve.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouterquestion(ActionEvent event) throws IOException {
        newquestion.setCategorie(categorie.getText());
        newquestion.setEnonce(enonce.getText());
        newquestion.setScore(Integer.valueOf(score.getText()));
        newCompte.AjouterQuestin(newquestion);


    }
    @FXML
    protected void ajouterexercice(ActionEvent event) throws IOException {


        newexo.setConsigne(consigne.getText());
        newexo.setScore(Integer.valueOf(score.getText()));
        newCompte.AjouterExo(newexo);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();


    }

}
