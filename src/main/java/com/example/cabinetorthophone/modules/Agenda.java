package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

    public class Agenda implements Serializable {
        private ArrayList<RendezVous> rendezVous = new ArrayList();

        public Agenda() {
        }


        public ArrayList<Atelier> getAtelier(){

            ArrayList<Atelier> a = new ArrayList<>();
            for (RendezVous rv : this.rendezVous){
                if (rv instanceof Atelier) a.add((Atelier) rv);
            }

            return a;
        }

        public ArrayList<Suivi> getSuivi(){
            ArrayList<Suivi> s = new ArrayList<>();
            for (RendezVous rv : this.rendezVous){
                if (rv instanceof Suivi) s.add((Suivi)rv);
            }

            return s;
        }


        public Atelier findAtelierById(int id){
            for (RendezVous rv : this.rendezVous){
                if (rv instanceof Atelier && ((Atelier) rv).getId()==id) return (Atelier) rv;
            }
            return null;
        }

        public ArrayList<RendezVous> getRendezVous(){return this.rendezVous;}
        public void ajouterRV(RendezVous RV) {
            if (RV != null) {
                this.rendezVous.add(RV);
            }

        }

        public void supprimerRV(Date date, String heure) {
            if (date != null && heure != null) {
                RendezVous rendezVousASupprimer = null;
                Iterator var4 = this.rendezVous.iterator();

                while(var4.hasNext()) {
                    RendezVous rv = (RendezVous)var4.next();
                    if (rv.getDate().equals(date) ) {
                        rendezVousASupprimer = rv;
                        break;
                    }
                }

                if (rendezVousASupprimer != null) {
                    this.rendezVous.remove(rendezVousASupprimer);
                }
            }

        }

        public void Modifier_RV(RendezVous rendezVous, ZonedDateTime date, String heure) {
            if (rendezVous != null && date != null && heure != null) {
                int index = this.rendezVous.indexOf(rendezVous);
                if (index != -1) {
                    rendezVous.setDate(date);

                    this.rendezVous.set(index, rendezVous);
                }
            }

        }
    }


