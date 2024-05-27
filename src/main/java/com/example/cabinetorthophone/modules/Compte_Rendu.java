package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.List;

public class Compte_Rendu implements Serializable {
    private List<Question> questionList;
    private List<Exercice> exerciceList;


    public Compte_Rendu(){

    }

    public void AjouterQuestin (Question qst)
    {
        questionList.add(qst);
    }

    public void AjouterExo (Exercice exo)
    {
        exerciceList.add(exo);
    }
}
