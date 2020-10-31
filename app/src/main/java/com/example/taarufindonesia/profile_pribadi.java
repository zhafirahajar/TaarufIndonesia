package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class profile_pribadi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pribadi);
        //-------------- kode passing data --------------
        Bundle extras = getIntent().getExtras();
        String inputfullName = extras.getString("fullNameString");
        String inputAlamat = extras.getString("AlamatString");
        String inputPekerjaan = extras.getString("PekerjaanString");
        String inputTglLahir = extras.getString("TglLahirString");
        TextView showfullName = (TextView) findViewById(R.id.Namalengkap);
        TextView showAlamat = (TextView) findViewById(R.id.alamat_value);
        TextView showPekerjaan = (TextView) findViewById(R.id.pekerjaanPribadi_value);
        TextView showTglLahir = (TextView) findViewById(R.id.tanggalLahir_value);
        showfullName.setText(inputfullName);
        showAlamat.setText(inputAlamat);
        showPekerjaan.setText(inputPekerjaan);
        showTglLahir.setText(inputTglLahir);
        //-------------- kode passing data --------------
        Button backsit3 = (Button) findViewById(R.id.Settings);
        backsit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile_pribadi.this, Settings.class);
                startActivity(intent);
            }
        });
    }

    public void backButtonPressed(View view){
        this.onBackPressed();
    } //di app
    public void clickLogout(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }
}