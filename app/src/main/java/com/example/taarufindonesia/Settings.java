package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //-------------- kode passing data --------------
        Bundle extras = getIntent().getExtras();
        String inputfullName = extras.getString("fullNameString");
        String inputAlamat = extras.getString("AlamatString");
        String inputPekerjaan = extras.getString("PekerjaanString");
        String inputTglLahir = extras.getString("TglLahirString");
        TextView showfullName = (EditText) findViewById(R.id.fullName_value);
        TextView showAlamat = (EditText) findViewById(R.id.alamat_value);
        TextView showPekerjaan = (EditText) findViewById(R.id.pekerjaanPribadi_value);
        TextView showTglLahir = (EditText) findViewById(R.id.tanggalLahir_value);
        showfullName.setText(inputfullName);
        showAlamat.setText(inputAlamat);
        showPekerjaan.setText(inputPekerjaan);
        showTglLahir.setText(inputTglLahir);
        //-------------- kode passing data --------------

    }

    public void backButtonPressed(View view){
        this.onBackPressed();
    } //di app

    public void clickSimpan(View view){
        Intent next = new Intent(this, profile_pribadi.class);
        startActivity(next);
    }
}