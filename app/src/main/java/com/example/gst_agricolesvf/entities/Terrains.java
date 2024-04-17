package com.example.gst_agricolesvf.entities;

public class Terrains {

    private int ter_id;
    private String type;
    private String surphase;
    private double quantite;
    private Farms farms;

    //private int farm_id;

    public Terrains(String type, String surphase, double quantite, Farms farms) {
        this.type = type;
        this.surphase = surphase;
        this.quantite = quantite;
        this.farms = farms;
    }

    /*public Terrains(int farm_id) {
        this.farm_id = farm_id;
    }*/

    /*public int getFarm_id() {
        return farm_id;
    }*/

    /*public void setFarm_id(int farm_id) {
        this.farm_id = farm_id;
    }*/

    public Terrains(Farms farms) {
        this.farms = farms;
    }

    public int getTer_id() {
        return ter_id;
    }

    public void setTer_id(int ter_id) {
        this.ter_id = ter_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSurphase() {
        return surphase;
    }

    public void setSurphase(String surphase) {
        this.surphase = surphase;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public Terrains(int ter_id, String type, String surphase, double quantite, Farms farms) {
        this.ter_id = ter_id;
        this.type = type;
        this.surphase = surphase;
        this.quantite = quantite;
        this.farms = farms;
    }

    public Farms getFarms() {
        return farms;
    }

    public void setFarms(Farms farms) {
        this.farms = farms;
    }
}
