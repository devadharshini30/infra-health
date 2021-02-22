package com.example.infrahealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainContentDisplay extends AppCompatActivity {

    public TextView temperatureValue;
    public TextView heartBeatRateValue;
    public TextView bloodPressValue;
    public ProgressDialog progressDialog;
    public int i=0;
    public int[] heartbeat;
    public int[] temperature;
    public int[] bloodPressure;
    private FirebaseAuth firebaseAuths;
    private DatabaseReference databaseReference;
    public String dataName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_content_display);

        heartbeat = new int[]{88, 78, 90, 73, 88, 90, 77, 97, 77, 87, 89, 76, 81, 71, 85, 74, 79, 83, 94, 87, 81, 85,};
        temperature=new int[]{91,93,96,101,104,108,89,99,100,107,108,103,99,94,97,93,90,87,93,95,98,105};
        bloodPressure = new int[]{88, 90, 78, 73, 56, 90, 77, 93, 77, 87, 89, 74, 81, 71, 80, 74, 56, 83, 94, 87, 81, 85};

        progressDialog=new ProgressDialog(this);

        temperatureValue= findViewById(R.id.tempValue);
        heartBeatRateValue= findViewById(R.id.heartBeatValue);
        bloodPressValue = findViewById(R.id.bpValue);

        dataName=getIntent().getExtras().getString("Value");

        Button but = findViewById(R.id.updateBut);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainContentDisplay.this,"Successfully Updated",Toast.LENGTH_SHORT).show();
                Random r = new Random();
                int i = r.nextInt(98-60+1)+60;
                int j = r.nextInt(90-80+1)+80;
                int k = r.nextInt(99-90+1)+90;

                ProgressDialog dialog = ProgressDialog.show(MainContentDisplay.this, "Update", "Please Wait while your data is updating",
                        true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                    }
                }, 3000);

                    temperatureValue.setText(i +"");
                    heartBeatRateValue.setText(j +"");
                    bloodPressValue.setText(k +"");
            }
        });

    }
}