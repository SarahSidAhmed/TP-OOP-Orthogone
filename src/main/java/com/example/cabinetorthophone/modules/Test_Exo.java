package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.Set;

public class Test_Exo extends Test implements TotalScore, Serializable {

    private Set<Exercice> exercices;


    public void Test_Exo(String nom, int capacite, Set<Exercice> exercices ){

        super.setNom(nom);
        super.setCapacite(capacite);
        this.exercices = exercices;

    }


    @Override
    public int calculateTotalScore() throws ScoreException {
        return 0;
    }

    public Set<Exercice> getExercices() {
        return exercices;
    }

    public void setExercices(Set<Exercice> exercices) {
        this.exercices = exercices;
    }
}
