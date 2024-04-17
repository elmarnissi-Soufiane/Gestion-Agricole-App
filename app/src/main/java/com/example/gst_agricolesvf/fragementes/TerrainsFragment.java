package com.example.gst_agricolesvf.fragementes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.gst_agricolesvf.Adapters.AdapterFarm;
import com.example.gst_agricolesvf.Adapters.AdapterTerrain;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Terrains;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.util.ArrayList;

public class TerrainsFragment extends Fragment {

    VmAgricoles vmAgricoles;

    Button btn_producteurTerrain, btn_terrainCrd, btn_farmTerrain;
    RecyclerView list_terrains;

    ArrayList<Terrains> terrainsArrayList;
    AdapterTerrain adapterTerrain;

    public TerrainsFragment(VmAgricoles vmAgricoles) {
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
        View view =  inflater.inflate(R.layout.fragment_terrains, container, false);

        btn_farmTerrain = view.findViewById(R.id.btn_farmTerrain);
        btn_producteurTerrain = view.findViewById(R.id.btn_producteurTerrain);
        btn_terrainCrd = view.findViewById(R.id.btn_terrainCrd);

        list_terrains = view.findViewById(R.id.list_terrains);


        //Recycle view
        terrainsArrayList = new ArrayList<Terrains>();
        adapterTerrain = new AdapterTerrain(vmAgricoles.context, vmAgricoles.terrainsArrayList, vmAgricoles);
        list_terrains.setAdapter(adapterTerrain);

        // Pour lignie la liste .
        list_terrains.setLayoutManager(new LinearLayoutManager(vmAgricoles.context));

        // henaya . rje 3 leh
        terrainsArrayList.addAll(vmAgricoles.getTerrains());
        adapterTerrain.notifyDataSetChanged();

        vmAgricoles.toAddTerrain = true;

        Log.d("terrains frag" , String.valueOf(vmAgricoles.currentFarm.getFarm_id()));

        btn_terrainCrd.setOnClickListener(ls -> {
            vmAgricoles.toAddTerrain = true;
            this.vmAgricoles.goToCrudTerrains();
            Toast.makeText(this.vmAgricoles.context, "crud terrain", Toast.LENGTH_SHORT).show();
        });

        btn_farmTerrain.setOnClickListener(ls -> {
            this.vmAgricoles.goToFrams();
            Toast.makeText(this.vmAgricoles.context, "reruturn terrain farm", Toast.LENGTH_SHORT).show();
        });

        btn_producteurTerrain.setOnClickListener(ls -> {
            this.vmAgricoles.goToProductauer();
            Toast.makeText(this.vmAgricoles.context, "return terrain producteur", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}