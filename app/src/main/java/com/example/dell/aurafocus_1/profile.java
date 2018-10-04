package com.example.musha.aninterface;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    private ImageButton button;
    private TextView login;
    private TextView reg;
    private TextView settings;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        button = (ImageButton) findViewById(R.id.imageButton3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        login = (TextView) findViewById(R.id.profile_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        reg = (TextView) findViewById(R.id.profile_reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        settings = (TextView) findViewById(R.id.profile_set);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });

    }

    public void openActivity1(){
        Intent intent = new Intent(this,HomePage.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this,settings.class);
        startActivity(intent);
    }


}
