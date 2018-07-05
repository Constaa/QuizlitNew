package com.example.jonas.wwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Wenn der Benutzer eine Frage senden will, gibt er seine Frage und die 4 Antwortmöglichkeit an.
 * Wenn dieser auf Senden klickt, so kommt ein Choose-Fenster, in dem er die App zum versenden auswählen kann.
 * Die Fragen werden via E-Mail o.ä. verschickt.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */
public class Einsenden extends AppCompatActivity {


    Button btSenden;
    EditText eTFRage;
    EditText eTAntwort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.einsenden);
        final Intent emailintent = new Intent(Intent.ACTION_SEND);
        btSenden = (Button) findViewById(R.id.btSenden);
        eTFRage = (EditText) findViewById(R.id.eTFrage);
        eTAntwort = (EditText) findViewById(R.id.eTAntwort);











        btSenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eTFRage.getText().toString();
                String details = eTAntwort.getText().toString();



                if (TextUtils.isEmpty(email)){
                    eTFRage.setError("Frage eingeben");
                    return;
                }
                if (TextUtils.isEmpty(details)){
                    eTAntwort.setError("Antworten eingeben");
                    return;
                }
                emailintent.setType("plain/text");
                emailintent.putExtra(Intent.EXTRA_EMAIL , new String[]{"teamquizlit@gmail.com"});
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "Einsendung einer Frage");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Frage:"+email+'\n'+"Antworten:"+'\n'+details);

                startActivity(Intent.createChooser(emailintent, "Sende diese Nachricht über: "));
            }
        });


    }



    private void backtohome() {
        Intent intent = new Intent(Einsenden.this, MainActivity.class);
        startActivity(intent);
    }

}
