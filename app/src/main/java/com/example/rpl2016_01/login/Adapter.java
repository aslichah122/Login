package com.example.rpl2016_01.login;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Siswa> rvData;

    public Adapter(ArrayList<Siswa> rvData) {
        this.rvData = rvData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.menetapkanSiswa(rvData.get(position));
    }

    @Override
    public int getItemCount() {
        return rvData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvnama;
        public TextView tvkelas;
        public TextView tvalamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnama = (TextView) itemView.findViewById(R.id.nama);
            tvkelas = (TextView) itemView.findViewById(R.id.kelas);
            tvalamat = (TextView) itemView.findViewById(R.id.alamat);
        }

        public void menetapkanSiswa(Siswa siswa) {
            tvnama.setText(siswa.nama);
            tvkelas.setText(siswa.kelas);
            tvalamat.setText(siswa.alamat);
        }

    } {
}}
