package com.example.taarufindonesia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HalamanLogin extends AppCompatActivity {

    private Button Home,Login;
    private EditText Username, Password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_login);

        //check the login and regis status using firebase
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(HalamanLogin.this, HalamanRegis.class);
                    Toast.makeText(HalamanLogin.this, "Cannot Sign-In", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                    return;
                }


            }
        };


        Login = (Button) findViewById(R.id.Login);
        Username = (EditText) findViewById(R.id.Username);
        Password = (EditText) findViewById(R.id.Password);

        //-------------- button LOGIN --------------
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String username_str = Username.getText().toString();
                final String password_str = Password.getText().toString();

                mAuth.signInWithEmailAndPassword(username_str,password_str).addOnCompleteListener(HalamanLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(HalamanLogin.this, "Account Not Found", Toast.LENGTH_SHORT).show();
                            //intent ke halaman selanjutnya
                            Intent pindah = new Intent(HalamanLogin.this, HalamanAwal.class);
                            startActivity(pindah);
                            finish();
                        }
                        else{
                            Toast.makeText(HalamanLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            //intent ke halaman selanjutnya
                            Intent pindah = new Intent(HalamanLogin.this, main_menu.class);
                            startActivity(pindah);
                            finish();
                        }
                    }
                });
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


    public void clickHome(View view){
        Intent next = new Intent(HalamanLogin.this, HalamanAwal.class);
        startActivity(next);
        finish();
        return;
    }
}