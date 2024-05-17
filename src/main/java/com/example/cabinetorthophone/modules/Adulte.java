package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Adulte extends Patient implements Serializable {
    private String diplome;
    private String profession;


    public Adulte(String nom, String prenom, int age, String adresse, String diplome, String tel, String profession) {
        super(nom, prenom,tel, age , adresse);
        this.diplome = diplome;
        this.profession = profession;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getProfession() {
        return this.profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void afficherProfile() {
        super.afficherProfile();
        System.out.println("Diplôme: " + this.diplome);
        System.out.println("Profession: " + this.profession);

    }

    public void modifierProfil(String newNom, String newPrenom, int newAge, int newNb_RV, String newDate_naissance, String newLieu_naissance, String newAdresse, String newEtude, String newTel_parent, String newDiplome, String newProfession, String newTel) {
        super.modifierProfil(newNom, newPrenom, newAge, newNb_RV, newDate_naissance, newLieu_naissance, newAdresse);
        if (newDiplome != null && !newDiplome.isEmpty()) {
            this.diplome = newDiplome;
        } else {
            System.out.println("Veuilleez entrer un diplome pour le patient.");
        }

        if (newProfession != null && !newProfession.isEmpty()) {
            this.profession = newProfession;
        } else {
            System.out.println("Veuilleez entrer une profession pour le patient.");
        }

//        if (newTel != null && !newTel.isEmpty()) {
//            this.tel = newTel;
//        } else {
//            System.out.println("Veuilleez entrer le numero de telephone du patient.");
//        }

    }
}


