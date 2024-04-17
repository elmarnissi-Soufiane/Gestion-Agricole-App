package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.FarmsFragment;
import com.example.gst_agricolesvf.fragementes.ProducteurFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class FarmsState implements IState{

    VmAgricoles vmAgricoles;
    public FarmsState(VmAgricoles vmAgricoles) {
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
        vmAgricoles.changeState(new TerrainsState(this.vmAgricoles));
    }

    @Override
    public void moveToCrudTerrains() {
    }

    @Override
    public void moveToCrudProducteur() {
    }

    @Override
    public void moveToCrudFarms() {
        vmAgricoles.changeState(new FarmsCrudState(this.vmAgricoles));
    }

    @Override
    public void execute() {
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new FarmsFragment(this.vmAgricoles)).commit();
    }
}
