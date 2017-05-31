package com.example.edgar.practicasimon;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by super on 17/01/2017.
 */

public class ServicioMusica extends Service {

    MediaPlayer reproductor;



    @Override

    public void onCreate() {

        Toast.makeText(this,"Servicio creado",
                Toast.LENGTH_SHORT).show();

        //reproductor = MediaPlayer.create(this, R.raw.intro);

    }

    public void elegirCancion(){

    }


    @Override

    public int onStartCommand(Intent intenc, int flags, int idArranque) {

        Toast.makeText(this,"Servicio arrancado "+ idArranque,
                Toast.LENGTH_SHORT).show();

        Bundle bundle = intenc.getExtras();

        if(bundle.getBoolean("uno")){
            reproductor = MediaPlayer.create(this, R.raw.back_on_track);
        }
        if(bundle.getBoolean("dos")){
            reproductor = MediaPlayer.create(this, R.raw.high_score);
        }
        if(bundle.getBoolean("tres")){
            reproductor = MediaPlayer.create(this, R.raw.xstep);
        }


        /*reproductor = MediaPlayer.create(this, R.raw.intro);*/
        reproductor.start();

        return START_STICKY;

    }



    @Override

    public void onDestroy() {

        Toast.makeText(this,"Servicio detenido",
                Toast.LENGTH_SHORT).show();

        reproductor.stop();

    }



    @Override

    public IBinder onBind(Intent intencion) {

        return null;

    }

}
