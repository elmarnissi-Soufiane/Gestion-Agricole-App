package com.example.gst_agricolesvf.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Producteurs;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.util.ArrayList;

public class AdapterFarm extends RecyclerView.Adapter<AdapterFarm.ConteneurFarm>  {

    Context context;
    ArrayList<Farms> farms;
    ArrayList<Producteurs> producteurs;
    VmAgricoles vmAgricoles;

    public AdapterFarm(Context context, ArrayList<Farms> farms, VmAgricoles vmAgricoles) {
        this.context = context;
        this.farms = farms;
        this.vmAgricoles = vmAgricoles;
    }

    @NonNull
    @Override
    public ConteneurFarm onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //recupere template .
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.items_farms, parent, false);

        return new ConteneurFarm(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ConteneurFarm holder, int position) {
        Farms farm = farms.get(position);
        Producteurs producteur = vmAgricoles.currentProducteur;

        holder.txt_item_farm_nom.setText(farm.getName().toString());
        holder.txt_item_farm_localisation.setText(farm.getLocalisation().toString());
        holder.txt_item_farm_prod_nom.setText(producteur.getName().toString());

        int id_farm = farm.getFarm_id();

        holder.btn_editFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vmAgricoles.updateFarm(vmAgricoles.currentFarm);
                vmAgricoles.toAddFarm = false ;
                vmAgricoles.setCurentFarms(farm);
                vmAgricoles.goToCrudFarms();
            }
        });

        holder.btn_deleteFarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmAgricoles.setCurentFarms(farm);
                vmAgricoles.currentFarm.setProducteurs(vmAgricoles.currentProducteur);
                vmAgricoles.deleteFarm(vmAgricoles.currentFarm);
            }
        });

        holder.btn_listTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmAgricoles.setCurentFarms(farm);
                vmAgricoles.getItemFramByIdTerrain(id_farm);
            }
        });

    }

    @Override
    public int getItemCount() {
        return farms.size();
    }

    public class ConteneurFarm extends RecyclerView.ViewHolder {

        TextView txt_item_farm_nom, txt_item_farm_localisation, txt_item_farm_prod_nom;

        Button btn_editFarm, btn_deleteFarm, btn_listTerrain;

        public ConteneurFarm(@NonNull View itemView) {
            super(itemView);

            txt_item_farm_nom = itemView.findViewById(R.id.txt_item_farm_nom);
            txt_item_farm_localisation = itemView.findViewById(R.id.txt_item_farm_localisation);
            txt_item_farm_prod_nom = itemView.findViewById(R.id.txt_item_farm_prod_nom);

            btn_editFarm = itemView.findViewById(R.id.btn_editFarm);
            btn_deleteFarm = itemView.findViewById(R.id.btn_deleteFarm);
            btn_listTerrain = itemView.findViewById(R.id.btn_listTerrain);

        }
    }
}
