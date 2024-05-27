package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Epreuve implements Serializable {
    private String oversevationsCliniques;
    private HashMap<Test, Compte_Rendu> tests;
    private ArrayList<Test> test;


    public Epreuve(String oversevationsCliniques, HashMap<Test, Compte_Rendu> tests) {

        this.oversevationsCliniques = oversevationsCliniques;
        this.tests = tests;
    }

    public Epreuve(){

        test = new ArrayList<>();
        this.tests = new HashMap<>();
    }

    public HashMap<Test, Compte_Rendu> getTests(){return this.tests;}

    public void setTests(HashMap<Test, Compte_Rendu> tests){this.tests = tests;}


    public void setOversevationsCliniques(String oversevationsCliniques){this.oversevationsCliniques = oversevationsCliniques;}


    public void addTest(Test test){
        Compte_Rendu c = new Compte_Rendu();
        this.tests.put(test, c);
    }

    public void supprimerTest(String nom){
        this.tests.remove(nom);

    }

    public ArrayList<Test> getTest() {
        return test;
    }

    public void setTest(ArrayList<Test> test) {
        this.test = test;
    }



    // TO DO :

    public void addTest(HashMap<Test, Compte_Rendu> hash) {
        // this.tests.
    }
}
