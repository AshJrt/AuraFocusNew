package com.example.dell.aurafocus_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class pause3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause3);

        Button btnEnd = findViewById(R.id.endBtn3);

        btnEnd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pause3.this, MainActivity.class));
            }
        });


        Button btnResume = findViewById(R.id.resumeBtn3);

        btnResume.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pause3.this, Start2.class));
            }
        });

        Button btnSettings = findViewById(R.id.settingsBtn3);

        btnSettings.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(pause3.this, MainSettings.class));
            }
        });
    }
}
