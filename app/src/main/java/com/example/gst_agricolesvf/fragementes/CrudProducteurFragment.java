package com.example.gst_agricolesvf.fragementes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.vm.VmAgricoles;


public class CrudProducteurFragment extends Fragment {

    VmAgricoles vmAgricoles;

    EditText edit_prod_nom, edit_prod_cin, edit_prod_tele, edit_prod_adresse;
    Button btn_addProd, btn_deleteProd, btn_editProd, btn_return;

    public CrudProducteurFragment(VmAgricoles vmAgricoles) {
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
        View v = inflater.inflate(R.layout.fragment_crud_producteur, container, false);

        edit_prod_nom = v.findViewById(R.id.edit_prod_nom);
        edit_prod_cin = v.findViewById(R.id.edit_prod_cin);
        edit_prod_tele = v.findViewById(R.id.edit_prod_tele);
        edit_prod_adresse = v.findViewById(R.id.edit_prod_adresse);

        btn_return = v.findViewById(R.id.btn_return);

        btn_addProd = v.findViewById(R.id.btn_addProd);
        btn_deleteProd = v.findViewById(R.id.btn_deleteProd);
        btn_editProd = v.findViewById(R.id.btn_editProd);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmAgricoles.goToProductauer();
            }
        });

        btn_addProd.setOnClickListener(ls -> {
            this.vmAgricoles.addProduct(edit_prod_nom.getText().toString(), edit_prod_cin.getText().toString(), edit_prod_tele.getText().toString(), edit_prod_adresse.getText().toString());
        });

        btn_deleteProd.setOnClickListener(ls -> {
            this.vmAgricoles.deleteProduct(edit_prod_cin.getText().toString());
        });

        btn_editProd.setOnClickListener(ls -> {
            this.vmAgricoles.updateProduct(edit_prod_nom.getText().toString(), edit_prod_cin.getText().toString(), edit_prod_tele.getText().toString(), edit_prod_adresse.getText().toString());
        });

        return v;
    }
}