package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Logiciel;
import com.example.cabinetorthophone.modules.Orthogone;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ConnexionController {

    @FXML
    private TextField email;
    @FXML
    private TextField password;

    @FXML
    protected void connexion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(""));

        if (Logiciel.seConnecter(email.getText(), password.getText())) {
            Orthogone o = Logiciel.getOrthogonistes().get(email.getText());

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Home.fxml"));
            Parent root = loader2.load();

            // Accédez au contrôleur de la page d'accueil si nécessaire
            HomeController homeController = loader2.getController();
            homeController.setUser(o);
            // Affichez la vue de la page d'accueil sur la scène principale
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }
}
