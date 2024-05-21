package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public abstract class Patient implements Serializable {
    private String nom;
    private String prenom;
    private int age;
    private static int compteur = 0;
    private int num_dossier;
    private int nb_rv;
    private String adresse;
    private String tel;

    public Patient(){

    }


    public Patient(String nom, String prenom, String tel, int age, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
        this.adresse = adresse;
        this.num_dossier = ++compteur;
        this.nb_rv = 0;

    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            boolean var10000;
            label37: {
                Patient patient = (Patient)o;
                if (this.num_dossier == patient.num_dossier) {
                    if (this.nom != null) {
                        if (this.nom.equals(patient.nom)) {
                            break label37;
                        }
                    } else if (patient.nom == null) {
                        break label37;
                    }
                }

                var10000 = false;
                return var10000;
            }

            var10000 = true;
            return var10000;
        } else {
            return false;
        }
    }

    public int hashCode() {
        Integer num = this.num_dossier;
        return num.hashCode();
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

    public int getNum_dossier() {
        return this.num_dossier;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void afficherProfile() {
        System.out.println("Nom: " + this.nom);
        System.out.println("Prenom: " + this.prenom);
        System.out.println("Age: " + this.age);
        System.out.println("Num_dossier: " + this.num_dossier);
        System.out.println("Nombre de rendez_vous: " + this.nb_rv);
        System.out.println("Adresse: " + this.adresse);
    }

    public int getNb_rv() {
        return this.nb_rv;
    }

    public void incrementNB_RV(){
        this.nb_rv++;
    }

    public void setNb_rv(int nb_rv) {
        this.nb_rv = nb_rv;
    }

    public void modifierProfil(String newNom, String newPrenom, int newAge, int newNb_RV, String newDate_naissance, String newLieu_naissance, String newAdresse) {
        if (newNom != null && !newNom.isEmpty()) {
            this.nom = newNom;
        } else {
            System.out.println("Veuilleez entrer un nom pour le patient.");
        }

        if (newPrenom != null && !newPrenom.isEmpty()) {
            this.prenom = newPrenom;
        } else {
            System.out.println("Veuilleez entrer un prenom pour le patient.");
        }

        if (newAge >= 0) {
            this.age = newAge;
        } else {
            System.out.println("Veuilleez entrer un age valide pour le patient.");
        }

        if (newNb_RV >= 0) {
            this.nb_rv = newNb_RV;
        } else {
            System.out.println("Veuilleez entrer un numero de rendez vous valide pour le patient.");
        }

        if (newAdresse != null && !newAdresse.isEmpty()) {
            this.adresse = newAdresse;
        } else {
            System.out.println("Veuilleez entrer une adresse pour le patient.");
        }

    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
