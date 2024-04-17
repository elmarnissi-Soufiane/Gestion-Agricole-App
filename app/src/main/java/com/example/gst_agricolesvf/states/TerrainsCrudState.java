package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.CrudTerrainsFragment;
import com.example.gst_agricolesvf.fragementes.FarmsFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class TerrainsCrudState implements IState{

    VmAgricoles vmAgricoles;
    public TerrainsCrudState(VmAgricoles vmAgricoles) {
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
    }

    @Override
    public void execute() {
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new CrudTerrainsFragment(this.vmAgricoles)).commit();
    }
}
