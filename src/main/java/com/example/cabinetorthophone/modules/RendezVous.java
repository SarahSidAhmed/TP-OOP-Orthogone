package com.example.cabinetorthophone.modules;

import java.util.Date;

public abstract class RendezVous implements Rendez_VousSet {
    private Date date;
    private String heure;
    private String duree;
    private Type_RV type;
    private String observation;

    public RendezVous() {
    }

    public RendezVous(Date date, String heure, String duree, Type_RV type, String observation) {
        this.date = date;
        this.heure = heure;
        this.duree = duree;
        this.type = type;
        this.observation = observation;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return this.heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDuree() {
        return this.duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Type_RV getType() {
        return this.type;
    }

    public void setType(Type_RV type) {
        this.type = type;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    void modifier_RV(Date newDate, String newHour) {
        this.setDate(newDate);
        this.setHeure(newHour);
    }

    void afficher() {
        System.out.println("Date: " + String.valueOf(this.getDate()));
        System.out.println("Heure: " + this.getHeure());
        System.out.println("Durée: " + this.getDuree());
        System.out.println("Type: " + String.valueOf(this.getType()));
        System.out.println("Observation: " + this.getObservation());
    }
}
