package com.example.gst_agricolesvf.entities;

public class Producteurs {

    private int prod_id;
    private String name;
    private String cin;
    private String tele;
    private String adresse;

    public Producteurs() {
    }

    public Producteurs(int prod_id, String name, String cin, String tele, String adresse) {
        this.prod_id = prod_id;
        this.name = name;
        this.cin = cin;
        this.tele = tele;
        this.adresse = adresse;
    }

    public Producteurs(String name, String cin, String tele, String adresse) {
        this.name = name;
        this.cin = cin;
        this.tele = tele;
        this.adresse = adresse;
    }

    public Producteurs(String cin) {
        this.cin = cin;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


}
