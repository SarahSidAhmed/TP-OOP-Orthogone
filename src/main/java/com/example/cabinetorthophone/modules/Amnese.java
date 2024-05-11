package com.example.cabinetorthophone.modules;


import java.util.Arrays;

import java.util.Arrays;

public class Amnese {
    private Question_amnese[] questions;

    public Amnese() {
    }

    public Question_amnese[] getQuestions() {
        return this.questions;
    }

    public void setQuestions(Question_amnese[] questions) {
        this.questions = questions;
    }

    public void ajouterQuestion(Question_amnese question) {
        if (this.questions.length == this.capaciteMax()) {
            System.out.println("Le tableau est plein, impossible d'ajouter une nouvelle question.");

            for(int i = 0; i < this.questions.length; ++i) {
                if (this.questions[i] == null) {
                    this.questions[i] = question;
                    System.out.println("Question ajoutée avec succès.");
                    return;
                }
            }
        }

    }

    private int capaciteMax() {
        return this.questions.length;
    }

    public void supprimerQuestion(String enonce) {
        for(int i = 0; i < this.questions.length; ++i) {
            if (this.questions[i] != null) {
                this.questions[i].getQuestions();
            }
        }

        System.out.println("Question non trouvée.");
    }

    public int rechercheQuestion(String enonce) {
        for(int i = 0; i < this.questions.length; ++i) {
            if (this.questions[i] != null) {
                this.questions[i].getQuestions();
            }
        }

        return -1;
    }

    public void afficherAmnese() {
        for(int i = 0; i < this.questions.length; ++i) {
            if (this.questions[i] != null) {
                System.out.println(Arrays.toString(this.questions[i].getQuestions()));
            }
        }

    }
}
