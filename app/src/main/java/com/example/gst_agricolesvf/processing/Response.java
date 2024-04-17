package com.example.gst_agricolesvf.processing;

import com.example.gst_agricolesvf.entities.Producteurs;

import java.util.ArrayList;

public class Response {

    public String status;
    public ArrayList<Producteurs> producteurs;

    public Response() {
    }

    public Response(String status, ArrayList<Producteurs> producteurs) {
        this.status = status;
        this.producteurs = producteurs;
    }
}
