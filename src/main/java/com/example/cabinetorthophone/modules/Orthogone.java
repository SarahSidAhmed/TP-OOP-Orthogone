package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Orthogone implements Comparable<Orthogone>, Serializable
{
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String password;
    private HashSet<Patient> patients;
    private ArrayList<Dossier> dossiers;
    private Agenda agenda;

    public Orthogone(String nom, String prenom, String adresse, String telephone, String email, String password, HashSet<Patient> patients, Agenda agenda, ArrayList<Dossier> dossiers) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setPassword(password);
        this.setDossiers(dossiers);
        this.setAgenda(agenda);
        this.setPatients(patients);
    }

    public Orthogone(String nom, String prenom, String adresse, String telephone, String email, String password) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTelephone(telephone);
        this.setEmail(email);
        this.setPassword(password);
        this.patients = new HashSet<Patient>();
        this.dossiers = new ArrayList<Dossier>();
        this.agenda = new Agenda();
    }

    public void modifierProfile(String nom, String prenom, String adresse, String telephone) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setTelephone(telephone);
    }

    public void ajouterPatient(Patient patient, int numDossier) {
        if (patient != null && numDossier != -1) {
            this.patients.add(patient);
            Dossier d = new Dossier(numDossier);
            this.dossiers.add(d);
        }

    }


    public void supprimerPatient(Patient patient) {
        if (patient != null) {
            this.patients.remove(patient);
        }

    }

    public void programmerRendezVous(RendezVous rendez_vous) {
        if (rendez_vous != null) {
            this.agenda.ajouterRV(rendez_vous);
        }

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

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(HashSet<Patient> patients) {
        if (patients != null) {
            this.patients = patients;
        } else {
            this.patients = new HashSet();
        }

    }

    public Patient rechercherPatientByDossier(int num){

        HashSet<Patient> p = getPatients();
        if (getDossiers().contains(num)){
            for (Patient p1 : p){
                if (p1.getNum_dossier() == num){
                    return p1;
                }
            }
        }
        return  null;
    }

    public ArrayList<Dossier> getDossiers() {
        return this.dossiers;
    }

    public void setDossiers(ArrayList<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    public Agenda getAgenda() {
        return this.agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public int compareTo(Orthogone o) {
        return 0;
    }

    public void creerDossier(Dossier nouveauDossier) {
        if (nouveauDossier != null && !this.dossiers.contains(nouveauDossier)) {
            this.dossiers.add(nouveauDossier);
        } else {
            System.out.println("Impossible de creer le dossier : Ce dossier existe deja.");
        }

    }
}
