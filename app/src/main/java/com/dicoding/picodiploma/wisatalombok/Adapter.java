package com.dicoding.picodiploma.wisatalombok;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {

    Context context;
    ArrayList<Wisata> listWisata;

    public ArrayList<Wisata> getListWisata() {
        return listWisata;
    }

    public void setListWisata(ArrayList<Wisata> listWisata) {
        this.listWisata = listWisata;
    }

    public Adapter(Context context) {
        this.context = context;
    }

    @Override
    public Adapter.myViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_item, viewGroup, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adapter.myViewHolder holder, int position) {
        Wisata w = getListWisata().get(position);

        Glide.with(context)
                .load(w.getFoto())
                .into(holder.foto);
        holder.tvNama.setText(w.getNama());
        holder.tvLokasi.setText(w.getLokasi());
    }

    @Override
    public int getItemCount() {
        return getListWisata().size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        ImageView foto;
        TextView tvNama, tvLokasi;

        public myViewHolder(View itemView) {
            super(itemView);

            foto = itemView.findViewById(R.id.img_wisata);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvLokasi = itemView.findViewById(R.id.tv_tempat);
        }
    }
}
