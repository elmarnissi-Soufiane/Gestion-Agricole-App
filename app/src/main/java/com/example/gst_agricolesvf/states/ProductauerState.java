package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.FarmsFragment;
import com.example.gst_agricolesvf.fragementes.LoginFragment;
import com.example.gst_agricolesvf.fragementes.ProducteurFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class ProductauerState implements IState{

    VmAgricoles vmAgricoles;
    public ProductauerState(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }

    @Override
    public void moveToLogin() {

    }

    @Override
    public void moveToRegister() {

    }

    @Override
    public void moveToProducteur() {
    }

    @Override
    public void moveToFarms() {
        vmAgricoles.changeState(new FarmsState(this.vmAgricoles));
    }

    @Override
    public void moveToTerrains() {
    }

    @Override
    public void moveToCrudTerrains() {
    }

    @Override
    public void moveToCrudProducteur() {
        vmAgricoles.changeState(new ProducateurCrudState(this.vmAgricoles));
    }

    @Override
    public void moveToCrudFarms() {
    }

    @Override
    public void execute() {
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new ProducteurFragment(this.vmAgricoles)).commit();
    }
}
