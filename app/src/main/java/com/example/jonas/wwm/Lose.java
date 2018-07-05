package com.example.jonas.wwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
/**
 * Auf diese Klasse wird der Benutzer weitergeleitet, wenn er verliert.
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */
public class Lose extends AppCompatActivity {



    ImageView iVHome;
    ImageView iVRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose);


        iVHome = (ImageView) findViewById(R.id.iVHome);
        iVRepeat = (ImageView) findViewById(R.id.iVRepeat);




        iVHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backhome();
            }
        });

        iVRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ModusWahl.class);
                startActivity(intent);
            }
        });
    }



    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);

    }

    public void backhome() {
        Intent home = new Intent(getBaseContext(), MainActivity.class);
        startActivity(home);
    }



    }

