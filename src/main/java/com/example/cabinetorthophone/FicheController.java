package com.example.cabinetorthophone;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.control.Label;

public class FicheController implements Initializable {
    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Dossier dossier;

    @FXML TableView<Fiche> tableViewFiche;
    @FXML TableColumn<Fiche, Type_Terme> tableColumnTerme;
    @FXML TableColumn<Fiche, Objectif> tableColumnObjectif;

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
    protected void onRVButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("RV.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Fiche> selectionModel = tableViewFiche.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewFiche.getItems().remove(selectedIndeces[i].intValue());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        tableColumnTerme.setCellValueFactory(new PropertyValueFactory<Fiche, Type_Terme>("Terme"));
        tableColumnObjectif.setCellValueFactory(new PropertyValueFactory<Fiche, Objectif>("Objectif"));
        List<Fiche> oo = new ArrayList<Fiche>(dossier.getFiche());
        ObservableList<Fiche> o = FXCollections.observableArrayList(oo);

        tableViewFiche.setItems(o);

        //editDate();
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
    protected void ajouterFiche(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ajouterFiche.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
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
