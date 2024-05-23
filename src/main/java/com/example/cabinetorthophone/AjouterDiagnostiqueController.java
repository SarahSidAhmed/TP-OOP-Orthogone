package com.example.cabinetorthophone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import com.example.cabinetorthophone.modules.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;


public class AjouterDiagnostiqueController implements Initializable {

    private static Orthogone orthogone;
    private static Patient patient;
    private Scene scene;
    private Stage stage;
    private Diagnostique newDiagnostique;
    private Bo courrentbo;
    private Dossier courrentdossier;


    @FXML private TextField nomTrouble;
    @FXML private ChoiceBox<Type_Trouble> choiceTrouble;
    private Type_Trouble typeTrouble;
    private Trouble newtrouble;

    @FXML TableView<Trouble> tableTrouble;
    @FXML TableColumn<Trouble, String> tableColumnTrouble;
    @FXML TableColumn<Trouble, Type_Trouble> tableColumnType;


    @FXML
    protected void Back(MouseEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("DossierHome.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        orthogone = Logiciel.getOrthogoneCourrant();
        courrentbo = Logiciel.getBoCourrant();

        ObservableList<Type_Trouble> types= FXCollections.observableArrayList(Arrays.asList(Type_Trouble.values()));
        choiceTrouble.setItems(types);


        tableColumnTrouble.setCellValueFactory(new PropertyValueFactory<Trouble , String>("nom"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<Trouble , Type_Trouble>("type"));

        ArrayList<Trouble> troubles = courrentbo.getDiagnostique().getTrouble();
        ObservableList<Trouble> listTrouble = FXCollections.observableArrayList(troubles);

        tableTrouble.setItems(listTrouble);

        ObservableList<Type_Trouble> cateogires= FXCollections.observableArrayList(Arrays.asList(Type_Trouble.values()));
        choiceTrouble.setItems(cateogires);

        editDate();

    }

    @FXML protected void ajouterTrouble(ActionEvent event){

        if (choiceTrouble.getValue() !=null && !nomTrouble.getText().isEmpty()){
            Trouble t = new Trouble(nomTrouble.getText(), choiceTrouble.getValue());
            courrentbo.getDiagnostique().ajouterTrouble(t);

            ArrayList<Trouble> ts = courrentbo.getDiagnostique().getTrouble();
            ObservableList<Trouble> listTrouble = FXCollections.observableArrayList(ts);
            tableTrouble.setItems(listTrouble);
        }

    }

    @FXML
    protected void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Trouble> selectionModel = tableTrouble.getSelectionModel();
        ObservableList<Integer> list = selectionModel.getSelectedIndices();

        Integer[] selectedIndeces = new Integer[list.size()];
        selectedIndeces = list.toArray(selectedIndeces);
        Arrays.sort(selectedIndeces);

        for (int i= selectedIndeces.length -1; i>=0; i-- ){
            selectionModel.clearSelection(selectedIndeces[i].intValue());
            tableTrouble.getItems().remove(selectedIndeces[i].intValue());
            courrentbo.getDiagnostique().getTrouble().remove(selectedIndeces[i].intValue());

        }

    }

    protected void editDate(){

        tableColumnTrouble.setCellFactory(TextFieldTableCell.<Trouble>forTableColumn());
        tableColumnTrouble.setOnEditCommit(event ->{
            Trouble p = event.getTableView().getItems().get(event.getTablePosition().getRow());
            p.setNom(event.getNewValue());
        });

    }

}
