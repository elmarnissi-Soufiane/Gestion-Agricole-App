package com.example.gst_agricolesvf.fragementes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.vm.VmAgricoles;


public class CrudFarmsFragment extends Fragment {

    VmAgricoles vmAgricoles;

    EditText edit_farm_nom, edit_farm_localisation;
    Button btn_addFarm, btn_return;

    public CrudFarmsFragment(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_crud_farms, container, false);
        edit_farm_nom = v.findViewById(R.id.edit_farm_nom);
        edit_farm_localisation = v.findViewById(R.id.edit_farm_localisation);

        if (vmAgricoles.toAddFarm) {
            vmAgricoles.setCurentFarms(new Farms(vmAgricoles.currentProducteur));
            vmAgricoles.currentFarm.setName("");
            vmAgricoles.currentFarm.setLocalisation("");
        }
        Log.d("name famrs vm ", vmAgricoles.currentFarm.toString());

        edit_farm_nom.setText(vmAgricoles.currentFarm.getName());
        edit_farm_localisation.setText(vmAgricoles.currentFarm.getLocalisation());


        btn_addFarm = v.findViewById(R.id.btn_addFarm);
        btn_return = v.findViewById(R.id.btn_return);

        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmAgricoles.goToFrams();
            }
        });

        btn_addFarm.setOnClickListener(ls -> {
            if (this.vmAgricoles.toAddFarm) {
                this.vmAgricoles.addFarm(edit_farm_nom.getText().toString(), edit_farm_localisation.getText().toString());
            }
            else {
                vmAgricoles.currentFarm.setLocalisation(String.valueOf(edit_farm_localisation.getText()));
                vmAgricoles.currentFarm.setName(edit_farm_nom.getText().toString());

                vmAgricoles.currentFarm.setProducteurs(vmAgricoles.currentProducteur);

                this.vmAgricoles.updateFarm(vmAgricoles.currentFarm);
            }
        });




        return v;
    }
}