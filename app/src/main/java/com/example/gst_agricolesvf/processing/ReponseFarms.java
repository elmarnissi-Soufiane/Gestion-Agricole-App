package com.example.gst_agricolesvf.processing;

import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Producteurs;

import java.util.ArrayList;

public class ReponseFarms {

    public String status;
    public ArrayList<Farms> farms;

    public ReponseFarms() {
    }

    public ReponseFarms(String status, ArrayList<Farms> farms) {
        this.status = status;
        this.farms = farms;
    }

}
