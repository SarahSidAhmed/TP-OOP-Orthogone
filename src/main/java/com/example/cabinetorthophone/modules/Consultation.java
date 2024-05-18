package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class Consultation extends RendezVous implements Serializable {
    private String nom;
    private String prenom;
    private int age;
    private final String DURRE_ADULTE = "1:30";
    private final String DURRE_ENFANT = "2:30";

    public Consultation(ZonedDateTime date, String observation, String nom, String prenom, int age) {
        super(date, Type_RV.CONSULTATION, observation);
        setDuree();
        Logiciel.getPatientCurrant().incrementNB_RV();
        super.setDuree(getDuree());
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAge(age);
    }



    public void setDuree() {
        if (getAge() >= 18) {
            super.setDuree(DURRE_ADULTE);
        } else {
            super.setDuree(DURRE_ENFANT);
        }

    }

    public void setTypeRV() {
        super.setTypeRV(Type_RV.CONSULTATION);
    }

    void afficher() {
        super.afficher();
        System.out.println("Nom: " + this.nom);
        System.out.println("Prenom: " + this.prenom);
        System.out.println("Age: " + this.age);
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

