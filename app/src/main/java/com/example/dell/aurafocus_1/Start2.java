package com.example.dell.aurafocus_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Start2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start2);

        Button btnPause = findViewById(R.id.pauseBtn2);

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Start2.this, pause3.class));
            }
        });

        Button btnClose = findViewById(R.id.closeBtn2);



    }
}
