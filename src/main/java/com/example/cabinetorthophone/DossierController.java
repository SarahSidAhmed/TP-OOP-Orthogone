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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class DossierController implements Initializable{

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Dossier dossier;


    @FXML TableView<Bo> tableViewBo;
    @FXML TableColumn<Bo, String> tableColumnThematique;
    @FXML TableColumn<Bo, Diagnostique> tableColumnDiagnostique;
    @FXML TableColumn<Bo, Epreuve> tableColumnEpreuve;

    @FXML
    private Label Dossier;

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
    public void onFichesButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Fiches.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }


    @FXML
    protected void onRVButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RV.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouterBo(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ajouterBo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Bo> selectionModel = tableViewBo.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewBo.getItems().remove(selectedIndeces[i].intValue());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        tableColumnThematique.setCellValueFactory(new PropertyValueFactory<Bo, String>("Thematique"));
        tableColumnDiagnostique.setCellValueFactory(new PropertyValueFactory<Bo, Diagnostique>("Diagnostique"));
        tableColumnEpreuve.setCellValueFactory(new PropertyValueFactory<Bo, Epreuve>("Epreuve"));




        List<Bo> oo = new ArrayList<Bo>(dossier.getBo());
        ObservableList<Bo> o = FXCollections.observableArrayList(oo);

        tableViewBo.setItems(o);

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
