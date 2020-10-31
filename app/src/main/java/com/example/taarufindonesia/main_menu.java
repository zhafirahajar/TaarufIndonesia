package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //-------------- kode passing data --------------
        final Button submitButton2 = (Button) findViewById(R.id.button_profile);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String inputfullName = extras.getString("fullNameString");
                String inputAlamat = extras.getString("AlamatString");
                String inputPekerjaan = extras.getString("PekerjaanString");
                String inputTglLahir = extras.getString("TglLahirString");
                Intent submitIntent = new Intent(main_menu.this, profile_pribadi.class);
                submitIntent.putExtra("fullNameString", inputfullName);
                submitIntent.putExtra("AlamatString", inputAlamat);
                submitIntent.putExtra("PekerjaanString", inputPekerjaan);
                submitIntent.putExtra("TglLahirString", inputTglLahir);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------
    }

    public void editProfile(View view){
        Intent next = new Intent(this, profile_pribadi.class);
        startActivity(next);
    }
    public void BackHome(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }
}