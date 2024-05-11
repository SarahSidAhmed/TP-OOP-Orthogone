package com.example.cabinetorthophone.modules;

import java.io.Serializable;

public class NoteException extends Exception implements Serializable {
    void NoteException(){
        System.out.println("Note ne peut depasser l'intervalle [0,5]");
    }
}
