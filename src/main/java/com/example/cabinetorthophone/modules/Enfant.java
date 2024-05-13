package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Enfant extends Patient implements Serializable {
    private String etude;
    private String tel_parent;

    public Enfant(String nom, String prenom, int age, int nb_rv, String date_naissance, String lieu_naissance, String adresse, String etude, String tel_parent) {
        super(nom, prenom, age, nb_rv, adresse);
        this.etude = etude;
        this.tel_parent = tel_parent;
    }

    public String getEtude() {
        return this.etude;
    }

    public void setEtude(String etude) {
        this.etude = etude;
    }

    public String getTel_parent() {
        return this.tel_parent;
    }

    public void setTel_parent(String tel_parent) {
        this.tel_parent = tel_parent;
    }

    public void afficherProfile() {
        super.afficherProfile();
        System.out.println("Niveau D etude : " + this.etude);
        System.out.println("Numero tel parent : " + this.tel_parent);
    }

    public void modifierProfil(String newNom, String newPrenom, int newAge, int newNb_RV, String newDate_naissance, String newLieu_naissance, String newAdresse, String newEtude, String newTel_parent) {
        super.modifierProfil(newNom, newPrenom, newAge, newNb_RV, newDate_naissance, newLieu_naissance, newAdresse);
        if (newEtude != null && !newEtude.isEmpty()) {
            this.etude = newNom;
        } else {
            System.out.println("Veuilleez entrer un niveau d'etude pour le patient.");
        }

        if (newTel_parent != null && !newTel_parent.isEmpty()) {
            this.tel_parent = newTel_parent;
        } else {
            System.out.println("Veuilleez entrer un numero de tel du parent du patient.");
        }

    }
}

