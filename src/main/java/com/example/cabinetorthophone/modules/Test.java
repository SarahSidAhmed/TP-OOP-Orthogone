package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.Objects;

public abstract class Test implements Serializable {
    private String nom;
    private int capacite;

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom(){
        return this.nom;
    }

    public void setCapacite(int i){
        this.capacite = i;
    }

    public int getCapacite(){return this.capacite;}

    @Override
    public boolean equals(Object o) {
        return Objects.equals(this.nom, (String) o);
    }
}
