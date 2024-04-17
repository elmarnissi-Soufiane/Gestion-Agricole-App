package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.RegisterFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class RegisterState implements IState{

    VmAgricoles vmAgricoles;
    public RegisterState(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }

    @Override
    public void moveToLogin() {
        vmAgricoles.changeState(new LoginState(this.vmAgricoles));
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
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new RegisterFragment(this.vmAgricoles)).commit();
    }
}
