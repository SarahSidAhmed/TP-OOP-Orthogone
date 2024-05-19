package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import com.example.cabinetorthophone.modules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class RVcontroller implements Initializable{

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Dossier dossier;

    @FXML TableView<RendezVous> tableViewRv;
    @FXML
    TableColumn<RendezVous, ZonedDateTime> tableColumnDate;
    @FXML TableColumn<RendezVous, String> tableColumnHeure;
    @FXML
    TableColumn<RendezVous, String> tableColumnDuree;
    @FXML TableColumn<RendezVous, Type_RV> tableColumnType;
    @FXML TableColumn<RendezVous, String> tableColumnObservation;


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
    protected void onFicheButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Fiches.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void onBoButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouterRv(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ajouterRV.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<RendezVous, ZonedDateTime>("Date"));
        tableColumnHeure.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("Heure"));
        tableColumnDuree.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("Duree"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<RendezVous, Type_RV>("Type"));
        tableColumnObservation.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("Observations"));
        List<RendezVous> oo = new ArrayList<RendezVous>(dossier.getListeRendezVous());
        ObservableList<RendezVous> o = FXCollections.observableArrayList(oo);

        tableViewRv.setItems(o);

        //editDate();
    }

    public void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

}
