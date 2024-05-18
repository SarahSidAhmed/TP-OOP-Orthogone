package com.example.cabinetorthophone;

import com.example.cabinetorthophone.modules.Logiciel;
import com.example.cabinetorthophone.modules.Orthogone;
import com.example.cabinetorthophone.modules.Patient;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgrammerAtelierController implements Initializable {

    private static Patient patient;
    private static Orthogone orthogone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orthogone = Logiciel.getOrthogoneCourrant();
        patient = Logiciel.getPatientCurrant();
    }
}
