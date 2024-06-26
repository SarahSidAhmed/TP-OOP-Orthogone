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
import java.util.ResourceBundle;

public class AjouterChoixQCUController implements Initializable{

    private static Orthogone orthogone;
    private Scene scene;
    private Stage stage;
    private Patient newPatient;
    //private QCU currentQCU = Logiciel.getQCUCourrant();
    @FXML private Button Back;
    @FXML private TextField choix;

    @FXML private Button finish;
    @FXML private Label errorText;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("AjouterQCU.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    //not finished
    @FXML
    protected void Finish(ActionEvent event) throws IOException {

        //currentQCU.addChoix(choix.getText());

        //aller a homePatients
        Parent root = FXMLLoader.load(getClass().getResource("AjouterQCU.fxml"));
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
