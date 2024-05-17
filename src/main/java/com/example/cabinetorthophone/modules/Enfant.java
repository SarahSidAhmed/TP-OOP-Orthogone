package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Enfant extends Patient implements Serializable {
    private String etude;

    public Enfant(String nom, String prenom, int age, String adresse, String etude, String tel_parent) {
        super(nom, prenom,tel_parent,  age, adresse);
        this.etude = etude;
    }

    public String getEtude() {
        return this.etude;
    }

    public void setEtude(String etude) {
        this.etude = etude;
    }


    public void afficherProfile() {
        super.afficherProfile();
        System.out.println("Niveau D etude : " + this.etude);

    }

    public void modifierProfil(String newNom, String newPrenom, int newAge, int newNb_RV, String newDate_naissance, String newLieu_naissance, String newAdresse, String newEtude, String newTel_parent) {
        super.modifierProfil(newNom, newPrenom, newAge, newNb_RV, newDate_naissance, newLieu_naissance, newAdresse);
        if (newEtude != null && !newEtude.isEmpty()) {
            this.etude = newNom;
        } else {
            System.out.println("Veuilleez entrer un niveau d'etude pour le patient.");
        }

//        if (newTel_parent != null && !newTel_parent.isEmpty()) {
//            this.tel_parent = newTel_parent;
//        } else {
//            System.out.println("Veuilleez entrer un numero de tel du parent du patient.");
//        }

    }
}

