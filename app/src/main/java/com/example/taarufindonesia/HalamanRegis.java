package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HalamanRegis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_regis);
        final Button submitButton = (Button)findViewById(R.id.Continue);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HalamanRegis.this, HalamanRegis2.class);
                startActivity(pindah);
                finish();
            }
        });
        final Button submitButton2 = (Button)findViewById(R.id.Login);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HalamanRegis.this, HalamanLogin.class);
                startActivity(pindah);
                finish();
            }
        });
    }
}