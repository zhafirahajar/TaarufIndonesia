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


    }
    public void listMatch(View view){
        Intent next = new Intent(this, ListMatches.class);
        startActivity(next);
    }

    public void editProfile(View view){
        Intent next = new Intent(this, profile_pribadi.class);
        startActivity(next);
    }
}