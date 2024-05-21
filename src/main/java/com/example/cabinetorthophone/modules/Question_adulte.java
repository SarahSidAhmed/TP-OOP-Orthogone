package com.example.cabinetorthophone.modules;


import java.io.Serializable;

public class Question_adulte extends Question_amnese implements Serializable {
    private Type_QuestionAdulte categorie;


    public Question_adulte(String question, Type_QuestionAdulte categorie) {
        super(question);
        this.categorie = categorie;
    }

    public Type_QuestionAdulte getCategorie() {
        return categorie;
    }

    public void setCategorie(Type_QuestionAdulte categorie) {
        this.categorie = categorie;
    }
}