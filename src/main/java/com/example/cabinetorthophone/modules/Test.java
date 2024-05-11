package com.example.cabinetorthophone.modules;

import java.io.Serializable;

abstract class Test implements Serializable {
    private String nom;
    private int capacite;
    private String[] observations;

    public void ajouterObservations(String observation){
        this.observations[this.observations.length] = observation;
    }

    public void modifierObservation(int i, String observation){
        this.observations[i] = observation;
    }

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

    public void setObservations(String[] observations){
        this.observations = observations;
    }
    public String[] getObservations(){
        return this.observations;
    }

}
