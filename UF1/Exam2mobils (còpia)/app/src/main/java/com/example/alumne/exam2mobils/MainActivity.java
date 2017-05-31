package com.example.alumne.exam2mobils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.DialogFragment;

public class MainActivity extends Activity {


    final static int NOTIFICACION = 1;
    final static int SERVICE = 2;
    final static int QUADRE_DIALEG =3;
    final static int SORTIR = 4;

    //View.OnClickListener listener;

    TextView tvpeso;
    TextView tvaltura;
    TextView tvedad;

    TextView textView;

    EditText altura;
    EditText peso;


    /*String valor1=altura.getText().toString();
    String valor2=peso.getText().toString();

    int nro1=Integer.parseInt(valor1);
    int nro2=Integer.parseInt(valor2);
    int calcularImc=nro1/nro2;
    String imcOk = String.valueOf(calcularImc);*/



    // String resultado=String.valueOf(suma);
    //tv3.setText(resultado);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* altura = (EditText) findViewById(R.id.editTextAltura);
        peso = (EditText) findViewById(R.id.editTextPeso);
        imc = (TextView) findViewById(R.id.resultadoTextView);*/

        tvaltura = (TextView) findViewById(R.id.textViewTextoAltura);
        tvpeso = (TextView) findViewById(R.id.textViewTextoPeso);
        tvedad = (TextView) findViewById(R.id.textViewTextoEdad);


       // resultado = (TextView) findViewById(R.id.textViewR);

        //resultado.setText(imcOk);
        /*prepareListener();
        tvaltura.setOnClickListener(listener);
        tvpeso.setOnClickListener(listener);
        tvedad.setOnClickListener(listener);*/

    }


    /*private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.textViewTextoAltura:
                        colors();
                        break;
                    case R.id.textViewTextoPeso:
                        colors();
                        break;
                    case R.id.textViewTextoEdad:
                        colors();
                        break;
                }
            }
        };
    }*/


    //menu option que apareix a dalt amb 3 opcions
    public boolean onCreateOptionsMenu(Menu menu) {
        // The add() method used in this sample takes four arguments:
        // groupId, itemId, order, and title.
        menu.add(0, NOTIFICACION, 0, "Notificacion");
        menu.add(0, SERVICE, 0, "Service");
        menu.add(0, QUADRE_DIALEG, 0, "Quadre dialeg");
        menu.add(0, SORTIR, 0, "Sortir");
        return true;
    }

    //menu option segons quina opció s'ha triat redirigeix a un activity o un altre
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case NOTIFICACION:
               /* Toast.makeText(
                        InicialActivity.this,
                        "Conf" , Toast.LENGTH_LONG).show();*/
                notificacion();
                return true;
            case SERVICE:

                Intent i = new Intent(getApplicationContext(), Imc.class);
                startService(i);
                return true;
            case QUADRE_DIALEG:
                colorsTextView();
                return true;

            case SORTIR:
                /*Toast.makeText(
                        InicialActivity.this,
                        "sortir" , Toast.LENGTH_LONG).show();*/
                sortirAplicacio();
                return true;
        }
        return false;
    }


    private void notificacion(){

        NotificationManager nManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(
                getBaseContext())
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("IMC")
                .setContentText("resultado imc");

        //Crear un intent especificando que realizará
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        //Crear del PendingIntent pasando el intent que se realizará, obligatorio usar método para obtener activity’s (getactivity)
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        nManager.notify(1, builder.build());
    }


    private void colorsTextView() {
        final CharSequence[] items = {"Vermell", "Verd", "Blau"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecciona un color");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,
                                int posicio) {
                Toast.makeText(getApplicationContext(),
                        items[posicio],
                        Toast.LENGTH_LONG).show();
                switch (posicio) {
                    case 0:
                        tvaltura.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        tvpeso.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        tvedad.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    private void sortirAplicacio() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Titol del quadre");
        builder.setMessage("Are you shure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        MainActivity.this.finish();
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
