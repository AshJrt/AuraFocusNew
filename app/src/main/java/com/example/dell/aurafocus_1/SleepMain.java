package com.example.dell.aurafocus_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SleepMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_main);

        Button btnSettings = findViewById(R.id.settingsBtn1);

        btnSettings.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(SleepMain.this, SleepSettings.class ));
            }
        });

        Button btnStart = findViewById(R.id.startBtn1);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SleepMain.this, Sleep2Main.class));
            }
        });


    }
}