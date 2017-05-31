package com.example.alumne.activity_service_boadcast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MiServicio extends Service {

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
        Intent i = new Intent();
        i.setAction("MiAction");
        sendBroadcast(i);

    }

    public int onStartCommand(Intent i, int flags,int startId) {

        Toast.makeText(getApplicationContext(), "Empieza cuenta.", Toast.LENGTH_LONG).show();

        this.stopSelf();
        // return START_STICKY;

        return super.onStartCommand(i, flags, startId);

    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
