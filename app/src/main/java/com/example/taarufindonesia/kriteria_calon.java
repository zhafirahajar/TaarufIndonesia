package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class kriteria_calon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kriteria_calon);
        //-------------- kode passing data --------------
        final Button submitButton = (Button) findViewById(R.id.button_ok);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String inputfullName = extras.getString("fullNameString");
                String inputAlamat = extras.getString("AlamatString");
                String inputPekerjaan = extras.getString("PekerjaanString");
                String inputTglLahir = extras.getString("TglLahirString");
                Intent submitIntent = new Intent(kriteria_calon.this, HalamanAwal.class);
                submitIntent.putExtra("fullNameString", inputfullName);
                submitIntent.putExtra("AlamatString", inputAlamat);
                submitIntent.putExtra("PekerjaanString", inputPekerjaan);
                submitIntent.putExtra("TglLahirString", inputTglLahir);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------

        //-------------- kode passing data --------------
        final Button submitButton2 = (Button) findViewById(R.id.button_back);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String inputfullName = extras.getString("fullNameString");
                String inputAlamat = extras.getString("AlamatString");
                String inputPekerjaan = extras.getString("PekerjaanString");
                String inputTglLahir = extras.getString("TglLahirString");
                Intent submitIntent = new Intent(kriteria_calon.this, HalamanLogin.class);
                submitIntent.putExtra("fullNameString", inputfullName);
                submitIntent.putExtra("AlamatString", inputAlamat);
                submitIntent.putExtra("PekerjaanString", inputPekerjaan);
                submitIntent.putExtra("TglLahirString", inputTglLahir);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------
    }

    public void clickRegister(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }

    public void clickLogin(View view){
        Intent next = new Intent(this, HalamanLogin.class);
        startActivity(next);
    }
}