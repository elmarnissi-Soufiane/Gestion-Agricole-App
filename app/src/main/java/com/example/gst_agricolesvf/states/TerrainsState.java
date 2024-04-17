package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.FarmsFragment;
import com.example.gst_agricolesvf.fragementes.TerrainsFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class TerrainsState implements IState{

    VmAgricoles vmAgricoles;
    public TerrainsState(VmAgricoles vmAgricoles) {
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
        vmAgricoles.changeState(new FarmsState(this.vmAgricoles));
    }

    @Override
    public void moveToTerrains() {
        vmAgricoles.changeState(new TerrainsState(this.vmAgricoles));
    }

    @Override
    public void moveToCrudTerrains() {
        vmAgricoles.changeState(new TerrainsCrudState(this.vmAgricoles));
    }

    @Override
    public void moveToCrudProducteur() {
    }

    @Override
    public void moveToCrudFarms() {
    }

    @Override
    public void execute() {
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new TerrainsFragment(this.vmAgricoles)).commit();
    }
}
