package com.example.dell.aurafocus_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SleepPause extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_pause);

        Button btnEnd = findViewById(R.id.endBtn3);

        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SleepPause.this, SleepMain.class));
            }
        });


        Button btnResume = findViewById(R.id.resumeBtn3);

        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SleepPause.this, Sleep2Main.class));
            }
        });

        Button btnSettings = findViewById(R.id.settingsBtn3);

        btnSettings.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SleepPause.this, SleepSettings.class));
            }
        });


    }
}
