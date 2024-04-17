package com.example.gst_agricolesvf.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_agricolesvf.R;
import com.example.gst_agricolesvf.entities.Farms;
import com.example.gst_agricolesvf.entities.Terrains;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.util.ArrayList;

public class AdapterTerrain extends RecyclerView.Adapter<AdapterTerrain.ConteneurTerrain>  {

    Context context;
    ArrayList<Terrains> terrains;
    VmAgricoles vmAgricoles;

    public AdapterTerrain(Context context, ArrayList<Terrains> terrains, VmAgricoles vmAgricoles) {
        this.context = context;
        this.terrains = terrains;
        this.vmAgricoles = vmAgricoles;
    }

    @NonNull
    @Override
    public ConteneurTerrain onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //recupere template .
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.items_terrains, parent, false);

        return new ConteneurTerrain(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ConteneurTerrain holder, int position) {
        Terrains terrain = terrains.get(position);

        holder.txt_item_terrain_type.setText(terrain.getType().toString());
        holder.txt_item_terrain_surphase.setText(terrain.getSurphase().toString());
        holder.txt_item_terrain_quantite.setText(String.valueOf(terrain.getQuantite()).toString());

        holder.btn_editTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmAgricoles.toAddTerrain = false;
                vmAgricoles.setCurentTerrain(terrain);
                vmAgricoles.goToCrudTerrains();
            }
        });

        holder.btn_deleteTerrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vmAgricoles.setCurentTerrain(terrain);
                vmAgricoles.currentterrain.setFarms(vmAgricoles.currentFarm);
                Log.d("ter idddddddd", String.valueOf(vmAgricoles.currentterrain.getTer_id()));
                vmAgricoles.deleteTerrain(vmAgricoles.currentterrain);
            }
        });

    }

    @Override
    public int getItemCount() {
        return terrains.size();
    }

    public class ConteneurTerrain extends RecyclerView.ViewHolder {

        TextView txt_item_terrain_type, txt_item_terrain_surphase, txt_item_terrain_quantite;

        Button btn_deleteTerrain, btn_editTerrain;

        public ConteneurTerrain(@NonNull View itemView) {
            super(itemView);

            txt_item_terrain_type = itemView.findViewById(R.id.txt_item_terrain_type);
            txt_item_terrain_surphase = itemView.findViewById(R.id.txt_item_terrain_surphase);
            txt_item_terrain_quantite = itemView.findViewById(R.id.txt_item_terrain_quantite);


            btn_deleteTerrain = itemView.findViewById(R.id.btn_deleteTerrain);
            btn_editTerrain = itemView.findViewById(R.id.btn_editTerrain);

        }
    }
}
