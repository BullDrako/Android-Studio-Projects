package com.example.alumne.dialogexercicis;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TimePicker;



public class MainActivity extends Activity {

    View.OnClickListener listener;

    TextView textView;
    Button boton1, boton2, boton3, boton4;

    TimePicker timePicker1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.button1);
        boton2 = (Button) findViewById(R.id.button2);
        boton3 = (Button) findViewById(R.id.button3);
        textView = (TextView) findViewById(R.id.textView);
        boton4 = (Button) findViewById(R.id.button4);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);



        prepareListener();
        boton1.setOnClickListener(listener);
        boton2.setOnClickListener(listener);
        boton3.setOnClickListener(listener);
        boton4.setOnClickListener(listener);
    }


    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        //obreQuadreDialeg(/*"boton 1"*/);
                        sortirAplicacio();
                        break;
                    case R.id.button2:
                        //obreCustomDialog("boton 2");
                        hasGuanyat();
                        break;
                    case R.id.button3:
                        //obrePickDialog();
                        colorsTextView();
                        break;
                    case R.id.button4:
                        timePicker();
                        break;
                }
            }
        };
    }

    private void timePicker() {

    }



    private void sortirAplicacio() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Titol del quadre");
        builder.setMessage("Are you shure you want to exit?")
                .setCancelable(false)//si pones true al clicar fuera del cuadro, el cuadro se quita
                .setNeutralButton("No fer res", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "no fer res", Toast.LENGTH_LONG).show();
                    }
                })
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

    private void hasGuanyat() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_layout);//carga layout personalizado
        dialog.setTitle("Guanyador!!");

        TextView text= (TextView) dialog.findViewById(R.id.textViewCustom);
        text.setText("Has Guanyat!!!");


        Button buttonCustom = (Button) dialog.findViewById(R.id.buttonCustom);//Boton layout personalizado

        buttonCustom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }

        });

        dialog.show();
    }

    private void colorsTextView() {
        final CharSequence[] items = {"Vermell", "Verd", "Blau"};
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Selecciona un color");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,
                                int posicio) {
                Toast.makeText(getApplicationContext(),
                        items[posicio],
                        Toast.LENGTH_LONG).show();
                switch (posicio) {
                    case 0:
                        textView.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        textView.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        textView.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
