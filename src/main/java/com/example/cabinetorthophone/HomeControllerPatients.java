package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.System.in;

public class HomeControllerPatients implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;


    @FXML TableView<Patient> tableViewPatient;
    @FXML TableColumn<Patient, String> tableColumnNom;
    @FXML TableColumn<Patient, String> tableColumnPrenom;
    @FXML TableColumn<Patient, Integer> tableColumnAge;
    @FXML TableColumn<Patient, Integer> tableColumnNum;
    @FXML TableColumn<Patient, String> tableColumnTel;
    @FXML TableColumn<Button, Button> tableColumnCheck;
    @FXML TableColumn<Patient, String> tableColumnAddress;





    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    public void AgendaCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeAgenda.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ProfileCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouterPatient(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AjouterPatient.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        tableColumnNom.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
        tableColumnPrenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
        tableColumnAge.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        tableColumnTel.setCellValueFactory(new PropertyValueFactory<Patient, String>("tel"));
        tableColumnNum.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("num_dossier"));

        //tableColumnCheck.setCellValueFactory(new PropertyValueFactory<Patient, Button>("BUTTON"));
        tableColumnAddress.setCellValueFactory(new PropertyValueFactory<Patient, String>("adresse"));

//        Patient p = new Enfant("Sarah", "Sid", 10, "Alger", "ESI", "07796953");
//        Patient p1 = new Enfant("Hic", "Sid", 3, "Alger", "ESI", "07796953");
//        Patient p2 = new Enfant("Djamel", "Sid", 5, "Alger", "ESI", "07796953");
//        Patient p3 = new Enfant("Sora", "Sid", 0, "Alger", "ESI", "07796953");
//        Patient p4 = new Enfant("Lyna", "Benahmed", 1, "Alger", "ESI", "07796953");
//        Patient p5 = new Enfant("Fatima", "Senouci", 2, "Alger", "ESI", "07796953");
//
//        orthogone.ajouterPatient(p, p.getNum_dossier());
//        orthogone.ajouterPatient(p1, p1.getNum_dossier());
//        orthogone.ajouterPatient(p2, p2.getNum_dossier());
//        orthogone.ajouterPatient(p3, p3.getNum_dossier());
//        orthogone.ajouterPatient(p4, p4.getNum_dossier());
//        orthogone.ajouterPatient(p5, p5.getNum_dossier());

        List<Patient> oo = new ArrayList<>(orthogone.getPatients());
        ObservableList<Patient> o = FXCollections.observableArrayList(oo);

        tableViewPatient.setItems(o);

        editDate();
    }

    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Patient> selectionModel = tableViewPatient.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewPatient.getItems().remove(selectedIndeces[i].intValue());
        }
    }


    protected void editDate(){
        tableColumnNom.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnNom.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setNom(event.getNewValue());
        });

        tableColumnPrenom.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnPrenom.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setPrenom(event.getNewValue());
        });

        StringConverter<Integer> integerStringConverter = new IntegerStringConverter();

        tableColumnAge.setCellFactory(TextFieldTableCell.<Patient, Integer>forTableColumn(integerStringConverter));
        tableColumnAge.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setAge(event.getNewValue());
        });

        tableColumnTel.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnTel.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setTel(event.getNewValue());
        });

        tableColumnAddress.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnAddress.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setAdresse(event.getNewValue());
        });

    }
}
