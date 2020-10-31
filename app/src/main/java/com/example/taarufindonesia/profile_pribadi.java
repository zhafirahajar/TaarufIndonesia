package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile_pribadi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_pribadi);

        Button backsit3 = (Button) findViewById(R.id.Settings);
        backsit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(profile_pribadi.this, Settings.class);
                startActivity(intent);
            }
        });
    }
    public void backButtonPressed(View view){
        this.onBackPressed();
    } //di app
    public void clickLogout(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }
}