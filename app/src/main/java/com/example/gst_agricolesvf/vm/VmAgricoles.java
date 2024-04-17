package com.example.gst_agricolesvf.vm;

import android.content.Context;
import android.util.Log;

import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Producteurs;
import com.example.gst_agricolesvf.entities.Terrains;
import com.example.gst_agricolesvf.entities.Users;
import com.example.gst_agricolesvf.processing.ReponseFarms;
import com.example.gst_agricolesvf.processing.ReponseTerrains;
import com.example.gst_agricolesvf.processing.Response;
import com.example.gst_agricolesvf.states.IState;
import com.example.gst_agricolesvf.states.LoginState;
import com.google.gson.Gson;

import io.socket.client.Ack;
import io.socket.client.IO;
import java.net.URISyntaxException;
import java.util.ArrayList;

import io.socket.client.Socket;

public class VmAgricoles {

    public static final String TAG = "VMAgricoles";
    IState iState;

    public ArrayList<Producteurs> producteursArrayList;
    public ArrayList<Farms> farmsArrayList;
    public ArrayList<Terrains> terrainsArrayList;
    public boolean toAddProd  ;
    public boolean toAddFarm ;
    public boolean toAddTerrain ;

    public Producteurs currentProducteur ;

    public Farms currentFarm ;


    public Terrains currentterrain ;

    public Context context;

    // creation d'une socket
    public Socket socket;

    public VmAgricoles() {
    }

    public VmAgricoles(Context context) {
        this.context = context;

        this.socket = null;
        //String url = "http://192.168.1.245:3002/";
        //String url = "http://172.31.176.1:3002/";
        String url = "http://172.31.176.1:3002/";
        if(this.socket == null){
            try {
                this.socket = IO.socket(url);
                this.socket.connect();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        this.iState = new LoginState(this);
        this.execute();

    }

    public void changeState(IState iState){
        this.iState = iState;
    }

    public void execute() {
        this.iState.execute();
        //this.socket.emit("newProducer", "Producer");
    }

    public void goToRegister() {
        this.iState.moveToRegister();
        this.execute();
    }

    public  void goToLogin() {
        this.iState.moveToLogin();
        this.execute();
    }

    public void goToProductauer() {
        this.iState.moveToProducteur();
        this.execute();
    }

    public void goToFrams() {
        this.iState.moveToFarms();
        this.execute();
    }

    public void goToTerrains() {
        this.iState.moveToTerrains();
        this.execute();
    }

    public void goToCrudProduct(){
        this.iState.moveToCrudProducteur();
        this.execute();
    }

    public void goToCrudFarms(){
        this.iState.moveToCrudFarms();
        this.execute();
    }

    public void goToCrudTerrains(){
        this.iState.moveToCrudTerrains();
        this.execute();
    }

    // login and reguster
    public void login(String email, String password){

        String val =  new Gson().toJson(new Users(email,password),Users.class) ;
        this.socket.emit("login",val, (Ack) args ->{
            String data = (String) args[0].toString();
            Response rep = new Gson().fromJson((String) data, Response.class);
            Log.d(TAG, String.valueOf(rep.producteurs));

            this.producteursArrayList = rep.producteurs;

            this.goToProductauer();

        }) ;
    }

    public void register(String name, String email, String password){
        String val = new Gson().toJson(new Users(name, email, password), Users.class);
        this.socket.emit("register", val, (Ack) args->{
            String data = (String) args[0];
            if(data.equals("true")){
                this.goToLogin();
            }
        });
    }

    // Producterus .
    public ArrayList<Producteurs> getProducteurs(){

        return producteursArrayList;
    }

    public void addProduct(String name, String cin, String tel, String adresse){
        String val = new Gson().toJson(new Producteurs(name, cin, tel, adresse), Producteurs.class);
        this.socket.emit("addProd", val, (Ack) args->{
            /*String data = (String) args[0];
            if(data.equals("true")){
                this.goToProductauer();
            }*/

            String data = (String) args[0].toString();
            Response rep = new Gson().fromJson((String) data, Response.class);
            Log.d(TAG, String.valueOf(rep.producteurs));

            this.producteursArrayList = rep.producteurs;

            this.goToProductauer();

        });
    }

    public void updateProduct(String name, String cin, String tel, String adresse){
        String val = new Gson().toJson(new Producteurs(name, cin, tel, adresse), Producteurs.class);
        this.socket.emit("updateProd", val, (Ack) args->{

            String data = (String) args[0].toString();
            Response rep = new Gson().fromJson((String) data, Response.class);
            Log.d(TAG, String.valueOf(rep.producteurs));

            this.producteursArrayList = rep.producteurs;

            this.goToProductauer();

        });
    }

    public void deleteProduct(String cin){
        String val = new Gson().toJson(new Producteurs(cin), Producteurs.class);
        this.socket.emit("deleteProd", val, (Ack) args->{

            String data = (String) args[0].toString();
            Response rep = new Gson().fromJson((String) data, Response.class);
            Log.d(TAG, String.valueOf(rep.producteurs));

            this.producteursArrayList = rep.producteurs;

            this.goToProductauer();

        });
    }

    // Farms /////////////////////////////////////////////////////////
    public void getItemFramByIdProd(String cin){
        String val = new Gson().toJson(new Farms(cin), Farms.class);
        this.socket.emit("getByIdFarm", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseFarms rep = new Gson().fromJson((String) data, ReponseFarms.class);
            Log.d(TAG, String.valueOf(rep.farms));

            this.farmsArrayList = rep.farms;

            this.goToFrams();

        });
    }

    public void setCurentProducteur(Producteurs producteurs){
        this.currentProducteur = producteurs;
    }

    public ArrayList<Farms> getFrams(){

        return farmsArrayList;
    }

    public void addFarm(String name, String localisation){
        Log.d("lcurrent", currentProducteur.getName());
        Log.d("lcurrent", String.valueOf(currentProducteur.getProd_id()));
        this.toAddFarm = true ;
        String val = new Gson().toJson(new Farms(name, localisation, currentProducteur), Farms.class);
        this.socket.emit("addFarm", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseFarms rep = new Gson().fromJson((String) data, ReponseFarms.class);
            Log.d(TAG, String.valueOf(rep.farms));

            this.farmsArrayList = rep.farms;

            this.goToFrams();

        });
    }

