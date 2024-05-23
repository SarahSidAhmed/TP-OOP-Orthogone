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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HomeAmneseEnfantController implements Initializable {

    private static Orthogone orthogone = Logiciel.getOrthogoneCourrant();
    private static Amnese a;
    private Scene scene;
    private Stage stage;


    @FXML private TextArea enonceQuestion;
    @FXML private ChoiceBox<Type_QuestionEnfant> choiceCategorie;

    @FXML
    TableView<Question_enfant> tableViewQuestion;
    @FXML TableColumn<Question_enfant, String> tableColumnEnonce;
    @FXML TableColumn<Question_enfant, Type_QuestionEnfant> tableColumnCategorie;

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
        Logiciel.sauvegarderUsers();
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

    @FXML protected void goToAdulte(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("HomeAmneseAdulte.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();

        if (orthogone.getAmnese() == null){
        orthogone.setAmnese(new Amnese());
        }
        a = orthogone.getAmnese();

        tableColumnEnonce.setCellValueFactory(new PropertyValueFactory<Question_enfant, String>("quesiton"));
        tableColumnCategorie.setCellValueFactory(new PropertyValueFactory<Question_enfant, Type_QuestionEnfant>("categorie"));



        ArrayList<Question_enfant> listQuestion = a.getQuestionsEnfant();
        ObservableList<Question_enfant> listObs = FXCollections.observableArrayList(listQuestion);

        tableViewQuestion.setItems(listObs);
        ObservableList<Type_QuestionEnfant> cateogires= FXCollections.observableArrayList(Arrays.asList(Type_QuestionEnfant.values()));
        choiceCategorie.setItems(cateogires);

        editData();


    }

    @FXML protected void ajouterQuestion(ActionEvent event){

        if (choiceCategorie.getValue() != null && !enonceQuestion.getText().isEmpty()){
            Type_QuestionEnfant categorie = choiceCategorie.getValue();
            String enonce = enonceQuestion.getText();

            Question_enfant q = new Question_enfant(enonce, categorie);
            a.ajouterQuestion(q);
            ArrayList<Question_enfant> listQuestion = a.getQuestionsEnfant();
            ObservableList<Question_enfant> listObs = FXCollections.observableArrayList(listQuestion);

            tableViewQuestion.setItems(listObs);

        }

    }

    @FXML protected void deleteData(ActionEvent event){

        TableView.TableViewSelectionModel<Question_enfant> selectionModel = tableViewQuestion.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableViewQuestion.getItems().remove(selectedIndeces[i].intValue());
            orthogone.getAmnese().getQuestions().remove(selectedIndeces[i].intValue());

        }
    }

    @FXML protected void editData(){
        //ENABLING THE EDITIBILITY OF THE CELLS
        tableColumnEnonce.setCellFactory(TextFieldTableCell.<Question_enfant>forTableColumn());
        tableColumnEnonce.setOnEditCommit(event ->{
            Question_enfant p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setQuesiton(event.getNewValue());
        });

    }
}
