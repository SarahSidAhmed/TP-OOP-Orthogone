package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Epreuve implements Serializable {
    private String[] oversevationsCliniques;
    private HashMap<Test, Compte_Rendu> tests;
//    private Compte_Rendu compteRendu;

    public Epreuve(String[] oversevationsCliniques, HashMap<Test, Compte_Rendu> tests) {

        this.oversevationsCliniques = oversevationsCliniques;
        this.tests = tests;
    }

    public Epreuve(){
        this.tests = new HashMap<>();
    }

    public HashMap<Test, Compte_Rendu> getTests(){return this.tests;}

    public void setTests(HashMap<Test, Compte_Rendu> tests){this.tests = tests;}

    public void setOversevationsCliniques(String[] oversevationsCliniques){this.oversevationsCliniques = oversevationsCliniques;}

    public void addObservation(String observation){
        this.oversevationsCliniques[this.oversevationsCliniques.length+1] = observation;
    }

    public void addTest(Test test){
        Compte_Rendu c = new Compte_Rendu();
        this.tests.put(test, c);
    }

    public void supprimerTest(String nom){
        this.tests.remove(nom);

    }
}