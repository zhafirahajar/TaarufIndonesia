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

        Button backsit1 = (Button) findViewById(R.id.love);
        backsit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_menu.this, ListMatches.class);
                startActivity(intent);
            }
        });
    }

    public void editProfile(View view){
        Intent next = new Intent(this, profile_pribadi.class);
        startActivity(next);
    }
}