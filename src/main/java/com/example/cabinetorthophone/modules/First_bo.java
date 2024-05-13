package com.example.cabinetorthophone.modules;

import java.io.Serializable;
import java.util.ArrayList;

public class First_bo extends Bo implements Serializable {
    private Amnese amnese;

    public First_bo(Amnese amnese, ArrayList<Epreuve> epreuves, Diagnostique diagnostique, String thematique, First_bo firstBo) {
        super(epreuves, diagnostique, thematique, firstBo);
        this.amnese = amnese;
    }
}