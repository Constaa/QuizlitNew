package com.example.jonas.wwm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Wenn der Benutzer ein Problem einsenden will, so gibt er hier seinen Namen, Email und das eigentliche Problem ein.
 * Das gleiche Prinzip wie beim Frage einsenden.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */
public class Problem extends AppCompatActivity {

    Button btSenden;
    EditText eTName;
    EditText eTEmail;
    EditText eTDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem);
     final Intent emailintent = new Intent(Intent.ACTION_SEND);
        btSenden = (Button) findViewById(R.id.btSenden);
        eTName = (EditText) findViewById(R.id.eTName);
        eTEmail = (EditText) findViewById(R.id.eTEmail);
        eTDetails = (EditText) findViewById(R.id.eTDetails);











        btSenden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = eTName.getText().toString();
                String email = eTEmail.getText().toString();
                String details = eTDetails.getText().toString();
                if (TextUtils.isEmpty(name)){
                    eTName.setError("Name eingeben");
                    return;
                }
                Boolean error = false;

                if (!isEmailKorrekt(email)){
                    error = true;
                    eTEmail.setError("Gültige E-Mail eingeben");
                    return;
                }
                if (TextUtils.isEmpty(details)){
                    eTDetails.setError("Beschreibung eingeben");
                }
                emailintent.setType("plain/text");
                emailintent.putExtra(Intent.EXTRA_EMAIL , new String[]{"teamquizlit@gmail.com"});
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "Problem bei der App");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Name:"+name+'\n'+"Email:"+email+'\n'+"Nachricht:"+'\n'+details);

                startActivity(Intent.createChooser(emailintent, "Sende diese Nachricht über: "));
            }
        });


    }

    private boolean isEmailKorrekt(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void backtohome() {
        Intent intent = new Intent(Problem.this, MainActivity.class);
        startActivity(intent);
    }



    public void onBackPressed() {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);

    }
}
