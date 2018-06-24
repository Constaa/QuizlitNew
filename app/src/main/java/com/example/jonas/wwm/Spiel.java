package com.example.jonas.wwm;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

public class Spiel extends AppCompatActivity {

    private static final String TAG = "Spiel";


    ModusWahl m;
    ProgressBar progressBar;
   CountDownTimer myCounter;
   Button antwort1;
   Button antwort2;
   Button antwort3;
   Button antwort4;
   MyCounter counter;
   TextView tvF1;
   int richtigeAntworten;
    ArrayList<Fragen> alleFragen;

    Fragen aktuelleFrage;
    Fragen f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20;
    int moduswahl,zeitwahl, zeit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        m = new ModusWahl();
        alleFragen = new ArrayList<>();
        f1 = new Fragen("Ist Stanley klein?", "Haja","Nein","Vielleicht","Giga Schwul", false);
        f2 = new Fragen("Ist Zinar groß?", "Ja","Nein","Vielleicht","Giga Schwul", false);
        f3 = new Fragen("Wann wurde die Mauer in Berlin niedergerissen","1998","1981","1898","1989",false);
        f4 = new Fragen("Vor welchen Tieren fürchtete sich Napoleon?","Hunden","Vögeln","Mäusen","Katzen",false);
        f5 = new Fragen("Wie heißt die Griechische Göttermutter?","Hestia","Eileithyia","Athene","Hera",false);
        f6 = new Fragen("Wo lebt der Dingo?","Europa","Asien","Afrika","Australien",false);
        f7 = new Fragen("Wer spielte den 1. James Bond?","Daniel Craig","Pierce Brosnan","Timothy Dalton","Sean Connery",false);
        f8 = new Fragen("Was ist ein Paso Doble?","Ein Getränk","Eine Straße","Ein Gebäude","Ein Tanz",false);
        f9 = new Fragen("Ab wann wurde Aspirin als Medikament verkauft?","1755","1829","1902","1899",false);
        f10 = new Fragen("Wie viele Karten braucht man zum Bridgespielen?","54","56","50","52",false);
        f11 = new Fragen("Welche Berufssparte leistet den “Hippokratischen Eid?","Lehrer","Politiker","Polizist","Mediziner",false);
        f12 = new Fragen("Ist die Tomate eine Frucht?", "Nein","Halb-Frucht","Ne Gemüse","Ja",false);
        f13 = new Fragen("Was ist Java?","Eine Insel","Ein Auto","Browser","Programmiersprache",false);
        f14 = new Fragen("Was bedeutet H&M ausgeschrieben?","Hammer und Max","Hang und Mong", "Himmel und Meer","Hennes Mauritz",false);



        Log.d(TAG, "fragen erstellt: ");

        alleFragen.add(f1);
        alleFragen.add(f2);
        alleFragen.add(f3);
        alleFragen.add(f4);
        alleFragen.add(f5);
        alleFragen.add(f6);
        alleFragen.add(f7);
        alleFragen.add(f8);
        alleFragen.add(f9);
        alleFragen.add(f10);
        alleFragen.add(f11);
        alleFragen.add(f12);
        alleFragen.add(f13);
        alleFragen.add(f14);

        Log.d(TAG, "fragen geaddet: ");
        moduswahl = (int) extras.get("MODUS");
        zeitwahl = (int) extras.get("ZEIT");
        Log.d(TAG, "zeit:: "+zeitwahl);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.frage01);
        progressBar = (ProgressBar)findViewById(R.id.progressBar2);
        antwort1 = (Button) findViewById(R.id.antwort1);
        antwort2 = (Button) findViewById(R.id.antwort2);
        antwort3 = (Button) findViewById(R.id.antwort3);
        antwort4 = (Button) findViewById(R.id.antwort4);
        tvF1 = (TextView) findViewById(R.id.tvF1);
        myCounter = new MyCountDownTimer(10000, 500);

        Log.d(TAG, "onCreate: counter");
        Log.d(TAG, "modus"+m.normal);
        switch (zeitwahl) {
            case 1:
                zeit = 30000;
                break;
            case 2:
                zeit = 60000;
                break;
            case 3:
                zeit = 90000;
                break;
        }
        counter = new MyCounter(zeit,500);
