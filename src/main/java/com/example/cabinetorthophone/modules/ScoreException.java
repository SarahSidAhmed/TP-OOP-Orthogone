package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class ScoreException extends Exception {
    public void ScoreException(){
        System.out.println("Le score ne peu depasser l'intervalle [0,10]");
    }
}
