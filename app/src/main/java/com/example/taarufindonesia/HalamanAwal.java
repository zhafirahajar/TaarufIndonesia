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

        //-------------- button LOGIN --------------
        final Button submitButton = (Button) findViewById(R.id.Login);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HalamanAwal.this, HalamanLogin.class);
                startActivity(pindah);
                finish();
            }
        });

        //-------------- button regis --------------
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