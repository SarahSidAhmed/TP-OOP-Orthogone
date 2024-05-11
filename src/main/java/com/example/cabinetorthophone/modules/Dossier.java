package com.example.cabinetorthophone.modules;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Dossier implements Serializable {
    private static int compteurNumDossier = 0;
    private int numDossier;
    private ArrayList<RendezVous> listeRendezVous;
    private ArrayList<Bo> bo;
    private ArrayList<Fiche> listeFiches;

    public Dossier() {
        this.numDossier = ++compteurNumDossier;
        this.listeRendezVous = new ArrayList();
        this.listeFiches = new ArrayList();
    }

    public void ajouterBO(ArrayList<Bo> bo) {
        this.setBo(bo);
    }

    public void ajouterFiche(Fiche fiche) {
        if (fiche != null) {
            this.listeFiches.add(fiche);
        }

    }

    public void ajouterRendezVous(RendezVous rendezVous) {
        if (rendezVous != null) {
            this.listeRendezVous.add(rendezVous);
        }

    }

    public void consulterBO() {
    }

    public Fiche consulterFiche(int index) {
        return index >= 0 && index < this.listeFiches.size() ? (Fiche)this.listeFiches.get(index) : null;
    }

    public void afficherDossier() {
        System.out.println("Numéro du dossier: " + this.numDossier);
        Iterator var1 = this.bo.iterator();

        while(var1.hasNext()) {
            Bo bo = (Bo)var1.next();
            System.out.println(bo.toString());
        }

        System.out.println("Détails du BO: " + this.bo.toString());
        var1 = this.listeRendezVous.iterator();

        while(var1.hasNext()) {
            RendezVous rv = (RendezVous)var1.next();
            System.out.println(rv.toString());
        }

        var1 = this.listeFiches.iterator();

        while(var1.hasNext()) {
            Fiche fiche = (Fiche)var1.next();
            System.out.println(fiche.toString());
        }

    }

    public int getNumDossier() {
        return this.numDossier;
    }

    public ArrayList<Bo> getBo() {
        return this.bo;
    }

    public void setBo(ArrayList<Bo> bo) {
        this.bo = bo;
    }
}
