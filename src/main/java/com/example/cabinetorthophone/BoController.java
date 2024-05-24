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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.util.Callback;

public class BoController implements Initializable{

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;


    @FXML TableView<Bo> tableViewBo;
    @FXML TableColumn<Bo, String> tableColumnThematique;
    @FXML TableColumn<Bo, Void> tableColumnDiagnostique;
    @FXML TableColumn<Bo, Void> tableColumnEpreuve;



    @FXML TextField thematique;


    @FXML
    public void logOut(ActionEvent event) throws IOException {
        Logiciel.sauvegarderUsers();
        Parent root= FXMLLoader.load(getClass().getResource("authentification.fxml"));
        stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }



    @FXML
    protected void ajouterBo(ActionEvent event) throws IOException {
        if (!thematique.getText().isEmpty()) {
            Bo b = new Bo();
            //ajouter la nouvelle BO
            b.setThematique(thematique.getText());
            dossier.getBo().add(b);


            ArrayList<Bo> listBo = dossier.getBo();
            ObservableList<Bo> listObs = FXCollections.observableArrayList(listBo);

            tableViewBo.setItems(listObs);
        }
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
            dossier.getBo().remove(selectedIndeces[i].intValue());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();
        dossier = Logiciel.getOrthogoneCourrant().getDossierByNum(patient.getNum_dossier());

        tableColumnThematique.setCellValueFactory(new PropertyValueFactory<Bo, String>("Thematique"));
        addButtonToTable();
        addButtonToTable0();

        List<Bo> oo = new ArrayList<Bo>(dossier.getBo());
        ObservableList<Bo> o = FXCollections.observableArrayList(oo);

        tableViewBo.setItems(o);

        //editDate();
    }

    private void addButtonToTable0() {
        Callback<TableColumn<Bo, Void>, TableCell<Bo, Void>> cellFactory = new Callback<TableColumn<Bo, Void>, TableCell<Bo, Void>>() {
            @Override
            public TableCell<Bo, Void> call(final TableColumn<Bo, Void> param) {
                final TableCell<Bo, Void> cell = new TableCell<Bo, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Bo data = getTableView().getItems().get(getIndex());

                            // Perform action with data
                            int num_dossier = Logiciel.getPatientCurrant().getNum_dossier();
                            Dossier dossierCourant= Logiciel.getOrthogoneCourrant().rechercherDossier(num_dossier);

                            Logiciel.setBoCourrant(data);


                            try {
                                Parent root =  FXMLLoader.load(getClass().getResource("ajouterEpreuve.fxml"));
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

        tableColumnEpreuve.setCellFactory(cellFactory);
    }

    private void addButtonToTable() {
        Callback<TableColumn<Bo, Void>, TableCell<Bo, Void>> cellFactory = new Callback<TableColumn<Bo, Void>, TableCell<Bo, Void>>() {
            @Override
            public TableCell<Bo, Void> call(final TableColumn<Bo, Void> param) {
                final TableCell<Bo, Void> cell = new TableCell<Bo, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Bo data = getTableView().getItems().get(getIndex());

                            // Perform action with data
                            int num_dossier = Logiciel.getPatientCurrant().getNum_dossier();
                            Dossier dossierCourant= Logiciel.getOrthogoneCourrant().rechercherDossier(num_dossier);

                            Logiciel.setDossierCourrant(dossierCourant);
                            Logiciel.setBoCourrant(data);


                            try {
                                Parent root =  FXMLLoader.load(getClass().getResource("ajouterDiagnostique.fxml"));
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

        tableColumnDiagnostique.setCellFactory(cellFactory);
    }

    @FXML protected void consulterFiche(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Fiches.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("PatientDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }


}
