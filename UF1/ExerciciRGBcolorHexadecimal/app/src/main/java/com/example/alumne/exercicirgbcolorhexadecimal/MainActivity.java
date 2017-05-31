package com.example.alumne.exercicirgbcolorhexadecimal;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    SeekBar rojoSeekbar;
    int rojo = 0;
    int verde = 0;
    int azul = 0;
    int transparencia = 0;



    SeekBar verdeSeekbar;
    SeekBar azulSeekbar;

    TextView colorMuestraDelColorTextView;

    SeekBar transparenciaSeekbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorMuestraDelColorTextView = (TextView) findViewById(R.id.colorMuestraDelColorTextView);

        initSeekbar();
    }

    private void initSeekbar() {

        rojoSeekbar = (SeekBar) findViewById(R.id.rojoSeekBar);
        rojoSeekbar.setMax(255);
        rojoSeekbar.setProgress(0);

        verdeSeekbar = (SeekBar) findViewById(R.id.verdeSeekBar);
        verdeSeekbar.setMax(255);
        verdeSeekbar.setProgress(0);

        azulSeekbar = (SeekBar) findViewById(R.id.azulSeekBar);
        azulSeekbar.setMax(255);
        azulSeekbar.setProgress(0);

        /*transparenciaSeekbar = (SeekBar) findViewById(R.id.transparenciaSeekBar);
        transparenciaSeekbar.setMax(255);
        transparenciaSeekbar.setProgress(0);*/



        //transparenciaSeekbar.setOnSeekBarChangeListener(list);

        azulSeekbar.setOnSeekBarChangeListener(list);
        verdeSeekbar.setOnSeekBarChangeListener(list);
        rojoSeekbar.setOnSeekBarChangeListener(list);

    }

    //Listener
    SeekBar.OnSeekBarChangeListener list = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {//cuando canvio de valor en seekbar

            if(seekBar.getId() == R.id.rojoSeekBar) {
                //colorMuestraDelColorTextView.setBackgroundColor(Color.RED);
                rojo = progress;
                canviaColor();
            }
            if(seekBar.getId() == R.id.verdeSeekBar) {
                //colorMuestraDelColorTextView.setBackgroundColor(Color.RED);
                verde = progress;
                canviaColor();
            }
            if(seekBar.getId() == R.id.azulSeekBar) {
                //colorMuestraDelColorTextView.setBackgroundColor(Color.RED);
                azul = progress;
                canviaColor();
            }
           /* if(seekBar.getId() == R.id.transparenciaSeekBar) {
                //colorMuestraDelColorTextView.setBackgroundColor(Color.RED);
                transparencia = progress;
                canviaColor();
            }*/

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {//cuando se clica

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {//cuando levantas

        }
    };


    private void canviaColor() {
        colorMuestraDelColorTextView.setBackgroundColor(Color.rgb(rojo,verde,azul));
        //colorMuestraDelColorTextView.setBackgroundColor(Color.argb(transparencia,rojo,verde,azul));
        //linearLayout.setBackgroundColor(Color.rgb(red,127,127));


    }
}
