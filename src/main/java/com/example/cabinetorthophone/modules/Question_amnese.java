package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public abstract class Question_amnese implements Serializable {
    private String[] questions;

    public Question_amnese() {
    }

    public String[] getQuestions() {
        return this.questions;
    }

    public void setQuestions(String[] questions) {
        this.questions = questions;
    }
}

