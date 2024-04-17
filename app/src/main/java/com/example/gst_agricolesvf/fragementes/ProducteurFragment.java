package com.example.gst_agricolesvf.fragementes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.gst_agricolesvf.Adapters.AdpterProducteur;
import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.entities.Producteurs;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.util.ArrayList;

public class ProducteurFragment extends Fragment {

    VmAgricoles vmAgricoles;
    RecyclerView list_Prod;
    Button btn_producteur;

    ArrayList<Producteurs> producteursArrayList;
    AdpterProducteur adpterProducteur;


    public ProducteurFragment(VmAgricoles vmAgricoles) {
        this.vmAgricoles = vmAgricoles;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_producteur, container, false);

        btn_producteur = v.findViewById(R.id.btn_producteur);
        list_Prod = v.findViewById(R.id.list_Prod);

        //Recycle view
        producteursArrayList = new ArrayList<Producteurs>();
        adpterProducteur = new AdpterProducteur(vmAgricoles.context, vmAgricoles.producteursArrayList, vmAgricoles);
        list_Prod.setAdapter(adpterProducteur);

        // Pour lignie la liste .
        list_Prod.setLayoutManager(new LinearLayoutManager(vmAgricoles.context));

        // henaya .
        producteursArrayList.addAll(vmAgricoles.getProducteurs());
        adpterProducteur.notifyDataSetChanged();

        btn_producteur.setOnClickListener(ls -> {
            this.vmAgricoles.goToCrudProduct();
            Toast.makeText(this.vmAgricoles.context, "crud producteur", Toast.LENGTH_SHORT).show();
        });

        return v;
    }
}