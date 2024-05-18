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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.System.getenv;
import static java.lang.System.in;

public class HomeControllerPatients implements Initializable {

    private Stage stage;
    private Scene scene;
    private static Orthogone orthogone;


    @FXML TableView<Patient> tableViewPatient;
    @FXML TableColumn<Patient, String> tableColumnNom;
    @FXML TableColumn<Patient, String> tableColumnPrenom;
    @FXML TableColumn<Patient, Integer> tableColumnAge;
    @FXML TableColumn<Patient, Integer> tableColumnNum;
    @FXML TableColumn<Patient, String> tableColumnTel;
    @FXML TableColumn<Patient, Void> tableColumnCheck;
    @FXML TableColumn<Patient, String> tableColumnAddress;


    private ZonedDateTime dateFocus;
    private ZonedDateTime today;




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
    public void AgendaCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeAgenda.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ProfileCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML
    protected void ajouterPatient(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AjouterPatient.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dateFocus = ZonedDateTime.now();
        today = ZonedDateTime.now();

        orthogone = Logiciel.getOrthogoneCourrant();
        tableColumnNom.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
        tableColumnPrenom.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
        tableColumnAge.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
        tableColumnTel.setCellValueFactory(new PropertyValueFactory<Patient, String>("tel"));
        tableColumnNum.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("num_dossier"));

        //tableColumnCheck.setCellValueFactory(new PropertyValueFactory<Patient, Void>("button"));
        tableColumnAddress.setCellValueFactory(new PropertyValueFactory<Patient, String>("adresse"));

        Patient p = new Enfant("Sarah", "Sid", 10, "Alger", "ESI", "07796953");
        Patient p1 = new Enfant("Hic", "Sid", 3, "Alger", "ESI", "07796953");
        Patient p2 = new Enfant("Djamel", "Sid", 5, "Alger", "ESI", "07796953");
        Patient p3 = new Enfant("Sora", "Sid", 0, "Alger", "ESI", "07796953");
        Patient p4 = new Enfant("Lyna", "Benahmed", 1, "Alger", "ESI", "07796953");
        Patient p5 = new Enfant("Fatima", "Senouci", 2, "Alger", "ESI", "07796953");


        orthogone.ajouterPatient(p, p.getNum_dossier());
        orthogone.ajouterPatient(p1, p1.getNum_dossier());
        orthogone.ajouterPatient(p2, p2.getNum_dossier());
        orthogone.ajouterPatient(p3, p3.getNum_dossier());
        orthogone.ajouterPatient(p4, p4.getNum_dossier());
        orthogone.ajouterPatient(p5, p5.getNum_dossier());


        int year = dateFocus.getYear();
        int month = dateFocus.getMonth().getValue();

//        ZonedDateTime time = ZonedDateTime.of(year, month, 5, 16,0,0,0,dateFocus.getZone());
//        RendezVous rv = new Consultation(time, " ", p.getNom(), p.getPrenom(), p.getAge());
//        orthogone.programmerRendezVous(rv);

        addButtonToTable();
        List<Patient> oo = new ArrayList<>(orthogone.getPatients());
        ObservableList<Patient> o = FXCollections.observableArrayList(oo);

        tableViewPatient.setItems(o);
        editDate();
    }

    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Patient> selectionModel = tableViewPatient.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewPatient.getItems().remove(selectedIndeces[i].intValue());
        }
    }


    protected void editDate(){


        //ENABLING THE EDITIBILITY OF THE CELLS
        tableColumnNom.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnNom.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setNom(event.getNewValue());
        });

        tableColumnPrenom.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnPrenom.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setPrenom(event.getNewValue());
        });

        StringConverter<Integer> integerStringConverter = new IntegerStringConverter();

        tableColumnAge.setCellFactory(TextFieldTableCell.<Patient, Integer>forTableColumn(integerStringConverter));
        tableColumnAge.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setAge(event.getNewValue());
        });

        tableColumnTel.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnTel.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setTel(event.getNewValue());
        });

        tableColumnAddress.setCellFactory(TextFieldTableCell.<Patient>forTableColumn());
        tableColumnAddress.setOnEditCommit(event ->{
            Patient p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setAdresse(event.getNewValue());
        });

    }

    private void addButtonToTable() {
        Callback<TableColumn<Patient, Void>, TableCell<Patient, Void>> cellFactory = new Callback<TableColumn<Patient, Void>, TableCell<Patient, Void>>() {
            @Override
            public TableCell<Patient, Void> call(final TableColumn<Patient, Void> param) {
                final TableCell<Patient, Void> cell = new TableCell<Patient, Void>() {

                    private final Button btn = new Button("Check");

                    {

                        btn.setPrefHeight(32.0);
                        btn.setPrefWidth(118.0);
                        btn.setStyle("-fx-background-color: #425c59;");
                        btn.setTextFill(javafx.scene.paint.Color.WHITE);
                        btn.setFont(javafx.scene.text.Font.font("System", javafx.scene.text.FontWeight.BOLD, 14));

                        btn.setOnAction((event) -> {
                            Patient data = getTableView().getItems().get(getIndex());
                            // Perform action with data
                            Logiciel.setPatientCurrant(data);
                            try {
                                Parent root =  FXMLLoader.load(getClass().getResource("PatientDetails.fxml"));
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
