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
 * Dies ist die Klasse, in der die das eigentliche Spiel passiert.
 * Die Fragen werden zum Start und nachdem die richtige Frage gewählt wurde, neu generiert bzw. zugeordnet.
 * Die Frage und die Antworten werden aus einem Fragen-Objekt genommen.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */
public class Lose extends AppCompatActivity {

    ImageView imageView7;
    ImageView imageView12;
    ImageView iVHome;
    ImageView iVRepeat;
    TextView textView2;
    TextView textView5;
    TextView tVHome;
    TextView tVRepeat;
    ModusWahl m = new ModusWahl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose);

        m.setModus(0);


        iVHome = (ImageView) findViewById(R.id.iVHome);
        iVRepeat = (ImageView) findViewById(R.id.iVRepeat);
        tVHome = (TextView) findViewById(R.id.tVHome);
        tVRepeat = (TextView) findViewById(R.id.tVRepeat);
        textView5 = (TextView) findViewById(R.id.textView5);





        iVHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backhome();
            }
        });
        tVHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backhome();
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

