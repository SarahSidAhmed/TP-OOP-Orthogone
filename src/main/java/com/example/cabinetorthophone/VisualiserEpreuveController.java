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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class VisualiserEpreuveController implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patient;
    private static Dossier dossier;
    private static Bo bo;
    private static Epreuve epreuve;
    @FXML
    TextField observations;



    @FXML
    TableView<Epreuve> tableViewEpreuve;
    @FXML
    TableColumn<Epreuve, Void> tableColumnCheck;


    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }



    public void ajouterEpreuve(ActionEvent actionEvent) throws IOException{

        if (!observations.getText().isEmpty()) {
            Epreuve p = new Epreuve();
            //ajouter la nouvelle BO
            p.setOversevationsCliniques(new String[]{observations.getText()});
            bo.getEpreuves().add(p);

            ArrayList<Epreuve> listEpreuve = bo.getEpreuves();
            ObservableList<Epreuve> listep = FXCollections.observableArrayList(listEpreuve);
            tableViewEpreuve.setItems(listep);


//        Parent root = FXMLLoader.load(getClass().getResource("AjouterEpreuve.fxml"));
//        stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.centerOnScreen();
//        stage.show();

    }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();
        dossier = Logiciel.getOrthogoneCourrant().getDossierByNum(patient.getNum_dossier());
        bo =Logiciel.getBoCourrant();


        addButtonToTable();

        ArrayList<Epreuve> oo= new ArrayList<Epreuve>(bo.getEpreuves());
        ObservableList<Epreuve> o = FXCollections.observableArrayList(oo);
        tableViewEpreuve.setItems(o);

    }

    private void addButtonToTable() {


        Callback<TableColumn<Epreuve, Void>, TableCell<Epreuve, Void>> cellFactory = new Callback<TableColumn<Epreuve, Void>, TableCell<Epreuve, Void>>() {
            @Override
            public TableCell<Epreuve, Void> call(final TableColumn<Epreuve, Void> param) {
                final TableCell<Epreuve, Void> cell = new TableCell<Epreuve, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Epreuve data = getTableView().getItems().get(getIndex());

                            // Perform action with data
                            int num_dossier = Logiciel.getPatientCurrant().getNum_dossier();
                            Dossier dossierCourant= Logiciel.getOrthogoneCourrant().RechercherDossier(num_dossier);
                            Bo boCourant=Logiciel.getBoCourrant();
                            Logiciel.setDossierCourrant(dossierCourant);
                            Logiciel.setBoCourrant(boCourant);
                            Logiciel.setEpreuveCourrant(data);


                            try {

                                    Parent root = FXMLLoader.load(getClass().getResource("Visualiser_test.fxml"));

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


    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Epreuve> selectionModel = tableViewEpreuve.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewEpreuve.getItems().remove(selectedIndeces[i].intValue());
            bo.getEpreuves().remove(selectedIndeces[i].intValue());
        }
    }



}
