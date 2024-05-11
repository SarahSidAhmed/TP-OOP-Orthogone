package com.example.cabinetorthophone.modules;

public class Adulte extends Patient {
    private String diplome;
    private String tel;
    private String profession;

    public Adulte(String nom, String prenom, int age, int nb_rv, String date_naissance, String lieu_naissance, String adresse, String diplome, String tel, String profession) {
        super(nom, prenom, age, nb_rv, date_naissance, lieu_naissance, adresse);
        this.diplome = diplome;
        this.tel = tel;
        this.profession = profession;
    }

    public String getDiplome() {
        return this.diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
        System.out.println("Téléphone: " + this.tel);
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

        if (newTel != null && !newTel.isEmpty()) {
            this.tel = newTel;
        } else {
            System.out.println("Veuilleez entrer le numero de telephone du patient.");
        }

    }
}


