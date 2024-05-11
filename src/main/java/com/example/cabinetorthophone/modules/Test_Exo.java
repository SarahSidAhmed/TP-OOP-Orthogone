package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.Set;

public class Test_Exo extends Test implements TotalScore, Serializable {

    private Set<Exercice> exercices;


    public void Test_Exo(String nom, int capacite, String[] observations, Set<Exercice> exercices ){

        super.setNom(nom);
        super.setCapacite(capacite);
        super.setObservations(observations);
        this.exercices = exercices;

    }


    @Override
    public int calculateTotalScore() throws ScoreException {
        return 0;
    }
}
