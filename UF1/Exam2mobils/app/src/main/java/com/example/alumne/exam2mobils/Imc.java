package com.example.alumne.exam2mobils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by alumne on 16/02/17.
 */
public class Imc extends Service {

    public int onStartCommand(Intent i, int flags,int startId) {

        Toast.makeText(getApplicationContext(), "Servicio.", Toast.LENGTH_LONG).show();

        this.stopSelf();
        // return START_STICKY;
        i = new Intent();
        i.setAction("MiAction");
        sendBroadcast(i);
        onDestroy();
        return super.onStartCommand(i, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
