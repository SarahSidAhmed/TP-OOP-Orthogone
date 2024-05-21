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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HomeAmneseAdulteController implements Initializable {



    private static Orthogone orthogone = Logiciel.getOrthogoneCourrant();
    private static Amnese a;
    private Scene scene;
    private Stage stage;


    @FXML private TextArea enonceQuestion;
    @FXML private ChoiceBox<Type_QuestionAdulte> choiceCategorie;

    @FXML TableView<Question_adulte> tableViewQuestion;
    @FXML TableColumn<Question_adulte, String> tableColumnEnonce;
    @FXML TableColumn<Question_adulte, Type_QuestionAdulte> tableColumnCategorie;



    @FXML
    public void AgendaCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomeAgenda.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML public void PatientsCheck(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("HomePatients.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML protected void AmneseCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeAmneseEnfant.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML protected void StatistiqueCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeStatistique.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


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
    protected void ProfileCheck(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    @FXML protected void goToEnfant(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeAmneseEnfant.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();

        tableColumnEnonce.setCellValueFactory(new PropertyValueFactory<Question_adulte, String>("quesiton"));
        tableColumnCategorie.setCellValueFactory(new PropertyValueFactory<Question_adulte, Type_QuestionAdulte>("categorie"));

        a = orthogone.getAmnese();

        ArrayList<Question_adulte> listQuestion = a.getQuestionsAdulte();
        ObservableList<Question_adulte> listObs = FXCollections.observableArrayList(listQuestion);

        tableViewQuestion.setItems(listObs);
        ObservableList<Type_QuestionAdulte> cateogires= FXCollections.observableArrayList(Arrays.asList(Type_QuestionAdulte.values()));
        choiceCategorie.setItems(cateogires);

        editData();
    }


    @FXML protected void ajouterQuestion(ActionEvent event){

        if (choiceCategorie.getValue() != null && !enonceQuestion.getText().isEmpty()){
            Type_QuestionAdulte categorie = choiceCategorie.getValue();
            String enonce = enonceQuestion.getText();

            Question_adulte q = new Question_adulte(enonce, categorie);
            a.ajouterQuestion(q);
            ArrayList<Question_adulte> listQuestion = a.getQuestionsAdulte();
            ObservableList<Question_adulte> listObs = FXCollections.observableArrayList(listQuestion);

            tableViewQuestion.setItems(listObs);

        }

    }

    @FXML protected void deleteData(ActionEvent event){

        TableView.TableViewSelectionModel<Question_adulte> selectionModel = tableViewQuestion.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewQuestion.getItems().remove(selectedIndeces[i].intValue());
        }
    }

    @FXML protected void editData(){
        //ENABLING THE EDITIBILITY OF THE CELLS
        tableColumnEnonce.setCellFactory(TextFieldTableCell.<Question_adulte>forTableColumn());
        tableColumnEnonce.setOnEditCommit(event ->{
            Question_adulte p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setQuesiton(event.getNewValue());
        });

    }
}
