package com.example.alumne.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity {

    View.OnClickListener listener;


    Button boton1, boton2, boton3;

    RelativeLayout RelativeL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.button);
        boton2 = (Button) findViewById(R.id.button2);
        boton3 = (Button) findViewById(R.id.button3);

        RelativeL = (RelativeLayout) findViewById(R.id.layoutPrincipal);


        prepareListener();
        boton1.setOnClickListener(listener);
        boton2.setOnClickListener(listener);
        boton3.setOnClickListener(listener);


    }


    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        obreQuadreDialeg(/*"boton 1"*/);
                        break;
                    case R.id.button2:
                        obreCustomDialog("boton 2");
                        break;
                    case R.id.button3:
                        obrePickDialog();
                        break;
                }
            }
        };
    }


    private void obreQuadreDialeg(/*String msg*/){
        //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();



        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Titol del quadre");
        builder.setMessage("Are you shure you want to exit?")
                .setCancelable(false)//si pones true al clicar fuera del cuadro, el cuadro se quita
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

    private void obreCustomDialog(String msg){
        //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_layout);//carga layout personalizado
        dialog.setTitle("Custom dialog");

        TextView text= (TextView) dialog.findViewById(R.id.textView);
        text.setText("Hello, this is a custom dialog.");

        ImageView image = (ImageView) dialog.findViewById(R.id.imageView);
        image.setImageResource(R.drawable.android);

        Button button1 = (Button) dialog.findViewById(R.id.button1);//Boton layout personalizado

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }

        });

        dialog.show();
    }

    private void obrePickDialog(){
        final CharSequence[] items = {"Red", "Green", "Blue"};
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setTitle("Pick a color");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog,
                                int posicio) {
                Toast.makeText(getApplicationContext(),
                        items[posicio],
                        Toast.LENGTH_LONG).show();
                switch (posicio) {
                    case 0:
                        RelativeL.setBackgroundColor(Color.RED);
                        break;
                    case 1:
                        RelativeL.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        RelativeL.setBackgroundColor(Color.BLUE);
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
