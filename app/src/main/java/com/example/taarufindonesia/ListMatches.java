package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListMatches extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_matches);


    }
    public void onPasangan(View view){
        Intent next = new Intent(this, ProfilPasangan.class);
        startActivity(next);
    }

    public void backPasangan(View view) {
        Intent next = new Intent(this, main_menu.class);
        startActivity(next);
    }
}