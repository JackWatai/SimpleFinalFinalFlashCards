package com.example.simplefinalfinalflashcard;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button buttontopic1;
    Button buttontopic2;
    Button buttontopic3;
    Button buttontopic4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttontopic1 = (Button) findViewById(R.id.button_topic1);
        buttontopic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Topic1.class);
                startActivity(intent);
            }
        });

        buttontopic2 = (Button) findViewById(R.id.button_topic2);
        buttontopic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Topic2.class);
                startActivity(intent);
            }
        });

        buttontopic3 = (Button) findViewById(R.id.button_topic3);
        buttontopic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Topic3.class);
                startActivity(intent);
            }
        });

        buttontopic4 = (Button) findViewById(R.id.button_topic4);
        buttontopic4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Topic4.class);
                startActivity(intent);
            }
        });


    }
}