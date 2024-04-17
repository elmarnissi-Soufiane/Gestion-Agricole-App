package com.example.gst_agricolesvf.processing;

import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Terrains;

import java.util.ArrayList;

public class ReponseTerrains {

    public String status;
    public ArrayList<Terrains> terrains;

    public ReponseTerrains() {
    }

    public ReponseTerrains(String status, ArrayList<Terrains> terrains) {
        this.status = status;
        this.terrains = terrains;
    }

}
