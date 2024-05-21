package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class ProgrammerRendezVousController implements Initializable {

    private static Orthogone orthogone;
    private Patient patient;

    private Stage stage;
    private Scene scene;



    @FXML private Button atelierBtn;
    @FXML private Button suiviBtn;
    @FXML private Button consultationBtn;
    @FXML private Label textExplain;

    @FXML private TableView tableRV;
    @FXML private TableColumn<RendezVous, ZonedDateTime> tableColumnDate;
    @FXML private TableColumn<RendezVous, Type_RV> tableColumnType;
    @FXML private TableColumn<RendezVous, String> tableColumnDuree;
    @FXML private TableColumn<RendezVous, String> tableColumnObservation;


    @FXML protected void Consultation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProgrammerConsultation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


    }
    @FXML protected void Suivi(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProgrammerSuivi.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML protected void Atelier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProgrammerAtelier.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    protected void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();

        if (patient.getNb_rv()==0){
            atelierBtn.setDisable(true);
            suiviBtn.setDisable(true);
            textExplain.setVisible(true);
        }else {
            atelierBtn.setDisable(false);
            suiviBtn.setDisable(false);
            textExplain.setVisible(false);
        }

        ObservableList<RendezVous> listRV = setTable();

        tableRV.setItems(listRV);
        editData();

    }

    private ObservableList<RendezVous> setTable() {

        ArrayList<RendezVous> rv = orthogone.getAgenda().getRendezVous();

        ObservableList<RendezVous> listRV = FXCollections.observableArrayList();

        //here we are selecting all the rendezvous of the specific client
        for (RendezVous r : rv) {
            if (r instanceof Consultation) {

                //CONSULTATION?
                if (((Consultation) r).getNom() == patient.getNom() &&
                        ((Consultation) r).getPrenom() == patient.getPrenom() &&
                        ((Consultation) r).getAge() == patient.getAge()) {
                    listRV.add(r);
                }

                //SUIVI?
            } else if (r instanceof Suivi) {
                if (((Suivi) r).getNum_dossier() == patient.getNum_dossier()) {
                    listRV.add(r);
                }

                //ATELIER?
            } else if (r instanceof Atelier) {
                if (((Atelier) r).rechercherPatientByNum(patient.getNum_dossier()).getNum_dossier() == patient.getNum_dossier()) {
                    listRV.add(r);
                }
            }
        }
        tableColumnDate.setCellValueFactory(new PropertyValueFactory<RendezVous, ZonedDateTime>("date"));
        tableColumnDuree.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("duree"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<RendezVous, Type_RV>("type"));
        tableColumnObservation.setCellValueFactory(new PropertyValueFactory<RendezVous, String>("observation"));

        return listRV;
    }

    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Patient> selectionModel = tableRV.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableRV.getItems().remove(selectedIndeces[i].intValue());
        }
    }

    protected void editData(){

        tableColumnObservation.setCellFactory(TextFieldTableCell.<RendezVous>forTableColumn());
        tableColumnObservation.setOnEditCommit(event ->{
            RendezVous r = event.getTableView().getItems().get(event.getTablePosition().getRow());
            r.setObservation(event.getNewValue());
        });
    }

}
