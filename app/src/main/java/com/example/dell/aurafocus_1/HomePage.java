package com.example.musha.aninterface;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomePage extends AppCompatActivity {
    DatabaseHelper myDb;

    private ImageButton button;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton pro;
        ImageButton set;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        myDb = new DatabaseHelper(this);

        pro = (ImageButton) findViewById(R.id.btn_home_profile);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });

        set = (ImageButton) findViewById(R.id.btn_home_set);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });


    }

        public void openActivity(){
            Intent intent = new Intent(this,user.class);
            startActivity(intent);
        }

        public void openActivity1(){
        Intent intent = new Intent(this,profile.class);
        startActivity(intent);
        }
}
