package com.example.musha.aninterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class set extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        TextView pro;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        pro = (TextView) findViewById(R.id.set_pro2);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity1();
            }
        });
    }




    public void openActivity1(){
        Intent intent = new Intent(this,profile.class);
        startActivity(intent);
    }
}


