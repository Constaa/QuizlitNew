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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

/**
 * Dies ist die Klasse, in der die das eigentliche Spiel passiert.
 * Die Fragen werden zum Start und nachdem die richtige Frage gewählt wurde, neu generiert bzw. zugeordnet.
 * Die Frage und die Antworten werden aus einem Fragen-Objekt genommen.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 * s
 **/

public class Spiel extends AppCompatActivity {

    private static final String TAG = "Spiel";
    Win w;
    ModusWahl m;
    ProgressBar progressBar;
   CountDownTimer myCounter;
   Button antwort1,antwort2,antwort3,antwort4;
   MyCounter counter;
   TextView tvF1;
   int richtigeAntworten, richtigeAntwortenGDZ, richtigeAntwortenINF;
    ArrayList<Fragen> alleFragen;

    Fragen aktuelleFrage;
    Fragen f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29,f30,f31,f32,f33,f34,f35,f36,f37,f38,f39,f40,f41,f42,f43,f44,f45,f46,f47,f48,f49,f50;
    int moduswahl,zeitwahl, zeit;



    @Override
    /**
     * Die Fragen-Objekte werden hier erstellt und der Liste hinzugefügt.
     * Zudem wird mit einem Switch-Case die Zeit für den GDZ-Modus mithilfe der übergebenen Variable zeitwahl eingestellt.
     * Der Modus wird ebenfalls mit diesem Prinzip ausgewählt.
     *
     */
    protected void onCreate(Bundle savedInstanceState) {
        Bundle extras = getIntent().getExtras();
        w = new Win();
        m = new ModusWahl();
        alleFragen = new ArrayList<>();
        f1 = new Fragen("Wann wurde die Mauer in Berlin niedergerissen?","1998","1981","1898","1989",false);
        f2 = new Fragen("Vor welchen Tieren fürchtete sich Napoleon?","Hunden","Vögeln","Mäusen","Katzen",false);
        f3 = new Fragen("Wie heißt die Griechische Göttermutter?","Hestia","Eileithyia","Athene","Hera",false);
        f4 = new Fragen("Wo lebt der Dingo?","Europa","Asien","Afrika","Australien",false);
        f5 = new Fragen("Wer spielte den 1. James Bond?","Daniel Craig","Pierce Brosnan","Timothy Dalton","Sean Connery",false);
        f6 = new Fragen("Was ist ein Paso Doble?","Ein Getränk","Eine Straße","Ein Gebäude","Ein Tanz",false);
        f7 = new Fragen("Ab wann wurde Aspirin als Medikament verkauft?","1755","1829","1902","1899",false);
        f8 = new Fragen("Wie viele Karten braucht man zum Bridgespielen?","54","56","50","52",false);
        f9 = new Fragen("Welche Berufssparte leistet den “Hippokratischen Eid?","Lehrer","Politiker","Polizist","Mediziner",false);
        f10 = new Fragen("Ist die Tomate eine Frucht?", "Nein","Halb-Frucht","Ne Gemüse","Ja",false);
        f11 = new Fragen("Was ist Java?","Eine Insel","Ein Auto","Browser","Programmiersprache",false);
        f12 = new Fragen("Was bedeutet H&M ausgeschrieben?","Hammer und Max","Hang und Mong", "Himmel und Meer","Hennes Mauritz",false);
        f13 = new Fragen("Zu welcher Gattung gehört der Koalabär?","Nagetiere","Bären","Reptilien","Beuteltiere",false);
        f14 = new Fragen("Was frisst ein Mungo?","Pflanzen","Insekten","Mango","Schlangen",false);
        f15 = new Fragen("Woher stammt die Siamkatze?","Mexico","Südafrika","Ägypten","Thailand",false);
        f16 = new Fragen("Was ist ein Lori?","Nager","Hund","Katze","Vogel",false);
        f17 = new Fragen("Mit welchem Gerät kann man Bilder in den Computer einlesen?","Drucker","Digitalkamera","USB","Scanner",false);
        f18 = new Fragen("Wie lautet die chemische Formel von Sauerstoff?","H20","S2","S","O2",false);
        f19 = new Fragen("In welchem Monat darf man Edelweiss pflücken?","Juli","Mai","Februar","Nie",false);
        f20 = new Fragen("Welcher Mensch hat alle 10 Gebote gehalten?","Mohammed","Abraham","Jesus","Moses",false);
        f21 = new Fragen("Wie viele Sterne hat die amerikanische Nationalflagge?","52","51","49","50",false);
        f22 = new Fragen("Wer erfand die Kunst des Buchdrucks?","Richard Altmann","James Watt","Albert Einstein","Johannes Gutenberg",false);
        f23 = new Fragen("Welcher Planet hat einen Ring?","Merkur","Jupiter","Pluto","Saturn",false);
        f24 = new Fragen("Wie heisst der höchste römische Gott?","Saturn","Neptun","Merkur","Jupiter",false);
        f25 = new Fragen("Was sind Steroide?","Enzyme","Drogen","Vitamine","Hormone",false);
        f26 = new Fragen("Was ist der grösste Kontinent?","Südamerkia","Afrika","Antarktis","Asien",false);
        f27 = new Fragen("Wann wurde die UNO gegründet?","1980","1897","1975","1945",false);
        f28 = new Fragen("Woher kam die Miss Europa 1984?","Deutschland","Frankreich","Spanien","Belgien",false);
        f29 = new Fragen("Wo starb Che Guevara?","Peru","Chile","Kolumbien","Argentinien",false);
        f30 = new Fragen("Wann wurde der Gotthardtunnel eingeweiht?","1998","1881","1748","1882",false);
        f31 = new Fragen("Welchen Beruf hatte der Erfinder der Guillotine?","Schreiner","Schmied","Schriftsteller","Arzt",false);
        f32 = new Fragen("Wonach schmeckt Grand Marnier?","Erdbeere","Zitrone","Pflaume","Orange",false);
        f33 = new Fragen("Wie viele Länder grenzen an die Schweiz?","3","4","6","5",false);
        f34 = new Fragen("In welcher Sportart wird der Ausdruck ,,Halsen“ gebraucht?","Klettern","Handball","Schwimmen","Segeln",false);
        f35 = new Fragen("Wie viel Prozent pures Gold enthält 18-karätiges Gold?","50","18","95","75",false);
        f36 = new Fragen("Aus welchem Land stammt der Maler El Greco?","Spanien","Portugal","Brasilien","Italien",false);
        f37 = new Fragen("Welcher US-Präsident erhielt den Pulitzer-Preis?","Geroge W. Bush","Barack Obama","Theodore Roosevelte","John F. Kennedy",false);
        f38 = new Fragen("Hollywood ist ein Stadtteil von?","New York","Californien","Florida","Los Angeles",false);
        f39 = new Fragen("Wie lange ist der Nil?","5982km","7241km","6789km","6671km",false);
        f40 = new Fragen("In welchem Jahrhundert lebte Jean-Jacques Rousseau?","19.Jh.","20.Jh","17.Jh","18.Jh",false);
        f41 = new Fragen("Welche Farbe hat die Warnflagge bei Autorennen?","Schwarz","Rot","Violet","Gelb",false);
        f42 = new Fragen("Wann startete der erste Zeppelin?","1908","1911","1879","1900",false);
        f43 = new Fragen("Wo war der  Grieche Achilles verletzbar?","Leber","Kopf","Herz","Ferse",false);
        f44 = new Fragen("Wo befindet sich der Erebus, der südlichste Vulkan der Erde?","Südafrika","Südamerkia","Asien","Antarktis",false);
        f45 = new Fragen("Was für ein Tier ist der Nimmersatt?","Amphibie","Reptiel","Säugetier","Vogel",false);
        f46 = new Fragen("Wie viel Schokolade isst der Schweizer im Jahr?","5kg","2kg","15kg","10kg",false);
        f47 = new Fragen("Wie nennt man eine Gruppe von Wölfen?","Herde","Kolonne","Kollektiv","Rudel",false);
        f48 = new Fragen("Welches Eishockey-Team gewann an der Olympiade 1980 Gold?","Norwegen","Schweden","Kanada","USA",false);
        f49 = new Fragen("Wie viele Seiten hat ein Pentagon?","8","7","6","5",false);
        f50 = new Fragen("Mit welchem Auto verunfallte James Dean tödlich?","Audi","Mustang","Mercedes","Porsche",false);




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
        alleFragen.add(f15);
        alleFragen.add(f16);
        alleFragen.add(f17);
        alleFragen.add(f18);
        alleFragen.add(f19);
        alleFragen.add(f20);

        alleFragen.add(f21);
        alleFragen.add(f22);
        alleFragen.add(f23);
        alleFragen.add(f24);
        alleFragen.add(f25);
        alleFragen.add(f26);
        alleFragen.add(f27);
        alleFragen.add(f28);
        alleFragen.add(f29);

        alleFragen.add(f30);
        alleFragen.add(f31);
        alleFragen.add(f32);
        alleFragen.add(f33);
        alleFragen.add(f34);
        alleFragen.add(f35);
        alleFragen.add(f36);
        alleFragen.add(f37);
        alleFragen.add(f38);
        alleFragen.add(f39);

        alleFragen.add(f40);
        alleFragen.add(f41);
        alleFragen.add(f42);
        alleFragen.add(f43);
        alleFragen.add(f44);
        alleFragen.add(f45);
        alleFragen.add(f46);
        alleFragen.add(f47);
        alleFragen.add(f48);
        alleFragen.add(f49);
        alleFragen.add(f50);


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
     * Zusätzlich wird eine Variable hochgezählt, die die Anzahl der richtigen Antworten zählt für eine optionale
     * Bestenliste.
     *
     */

    public void gegenDieZeit() {
        Log.d(TAG, "gegenDieZeit: ");
        myCounter.cancel();
        counter.start();
        progressBar.setProgress(100);
        richtigeAntwortenGDZ = 0;
        starteNeueFrageOhneTimerStop();
        Log.d(TAG, "gegenDieZeit: antworten zugwiesen");



        antwort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort1.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenGDZ = richtigeAntwortenGDZ+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenGDZ);
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
                    richtigeAntwortenGDZ = richtigeAntwortenGDZ+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenGDZ);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                 //   b.setValueGDZ(richtigeAntwortenGDZ);
                    verloren();
                }
            }
        });
        antwort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort3.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenGDZ = richtigeAntwortenGDZ+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenGDZ);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                  //  b.setValueGDZ(richtigeAntwortenGDZ);
                    verloren();
                }
            }



        });
        antwort4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: button geklickt");
                if (antwort4.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenGDZ = richtigeAntwortenGDZ+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenGDZ);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                 //   b.setValueGDZ(richtigeAntwortenGDZ);
                    verloren();
                }
            }
        });

    }
    /**
     * Der Timer wird nicht gestartet und auch nicht angezeigt. Man verliert nur, indem man
     * die Frage falsch beantwortet. Gewonnen hat man, wenn die Liste (alleFragen) leer ist.
     * Zusätzlich wird eine Variable hochgezählt, die die Anzahl der richtigen Antworten zählt für eine optionale
     * Bestenliste.
     *
     */

    public void unendlichkeit() {
        progressBar.setVisibility(View.INVISIBLE);
        Log.d(TAG, "unendlichkeit: ");
        myCounter = new MyCountDownTimer(10000, 500);
        richtigeAntwortenINF = 0;
        starteNeueFrage();
        myCounter.cancel();



        antwort1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort1.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenINF = richtigeAntwortenINF+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenINF);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                   // b.setValueINF(richtigeAntwortenINF);
                    verloren();
                }
            }});



        antwort2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (antwort2.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenINF = richtigeAntwortenINF+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenINF);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                  //  b.setValueINF(richtigeAntwortenINF);
                    verloren();
                }
            }
        });
        antwort3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort3.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenINF = richtigeAntwortenINF+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenINF);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                  //  b.setValueINF(richtigeAntwortenINF);
                    verloren();
                }
            }



        });
        antwort4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (antwort4.getText().equals(aktuelleFrage.getrAntwort())) {
                    richtigeAntwortenINF = richtigeAntwortenINF+1;
                    Log.d(TAG, "onClick: "+richtigeAntwortenINF);
                    if (alleFragen.size() > 0){
                        starteNeueFrageOhneTimerStop();
                    }
                    else {
                        gewonnen();
                    }

                }
                else {
                  //  b.setValueINF(richtigeAntwortenINF);
                    verloren();
                }
            }
        });
    }
    /**
     * Der Timer geht 10 Sekunden. Man hat entweder verloren, wenn diese 10 Sekunden überschritten werden oder wenn man eine
     * falsche Antwort anklickt. Gewonnen hat man bei 15 richtig beantworteten Fragen. Die Anzahl der richtig beantworteten Fragen
     * wird immer hochgezählt. Zusätzlich wird eine Variable hochgezählt, die die Anzahl der richtigen Antworten zählt für eine optionale
     * Bestenliste.
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
     * Der Timer und die ProgressBar werden gestoppt und der Nutzer wird auf die "Win" Seite weitergeleitet und hat gewonnen.
     * Diese Methode trifft dann ein, wenn der Nutzer die Voraussetzungen für den Gewinn erfüllt hat.
     *
     *
     */

    private void gewonnen() {
        myCounter.cancel();
        Intent intent = new Intent(this.getBaseContext(), Win.class);
        startActivity(intent);
    }
    /**
     * Diese Methode nimmt die zufällig ausgewählte Frage und führt die Methode antwortenZuweisen() aus.
     * Der Counter wird gestoppt und dann gestartet.
     *
     */

    private void starteNeueFrage() {
        int indexFrage = randomFrage();
        antwortenZuweisen(indexFrage);
        myCounter.cancel();
        myCounter.start();
    }
    /**
     * Dies ist die Methode für den Unendlichkeitsmodus, da dort kein Timer vorhanden ist und dieser auch nicht
     * gestartet werden muss.
     *
     */

    private void starteNeueFrageOhneTimerStop() {
        int indexFrage = randomFrage();
        antwortenZuweisen(indexFrage);
    }
    /**
     * Eine zufällige Zahl wird gewürfelt, dabei wird die Größe der Liste der Fragen berücksichtigt.
     * @return der INT-Wert der zufälligen Zahl (Index von alleFragen[]).
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
     * @param rnd der INT-Wert der zufälligen Frage
     * die aktuelle Frage wird durch den Wert rnd bestimmt.
     * Dann wird die Frage durch dieses Objekt in der Liste zugwiesen, sowie auch die Antworten.
     * Die Antworten werden zufällig angeordnet.
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
     * Diese Methode verhindert das zurückgehen während man in einer Frage ist.
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
     * Dadurch vibriert das Endgerät kurz und der Timer wird gestoppt und man kommt auf die "Lose" Seite.
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

          gewonnen();
      }
  }



        }






