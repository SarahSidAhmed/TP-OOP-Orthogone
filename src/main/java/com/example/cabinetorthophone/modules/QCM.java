package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class QCM extends Question implements ScoreQuestionExo, Serializable {
    private String[] choix;
    private Set<Integer> reponse;

    public QCM(String categorie, String enonce, int score, String[] choix, Set<Integer> reponse){
        super(categorie, enonce, score);
        this.choix = choix;
        this.reponse = reponse;
    }

    //to calculate the score of the QCM

    public int scoreCalculation(Integer[] reponses) throws ScoreException{
        int i= 0;
        int j = 0;
        int correctAnswers = 0;

        Iterator<Integer> it = this.reponse.iterator();
        while(it.hasNext()){
            Integer r = it.next();
            if (Objects.equals(reponses[i], r)){
                correctAnswers++;
            }
        }
        int score = (correctAnswers) / this.choix.length;

        if (score> 10) throw new ScoreException();
        else {
        super.setScore(score);
        return score;
        }

    }


    @Override
    public int calculateTotalScore() throws ScoreException {

        return 0;
    }


    // Getters
    public String[] getChoix() {
        return choix;
    }

    public Set<Integer> getReponse() {
        return reponse;
    }

    // Setters
    public void setChoix(String[] choix) {
        this.choix = choix;
    }

    public void setReponse(Set<Integer> reponse) {
        this.reponse = reponse;
    }

    public void addChoix(String text) {
        int n= getChoix().length;
        choix[n+1]=" ";
        choix[n+3]=text;
        setChoix(choix);

    }
}
