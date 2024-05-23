package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Trouble implements Serializable {

    private String nom;
    private Type_Trouble type;

    public Trouble(String nom, Type_Trouble type){

        this.nom = nom;
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Type_Trouble getType() {
        return type;
    }

    public void setType(Type_Trouble type) {
        this.type = type;
    }
}
