package com.cine.cinefront;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ItemCardviewMetodopagoBinding;
import com.cine.cinefront.model.MetodoPago;

import java.util.ArrayList;

public class MetodoPagoAdapter extends RecyclerView.Adapter<MetodoPagoAdapter.ViewHolder>{

    private ArrayList<MetodoPago> dataMetodoPago;
    private Context context;

    public MetodoPagoAdapter(Context context){
        this.context=context;
        dataMetodoPago=new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        ItemCardviewMetodopagoBinding recyclerBinding=ItemCardviewMetodopagoBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(recyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MetodoPago objMetodoPago=dataMetodoPago.get(position);
        holder.recyclerBinding.tvMetodoPago.setText(objMetodoPago.getTipopago());
        Glide.with(context).load(Constante.URL_IMAGENMETPAG_API+objMetodoPago.getIdmetpag()).into(holder.recyclerBinding.ivMetodoPago);
    }

    public void agregarList(ArrayList<MetodoPago>listaMetodoPago){
        dataMetodoPago.addAll(listaMetodoPago);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataMetodoPago.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCardviewMetodopagoBinding recyclerBinding;
        public ViewHolder(@NonNull ItemCardviewMetodopagoBinding itemView) {
            super(itemView.getRoot());
            recyclerBinding=itemView;
        }
    }

}
