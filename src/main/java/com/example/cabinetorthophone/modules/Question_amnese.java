package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.HashSet;

public abstract class Question_amnese implements Serializable {
    private String quesiton;

    public Question_amnese(String quesiton) {
        this.quesiton = quesiton;
    }


    public String getQuesiton() {
        return quesiton;
    }

    public void setQuesiton(String quesiton) {
        this.quesiton = quesiton;
    }
}

