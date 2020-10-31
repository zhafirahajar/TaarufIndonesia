package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HalamanAwal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_awal);
        //-------------- kode passing data --------------
        final Button submitButton = (Button) findViewById(R.id.Login);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String inputfullName = extras.getString("fullNameString");
                String inputAlamat = extras.getString("AlamatString");
                String inputPekerjaan = extras.getString("PekerjaanString");
                String inputTglLahir = extras.getString("TglLahirString");
                Intent submitIntent = new Intent(HalamanAwal.this, HalamanLogin.class);
                submitIntent.putExtra("fullNameString", inputfullName);
                submitIntent.putExtra("AlamatString", inputAlamat);
                submitIntent.putExtra("PekerjaanString", inputPekerjaan);
                submitIntent.putExtra("TglLahirString", inputTglLahir);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------
        final Button submitButton2 = (Button)findViewById(R.id.Register);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HalamanAwal.this, HalamanRegis.class);
                startActivity(pindah);
                finish();
            }
        });
    }
}