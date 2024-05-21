package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public class Suivi extends RendezVous implements Serializable{
    private int num_dossier;
    private boolean present;

    public Suivi(ZonedDateTime date, Type_RV type, String observation, int num_dossier, boolean present) {
        super(date, Type_RV.SUIVI, observation);
        setDuree();
        this.setPrsent(present);
        Logiciel.getPatientCurrant().incrementNB_RV();
        this.setNum_dossier(num_dossier);
    }

    void afficher() {
        super.afficher();
        System.out.println("Num_dossier: " + this.num_dossier);
        System.out.println("Present: " + this.present);
    }



    public int getNum_dossier() {
        return this.num_dossier;
    }

    public void setNum_dossier(int num_dossier) {
        this.num_dossier = num_dossier;
    }

    public boolean isPrsent() {
        return this.present;
    }

    public void setPrsent(boolean prsent) {
        this.present = prsent;
    }


    public void setTypeRV() {
        super.setTypeRV(Type_RV.SUIVI);
    }

    @Override
    public void setDuree() {
        super.setDuree("1:00");
    }
}

