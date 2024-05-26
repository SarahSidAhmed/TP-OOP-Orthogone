package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Exercice implements ScoreQuestionExo, Serializable {

    private String material;
    private String consigne;
    private boolean material_inclu;
    private int[] score;


    public Exercice(String material, String consigne, boolean material_inclu, int[] score){
        this.material = material;
        this.consigne = consigne;
        this.material_inclu = material_inclu;
        this.score = score;
    }

    public void addNewScore(int score){
        this.score[this.score.length] = score;
    }

    public void setScore(int[] score){
        this.score = score;
    }

    public int[] getScore(){
        return this.score;
    }

    public void setMaterial(String material){
        this.material = material;
    }

    public void setConsigne(String consigne){
        this.consigne = consigne;
    }

    public void setMaterial_inclu(Boolean material_inclu){
        this.material_inclu = material_inclu;
    }

    public String getMaterial() {
        return material;
    }

    public String getConsigne() {
        return consigne;
    }

    public boolean isMaterial_inclu() {
        return material_inclu;
    }


    @Override
    public int calculateTotalScore() throws ScoreException {
        return 0;
    }


}
