package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class profile_pribadi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pribadi);
        //-------------- kode passing data --------------

    }

    public void backButtonPressed(View view){
        this.onBackPressed();
    } //di app
    public void clickLogout(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }
}