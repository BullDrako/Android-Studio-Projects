package com.example.edgar.cerclesmoviment;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    Button b, parar;
    EscenaView escenaPilota;
    ThreadMouPilotes threadMouPilotes;
    View.OnTouchListener touchListener;
    View.OnClickListener clickListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Vista amb Layout
        setContentView(R.layout.activity_main);

        // Vista directament de la classe
        //setContentView(new ExempleView(this));

        escenaPilota = (EscenaView) this.findViewById(R.id.ViewLoayut);


        escenaPilota.generaEscena();

        b = (Button) findViewById(R.id.button1);
        parar = (Button) findViewById(R.id.button2);
        /*b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click

                escenaPilota.mouObject();
                escenaPilota.calculaColisions();
                escenaPilota.postInvalidate();
                threadMouPilotes.interrupt();

            }
        });*/

        prepareListenerClick();
        b.setOnClickListener(clickListener);
        parar.setOnClickListener(clickListener);
        prepareListenerTouch();
        escenaPilota.setOnTouchListener(touchListener);
        hilo();
    }

    private void hilo() {
        threadMouPilotes = new ThreadMouPilotes(escenaPilota);
        threadMouPilotes.start();
    }

    private void prepareListenerClick(){
        clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button1:
                        //escenaPilota.nau.setPosX(500);
                       // escenaPilota.mouObject();
                        //escenaPilota.calculaColisions();
                        escenaPilota.postInvalidate();
                       // threadMouPilotes.interrupt();
                        //escenaPilota.creaAlTocar();
                        break;
                    case R.id.button2:
                        threadMouPilotes.interrupt();
                        escenaPilota.mouObject();
                        //escenaPilota.calculaColisions();

                        break;
                }
            }
        };
    }

    private void prepareListenerTouch(){
        touchListener = new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
               /// escenaPilota.generaEscena();
                escenaPilota.creaAlTocar(event.getX(), event.getY());
                escenaPilota.postInvalidate();
                return true;
            }
        };
    }
}

