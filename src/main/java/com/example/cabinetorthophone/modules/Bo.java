package com.example.cabinetorthophone.modules;


import java.util.ArrayList;
import java.util.Iterator;

public class Bo {
    private ArrayList<Epreuve> epreuves = new ArrayList();
    private Diagnostique diagnostique;
    private String thematique;
    private First_bo first_bo;

    public Bo(ArrayList<Epreuve> epreuves, Diagnostique diagnostique, String thematique, First_bo firstBo) {
        this.epreuves = epreuves;
        this.diagnostique = diagnostique;
        this.thematique = thematique;
        this.first_bo = firstBo;
    }

    public void ajouterEpreuve(Epreuve epreuve) {
        this.epreuves.add(epreuve);
    }

    public void supprimerEpreuve(int position) {
        if (position >= 0 && position < this.epreuves.size()) {
            this.epreuves.remove(position);
        } else {
            System.out.println("Position invalide");
        }

    }

    public void afficherBo() {
        System.out.println("Thématique: " + this.thematique);
        System.out.println("Diagnostique: " + String.valueOf(this.diagnostique));
        System.out.println("Epreuves: ");
        Iterator var1 = this.epreuves.iterator();

        while(var1.hasNext()) {
            Epreuve e = (Epreuve)var1.next();
            System.out.println(e);
        }

    }

    public ArrayList<Epreuve> getEpreuves() {
        return this.epreuves;
    }

    public Diagnostique getDiagnostique() {
        return this.diagnostique;
    }

    public String getThematique() {
        return this.thematique;
    }

    public void setEpreuves(ArrayList<Epreuve> epreuves) {
        this.epreuves = epreuves;
    }

    public void setDiagnostique(Diagnostique diagnostique) {
        this.diagnostique = diagnostique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    public First_bo getFirst_bo() {
        return this.first_bo;
    }

    public void setFirst_bo(First_bo first_bo) {
        this.first_bo = first_bo;
    }
}

