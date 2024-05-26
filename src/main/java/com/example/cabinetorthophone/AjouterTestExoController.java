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
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AjouterTestExoController implements Initializable{

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Test test;
    @FXML private Button Back;
    @FXML private TextField materiel;
    @FXML private TextField score;
    @FXML private TextField capacite;
    @FXML private TextField consigne;
    @FXML private Button finish;
    @FXML private Label errorText;
    private Test currentTest;
    private Epreuve currentEpreuve=Logiciel.getEpreuveCourrant();
    private Bo currentBo=Logiciel.getBoCourrant();
    private Dossier currentDossier=Logiciel.getDossierCourrant();
    private Exercice newexo;
    private Test_Exo test_exo;
    private int[] ScoreInt;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterTest.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    public void exo_suivant(ActionEvent actionEvent) throws IOException {

        for (int i = 0; i < test_exo.getCapacite();i++) {
            //ajouter le exo a testExo
            newexo.setConsigne(consigne.getText());
            newexo.setMaterial(materiel.getText());
            ScoreInt[i] = Integer.valueOf(score.getText());
            newexo.setScore(ScoreInt);
            //une boucle de capacite du testexo
            currentEpreuve.addTest(currentTest);
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
        Parent root = FXMLLoader.load(getClass().getResource("ajouterTestExo.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();

    }
}
