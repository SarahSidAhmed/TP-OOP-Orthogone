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

public class AjouterEpreuveController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Epreuve newEpreuve;
    @FXML private Button Back;
    @FXML private TextField observations;
    @FXML private Button finish;
    @FXML private Button ajouteretest;
    @FXML private Button ajoutercompterendu;
    @FXML private Label errorText;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterBo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void Suivant(ActionEvent actionEvent) {
    }


    @FXML
    protected void Finish(ActionEvent event) throws IOException {

        //ajouter le bilan dans la liste des bilans de l'orthophoniste how : ????!!!!!
        // orthogone.ajouterBo(newBo, newBo.getNum_dossier());

        //aller a homeDossier
        Parent root = FXMLLoader.load(getClass().getResource("ajouterBo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouteretest(ActionEvent event) throws IOException {

        //aller a ajouter epreuve
        Parent root = FXMLLoader.load(getClass().getResource("ajouterTest.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void ajoutercoompterendu(ActionEvent event) throws IOException {

        //aller a ajouter epreuve
        Parent root = FXMLLoader.load(getClass().getResource("ajouterCompterendu.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
    }//hmmmmm  what to write here ....? get dossiercourrant?
}