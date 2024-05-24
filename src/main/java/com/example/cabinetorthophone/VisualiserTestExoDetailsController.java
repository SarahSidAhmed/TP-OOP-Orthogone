package com.example.cabinetorthophone;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.example.cabinetorthophone.modules.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Callback;

public class VisualiserTestExoDetailsController implements Initializable{
    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static Test test;
    private static Test_Exo testExo;
    private static Epreuve epreuve;
    private static Exercice exo;

    @FXML TableView<Exercice> tableViewExo;
    @FXML TableColumn<Exercice, Void> tableColumnCheck;


    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("VisualiserTestExo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }


    // not finished yet
    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Exercice> selectionModel = tableViewExo.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewExo.getItems().remove(selectedIndeces[i].intValue());

// to check
            testExo.getExercices().remove(selectedIndeces[i].intValue());
        }
    }

//not finished
    public void ajouterExercice(ActionEvent actionEvent)throws IOException {


        //ajouter le nouveau exercice
        Parent root = FXMLLoader.load(getClass().getResource("ajouterExercice.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }


    // not finished yet
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();
        dossier = Logiciel.getOrthogoneCourrant().getDossierByNum(patient.getNum_dossier());
        //.... suite pour jusque arrive a epeuve et a le test exo puis a lexo
        addButtonToTable();
    }
    private void addButtonToTable() {
        Callback<TableColumn<Exercice, Void>, TableCell<Exercice, Void>> cellFactory = new Callback<TableColumn<Exercice, Void>, TableCell<Exercice, Void>>() {
            @Override
            public TableCell<Exercice, Void> call(final TableColumn<Exercice, Void> param) {
                final TableCell<Exercice, Void> cell = new TableCell<Exercice, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Exercice data = getTableView().getItems().get(getIndex());

                            // Perform action with data.... things to do here too
                            int num_dossier = Logiciel.getPatientCurrant().getNum_dossier();
                            Dossier dossierCourant= Logiciel.getOrthogoneCourrant().rechercherDossier(num_dossier);

                            // Logiciel.setExoCourrant(data);


                            try {
                                Parent root =  FXMLLoader.load(getClass().getResource("VisualiserExercice.fxml"));
                                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }


                            //System.out.println("Selected Data: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }
        };

        tableColumnCheck.setCellFactory(cellFactory);
    }

}
