package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class kriteria_calon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kriteria_calon);
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