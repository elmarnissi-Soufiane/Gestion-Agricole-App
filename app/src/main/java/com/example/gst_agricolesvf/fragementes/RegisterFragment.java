package com.example.gst_agricolesvf.fragementes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.vm.VmAgricoles;

public class RegisterFragment extends Fragment {

    VmAgricoles vmAgricoles;
    EditText edit_utilisateur1, edit_utilisateur2, edit_mdp1, edit_mdp2;
    Button btn_creer;


    public RegisterFragment(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        btn_creer = view.findViewById(R.id.btn_creer);
        edit_utilisateur1 = view.findViewById(R.id.edit_utilisateur1);
        edit_utilisateur2 = view.findViewById(R.id.edit_utilisateur2);
        edit_mdp1 = view.findViewById(R.id.edit_mdp1);
        edit_mdp2 = view.findViewById(R.id.edit_mdp2);

        String name = edit_utilisateur1.getText().toString();
        String passsword = edit_mdp1.getText().toString();
        String conf = edit_mdp2.getText().toString();
        String email = edit_utilisateur2.getText().toString();

        btn_creer.setOnClickListener(ls -> {

            this.vmAgricoles.register(edit_utilisateur1.getText().toString(), edit_utilisateur2.getText().toString(), edit_mdp1.getText().toString());
            Toast.makeText(vmAgricoles.context, "verifier le mot de passe de confirmation", Toast.LENGTH_SHORT).show();
            //this.vmAgricoles.goToLogin();
        });

        return view;
    }
}