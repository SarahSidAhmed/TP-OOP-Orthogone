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

public class ConnexionController {

    @FXML
    private TextField email;
    @FXML
    private TextField password;

    @FXML
    private Label errorText;

    @FXML
    protected void connexion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(""));

        Orthogone o1 = new Orthogone("Hic", "Sid", "Alger", "0777796966", "sid@gmail.com", "1234");
        String val = Logiciel.CreerCompte(o1);

        errorText.setText(val);
        if (!this.password.getText().isEmpty() && !this.email.getText().isEmpty()) {
            if (Logiciel.seConnecter(email.getText(), password.getText())) {
                Orthogone o = Logiciel.getOrthogonistes().get(email.getText());

                FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Home.fxml"));
                Parent root = loader2.load();

                // Accédez au contrôleur de la page d'accueil si nécessaire
                HomeController homeController = loader2.getController();
                homeController.setUser(o);
                // Affichez la vue de la page d'accueil sur la scène principale
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } else {

                this.errorText.setText("User doesn't exist!");
            }
        }
        else {
            this.errorText.setText("Fields can not be empty!");
        }
    }
}
