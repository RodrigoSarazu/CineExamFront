package com.cine.cinefront;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ItemCardviewBinding;
import com.cine.cinefront.model.Locales;

import java.util.ArrayList;

public class LocalesAdapter extends RecyclerView.Adapter<LocalesAdapter.ViewHolder> {

    private ArrayList<Locales>dataLocales;
    private Context context;

    public LocalesAdapter(Context context){
        this.context=context;
        dataLocales=new ArrayList<>();
    }


    @NonNull
    @Override
    public LocalesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        ItemCardviewBinding recyclerBinding=ItemCardviewBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(recyclerBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalesAdapter.ViewHolder holder, int position) {
        final Locales objLocales=dataLocales.get(position);
        holder.recyclerBinding.tvlocal.setText(objLocales.getNomloc());
        Glide.with(context).load(new Constante().URL_IMAGENLOC_API+objLocales.getId()).into(holder.recyclerBinding.ivLocal);
    }


    public void agregarList(ArrayList<Locales>listaLocales){
        dataLocales.addAll(listaLocales);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataLocales.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemCardviewBinding recyclerBinding;
        public ViewHolder(@NonNull  ItemCardviewBinding itemView) {
            super(itemView.getRoot());
            recyclerBinding=itemView;
        }
    }
}
