package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.Iterator;

public class Objectif implements Serializable {

    private String nom;
    private int note;
    private boolean checked = false;
    private Type_Terme terme;

    public Objectif(String nom, int note, Type_Terme type) throws NoteException {
        this.nom = nom;
        if (note < 0 || note > 20) {
            throw new NoteException();
        }
        this.checked = false;
        this.terme = type;
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

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Type_Terme getTerme() {
        return this.terme;
    }

    public void setTerme(Type_Terme terme) {
        this.terme = terme;
    }
}

