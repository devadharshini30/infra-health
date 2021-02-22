package com.example.infrahealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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

public class LoginActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private FirebaseAuth fireAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button regBut = findViewById(R.id.regButton);
        EditText emailText = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText name = findViewById(R.id.name);
        progressDialog=new ProgressDialog(this);
        fireAuth = FirebaseAuth.getInstance();

        regBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailText.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String sampleUser= name.getText().toString().trim();

                progressDialog.setMessage("Registering, Please Wait...");
                progressDialog.show();

                fireAuth.createUserWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Intent i=new Intent(LoginActivity.this, MainContentDisplay.class);
                                    i.putExtra("Value",sampleUser);
                                    startActivity(i);
                                    Toast.makeText(LoginActivity.this, "Hey, "+sampleUser+"\nRegistered Successfully.. " ,Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }else{
                                    Toast.makeText(LoginActivity.this, "Registration Failed.." ,Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                            }
                        });
            }
        });

        
        


    }
}