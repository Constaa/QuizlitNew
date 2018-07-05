package com.example.jonas.wwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Das ist die Startseite und wenn man auf die Buttons klickt, wird man auf die dementsprechende
 * Seite weitergeleitet. Wie beispielsweise auf Spiel oder Frage Einsenden.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */
public class MainActivity extends AppCompatActivity  {



    Button bTBestenliste;
    Button btSpielen;
Button bTFragen;
TextView tVProblemee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // getSupportActionBar().hide();
        Button bTBestenliste = (Button) findViewById(R.id.bTBestenliste);
        Button btSpielen = (Button) findViewById(R.id.btNormal);
        Button bTFragen = (Button) findViewById(R.id.bTFragen);
        TextView tVProblemee = (TextView) findViewById(R.id.tVProblemee);

        btSpielen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ModusWahl.class);
                startActivity(intent);
            }
        });
        bTFragen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Einsenden.class);
                startActivity(intent);
            }
        });
        bTBestenliste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Diese Funktion ist noch nicht verfügbar!", Toast.LENGTH_SHORT).show();

            }
        });
        tVProblemee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Problem.class);
                startActivity(intent);
            }
        });
    }}



