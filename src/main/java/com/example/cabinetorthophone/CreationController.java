package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Orthogone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    protected void inscription(ActionEvent event){

        FXMLLoader loader = new FXMLLoader(getClass().getResource("creation.fxml"));

        String nom1 = nom.getText();
        String prenom1 = prenom.getText();
        String address1 = address.getText();
        String email1 = email.getText();
        String pass1 = pass.getText();
        String conPass1 = conPass.getText();
        String telephone = tel.getText();

        if (pass1.equals(conPass1)){
        Orthogone orthogone = new Orthogone(nom1, prenom1, address1, telephone, email1, pass1);

        }
        else{
            errorLabel.setText("Verifier votre mot de passe");
        }

//        try{
//            FXMLLoader loader2 = new FXMLLoader(getClass().getResource(""))
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
    }

}
