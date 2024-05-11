package com.example.cabinetorthophone.modules;

public interface Rendez_VousSet {


        default void setDuree(String duree) {
            duree = "1";
        }

        void setTypeRV(Type_RV var1);
    }

