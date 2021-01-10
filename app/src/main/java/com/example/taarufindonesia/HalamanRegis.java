package com.example.taarufindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HalamanRegis extends AppCompatActivity {

    private Button Continue,Login;
    private EditText Username, Password, Repassword;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_regis);

        //check the login and regis status using firebase
        /*
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(HalamanRegis.this, HalamanAwal.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };
         */
        mAuth = FirebaseAuth.getInstance();


        Continue = (Button) findViewById(R.id.Continue);
        Login = (Button) findViewById(R.id.Login);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);

        //-------------- button SELANJUTNYA --------------
        Continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username_str = Username.getText().toString();
                final String password_str = Password.getText().toString();

                mAuth.createUserWithEmailAndPassword(username_str,password_str).addOnCompleteListener(HalamanRegis.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(HalamanRegis.this, "Cannot Sign-Up", Toast.LENGTH_SHORT).show();
                            //intent ke halaman selanjutnya
                            Intent pindah = new Intent(HalamanRegis.this, HalamanAwal.class);
                            startActivity(pindah);
                            finish();
                        }
                        else{
                            Toast.makeText(HalamanRegis.this, "Sign-Up Successfully", Toast.LENGTH_SHORT).show();
                            //intent ke halaman selanjutnya
                            Intent pindah = new Intent(HalamanRegis.this, HalamanRegis2.class);
                            startActivity(pindah);
                            finish();
                        }
                    }
                });
            }
        });

        //-------------- button LOGIN --------------
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(HalamanRegis.this, HalamanLogin.class);
                startActivity(pindah);
                finish();
            }
        });


    }

    /*
     @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
     */

}