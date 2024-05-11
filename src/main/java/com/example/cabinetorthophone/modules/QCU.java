package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class QCU extends Question implements ScoreQuestionExo, Serializable {

    private String[] choix;
    private int num_reponse;

    public QCU(String categorie, String enonce, int score, String[] choix, int num_reponse){
        super(categorie, enonce, score);
        this.choix = choix;
        this.num_reponse = num_reponse;
    }
    @Override
    public int calculateTotalScore() throws ScoreException {
        return 0;
    }


    public int calculateScore(int num_reponse){
        int score = 0;
        if (this.num_reponse == num_reponse){
            super.setScore(10);
            score = 10;
        }
        return score;
    }

    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public String[] getChoix() {
        return choix;
    }

    public void setNum_reponse(int num_reponse) {
        this.num_reponse = num_reponse;
    }

    public int getNum_reponse() {
        return num_reponse;
    }

}
