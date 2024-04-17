package com.example.gst_agricolesvf.entities;

public class Farms {

    private int farm_id;
    private String name;
    private String localisation;
    private Producteurs producteurs;

    private String cin;


    public Farms(String cin) {
        this.cin = cin;
    }

    public Farms(int farm_id, String name, String localisation) {
        this.farm_id = farm_id;
        this.name = name;
        this.localisation = localisation;
    }

    public Farms(String name, String localisation, Producteurs producteurs) {
        this.name = name;
        this.localisation = localisation;
        this.producteurs = producteurs;
    }

    public Farms(String name, String localisation) {
        this.name = name;
        this.localisation = localisation;
    }

    public Farms(int farm_id, String name, String localisatio, Producteurs producteurs) {
        this.name = name;
        this.localisation = localisatio;
        this.producteurs = producteurs;
    }

    public Farms(Producteurs producteurs) {
        this.producteurs = producteurs;
    }

    public int getFarm_id() {
        return farm_id;
    }

    public void setFarm_id(int farm_id) {
        this.farm_id = farm_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisatio) {
        this.localisation = localisatio;
    }

    public Producteurs getProducteurs() {
        return producteurs;
    }

    public void setProducteurs(Producteurs producteurs) {
        this.producteurs = producteurs;
    }
}
