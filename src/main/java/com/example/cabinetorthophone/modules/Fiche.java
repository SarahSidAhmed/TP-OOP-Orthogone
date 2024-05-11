package com.example.cabinetorthophone.modules;


import java.util.ArrayList;
import java.util.Iterator;

public class Fiche {
    private Type_Terme terme;
    private ArrayList<Objectif> objectifs;

    public Fiche(Type_Terme terme, ArrayList<Objectif> objectifs) {
        this.terme = terme;
        this.objectifs = objectifs;
    }

    public void afficherFiche() {
        System.out.println("Terme: " + String.valueOf(this.terme));
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

    public Type_Terme getTerme() {
        return this.terme;
    }

    public void setTerme(Type_Terme terme) {
        this.terme = terme;
    }
}

