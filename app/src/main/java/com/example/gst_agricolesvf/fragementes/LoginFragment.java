package com.example.gst_agricolesvf.fragementes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import kotlin.collections.MapsKt;


public class LoginFragment extends Fragment {

    Button btn_login;
    EditText edit_utilisateur, edit_mdp;
    TextView txt_creercompte;
    VmAgricoles vmAgricoles;

    public LoginFragment(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btn_login = view.findViewById(R.id.btn_login);
        txt_creercompte = view.findViewById(R.id.txt_creercompte);
        edit_utilisateur = view.findViewById(R.id.edit_utilisateur);
        edit_mdp = view.findViewById(R.id.edit_mdp);

        edit_utilisateur.setText("soufiane@gmail.com");
        edit_mdp.setText("12345678");


        String email = edit_utilisateur.getText().toString();
        String passsword = edit_mdp.getText().toString();

        txt_creercompte.setOnClickListener(ls -> {

                this.vmAgricoles.goToRegister();
        });

        btn_login.setOnClickListener(ls -> {
            this.vmAgricoles.login(edit_utilisateur.getText().toString(), edit_mdp.getText().toString());
            Toast.makeText(vmAgricoles.context, "Login Success", Toast.LENGTH_SHORT).show();
        });

        return view;
    }

}