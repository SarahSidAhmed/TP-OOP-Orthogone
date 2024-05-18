package com.example.cabinetorthophone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Accueil.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 795, 540);
        stage.setTitle("Cabinet Orthophoniste");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args){
        launch();
    }
}