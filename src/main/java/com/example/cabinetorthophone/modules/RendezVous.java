package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.time.ZonedDateTime;

public abstract class RendezVous implements Serializable, Rendez_VousSet {
    private ZonedDateTime date;
    private String duree;
    private Type_RV type;
    private String observation;

    public RendezVous() {
    }

    public RendezVous(ZonedDateTime date, Type_RV type, String observation) {
        this.date = date;
        this.type = type;
        this.observation = observation;

    }

    public ZonedDateTime getDate() {
        return this.date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public String getDuree() {
        return this.duree;
    }

    @Override
    public void setDuree(String duree) {
        this.duree = duree;
    }


    @Override
    public void setTypeRV(Type_RV type) {
        this.type = type;
    }

    public Type_RV getType() {
        return this.type;
    }

    public String getObservation() {
        return this.observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    void modifier_RV(ZonedDateTime newDate, String newHour) {
        this.setDate(newDate);
    }


    void afficher() {
        System.out.println("Date: " + String.valueOf(this.getDate()));
        System.out.println("Durée: " + this.getDuree());
        System.out.println("Observation: " + this.getObservation());
    }


}
