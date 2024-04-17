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
import com.example.gst_agricolesvf.entities.Producteurs;
import com.example.gst_agricolesvf.vm.VmAgricoles;

import java.util.ArrayList;

public class AdpterProducteur extends RecyclerView.Adapter<AdpterProducteur.ConteneurProducteur>  {

    Context context;
    ArrayList<Producteurs> producteurs;
    VmAgricoles vmAgricoles;

    public AdpterProducteur(Context context, ArrayList<Producteurs> producteurs, VmAgricoles vmAgricoles) {
        this.context = context;
        this.producteurs = producteurs;
        this.vmAgricoles = vmAgricoles;
    }

    @NonNull
    @Override
    public ConteneurProducteur onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //recupere template .
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.items_producteurs_v2, parent, false);

        return new ConteneurProducteur(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ConteneurProducteur holder, int position) {
        Producteurs producteur = producteurs.get(position);

        holder.txt_item_prod_cin.setText(producteur.getCin().toString());
        holder.txt_item_prod_nom.setText(producteur.getName().toString());
        holder.txt_item_prod_tele.setText(producteur.getTele().toString());
        holder.txt_item_prod_adresse.setText(producteur.getAdresse().toString());

        String cin = producteur.getCin();

        holder.btn_farms_item.setOnClickListener(ls ->{
            this.vmAgricoles.setCurentProducteur(producteur);
            this.vmAgricoles.getItemFramByIdProd(cin);
        });

    }

    @Override
    public int getItemCount() {
        return producteurs.size();
    }

    public class ConteneurProducteur extends RecyclerView.ViewHolder {

        TextView txt_item_prod_nom, txt_item_prod_cin, txt_item_prod_tele, txt_item_prod_adresse;
        Button btn_farms_item;

        public ConteneurProducteur(@NonNull View itemView) {
            super(itemView);

            txt_item_prod_nom = itemView.findViewById(R.id.txt_item_prod_nom);
            txt_item_prod_cin = itemView.findViewById(R.id.txt_item_prod_cin);
            txt_item_prod_tele = itemView.findViewById(R.id.txt_item_prod_tele);
            txt_item_prod_adresse = itemView.findViewById(R.id.txt_item_prod_adresse);

            btn_farms_item = itemView.findViewById(R.id.btn_farms_item);


        }
    }
}
