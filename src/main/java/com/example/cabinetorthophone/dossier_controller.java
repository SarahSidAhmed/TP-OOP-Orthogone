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
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;


public class dossier_controller implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;
    private static Patient patientCurrant;
    private static Dossier dossierCurrant;

    @FXML
    TextField numdossier;
    @FXML TextField date;
    @FXML TextField lieu;
    @FXML TableView<Dossier> tableViewDosiers;
    @FXML TableColumn<Dossier, Void> tableColumnBo;
    @FXML TableColumn<Dossier, Void> tableColumnFiches;



    public void Back(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("PatientDetails.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        addButtonToTable();
        addButtonToTable0();
        initiate();

        List<Dossier> oo = new ArrayList<>(orthogone.getDossiers());
        ObservableList<Dossier> o = FXCollections.observableArrayList(oo);

        tableViewDosiers.setItems(o);


    }

    private void addButtonToTable0() {

        Callback<TableColumn<Dossier, Void>, TableCell<Dossier, Void>> cellFactory = new Callback<TableColumn<Dossier, Void>, TableCell<Dossier, Void>>() {
            @Override
            public TableCell<Dossier, Void> call(final TableColumn<Dossier, Void> param) {
                final TableCell<Dossier, Void> cell = new TableCell<Dossier, Void>() {

                    private final Button btn = new Button("Bo");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Dossier data = getTableView().getItems().get(getIndex());
                            // Perform action with data
                            Logiciel.setDossierCourrant(data);
                            try {
                                Parent root =  FXMLLoader.load(getClass().getResource("Fiches.fxml"));
                                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }


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

        tableColumnFiches.setCellFactory(cellFactory);

    }

    private void addButtonToTable() {
        Callback<TableColumn<Dossier, Void>, TableCell<Dossier, Void>> cellFactory = new Callback<TableColumn<Dossier, Void>, TableCell<Dossier, Void>>() {
            @Override
            public TableCell<Dossier, Void> call(final TableColumn<Dossier, Void> param) {
                final TableCell<Dossier, Void> cell = new TableCell<Dossier, Void>() {

                    private final Button btn = new Button("Bo");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Dossier data = getTableView().getItems().get(getIndex());
                            // Perform action with data
                            Logiciel.setDossierCourrant(data);
                            try {
                                Parent root =  FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
                                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                                scene = new Scene(root);
                                stage.setScene(scene);
                                stage.centerOnScreen();
                                stage.show();

                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }


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

        tableColumnBo.setCellFactory(cellFactory);
    }



    private void initiate() {

            this.numdossier.setText(String.valueOf(dossierCurrant.getNumDossier()));
            this.date.setText(dossierCurrant.getDate_naissance());
            this.lieu.setText(dossierCurrant.getLieu_naissance());

    }


}