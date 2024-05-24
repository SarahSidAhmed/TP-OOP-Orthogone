package com.example.cabinetorthophone.modules;

import javafx.scene.paint.Paint;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Iterator;


    public class Atelier extends RendezVous implements Serializable {
        private HashSet<Patient> patients;
        private String thematique;
        private int numPatient=0;
        private static int idAtelier=0;
        private int id;

        public Atelier(ZonedDateTime time , String observation, HashSet<Patient> patients, String thematique) {
            super(time, Type_RV.ATELIER, observation );
            this.setDuree();
            this.id = idAtelier;
            idAtelier++;
            this.numPatient = 0;
            Logiciel.getPatientCurrant().incrementNB_RV();
            this.patients = patients;
            this.thematique = thematique;
        }

        public static void setCompteurAtelier(int cp){idAtelier = cp;}
        public void afficher() {
            Iterator var1 = this.patients.iterator();

            while(var1.hasNext()) {
                Patient patient = (Patient)var1.next();
                patient.afficherProfile();
            }

            System.out.println("Thématique: " + this.thematique);
        }

        public HashSet<Patient> getPatients(){return this.patients;}

        public void addPatient(Patient p){
            this.patients.add(p);
            setNumPatient(this.numPatient++);
        }

        public Patient rechercherPatientByNum(int num){
            for (Patient p : this.patients){
                if (p.getNum_dossier()==num){
                    return p;
                }
            }
            return null;
        }
        public String getDurre(){return super.getDuree();}

        @Override
        public void setDuree() {
            super.setDuree("1:00");
        }

        public void setTypeRV(Type_RV typeRV) {
            super.setTypeRV(Type_RV.ATELIER);
        }

        public String getThematique(){return this.thematique;}
        public void setThematique(String thema){this.thematique = thema;}

        public int getNumPatient() {
            return numPatient;
        }

        public void setNumPatient(int numPatient) {
            this.numPatient = numPatient;
        }

        public int getId() {
            return id;
        }
    }


