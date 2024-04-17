package com.example.gst_agricolesvf.states;

import com.example.gst_agricolesvf.MainActivity;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.fragementes.LoginFragment;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class LoginState implements IState{

    VmAgricoles vmAgricoles;
    public LoginState(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }

    @Override
    public void moveToLogin() {

    }

    @Override
    public void moveToRegister() {
        vmAgricoles.changeState(new RegisterState(this.vmAgricoles));
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
        ((MainActivity) this.vmAgricoles.context).getSupportFragmentManager().beginTransaction().replace(R.id.frm_principale, new LoginFragment(this.vmAgricoles)).commit();
    }
}
