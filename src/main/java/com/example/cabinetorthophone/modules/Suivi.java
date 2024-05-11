package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.Date;

public class Suivi extends RendezVous implements Serializable {
    private int num_dossier;
    private boolean present;

    public Suivi(Date date, String heure, String duree, Type_RV type, String observation, int num_dossier, boolean present) {
        super(date, heure, duree, type, observation);
        this.setPrsent(present);
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

    @Override
    public void setTypeRV(Type_RV var1) {

    }
}

