package com.example.jonas.wwm;

/**
 * Dies ist die Klasse, in der die das eigentliche Spiel passiert.
 * Die Fragen werden zum Start und nachdem die richtige Frage gewählt wurde, neu generiert bzw. zugeordnet.
 * Die Frage und die Antworten werden aus einem Fragen-Objekt genommen.
 *
 * @author jonas dietsche, zinar kayhan, stanley prohaska
 * @version 1.0
 *
 */

public class Fragen {
    String frage;
    String antwort1;
    String antwort2;
    String antwort3;
    String rAntwort;
    boolean schonBenutzt = false;
    public Fragen(String c_frage, String c_antwort1, String c_antwort2, String c_antwort3, String c_rAntwort, boolean c_schonBenutzt) {
      frage = c_frage;
      antwort1 = c_antwort1;
      antwort2 = c_antwort2;
      antwort3 = c_antwort3;
      rAntwort = c_rAntwort;
    }

    public String getFrage() {
        return frage;
    }

    public String getAntwort1() {
        return antwort1;
    }

    public String getAntwort2() {
        return antwort2;
    }

    public String getAntwort3() {
        return antwort3;
    }

    public String getrAntwort() {
        return rAntwort;
    }

    public boolean isSchonBenutzt() {
        return schonBenutzt;
    }

    public void setSchonBenutzt(boolean schonBenutzt) {
        this.schonBenutzt = schonBenutzt;
    }


}
