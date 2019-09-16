package com.dicoding.picodiploma.wisatalombok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailWisata extends AppCompatActivity {

    ImageView ivFoto;
    TextView tvNama, tvLokasi, tvKeterangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("nama"));
        }

        ivFoto = findViewById(R.id.img_wisata_received);
        tvNama = findViewById(R.id.nama_received);
        tvLokasi = findViewById(R.id.lokasi_received);
        tvKeterangan = findViewById(R.id.keterangan_received);

        String namaHolder = getIntent().getStringExtra("nama");
        String lokasiHolder = getIntent().getStringExtra("lokasi");
        String keteranganHolder = getIntent().getStringExtra("keterangan");
        String fotoHolder = getIntent().getStringExtra("gambar");

        tvNama.setText(namaHolder);
        tvLokasi.setText(lokasiHolder);
        tvKeterangan.setText(keteranganHolder);
        Glide.with(DetailWisata.this)
                .load(fotoHolder)
                .into(ivFoto);
    }
}
