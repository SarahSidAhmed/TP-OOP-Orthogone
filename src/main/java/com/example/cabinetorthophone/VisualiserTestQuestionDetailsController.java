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

public class VisualiserTestQuestionDetailsController implements Initializable {
    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static Test_Question testqst;
    private static Epreuve epreuve;
    private static Question question;
    private static Test courrantTest;

    @FXML TableView<Question> tableViewQuestion;
    @FXML TableColumn<Question, Void> tableColumnCheck;

    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("VisualiserTestQuestion.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    // not finished yet
    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Question> selectionModel = tableViewQuestion.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewQuestion.getItems().remove(selectedIndeces[i].intValue());

// to check

            testqst.getQuestions().remove(selectedIndeces[i].intValue());
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();
        dossier = Logiciel.getOrthogoneCourrant().getDossierByNum(patient.getNum_dossier());
        bo =Logiciel.getBoCourrant();
        epreuve=Logiciel.getEpreuveCourrant();
        courrantTest= (Test_Question) Logiciel.getTestCourant();
        addButtonToTable();
    }
    private void addButtonToTable() {
        Callback<TableColumn<Question, Void>, TableCell<Question, Void>> cellFactory = new Callback<TableColumn<Question, Void>, TableCell<Question, Void>>() {
            @Override
            public TableCell<Question, Void> call(final TableColumn<Question, Void> param) {
                final TableCell<Question, Void> cell = new TableCell<Question, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Question data = getTableView().getItems().get(getIndex());

                            // Perform action with data.... things to do here too
                            int num_dossier = Logiciel.getPatientCurrant().getNum_dossier();
                            Dossier dossierCourant= Logiciel.getOrthogoneCourrant().rechercherDossier(num_dossier);
                            Bo  bo =Logiciel.getBoCourrant();
                            Epreuve epreuve=Logiciel.getEpreuveCourrant();
                            Test courrantTest= (Test_Question) Logiciel.getTestCourant();
                            Logiciel.setTestCourant(courrantTest);
                            Logiciel.setDossierCourrant(dossierCourant);
                            Logiciel.setQuestionCourant(data);

                           // maybe ajouter instanceof
                            try {
                                if( data instanceof Question_Libre){
                                    Parent root = FXMLLoader.load(getClass().getResource("VisualiserQuestionDetails.fxml"));

                                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                    scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.centerOnScreen();
                                    stage.show();
                                }

                                else{
                                    if(data instanceof QCU) {
                                        Parent root = FXMLLoader.load(getClass().getResource("VisualiserQCUDetails.fxml"));

                                        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                        scene = new Scene(root);
                                        stage.setScene(scene);
                                        stage.centerOnScreen();
                                        stage.show();
                                    }
                                    else{
                                        if(data instanceof QCM) {
                                            Parent root = FXMLLoader.load(getClass().getResource("VisualiserQCMDetails.fxml"));

                                            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                            scene = new Scene(root);
                                            stage.setScene(scene);
                                            stage.centerOnScreen();
                                            stage.show();
                                        }



                            }
                                }

                            }catch (IOException e) {
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
