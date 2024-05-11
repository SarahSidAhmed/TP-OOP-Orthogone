package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Question implements Serializable {
    private String categorie;
    private String enonce;
    int score;

    public Question(String categorie, String enonce, int score){
        this.categorie = categorie;
        this.enonce = enonce;
        this.score = score;
    }

    public void afficher(){

    }


    //GETTERS & SETTERS
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie(){
        return this.categorie;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public int getScore() {
        return score;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
