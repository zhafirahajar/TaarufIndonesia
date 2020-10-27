package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class activity_kriteria_calon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kriteria_calon);
    }

    public void clickStart(View view){
        Intent next = new Intent(this, activity_main_menu.class);
        startActivity(next);
    }
}