    public void setCurentFarms(Farms farms){
        this.currentFarm = farms;
    }

    public void updateFarm(Farms farms){
        String val = new Gson().toJson(farms, Farms.class);
        Log.d("valllllll",val) ;
        this.toAddFarm = false ;
        this.socket.emit("updateFarm", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseFarms rep = new Gson().fromJson((String) data, ReponseFarms.class);

            this.farmsArrayList = rep.farms;

            this.goToFrams();

        });
    }

    public void deleteFarm(Farms farms){
        String val = new Gson().toJson(farms, Farms.class);
        this.socket.emit("deleteFarm", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseFarms rep = new Gson().fromJson((String) data, ReponseFarms.class);

            this.farmsArrayList = rep.farms;

            this.goToFrams();

        });
    }

    // Terrains :: /////////////////////////////////////
    public void getItemFramByIdTerrain(int id){
        //id = currentFarm.getFarm_id();
        String val = new Gson().toJson(currentFarm, Farms.class);
        this.socket.emit("getByIdTerrain", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseTerrains rep = new Gson().fromJson((String) data, ReponseTerrains.class);
            Log.d(TAG, String.valueOf(rep.terrains));

            this.terrainsArrayList = rep.terrains;

            this.goToTerrains();

        });
    }


    public void setCurentTerrain(Terrains terrains){
        this.currentterrain = terrains;
    }

    public ArrayList<Terrains> getTerrains(){

        return terrainsArrayList;
    }

    public void deleteTerrain(Terrains terrains){
        String val = new Gson().toJson(terrains, Terrains.class);
        Log.d("vallllllll ter", val);
        this.socket.emit("deleteTerrain", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseTerrains rep = new Gson().fromJson((String) data, ReponseTerrains.class);

            this.terrainsArrayList = rep.terrains;

            this.goToTerrains();

        });
    }


    public void addTerrain(String type, String surphase, double quantite){
        Log.d("lcurrent", currentProducteur.getName());
        Log.d("lcurrent", String.valueOf(currentterrain.getFarms().getFarm_id()));
        this.toAddTerrain = true ;
        Log.d("fams currrrr", String.valueOf(currentFarm.getFarm_id()));
        String val = new Gson().toJson(new Terrains(type, surphase, quantite ,currentFarm), Terrains.class);
        Log.d("val terrain", val);
        this.socket.emit("addTerrain", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseTerrains rep = new Gson().fromJson((String) data, ReponseTerrains.class);
            Log.d(TAG, String.valueOf(rep.terrains));

            this.terrainsArrayList = rep.terrains;

            this.goToTerrains();

        });
    }


    public void updateTerrain(Terrains terrains){
        String val = new Gson().toJson(terrains, Terrains.class);
        Log.d("valllllll",val) ;
        this.toAddFarm = false ;
        this.socket.emit("updateTerrain", val, (Ack) args->{

            String data = (String) args[0].toString();
            ReponseTerrains rep = new Gson().fromJson((String) data, ReponseTerrains.class);

            this.terrainsArrayList = rep.terrains;

            this.goToTerrains();

        });
    }


}
