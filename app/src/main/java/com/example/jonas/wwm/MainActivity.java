package com.example.jonas.wwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Dies ist die Klasse, in der die das eigentliche Spiel passiert.
 * Die Fragen werden zum Start und nachdem die richtige Frage gewählt wurde, neu generiert bzw. zugeordnet.
 * Die Frage und die Antworten werden aus einem Fragen-Objekt genommen.
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
        tVProblemee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Problem.class);
                startActivity(intent);
            }
        });
    }}



