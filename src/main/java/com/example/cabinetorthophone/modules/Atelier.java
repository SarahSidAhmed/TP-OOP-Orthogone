package com.example.cabinetorthophone.modules;

import java.util.HashSet;
import java.util.Iterator;


    public class Atelier extends RendezVous {
        private HashSet<Patient> patients;
        private String thematique;

        public Atelier(HashSet<Patient> patients, String thematique) {
            this.patients = patients;
            this.thematique = thematique;
        }

        public void afficher() {
            Iterator var1 = this.patients.iterator();

            while(var1.hasNext()) {
                Patient patient = (Patient)var1.next();
                patient.afficherProfile();
            }

            System.out.println("Thématique: " + this.thematique);
        }

        public void setTypeRV(Type_RV type) {
        }
    }


