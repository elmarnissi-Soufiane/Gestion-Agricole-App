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
import com.example.gst_agricolesvf.Adapters.AdpterProducteur;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Producteurs;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.util.ArrayList;

public class FarmsFragment extends Fragment {
    VmAgricoles vmAgricoles;
    RecyclerView list_farms;

    Button btn_producteurFarm, btn_farmsCrd;

    ArrayList<Farms> farmsArrayList;
    AdapterFarm adapterFarm;


    public FarmsFragment(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_farms, container, false);

        list_farms = view.findViewById(R.id.list_farms);
        btn_farmsCrd = view.findViewById(R.id.btn_farmsCrd);
        btn_producteurFarm = view.findViewById(R.id.btn_producteurFarm);

        //Recycle view
        farmsArrayList = new ArrayList<Farms>();
        adapterFarm = new AdapterFarm(vmAgricoles.context, vmAgricoles.farmsArrayList, vmAgricoles);
        list_farms.setAdapter(adapterFarm);

        // Pour lignie la liste .
        list_farms.setLayoutManager(new LinearLayoutManager(vmAgricoles.context));

        // henaya . rje 3 leh
        farmsArrayList.addAll(vmAgricoles.getFrams());

        vmAgricoles.toAddFarm = true;

        adapterFarm.notifyDataSetChanged();




        btn_producteurFarm.setOnClickListener(ls -> {
            this.vmAgricoles.goToProductauer();
            Toast.makeText(this.vmAgricoles.context, "return fram producteur", Toast.LENGTH_SHORT).show();
        });

        btn_farmsCrd.setOnClickListener(ls -> {
            vmAgricoles.toAddFarm = true;
            this.vmAgricoles.goToCrudFarms();
            Toast.makeText(this.vmAgricoles.context, "crud farms", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}