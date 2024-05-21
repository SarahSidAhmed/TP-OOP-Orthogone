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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class FicheController implements Initializable {
    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Dossier dossier;
    private static Fiche fiche;


    @FXML TableView<Fiche> tableViewFiche;
    @FXML TableColumn<Fiche, Void> tableColumnCheck;
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
        //fiche =Logiciel.getFicheCourrant();
        tableColumnObjectif.setCellValueFactory(new PropertyValueFactory<Fiche, Objectif>("Objectif"));
        addButtonToTable();
        List<Fiche> oo = new ArrayList<Fiche>(dossier.getFiche());
        ObservableList<Fiche> o = FXCollections.observableArrayList(oo);

        tableViewFiche.setItems(o);

        //editDate();
    }

    private void addButtonToTable() {

            Callback<TableColumn<Fiche, Void>, TableCell<Fiche, Void>> cellFactory = new Callback<TableColumn<Fiche, Void>, TableCell<Fiche, Void>>() {
                @Override
                public TableCell<Fiche, Void> call(final TableColumn<Fiche, Void> param) {
                    final TableCell<Fiche, Void> cell = new TableCell<Fiche, Void>() {

                        private final Button btn = new Button("Check");

                        {

                            btn.setPrefHeight(32.0);
                            btn.setPrefWidth(118.0);
                            btn.setStyle("-fx-background-color: #425c59;");
                            btn.setTextFill(javafx.scene.paint.Color.WHITE);
                            btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                            btn.setOnAction((event) -> {
                                Fiche data = getTableView().getItems().get(getIndex());

                                //HEREEEEE     Perform action with data
                                Logiciel.getPatientCurrant().getNum_dossier();


                                try {
                                    Parent root =  FXMLLoader.load(getClass().getResource("Objectifs.fxml"));
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
    protected void ajouterFiche(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("ajouterFiche.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    public void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
}
