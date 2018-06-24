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
public class ModusWahl extends AppCompatActivity {
    Button btNormal;
    Button btINF;
    Button btGDZ;
    TextView tvUS;
    Spiel frageKlasse;
    boolean normal;
    boolean unendlich;
    boolean gdz;

int modus = 0;
int gdzmod = 0;

    public int getGdzmod() {
        return gdzmod;
    }

    public void setGdzmod(int gdzmod) {
        this.gdzmod = gdzmod;
    }

    public ModusWahl() {

    }

    public int getModus() {
        return modus;
    }

    public void setModus(int modus) {
        this.modus = modus;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modus_wahl);
        btNormal = (Button) findViewById(R.id.btNormal);
        btINF = (Button) findViewById(R.id.btINF);
        btGDZ = (Button) findViewById(R.id.btGDZ);
        tvUS = (TextView) findViewById(R.id.tvUS);
        frageKlasse = new Spiel();
        normal = false;
        unendlich = false;
        gdz = false;
        btNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normal = true;
                setModus(1);
                starteSpiel();


            }
        });
    btINF.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            unendlich = true;
            setModus(2);
            starteSpiel();
        }
    });
    btGDZ.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            gdz = true;
            setModus(3);

            btNormal.setText("30 Sekunden");
            btINF.setText("60 Sekunden");
            btGDZ.setText("90 Sekunden");
            tvUS.setText("ZEIT WÄHLEN");
            btNormal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setGdzmod(1);

                    starteSpiel();
                }
            });
            btINF.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setGdzmod(2);

                    starteSpiel();
                }
            });
            btGDZ.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setGdzmod(3);

                    starteSpiel();
                }
            });
        }
    });

    }
    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    private void starteSpiel() {
        Intent intent = new Intent(getBaseContext(), Spiel.class);
        intent.putExtra("MODUS", modus);
        intent.putExtra("ZEIT",gdzmod);
        startActivity(intent);

    }


}
