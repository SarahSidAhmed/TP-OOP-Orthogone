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


public class AjouterDiagnostiqueController implements Initializable {

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Diagnostique newDiagnostique;
    private Bo courrentbo;
    private Dossier courrentdossier;
    @FXML private Button Back;
    @FXML private TextField nom;
    @FXML private Button finish;
    @FXML private TextField type;
    @FXML private Label errorText;
    private Type_Trouble typeTrouble;
    private Trouble newtrouble;

    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("ajouterBo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void Finish(ActionEvent event) throws IOException {
        typeTrouble = Type_Trouble.valueOf(type.getText());
        newtrouble.setNom(nom.getText());
        newtrouble.setType(typeTrouble);
        newDiagnostique.ajouterTrouble(newtrouble);

        //ajouter le Diagnostique
        courrentbo.setDiagnostique(newDiagnostique);

        ArrayList<Bo> bos = new ArrayList<>();

        // Add the updated Bo to the ArrayList
        bos.add(courrentbo);
        courrentdossier.setBo(bos);
        ArrayList<Dossier> dossiers = new ArrayList<>();
        dossiers.add(courrentdossier);
        orthogone.setDossiers(dossiers);

        //aller a homeDossier
        Parent root = FXMLLoader.load(getClass().getResource("ajouterBo.fxml"));
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
