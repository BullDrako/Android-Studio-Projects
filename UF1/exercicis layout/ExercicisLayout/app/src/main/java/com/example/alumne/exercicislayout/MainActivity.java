package com.example.alumne.exercicislayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.security.Principal;

public class MainActivity extends Activity {
    String tag = "Events";

    OnClickListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.layout5eventos);
        //Log.d(tag, "In the onCreate() event");

        Button boton1 = (Button) findViewById(R.id.boton1);
        boton1.setText("1");

        boton1.setPaintFlags(boton1.getPaintFlags()
                | Paint.UNDERLINE_TEXT_FLAG);

        Button boton2 = (Button) findViewById(R.id.boton2);
        boton2.setText("2");

        boton2.setPaintFlags(boton2.getPaintFlags()
                | Paint.UNDERLINE_TEXT_FLAG);

        Button boton3 = (Button) findViewById(R.id.boton3);
        boton3.setText("No hagas click :)");

        boton3.setPaintFlags(boton3.getPaintFlags()
                | Paint.UNDERLINE_TEXT_FLAG);

        prepareListenners();
        boton1.setOnClickListener(listener);
        boton2.setOnClickListener(listener);
        boton3.setOnClickListener(listener);

    }

    public void prepareListenners(){
        listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.boton1:
                        startActivity(new Intent(MainActivity.this,
                                SegonActivity.class));
                        break;
                    case R.id.boton2:
                        startActivity(new Intent(MainActivity.this,
                                CartasActivity.class));
                        break;
                    case R.id.boton3:
                       canviaText();
                        break;
                }

            }
        };

    }

    public void canviaText(){

        Button boton3 = (Button) findViewById(R.id.boton3);
        boton3.setText("Vaya, has clickado ;)");
    }



    /*
    public void onStart(){
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }
*/
    /*public void onRestart(){
        super.onRestart();
        setContentView(R.layout.activity_second);
        Log.d(tag, "In the onRestart() event");
    }*/


}
