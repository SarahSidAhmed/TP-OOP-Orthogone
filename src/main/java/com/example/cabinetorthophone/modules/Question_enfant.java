package com.example.cabinetorthophone.modules;


import java.io.Serializable;

public class Question_enfant extends Question_amnese implements Serializable {
    private Type_QuestionEnfant categorie;

    public Question_enfant(String question , Type_QuestionEnfant categories) {
        super(question);
        this.categorie = categories;
    }

    public Type_QuestionEnfant getCategorie() {
        return categorie;
    }

    public void setCategorie(Type_QuestionEnfant categorie) {
        this.categorie = categorie;
    }
}
