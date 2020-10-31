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
                EditText fullName = (EditText) findViewById(R.id.Nama);
                EditText Alamat = (EditText) findViewById(R.id.Alamat);
                EditText Pekerjaan = (EditText) findViewById(R.id.Pekerjaan);
                EditText TglLahir = (EditText) findViewById(R.id.TglLahir);
                String fullNameString = fullName.getText().toString();
                String AlamatString = Alamat.getText().toString();
                String PekerjaanString = Pekerjaan.getText().toString();
                String TglLahirString = TglLahir.getText().toString();
                Intent submitIntent = new Intent(HalamanRegis2.this, kriteria_calon.class);
                submitIntent.putExtra("fullNameString", fullNameString);
                submitIntent.putExtra("AlamatString", AlamatString);
                submitIntent.putExtra("PekerjaanString", PekerjaanString);
                submitIntent.putExtra("TglLahirString", TglLahirString);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------

        //-------------- kode passing data --------------
        final Button submitButton2 = (Button) findViewById(R.id.Login);
        submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText fullName = (EditText) findViewById(R.id.Nama);
                EditText Alamat = (EditText) findViewById(R.id.Alamat);
                EditText Pekerjaan = (EditText) findViewById(R.id.Pekerjaan);
                EditText TglLahir = (EditText) findViewById(R.id.TglLahir);
                String fullNameString = fullName.getText().toString();
                String AlamatString = Alamat.getText().toString();
                String PekerjaanString = Pekerjaan.getText().toString();
                String TglLahirString = TglLahir.getText().toString();
                Intent submitIntent = new Intent(HalamanRegis2.this, HalamanLogin.class);
                submitIntent.putExtra("fullNameString", fullNameString);
                submitIntent.putExtra("AlamatString", AlamatString);
                submitIntent.putExtra("PekerjaanString", PekerjaanString);
                submitIntent.putExtra("TglLahirString", TglLahirString);
                startActivity(submitIntent);
            }
        });
        //-------------- kode passing data --------------
    }
}