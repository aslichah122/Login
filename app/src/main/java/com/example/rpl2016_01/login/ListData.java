package com.example.rpl2016_01.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {
    RecyclerView recyclerView;
    private Adapter adapter;
    private ArrayList<Siswa> rvData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        initDataset();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(rvData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void initDataset(){


        Siswa siswa1 = new Siswa();
        siswa1.setNama("Wulan");
        siswa1.setKelas("12");
        siswa1.setAlamat("Tunggul");
        rvData.add(siswa1);

        Siswa siswa2 = new Siswa();
        siswa1.setNama("Meilisa");
        siswa1.setKelas("12");
        siswa1.setAlamat("Mijen");
        rvData.add(siswa2);

        Siswa siswa3 = new Siswa();
        siswa1.setNama("Naela");
        siswa1.setKelas("12");
        siswa1.setAlamat("Kedungsari");
        rvData.add(siswa3);
    }
}

