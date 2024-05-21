package com.example.cabinetorthophone.modules;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Fiche implements Serializable {
    private ArrayList<Objectif> objectifs;

    public Fiche(){
        this.objectifs = new ArrayList<>();
    }
    public Fiche(ArrayList<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

    public void afficherFiche() {
        System.out.print("Objectifs: ");
        Iterator var1 = this.objectifs.iterator();

        while(var1.hasNext()) {
            Objectif o = (Objectif)var1.next();
            System.out.print(String.valueOf(o) + " ");
        }

        System.out.println();
    }

    public void ajouterObjectif(Objectif objectif) {
        this.objectifs.add(objectif);
    }

    public void modifierObjectif(int position, Objectif newObjectif) {
        if (position >= 0 && position < this.objectifs.size()) {
            this.objectifs.set(position, newObjectif);
        } else {
            System.out.println("Position invalide");
        }

    }

    public void supprimerObjectif(int position) {
        if (position >= 0 && position < this.objectifs.size()) {
            this.objectifs.remove(position);
        } else {
            System.out.println("Position invalide");
        }

    }

    public ArrayList<Objectif> getObjectifs() {
        return this.objectifs;
    }

    public void setObjectifs(ArrayList<Objectif> objectifs) {
        this.objectifs = objectifs;
    }

}

