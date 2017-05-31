package com.example.alumne.sharedstorage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    Button bUsuari,bGuest;
    TextView tvNom, tvUsuari;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bUsuari = (Button) findViewById(R.id.bUsuari);
        bGuest = (Button) findViewById(R.id.bGuest);

        tvNom = (TextView) findViewById(R.id.tvNom);
        tvUsuari = (TextView) findViewById(R.id.tvUsuari);

        SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
        //obtenim les dades que volem, per exemple usuari i password
        String nom = prefs.getString("nom", "");
        String usuari = prefs.getString("usuari", "");

        tvNom.setText(nom);
        tvUsuari.setText(usuari);

        prepare();
        bUsuari.setOnClickListener(listener);
        bGuest.setOnClickListener(listener);

        //ir a tools>android>android device monitor
        //pestaña file explorer
        //buscar nombre proyecto>data>data>shared_prefs>infoUsuari.xml

        /*bUsuari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                escriureDadesUsuari();
            }
        });
        bGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                escriureDadesGuest();
            }
        });*/

    }

    public void escriureDadesUsuari() {
        SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
        //obtenim l'editor
        SharedPreferences.Editor mEditor = prefs.edit();
        //Escrivim les dades
        mEditor.putString("nom", "DAM2");
        mEditor.putString("usuari", "user dam2");
        //fem un commit
        mEditor.commit();
    }

    public void escriureDadesGuest() {
        SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
        //obtenim l'editor
        SharedPreferences.Editor mEditor = prefs.edit();
        //Escrivim les dades
        mEditor.putString("nom", "Anònim");
        mEditor.putString("usuari", "Guest");
        //fem un commit
        mEditor.commit();

        Toast.makeText(getBaseContext(), "NOMAAA", Toast.LENGTH_LONG).show();
    }

    public void prepare(){
        listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (v.getId()){
                    case R.id.bUsuari:
                        Toast.makeText(getApplicationContext(), "boton usuari", Toast.LENGTH_LONG).show();
                        escriureDadesUsuari();
                    case R.id.bGuest:
                        Toast.makeText(getApplicationContext(), "boton guest", Toast.LENGTH_LONG).show();
                        escriureDadesGuest();
                }

            }
        };
    }
}