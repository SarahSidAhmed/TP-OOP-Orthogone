package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Logiciel;
import com.example.cabinetorthophone.modules.Orthogone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreationController {

    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField address;
    @FXML
    TextField tel;
    @FXML
    TextField email;
    @FXML
    TextField pass;
    @FXML
    TextField conPass;
    @FXML
    Label errorLabel;



    @FXML
    protected void inscription(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("creation.fxml"));

        String nom1 = nom.getText();
        String prenom1 = prenom.getText();
        String address1 = address.getText();
        String email1 = email.getText();
        String pass1 = pass.getText();
        String conPass1 = conPass.getText();
        String telephone = tel.getText();

        if (!nom1.isEmpty() &&
                !prenom1.isEmpty() &&
                !address1.isEmpty() &&
                !email1.isEmpty() &&
                !pass1.isEmpty() &&
                !conPass1.isEmpty() &&
                !telephone.isEmpty()) {
            if (pass1.equals(conPass1)) {
                Orthogone orthogone = new Orthogone(nom1, prenom1, address1, telephone, email1, pass1);
                Logiciel.CreerCompte(orthogone);

                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loader2.load();

                // Accédez au contrôleur de la page d'accueil si nécessaire
                HomeController homeController = loader2.getController();
                homeController.setUser(orthogone);
                // Affichez la vue de la page d'accueil sur la scène principale
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

            } else {
                errorLabel.setText("Verifier votre mot de passe");
            }
        }else errorLabel.setText("CHamps ne peuvent pas etre vides!");

//        try{
//            FXMLLoader loader2 = new FXMLLoader(getClass().getResource(""))
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }

}
