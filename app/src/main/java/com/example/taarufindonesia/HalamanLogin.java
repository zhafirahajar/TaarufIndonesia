package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HalamanLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_login);
        //-------------- kode passing data --------------
        final Button submitButton2 = (Button) findViewById(R.id.Login);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String inputfullName = extras.getString("fullNameString");
                String inputAlamat = extras.getString("AlamatString");
                String inputPekerjaan = extras.getString("PekerjaanString");
                String inputTglLahir = extras.getString("TglLahirString");
                Intent submitIntent = new Intent(HalamanLogin.this, main_menu.class);
                submitIntent.putExtra("fullNameString", inputfullName);
                submitIntent.putExtra("AlamatString", inputAlamat);
                submitIntent.putExtra("PekerjaanString", inputPekerjaan);
                submitIntent.putExtra("TglLahirString", inputTglLahir);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------
    }

    public void clickLogin(View view){
        Intent next = new Intent(this, main_menu.class);
        startActivity(next);
    }

    public void clickHome(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }
}