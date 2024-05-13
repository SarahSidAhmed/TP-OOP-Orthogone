package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Diagnostique implements Serializable {
    private String[] troubles;

    public Diagnostique(String[] troubles) {
        this.troubles = troubles;
    }

    public void ajouterTrouble(String trouble) {
        ArrayList<String> troublesList = new ArrayList(Arrays.asList(this.troubles));
        troublesList.add(trouble);
        this.troubles = (String[])troublesList.toArray(new String[0]);
    }

    public void supprimerTrouble(String trouble) {
        ArrayList<String> troublesList = new ArrayList(Arrays.asList(this.troubles));
        troublesList.remove(trouble);
        this.troubles = (String[])troublesList.toArray(new String[0]);
    }

    public void afficherDiagnostique() {
        System.out.println("Liste des troubles: " + Arrays.toString(this.troubles));
    }
}

