package com.cine.cinefront;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ItemCardviewBinding;

import com.cine.cinefront.databinding.ItemCardviewPeliculasBinding;
import com.cine.cinefront.model.Peliculas;


import java.util.ArrayList;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.ViewHolder>{
    private ArrayList<Peliculas>dataPeliculas;
    private Context context;

     public PeliculasAdapter(Context context){
         this.context=context;
         dataPeliculas=new ArrayList<> ();
     }


    @NonNull
    @Override
    public PeliculasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        ItemCardviewPeliculasBinding recyclerBinding= ItemCardviewPeliculasBinding.inflate(layoutInflater,parent,false);
        return new PeliculasAdapter.ViewHolder (recyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         final Peliculas objPeliculas=dataPeliculas.get(position);
         holder.recyclerBinding.tvpelicula.setText(objPeliculas.getNompeli ());
         holder.recyclerBinding.tvpeliculainfo.setText(objPeliculas.getInfopeli ());
         Glide.with ( context).load ( Constante.URL_IMAGENLOC_APIPELI +objPeliculas.getIdpeli ()).into ( holder.recyclerBinding.ivpelicula );

    }

    public void agregarList(ArrayList<Peliculas>listaPeliculas){
        dataPeliculas.addAll(listaPeliculas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataPeliculas.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ItemCardviewPeliculasBinding recyclerBinding;
            public ViewHolder(@NonNull   ItemCardviewPeliculasBinding itemView) {
                super(itemView.getRoot());
                recyclerBinding=itemView;
            }
    }
}
