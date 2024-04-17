package com.example.gst_agricolesvf.states;

public interface IState {

    void moveToLogin();
    void moveToRegister();
    void moveToProducteur();
    void moveToFarms();
    void moveToTerrains();
    void moveToCrudTerrains();
    void moveToCrudProducteur();
    void moveToCrudFarms();
    void execute();
}
