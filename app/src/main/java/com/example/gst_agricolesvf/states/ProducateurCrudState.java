package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.CrudFarmsFragment;
import com.example.gst_agricolesvf.fragementes.CrudProducteurFragment;
import com.example.gst_agricolesvf.fragementes.FarmsFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class ProducateurCrudState implements IState{

    VmAgricoles vmAgricoles;
    public ProducateurCrudState(VmAgricoles vmAgricoles) {
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
        vmAgricoles.changeState(new ProductauerState(this.vmAgricoles));
    }

    @Override
    public void moveToFarms() {
    }

    @Override
    public void moveToTerrains() {
    }

    @Override
    public void moveToCrudTerrains() {
    }

    @Override
    public void moveToCrudProducteur() {
    }

    @Override
    public void moveToCrudFarms() {
    }

    @Override
    public void execute() {
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new CrudProducteurFragment(this.vmAgricoles)).commit();
    }
}
