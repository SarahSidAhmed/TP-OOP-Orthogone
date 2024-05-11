package com.example.cabinetorthophone.modules;

import java.util.ArrayList;
import java.util.Arrays;

public class Diagnostique {
    private String[] troubles;
    private Type_Trouble type;

    public Diagnostique(String[] troubles, Type_Trouble type) {
        this.troubles = troubles;
        this.type = type;
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
        System.out.println("Type de Trouble: " + String.valueOf(this.type));
        System.out.println("Liste des troubles: " + Arrays.toString(this.troubles));
    }
}

