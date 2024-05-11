package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Question_Libre extends Question implements ScoreQuestionExo, Serializable {

    private String reponse;

    public Question_Libre(String enonce, String categorie, int score, String reponse){
        super(categorie, enonce, score);
        this.reponse = reponse;
    }


    @Override
    public int calculateTotalScore() throws ScoreException {
        if (this.score > 10 || this.score<0) throw  new ScoreException();
        else return this.score;
    }

    @Override
    public void setCategorie(String categorie) {
        super.setCategorie(categorie);
    }


    @Override
    public void setScore(int score) {
        super.setScore(score);
    }

    @Override
    public int getScore() {
        return super.getScore();
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public String getReponse() {
        return reponse;
    }
}
