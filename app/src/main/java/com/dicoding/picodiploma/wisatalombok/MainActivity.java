package com.dicoding.picodiploma.wisatalombok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvList;
    private ArrayList<Wisata> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rv_List);
        rvList.setHasFixedSize(true);

        list.addAll(WisataData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvList.setLayoutManager(new LinearLayoutManager(this));
        Adapter listLanguageAdapter = new Adapter(this);
        listLanguageAdapter.setListWisata(list);
        rvList.setAdapter(listLanguageAdapter);

        ItemClickSupport.addTo(rvList).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedItem(list.get(position));
            }
        });
    }

    private void showSelectedItem(Wisata wisata){
        Intent intent = new Intent(MainActivity.this, DetailWisata.class);

        intent.putExtra("gambar", wisata.getFoto());
        intent.putExtra("nama", wisata.getNama());
        intent.putExtra("lokasi", wisata.getLokasi());
        intent.putExtra("keterangan", wisata.getKeterangan());

        startActivity(intent);
    }
}
