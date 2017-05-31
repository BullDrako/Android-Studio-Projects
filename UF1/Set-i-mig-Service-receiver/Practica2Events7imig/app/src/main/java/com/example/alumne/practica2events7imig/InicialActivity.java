package com.example.alumne.practica2events7imig;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;
import android.app.Dialog;
import android.content.DialogInterface;
/**
 * Created by alumne on 03/11/16.
 */
public class InicialActivity extends Activity {

    View.OnClickListener listener;

    final static int CONF_ACTIVITY = 1;
    final static int JUGAR_ACTIVITY = 2;
    final static int SORTIR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial_layout);

        Button jugarButton = (Button) findViewById(R.id.jugar_button);
        Button confButton = (Button) findViewById(R.id.configuracio_button);
        Button sortirButton = (Button) findViewById(R.id.sortir_button);

        prepareListenners();
        jugarButton.setOnClickListener(listener);
        confButton.setOnClickListener(listener);
        sortirButton.setOnClickListener(listener);
    }


    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.BATTERY_LOW");
        sendBroadcast(intent);
        /*Intent intent2 = new Intent();

         */
    }

    public void prepareListenners(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.configuracio_button:
                        startActivity(new Intent(InicialActivity.this,
                                ConfiguracioActivity.class));
                        break;
                    case R.id.jugar_button:
                        startActivity(new Intent(InicialActivity.this,
                                MainActivity.class));
                        break;
                    case R.id.sortir_button:
                        sortirAplicació();
                        break;
                }

            }
        };

    }

    //menu option menu option que apareix a dalt amb 3 opcions
    public boolean onCreateOptionsMenu(Menu menu) {
        // The add() method used in this sample takes four arguments:
        // groupId, itemId, order, and title.
        menu.add(0, CONF_ACTIVITY, 0, "Configuració");
        menu.add(0, JUGAR_ACTIVITY, 0, "Jugar");
        menu.add(0, SORTIR, 0, "Sortir");
        return true;
    }

    //menu option segons quina opció s'ha triat redirigeix a un activity o un altre
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case CONF_ACTIVITY:
               /* Toast.makeText(
                        InicialActivity.this,
                        "Conf" , Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(InicialActivity.this,
                        ConfiguracioActivity.class));
                return true;
            case JUGAR_ACTIVITY:
                /*Toast.makeText(
                        InicialActivity.this,
                        "Jugar" , Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(InicialActivity.this,
                        MainActivity.class));
                return true;
            case SORTIR:
                /*Toast.makeText(
                        InicialActivity.this,
                        "sortir" , Toast.LENGTH_LONG).show();*/
               sortirAplicació();
                return true;
        }
        return false;
    }

    //mètode que executa una alerta i dona l'opció de si es vol sortir o no
    public void sortirAplicació(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Set i Mig");
        builder.setMessage("Vols sortir de l'aplicació?")
                .setCancelable(false)//si pones true al clicar fuera del cuadro, el cuadro se quita
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        InicialActivity.this.finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
