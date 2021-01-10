package com.example.taarufindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class profile_pribadi extends AppCompatActivity {
    private TextView NamaLengkap, tanggalLahir_value, alamat_value, pekerjaanPribadi_value;
    private Button Edit,logout;
    private FirebaseAuth mAuth;
    private DatabaseReference userDatabse;
    private String userId, name, address, occupation, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile_pribadi);

            NamaLengkap = (TextView) findViewById(R.id.Namalengkap);
            tanggalLahir_value = (TextView) findViewById(R.id.tanggalLahir_value);
            alamat_value = (TextView) findViewById(R.id.alamat_value);
            pekerjaanPribadi_value = (TextView) findViewById(R.id.pekerjaanPribadi_value);
            Edit = (Button) findViewById(R.id.Edit);

            mAuth = FirebaseAuth.getInstance();
            userId = mAuth.getCurrentUser().getUid();
            userDatabse = FirebaseDatabase.getInstance().getReference().child("user").child(userId);

            getUserInfo();
        }

    private void getUserInfo() {
        userDatabse.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0){
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if(map.get("name") != null){
                        name = map.get("name").toString();
                        NamaLengkap.setText(name);
                    }
                    if(map.get("address") != null){
                        address = map.get("address").toString();
                        alamat_value.setText(address);
                    }
                    if(map.get("dob") != null){
                        dob = map.get("dob").toString();
                        tanggalLahir_value.setText(dob);
                    }
                    if(map.get("occupation") != null){
                        occupation = map.get("occupation").toString();
                        pekerjaanPribadi_value.setText(occupation);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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

    public void clickEdit(View view){
        Intent next = new Intent(this, Settings.class);
        startActivity(next);
    }
}