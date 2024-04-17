package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.CrudFarmsFragment;
import com.example.gst_agricolesvf.fragementes.FarmsFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class FarmsCrudState implements IState{

    VmAgricoles vmAgricoles;
    public FarmsCrudState(VmAgricoles vmAgricoles) {
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
    }

    @Override
    public void moveToCrudFarms() {
        //  vmAgricoles.changeState(new FarmsState(this.vmAgricoles));
    }

    @Override
    public void execute() {
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new CrudFarmsFragment(this.vmAgricoles)).commit();
    }
}
