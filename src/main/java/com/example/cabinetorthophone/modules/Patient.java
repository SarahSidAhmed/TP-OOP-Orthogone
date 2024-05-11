package com.example.cabinetorthophone.modules;

public abstract class Patient {
    private String nom;
    private String prenom;
    private int age;
    private static int compteur = 0;
    private int num_dossier;
    private int nb_rv;
    private String date_naissance;
    private String lieu_naissance;
    private String adresse;

    public Patient(String nom, String prenom, int age, int nb_rv, String date_naissance, String lieu_naissance, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.lieu_naissance = lieu_naissance;
        this.date_naissance = date_naissance;
        this.adresse = adresse;
        this.num_dossier = ++compteur;
        this.nb_rv = nb_rv;
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

    public String getLieu_naissance() {
        return this.lieu_naissance;
    }

    public void setLieu_naissance(String lieu_naissance) {
        this.lieu_naissance = lieu_naissance;
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
        System.out.println("Date de naissance: " + this.date_naissance);
        System.out.println("Lieu de naissance: " + this.lieu_naissance);
        System.out.println("Adresse: " + this.adresse);
    }

    public int getNb_rv() {
        return this.nb_rv;
    }

    public void setNb_rv(int nb_rv) {
        this.nb_rv = nb_rv;
    }

    public String getDate_naissance() {
        return this.date_naissance;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
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

        if (newDate_naissance != null) {
            this.date_naissance = newDate_naissance;
        } else {
            System.out.println("Veuilleez entrer une date de nissance pour le patient.");
        }

        if (newLieu_naissance != null && !newLieu_naissance.isEmpty()) {
            this.lieu_naissance = newLieu_naissance;
        } else {
            System.out.println("Veuilleez entrer un lieu de naissance pour le patient.");
        }

        if (newAdresse != null && !newAdresse.isEmpty()) {
            this.adresse = newAdresse;
        } else {
            System.out.println("Veuilleez entrer une adresse pour le patient.");
        }

    }
}