switch (moduswahl) {


    case 1:

        normalesSpiel();
        Log.d(TAG, "modus auswählen: ");
        break;
    case 2:
        unendlichkeit();
        break;
    case 3:
        gegenDieZeit();
        break;
}



    }
    /**
     * Der Modus gegen die Zeit wird gestartet.
     * Der Timer stellt sich je nachdem, was gewählt wurde, durch einen Extra Intent
     * in der Klasse ModusWahl. Die ProgressBar läuft in den letzten 10 Sekunden herunter.
     * In jeder Spielmodus Methode wird der Inhalt des geklickten Buttons mit der hinterlegten richtigen Antwort (rAntwort)
     * des aktuellen Fragen-Objekts verglichen und je nachdem entschieden, was passiert.
     *
     */

    public void gegenDieZeit() {
        Log.d(TAG, "gegenDieZeit: ");
        myCounter.cancel();
        counter.start();
        progressBar.setProgress(100);
        richtigeAntworten = 0;
        starteNeueFrageOhneTimerStop();
        Log.d(TAG, "gegenDieZeit: antworten zugwiesen");



        antwort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort1.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }});



        antwort2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort2.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }
        });
        antwort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort3.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }



        });
        antwort4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort4.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }
        });

    }
    /**
     * Der Timer wird nicht gestartet und auch nicht angezeigt. Man verliert nur, indem man
     * die Frage falsch beantwortet. Gewonnen hat man, wenn die Liste (alleFragen) leer ist.
     *
     */

    public void unendlichkeit() {
        progressBar.setVisibility(View.INVISIBLE);
        Log.d(TAG, "unendlichkeit: ");
        myCounter = new MyCountDownTimer(10000, 500);
        richtigeAntworten = 0;
        starteNeueFrage();
        myCounter.cancel();



        antwort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort1.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }});



        antwort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (antwort2.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }
        });
        antwort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort3.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }



        });
        antwort4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort4.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (alleFragen.size() > 0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }
        });
    }
    /**
     * Der Timer geht 10 Sekunden. Man hat entweder verloren, wenn diese 10 Sekunden überschritten werden oder wenn man eine
     * falsche Antwort anklickt. Gewonnen hat man bei 15 richtig beantworteten Fragen. Die Anzahl der richtig beantworteten Fragen
     * wird immer hochgezählt.
     *
     */

    public void normalesSpiel() {
        Log.d(TAG, "normalesSpiel: ");

        richtigeAntworten = 0;
        Log.d(TAG, "Timer gestartet: ");
        starteNeueFrage();
        Log.d(TAG, "frage starten: ");
        progressBar.setProgress(100);



        antwort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort1.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (richtigeAntworten < 15 && alleFragen.size()>0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }});



        antwort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (antwort2.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (richtigeAntworten < 15 && alleFragen.size()>0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
                }
        });
        antwort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort3.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (richtigeAntworten < 15 && alleFragen.size()>0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }



        });
        antwort4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort4.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntworten = richtigeAntworten+1;
                    Log.d(TAG, "onClick: "+richtigeAntworten);
                    if (richtigeAntworten < 15 && alleFragen.size()>0){
                        starteNeueFrage();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                    verloren();
                }
            }
        });
    }
    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    private void gewonnen() {
        myCounter.cancel();
        Intent intent = new Intent(this.getBaseContext(), Win.class);
        startActivity(intent);
    }
    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    private void starteNeueFrage() {
        int indexFrage = randomFrage();
        antwortenZuweisen(indexFrage);
        myCounter.cancel();
        myCounter.start();
    }
    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    private void starteNeueFrageOhneTimerStop() {
        int indexFrage = randomFrage();
        antwortenZuweisen(indexFrage);
    }
    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    private int randomFrage() {
        Random zahl1 = new Random();
        Log.d(TAG, "randomFrage: "+alleFragen.size());
        int rF = zahl1.nextInt(alleFragen.size());
        Log.d(TAG, "randomFrage:" + rF);
        return rF;

    }

    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    private void antwortenZuweisen(int rnd) {
        Random zahl = new Random();
        aktuelleFrage = alleFragen.get(rnd);
        alleFragen.remove(rnd);
        tvF1.setText(aktuelleFrage.getFrage());
        Log.d(TAG, "ANTWORTAMK: "+ aktuelleFrage.getAntwort1());


        ArrayList<String> antworten = new ArrayList<>();
        antworten.add(aktuelleFrage.getAntwort1());
        antworten.add(aktuelleFrage.getAntwort2());
        antworten.add(aktuelleFrage.getAntwort3());
        antworten.add(aktuelleFrage.getrAntwort());



    int aF = zahl.nextInt(antworten.size());
    antwort1.setText(antworten.get(aF));
    Log.d(TAG, "antwortenZuweisen: " + aF);
    antworten.remove(aF);
    aF = zahl.nextInt(antworten.size());
        antwort2.setText(antworten.get(aF));
        Log.d(TAG, "antwortenZuweisen: " + aF);
        antworten.remove(aF);
        aF = zahl.nextInt(antworten.size());
        antwort3.setText(antworten.get(aF));
        Log.d(TAG, "antwortenZuweisen: " + aF);
        antworten.remove(aF);
        aF = zahl.nextInt(antworten.size());
        antwort4.setText(antworten.get(aF));
        Log.d(TAG, "antwortenZuweisen: " + aF);
        antworten.remove(aF);



    }
    /**
     * Hier wird beschrieben was die Methode macht
     *
     */

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"Du kannst hier nicht zurück!", Toast.LENGTH_SHORT).show();

    }


       public class MyCountDownTimer extends CountDownTimer {

            public MyCountDownTimer(long millisInFuture, long countDownInterval) {
                super(millisInFuture, countDownInterval);
            }

            @Override
            public void onTick(long millisUntilFinished) {

                int progress = (int) (millisUntilFinished/100);
                progressBar.setProgress(progress);
            }

            @Override
            public void onFinish() {

                progressBar.setProgress(0);
               verloren();
            }
            }


    /**
     * Diese Methode wird ausgeführt, wenn eine falsche Antwort gewählt wurde oder die Zeit abgelaufen ist.
     *
     */


public void verloren() {
    Vibrator v = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    v.vibrate(500);
    myCounter.cancel();
    counter.cancel();
    Intent intent = new Intent(getBaseContext(), Lose.class);
    startActivity(intent);
}
    public void setModuswahl(int moduswahl) {
        this.moduswahl = moduswahl;
    }
  public class MyCounter extends MyCountDownTimer {
      public MyCounter(long millisInFuture, long countDownInterval) {
          super(millisInFuture, countDownInterval);
      }

      @Override
      public void onTick(long millisUntilFinished) {

          int progress = (int) (millisUntilFinished/100);
          progressBar.setProgress(progress);
      }

      @Override
      public void onFinish() {
        progressBar.setProgress(0);
          verloren();
      }
  }



        }






