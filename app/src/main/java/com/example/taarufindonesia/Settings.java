package com.example.taarufindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Settings extends AppCompatActivity {
    private EditText fullName, tanggalLahir, alamat, pekerjaanPribadi;
    private Button simpan;
    private FirebaseAuth mAuth;
    private DatabaseReference userDatabse;
    private String userId, name, address, occupation, dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        fullName = (EditText) findViewById(R.id.fullName_value);
        tanggalLahir = (EditText) findViewById(R.id.tanggalLahir_value);
        alamat = (EditText) findViewById(R.id.alamat_value);
        pekerjaanPribadi = (EditText) findViewById(R.id.pekerjaanPribadi_value);
        simpan = (Button) findViewById(R.id.simpan);

        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();
        userDatabse = FirebaseDatabase.getInstance().getReference().child("user").child(userId);

        getUserInfo();

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInformation();
                Intent next = new Intent(Settings.this, profile_pribadi.class);
                startActivity(next);
                return;
            }
        });

    }

    private void saveUserInformation() {
        name = fullName.getText().toString();
        address = alamat.getText().toString();
        occupation = pekerjaanPribadi.getText().toString();
        dob = tanggalLahir.getText().toString();

        Map userInfo = new HashMap();
        userInfo.put("name", name);
        userInfo.put("address",address);
        userInfo.put("dob",dob);
        userInfo.put("occupation",occupation);

        userDatabse.updateChildren(userInfo);
    }

    public void backButtonPressed(View view){
        this.onBackPressed();
    } //di app

    private void getUserInfo() {
        userDatabse.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0){
                    Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                    if(map.get("name") != null){
                        name = map.get("name").toString();
                        fullName.setText(name);
                    }
                    if(map.get("address") != null){
                        address = map.get("address").toString();
                        alamat.setText(address);
                    }
                    if(map.get("dob") != null){
                        dob = map.get("dob").toString();
                        tanggalLahir.setText(dob);
                    }
                    if(map.get("occupation") != null){
                        occupation = map.get("occupation").toString();
                        pekerjaanPribadi.setText(occupation);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}