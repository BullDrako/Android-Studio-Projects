package com.example.alumne.notificacionprueba;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NotificationManager nManager = (NotificationManager);
        NotificationManager nManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(
                getBaseContext())
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("MyService")
                .setContentText("Terminó el servicio");
        //setWhen(System.currentTimeMillis)


        //Crear un intent especificando que realizará (llamada a otra activity, settings del sistema,…)

        //Intent i = new Intent(Settings.ACTION_SECURITY_SETTINGS); //Abre la seccion de seguridad de ajustes
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);

        //Crear del PendingIntent pasando el intent que se realizará, obligatorio usar método para obtener activity’s (getactivity)
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(pi);

        nManager.notify(1, builder.build());
    }
}
