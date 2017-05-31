package com.example.alumne.broadcastreceiverpropio;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MYSERVICE extends Service {
    int crono = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(), "Servicio creado.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Servicio destruido.", Toast.LENGTH_LONG).show();
    }

    public int onStartCommand(Intent i, int flags,int startId) {

        Toast.makeText(getApplicationContext(), "Empieza cuenta.", Toast.LENGTH_LONG).show();
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<=1000 ; i++) {
                    crono = i;
                }
            }
        });

        try{
            Thread.sleep(10000);
            //Toast.makeText(getApplicationContext(), "Que sueño " + crono, Toast.LENGTH_LONG).show();
        } catch(InterruptedException e){
            e.printStackTrace();
        }

        hilo.start();
        Toast.makeText(getApplicationContext(), "Que sueño " + crono, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "Número: " + crono, Toast.LENGTH_LONG).show();
        this.stopSelf();
       // return START_STICKY;

        return super.onStartCommand(i, flags, startId);

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}