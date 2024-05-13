package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test_Question extends Test implements TotalScore, Serializable {

    private Set<Question> questions;


    public Test_Question(){
        this.questions = new HashSet<Question>() {
        };
    }

    public void ajouterQuestion(Question q){
        this.questions.add(q);
    }

    public void supprimerQuestion(int i){
        this.questions.remove(i);
    }

    public void modifierQuestion(int i, Question q){

        this.questions.remove(i);
        this.questions.add(q);
    }

    public void rechercherQuestion(String enonce){
        boolean found = false;
        int pos = 0;

        while(pos<this.questions.size() && !found){
            if (this.questions.contains(enonce)){
                found = true;
            }
            else pos++;
        }
    }

    @Override
    public int calculateTotalScore() throws ScoreException {
        int score = 0;
        for (Question q : this.questions){
            score =+ q.getScore();
        }
        score = score/this.questions.size();

        if (score> 10 || score<0) throw new ScoreException();
        else return score;
    }
}
