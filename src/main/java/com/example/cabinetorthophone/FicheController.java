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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

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


    @FXML TableView<Objectif> tableViewFiche;
    @FXML TableColumn<Objectif, String> tableColumnObjectif;
    @FXML TableColumn<Objectif, Type_Terme> tableColumnTerme;
    @FXML TableColumn<Objectif, Integer> tableColumnNote;
    @FXML TableColumn<Objectif, Void> tableColumnChecked;

    @FXML ChoiceBox<Type_Terme> choiceTerme;
    @FXML TextField nomObjectif;


    

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
            fiche.getObjectifs().remove(selectedIndeces[i].intValue());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        fiche =Logiciel.getFicheCourrant();

        tableColumnObjectif.setCellValueFactory(new PropertyValueFactory<Objectif, String>("nom"));
        tableColumnTerme.setCellValueFactory(new PropertyValueFactory<Objectif, Type_Terme>("terme"));
        tableColumnNote.setCellValueFactory(new PropertyValueFactory<Objectif, Integer>("note"));

        addButtonToTable();
        List<Objectif> oo = new ArrayList<Objectif>(fiche.getObjectifs());
        ObservableList<Objectif> o = FXCollections.observableArrayList(oo);


        ObservableList<Type_Terme> cateogires= FXCollections.observableArrayList(Arrays.asList(Type_Terme.values()));
        choiceTerme.setItems(cateogires);
        tableViewFiche.setItems(o);

        editDate();

    }

    private void addButtonToTable() {

            Callback<TableColumn<Objectif, Void>, TableCell<Objectif, Void>> cellFactory = new Callback<TableColumn<Objectif, Void>, TableCell<Objectif, Void>>() {
                @Override
                public TableCell<Objectif, Void> call(final TableColumn<Objectif, Void> param) {
                    final TableCell<Objectif, Void> cell = new TableCell<Objectif, Void>() {

                        private final Button btn = new Button("Check");

                        {
                            btn.setStyle("-fx-background-color: #425c59;");
                            btn.setPrefHeight(32.0);
                            btn.setPrefWidth(118.0);

                            btn.setTextFill(javafx.scene.paint.Color.WHITE);
                            btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                            btn.setOnAction((event) -> {
                                Objectif data = getTableView().getItems().get(getIndex());

                                //HEREEEEE     Perform action with data
                                data.setChecked(true);
                                btn.setStyle("-fx-background-color: #429c59;");
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

            tableColumnChecked.setCellFactory(cellFactory);
        }



    @FXML
    protected void ajouterObjectif(ActionEvent event) throws IOException, NoteException {
        if (choiceTerme.getValue() != null && !nomObjectif.getText().isEmpty()){
            Type_Terme categorie = choiceTerme.getValue();
            String enonce = nomObjectif.getText();

            Objectif q = new Objectif(enonce, 0, categorie);
            fiche.ajouterObjectif(q);
            ArrayList<Objectif> listQuestion = fiche.getObjectifs();
            ObservableList<Objectif> listObs = FXCollections.observableArrayList(listQuestion);

            tableViewFiche.setItems(listObs);

        }
    }


    protected void editDate(){

        tableColumnObjectif.setCellFactory(TextFieldTableCell.<Objectif>forTableColumn());
        tableColumnObjectif.setOnEditCommit(event ->{
            Objectif p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setNom(event.getNewValue());
        });

        StringConverter<Integer> integerStringConverter = new IntegerStringConverter();

        tableColumnNote.setCellFactory(TextFieldTableCell.<Objectif, Integer>forTableColumn(integerStringConverter));
        tableColumnNote.setOnEditCommit(event ->{
            Objectif p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            try {
                p.setNote(event.getNewValue());
            } catch (NoteException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void Back(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("VisualiserFiche.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }
}
