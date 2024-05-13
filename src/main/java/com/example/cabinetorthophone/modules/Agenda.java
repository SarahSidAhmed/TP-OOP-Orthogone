package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

    public class Agenda implements Serializable {
        private ArrayList<RendezVous> rendezVous = new ArrayList();

        public Agenda() {
        }

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
                    if (rv.getDate().equals(date) && rv.getHeure().equals(heure)) {
                        rendezVousASupprimer = rv;
                        break;
                    }
                }

                if (rendezVousASupprimer != null) {
                    this.rendezVous.remove(rendezVousASupprimer);
                }
            }

        }

        public void Modifier_RV(RendezVous rendezVous, Date date, String heure) {
            if (rendezVous != null && date != null && heure != null) {
                int index = this.rendezVous.indexOf(rendezVous);
                if (index != -1) {
                    rendezVous.setDate(date);
                    rendezVous.setHeure(heure);
                    this.rendezVous.set(index, rendezVous);
                }
            }

        }
    }

