package com.cine.cinefront;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import com.cine.cinefront.common.Constante;

import com.cine.cinefront.databinding.ItemCardviewComidasBinding;
import com.cine.cinefront.model.Comidas;

public class ComidasAdapter extends RecyclerView.Adapter<ComidasAdapter.ViewHolder> {

    private ArrayList<Comidas> dataComidas;
    private Context context;

    public ComidasAdapter(Context context){
        this.context= context;
        dataComidas= new ArrayList<>();
    }

    @NonNull
    @Override
    public ComidasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemCardviewComidasBinding recyclerBinding = ItemCardviewComidasBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(recyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ComidasAdapter.ViewHolder holder, int position) {
        final Comidas objComidas = dataComidas.get(position);
        holder.recyclerBinding.tvcomida.setText(objComidas.getNomcom());
        holder.recyclerBinding.tvpreciocom.setText(objComidas.getPrecio());
        Glide.with(context).load(new Constante().URL_IMAGENCOM_API+objComidas.getIdcom()).into(holder.recyclerBinding.ivComida);
    }

    public void agregarListcom(ArrayList<Comidas>listaComidas){
        dataComidas.addAll(listaComidas);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataComidas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCardviewComidasBinding recyclerBinding;
        public ViewHolder(@NonNull ItemCardviewComidasBinding itemView) {
            super(itemView.getRoot());
            recyclerBinding = itemView;
        }
    }
}
