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
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VisualiserFicheController implements Initializable {

    private Orthogone orthogone;
    private Dossier dossier;
    private Stage stage;
    private Scene scene;


    @FXML TableView tableViewFiche;
    @FXML TableColumn tableColumnNum;
    @FXML TableColumn<Fiche, Void> tableColumnCheck;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dossier = Logiciel.getDossierCourrant();
        Integer num = 1;
        tableColumnNum.setCellValueFactory(new PropertyValueFactory<Integer, Integer>("num"));
        tableColumnCheck.setCellValueFactory(new PropertyValueFactory<Fiche, Void>("checked"));

        addButtonToTable();
        List<Fiche> oo = new ArrayList<Fiche>(dossier.getFiche());
        ObservableList<Fiche> o = FXCollections.observableArrayList(oo);

        tableViewFiche.setItems(o);

    }
    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("DossierChoice.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Objectif> selectionModel = tableViewFiche.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewFiche.getItems().remove(selectedIndeces[i].intValue());
        }
    }
    @FXML
    protected void ajouterFiche(ActionEvent event) throws IOException, NoteException {
        Fiche f = new Fiche();

        dossier.ajouterFiche(f);
        ObservableList<Fiche> listObs = FXCollections.observableArrayList(dossier.getFiche());
        tableViewFiche.setItems(listObs);

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
                            Logiciel.setFicheCourrant(data);


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
