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

public class VisualiserTestController implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static Epreuve epreuve;
    private static Test courrantTest;

    @FXML TableView<Test> tableViewTest;
    @FXML TableColumn<Test, Void> tableColumnCheck;


    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("VisualiserEpreuve.fxml"));
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
        dossier = Logiciel.getOrthogoneCourrant().getDossierByNum(patient.getNum_dossier());
        bo =Logiciel.getBoCourrant();
        epreuve=Logiciel.getEpreuveCourrant();
        addButtonToTable();


//        ArrayList<Epreuve> epreuves= new ArrayList<>();
//        epreuves.add(epreuve);
//        bo.setEpreuves(epreuves);
//        courrantTest=Logiciel.getTestCourant();


        ArrayList<Test> oo = epreuve.getTest();
        ObservableList<Test> o = FXCollections.observableArrayList(oo);

        tableViewTest.setItems(o);

        //editDate();
    }

    private void addButtonToTable() {

        Callback<TableColumn<Test, Void>, TableCell<Test, Void>> cellFactory = new Callback<TableColumn<Test, Void>, TableCell<Test, Void>>() {
            @Override
            public TableCell<Test, Void> call(final TableColumn<Test, Void> param) {
                final TableCell<Test, Void> cell = new TableCell<Test, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Test data = getTableView().getItems().get(getIndex());

                            // Perform action with data
                            int num_dossier = Logiciel.getPatientCurrant().getNum_dossier();
                            Dossier dossierCourant= Logiciel.getOrthogoneCourrant().RechercherDossier(num_dossier);

                            Logiciel.setDossierCourrant(dossierCourant);
                            Logiciel.setTestCourant(data);


                            try {
                                if(courrantTest instanceof Test_Question) {
                                    Parent root = FXMLLoader.load(getClass().getResource("VisualiserTestQuestion.fxml"));

                                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();
                                }

                                else{
                                    if(courrantTest instanceof Test_Exo) {
                                    Parent root = FXMLLoader.load(getClass().getResource("VisualiserTestExo.fxml"));

                                    stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                    scene = new Scene(root);
                                    stage.setScene(scene);
                                    stage.centerOnScreen();
                                    stage.show();
                                }
                                }

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


    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Test> selectionModel = tableViewTest.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewTest.getItems().remove(selectedIndeces[i].intValue());
            epreuve.getTest().remove(selectedIndeces[i].intValue());
        }
    }

    public void ajouterTest(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AjouterTest.fxml"));
        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();


    }

}
