package com.example.cabinetorthophone.modules;

import java.util.Date;

public class Consultation extends RendezVous {
    private String nom;
    private String prenom;
    private int age;

    public Consultation(Date date, String heure, String duree, Type_RV type, String observation, String nom, String prenom, int age) {
        super(date, heure, duree, type, observation);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAge(age);
    }

    public void setDuree(String dure) {
        if (this.age > 18) {
            this.setDuree("1:30");
        } else {
            this.setDuree("2:30");
        }

    }

    public void setTypeRV(Type_RV type) {
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

