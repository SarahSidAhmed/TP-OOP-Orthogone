package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class Objectif implements Serializable {

    private String nom;
    private int note;
    private boolean checked;

    public Objectif(String nom, int note) throws NoteException {
        this.nom = nom;
        if (note < 0 || note > 20) {
            throw new NoteException();
        }
        this.note = note;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) throws NoteException {
        if (note < 0 || note > 20) {
            throw new NoteException();
        }
        this.note = note;
    }
}

