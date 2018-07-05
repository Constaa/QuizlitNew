package com.example.jonas.wwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;
/**
 * Bei einem Gewinn der drei Spielmodi wird man hier her weitergeleitet.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */
public class Win extends AppCompatActivity {



    ImageView iVHome;
    ImageView iVRepeat;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win);

        iVHome = (ImageView) findViewById(R.id.iVHome);
        iVRepeat= (ImageView) findViewById(R.id.iVRepeat);





        iVHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        iVRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), ModusWahl.class);
                startActivity(intent);
            }
        });


    }

    public Win() {

    }

    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);

    }



}
