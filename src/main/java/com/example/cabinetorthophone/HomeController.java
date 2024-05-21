package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Logiciel;
import com.example.cabinetorthophone.modules.Orthogone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

private static Orthogone orthogone = Logiciel.getOrthogoneCourrant();
private Scene scene;
private Stage stage;

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField address;
    @FXML
    private TextField tel;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private Label textPop;
    @FXML
    private Button profileBtn;



    public void initiation(){
        if (orthogone != null) {
            nom.setText(orthogone.getNom());
            prenom.setText(orthogone.getPrenom());
            address.setText(orthogone.getAdresse());
            tel.setText(orthogone.getTelephone());
            email.setText(orthogone.getEmail());
            password.setText(orthogone.getPassword());
        }
        else textPop.setText("Error NULL!");

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
    protected void ProfileCheck(ActionEvent event){
        initiation();

    }

    @FXML
    protected void sauveGarder(ActionEvent event){

        if (!this.nom.getText().isEmpty() &&
            !this.prenom.getText().isEmpty() &&
            !this.address.getText().isEmpty() &&
            !this.email.getText().isEmpty() &&
            !this.tel.getText().isEmpty()) {

            setPorfile(this.nom.getText(), this.prenom.getText(),
                    this.password.getText(), this.address.getText(), this.tel.getText());

            textPop.setVisible(true);
            textPop.setText("Modification Sauvegarder!");
        }
        else {
            textPop.setVisible(true);
            textPop.setText("Champs ne peuvent pas etre vide!");
        }
    }

    //to set the current user of the app
    public void setUser(Orthogone o){
        this.orthogone = o;
    }


    protected void setPorfile(String nom, String prenom, String password, String address, String tel){
        orthogone.setAdresse(address);
        orthogone.setNom(nom);
        orthogone.setPassword(password);
        orthogone.setPrenom(prenom);
        orthogone.setTelephone(tel);
    }


    public Orthogone getOrthogone(){
        return this.orthogone;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        initiation();
    }

    //allah ghaleb initializer f la poubelle
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        orthogone = Logiciel.getOrthogoneCourrant();
//        initiation();
//    }

}
