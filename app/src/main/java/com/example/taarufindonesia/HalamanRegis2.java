package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HalamanRegis2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_regis2);

        //-------------- kode passing data --------------
        final Button submitButton = (Button)findViewById(R.id.next_kriteria);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(HalamanRegis2.this, kriteria_calon.class);
                startActivity(next);
                finish();
                return;
            }
        });
        //-------------- kode passing data --------------

        //-------------- kode passing data --------------
        final Button login = (Button) findViewById(R.id.Login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(HalamanRegis2.this, HalamanLogin.class);
                startActivity(next);
                finish();
                return;
            }
        });
        //-------------- kode passing data --------------
    }
}