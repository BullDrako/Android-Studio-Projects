package com.example.alumne.examenm8uf2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by alumne on 20/04/17.
 */

public class AudioActivity extends Activity {

    Button buttonAudioR2D2;
    Button buttonAudioChewaka;
    Button buttonPlay, buttonReset, buttonSave;

    View.OnClickListener listener;

    SoundPool soundPool;
    int sonR2D2;
    int sonChewaka;
    int sonDontFail;

    List<Integer> sonsMaquina = new ArrayList<Integer>();

    int duracion = 700;

    private static final String FILENAME = "llistaSons";
    private ArrayList<String> SONS2 = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_layout);


        buttonAudioR2D2 = (Button) findViewById(R.id.buttonAudioR2D2);
        buttonAudioChewaka = (Button) findViewById(R.id.buttonAudioChewaka);

        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonReset = (Button) findViewById(R.id.buttonReset);
        buttonSave = (Button) findViewById(R.id.buttonSave);




        createSoundPool();
        sonR2D2 = soundPool.load(this, R.raw.r2d2, 1);
        sonChewaka = soundPool.load(this, R.raw.chewaka, 1);
        sonDontFail = soundPool.load(this, R.raw.dontfail, 1);



        prepareListeners();

        buttonAudioR2D2.setOnClickListener(listener);
        buttonAudioChewaka.setOnClickListener(listener);
        buttonPlay.setOnClickListener(listener);
        buttonSave.setOnClickListener(listener);
        buttonReset.setOnClickListener(listener);

    }

    public void prepareListeners(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.buttonAudioR2D2:
                        sonidoR2D2();
                        sonsMaquina.add(0);
                        SONS2.add("R2D2");
                        break;
                    case R.id.buttonAudioChewaka:
                        sonidoChewaka();
                        sonsMaquina.add(1);
                        SONS2.add("Chewaka");
                        break;
                    case R.id.buttonPlay:
                        play();
                        break;
                    case R.id.buttonSave:
                        escriureFixter();
                        break;
                    case R.id.buttonReset:
                        sonsMaquina.clear();
                        Toast.makeText(getApplicationContext(),
                                "lista vacia",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
    }

    /**
     * Escriure fitxer
     */
    private void escriureFixter() {
        try {

            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(SONS2);
            Toast.makeText(getApplicationContext(),
                    SONS2 + " is written to " + FILENAME,
                    Toast.LENGTH_SHORT).show();
            oos.close();
            fos.close();

        } catch (Exception e) {

        }
    }

    /**
     * How to use SoundPool on all API levels
     */
    protected void createSoundPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool();
        } else {
            createOldSoundPool();
        }
    }

    /**
     * How to use SoundPool on all API levels
     */
    protected void createSoundVISIBLEPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool();
        } else {
            createOldSoundPool();
        }
    }
    /**
     * Create SoundPool for versions >= LOLLIPOP
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    /**
     * Create SoundPool for deprecated versions < LOLLIPOP
     */
    @SuppressWarnings("deprecation")
    protected void createOldSoundPool() {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
    }


    /**
     * reproduiex so de R2
     */

    public void sonidoR2D2(){
        soundPool.play(sonR2D2, 1, 1, 0, 0, 1);
    }

    /**
     * reproduiex so Chewie
     */
    public void sonidoChewaka(){
        soundPool.play(sonChewaka, 1, 1, 0, 0, 1);
    }


    /**
     * reproduiex tota la cadena de sons
     */
    public void play(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {}
        }, sonsMaquina.size() * duracion * 2);
        // reproduir sons
        for (int i = 0; i < sonsMaquina.size(); i++) {

            final int valorSons= sonsMaquina.get(i).intValue();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch(valorSons) {
                        case 0:
                            sonidoR2D2();
                            break;
                        case 1:
                            sonidoChewaka();

                            break;
                    }
                }
            }, duracion * i * 2);
        }
    }
}
