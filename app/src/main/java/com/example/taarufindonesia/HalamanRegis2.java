package com.example.taarufindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HalamanRegis2 extends AppCompatActivity {

    private EditText Nama, Alamat, Pekerjaan, TglLahir;
    private RadioGroup JenisKelamin;
    private Button next_kriteria;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_regis2);

        Nama = (EditText) findViewById(R.id.Nama);
        Alamat = (EditText) findViewById(R.id.Alamat);
        Pekerjaan = (EditText) findViewById(R.id.Pekerjaan);
        TglLahir = (EditText) findViewById(R.id.TglLahir);
        JenisKelamin = (RadioGroup) findViewById(R.id.JenisKelamin);
        next_kriteria = (Button) findViewById(R.id.next_kriteria);

        mAuth = FirebaseAuth.getInstance();

        //-------------- DATABASE --------------
        next_kriteria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedSex = JenisKelamin.getCheckedRadioButtonId();
                final RadioButton radioButton = (RadioButton) findViewById(selectedSex);
                final String name_str = Nama.getText().toString();
                final String alamat_str = Alamat.getText().toString();
                final String pekerjaan_str = Pekerjaan.getText().toString();
                final String dob_str = TglLahir.getText().toString();

                String userId = mAuth.getCurrentUser().getUid();

                //set name
                DatabaseReference curentUserDb_name = FirebaseDatabase.getInstance().getReference().child("user").child(userId).child("name");
                curentUserDb_name.setValue(name_str);

                //set address
                DatabaseReference curentUserDb_address = FirebaseDatabase.getInstance().getReference().child("user").child(userId).child("address");
                curentUserDb_address.setValue(alamat_str);

                //set pekerjaan
                DatabaseReference curentUserDb_pekerjaan = FirebaseDatabase.getInstance().getReference().child("user").child(userId).child("occupation");
                curentUserDb_pekerjaan.setValue(pekerjaan_str);

                //set tanggal lahir
                DatabaseReference curentUserDb_dob = FirebaseDatabase.getInstance().getReference().child("user").child(userId).child("dob");
                curentUserDb_dob.setValue(dob_str);

                Intent next = new Intent(HalamanRegis2.this, HalamanLogin.class);
                startActivity(next);
                finish();
                return;
            }
        });

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
    }
}