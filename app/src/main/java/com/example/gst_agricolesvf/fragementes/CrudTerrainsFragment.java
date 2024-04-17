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
import com.example.gst_agricolesvf.entities.Terrains;
import com.example.gst_agricolesvf.vm.VmAgricoles;


public class CrudTerrainsFragment extends Fragment {

    VmAgricoles vmAgricoles;

    Button btn_addTerrain, btn_return;
    EditText edit_terrain_quantite, edit_terrain_surphase, edit_terrain_type;

    public CrudTerrainsFragment(VmAgricoles vmAgricoles) {

        this.vmAgricoles = vmAgricoles;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crud_terrains, container, false);
        edit_terrain_quantite = view.findViewById(R.id.edit_terrain_quantite);
        edit_terrain_surphase = view.findViewById(R.id.edit_terrain_surphase);
        edit_terrain_type = view.findViewById(R.id.edit_terrain_type);
        btn_addTerrain = view.findViewById(R.id.btn_addTerrain);

        btn_return = view.findViewById(R.id.btn_return);

        btn_return.setOnClickListener(ls ->{
            vmAgricoles.goToTerrains();
        });

        Log.d("zzzzzzzzzzzzz", String.valueOf(vmAgricoles.toAddTerrain));
        if (vmAgricoles.toAddTerrain) {

            Log.d("farm Id 101", String.valueOf(vmAgricoles.currentFarm.getFarm_id()));

            vmAgricoles.setCurentTerrain(new Terrains(vmAgricoles.currentFarm));
            vmAgricoles.currentterrain.setType("");
            vmAgricoles.currentterrain.setSurphase("");
            vmAgricoles.currentterrain.setQuantite(0);
        }



        edit_terrain_quantite.setText(String.valueOf(vmAgricoles.currentterrain.getQuantite()));
        edit_terrain_surphase.setText(vmAgricoles.currentterrain.getSurphase());
        edit_terrain_type.setText(vmAgricoles.currentterrain.getType());

        btn_addTerrain.setOnClickListener(ls -> {
            if (this.vmAgricoles.toAddTerrain) {
                this.vmAgricoles.addTerrain(edit_terrain_type.getText().toString(), edit_terrain_surphase.getText().toString(), Double.parseDouble(edit_terrain_quantite.getText().toString()));
            }
            else {

                vmAgricoles.currentterrain.setType(edit_terrain_type.getText().toString());
                vmAgricoles.currentterrain.setSurphase(edit_terrain_surphase.getText().toString());
                vmAgricoles.currentterrain.setQuantite(Double.parseDouble(edit_terrain_quantite.getText().toString()));

                vmAgricoles.currentterrain.setFarms(vmAgricoles.currentFarm);

                this.vmAgricoles.updateTerrain(vmAgricoles.currentterrain);
            }
        });

        return view;
    }
}