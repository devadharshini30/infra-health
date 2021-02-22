package com.example.infrahealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityLog extends AppCompatActivity {

    private FirebaseAuth fireAuth;
    private EditText emailLog;
    private EditText passLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        emailLog = findViewById(R.id.emailLog);
        passLog = findViewById(R.id.passLog);
        Button logBut = findViewById(R.id.logButton);


        logBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityLog.this, MainContentDisplay.class);
                startActivity(intent);

            }

        });


    }

}