package com.example.alumne.seekbarprogress;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    LinearLayout linearLayout;
    SeekBar seekbar;
    TextView textView;
    ProgressBar progressBar;
    int red = 0;
    int green = 0;
    int blue = 0;
    int pValue = 0;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        linearLayout = (LinearLayout) findViewById(R.id.idmainlayout);

        linearLayout.setBackgroundResource(R.drawable.foto);
        //linearLayout.setBackgroundColor(Color.BLUE);
        //linearLayout.setBackgroundColor(Color.rgb(124,12,76));
        initSeekbar();
    }

    private void initSeekbar() {//va de 0 a 255 si se quiere de 100 a 200 hacer offset

        //progressBar
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        pValue = 0;
        progressBar.setProgress(pValue);


        //Seekbar
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(255);
        seekbar.setProgress(127); //valor por el que empieza

        red = 127;
        green = 127;
        blue = 127;

        //TextView
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("Value: 127");
        seekbar.setOnSeekBarChangeListener(list);
    }

        //Listener
        SeekBar.OnSeekBarChangeListener list = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {//cuando canvio de valor en seekbar

               if(seekBar.getId() == R.id.seekBar) {
                   textView.setText("Value: " + progress);
                   textView.setBackgroundColor(Color.CYAN);
                   red = progress;
                   // linearLayout.setBackgroundColor(Color.rgb(progress,127,127));
                   canviaColor();
                   pValue++;
                   progressBar.setProgress(pValue);
               }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//cuando se clica

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {//cuando levantas

            }
        };



    private void canviaColor() {
        linearLayout.setBackgroundColor(Color.rgb(red,127,127));
    }
}
