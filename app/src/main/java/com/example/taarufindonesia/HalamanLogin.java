package com.example.taarufindonesia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HalamanLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_login);

    }

    public void clickLogin(View view){
        Intent next = new Intent(this, main_menu.class);
        startActivity(next);
    }

    public void clickHome(View view){
        Intent next = new Intent(this, HalamanAwal.class);
        startActivity(next);
    }
}