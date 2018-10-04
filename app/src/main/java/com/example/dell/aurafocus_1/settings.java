package com.example.musha.aninterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class settings extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView pro;
        TextView about;
        TextView feed;
        TextView rate;
        TextView account;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        pro = (TextView) findViewById(R.id.set_pro2);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity();
            }
        });


        feed = (TextView) findViewById(R.id.set_feed);
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });

        about = (TextView) findViewById(R.id.set_about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });

        rate = (TextView) findViewById(R.id.set_rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        account = (TextView) findViewById(R.id.set_account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity4();
            }
        });


    }

    public void openActivity(){
        Intent intent = new Intent(this,ProPic.class);
        startActivity(intent);
    }

    public void openActivity1(){
        Intent intent = new Intent(this,AboutUS.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this,RateUs.class);
        startActivity(intent);
    }

    public void openActivity3(){
        Intent intent = new Intent(this,Feedback.class);
        startActivity(intent);
    }

    public void openActivity4(){
        Intent intent = new Intent(this,change.class);
        startActivity(intent);
    }
}
