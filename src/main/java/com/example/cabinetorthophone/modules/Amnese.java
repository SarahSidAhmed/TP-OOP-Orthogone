package com.example.cabinetorthophone.modules;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Arrays;

public class Amnese implements Serializable {
    private ArrayList<Question_amnese> questions;

    public Amnese(){
        this.questions = new ArrayList<>();
    }
    public Amnese(ArrayList<Question_amnese> questions) {
        this.questions = questions;
    }

    public ArrayList<Question_enfant> getQuestionsEnfant(){
        ArrayList<Question_enfant> questionEnfants = new ArrayList<>();
        for (Question_amnese q: questions){
            if (q instanceof Question_enfant) questionEnfants.add((Question_enfant) q);
        }
        return questionEnfants;
    }


    public ArrayList<Question_adulte> getQuestionsAdulte(){
        ArrayList<Question_adulte> questionAdultes = new ArrayList<>();

        for (Question_amnese q: questions){
            if (q instanceof Question_adulte) questionAdultes.add((Question_adulte) q);
        }
        return questionAdultes;
    }


    public ArrayList<Question_amnese> getQuestions() {
        return this.questions;
    }

    public void setQuestions(ArrayList<Question_amnese> questions) {
        this.questions = questions;
    }

    public void ajouterQuestion(Question_amnese question) {

        this.questions.add(question);

    }

    private int capaciteMax() {
        return this.questions.size();
    }

}
