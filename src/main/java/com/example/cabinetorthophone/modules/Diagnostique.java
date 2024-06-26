package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Diagnostique implements Serializable {

    private List<Trouble> troubles;

    public Diagnostique(){
        this.troubles = new ArrayList<>();
    }
    public Diagnostique(List<Trouble> troubles) {
        this.troubles = new ArrayList<>(troubles);
    }

    public void setTroubles(List<Trouble> troubles) {
        this.troubles = troubles;
    }

    public ArrayList<Trouble> getTrouble(){
        return (ArrayList<Trouble>) this.troubles;
    }

    public void ajouterTrouble(Trouble trouble) {
        this.troubles.add(trouble);
    }

    public void supprimerTrouble(Trouble trouble) {
        this.troubles.remove(trouble);
    }

    public void afficherDiagnostique() {
        System.out.println("Liste des troubles: " + this.troubles);
    }



}

