package com.example.alumne.notificacionencapsulacion;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;

public class MainActivity extends Activity {
    private static final int NOTIFY_ID = 1337;//Creo mi propio identificador

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NotificationManager mgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);//pedimos el servicio del sistema
        NotificationCompat.Builder normal = buildNormal();//modo compatibilidad
        NotificationCompat.InboxStyle big =
                new NotificationCompat.InboxStyle(normal);
        //Tot allò que volem mostrar a la notificació de string.xml
        mgr.notify(NOTIFY_ID,
                big.setSummaryText(getString(R.string.summary))
                        .addLine(getString(R.string.entry))
                        .addLine(getString(R.string.another_entry))
                        .addLine(getString(R.string.third_entry))
                        .addLine(getString(R.string.yet_another_entry))
                        .addLine(getString(R.string.low)).build());

        finish();//envia la notificacion y finaliza el ciclo de vida
    }

    private NotificationCompat.Builder buildNormal() {
        NotificationCompat.Builder b = new NotificationCompat.Builder(this);
/*
        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(getString(R.string.download_complete))
                .setContentText(getString(R.string.fun))
                .setContentIntent(buildPendingIntent(Settings.ACTION_SECURITY_SETTINGS))
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setTicker(getString(R.string.download_complete))
                .setPriority(Notification.PRIORITY_HIGH)
                .addAction(android.R.drawable.ic_media_play,
                        getString(R.string.play),
                        buildPendingIntent(Settings.ACTION_SECURITY_SETTINGS));

*/
        //fem la notificació amb pantalla sencera
        b.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(getString(R.string.download_complete))
                .setContentText(getString(R.string.fun))
                .setContentIntent(buildPendingIntent(Settings.ACTION_SECURITY_SETTINGS))
                .setSmallIcon(android.R.drawable.stat_sys_download_done)
                .setTicker(getString(R.string.download_complete))
                .setFullScreenIntent(buildPendingIntent(Settings.ACTION_DATE_SETTINGS), true)
                .addAction(android.R.drawable.ic_media_play,
                        getString(R.string.play),
                        buildPendingIntent(Settings.ACTION_SETTINGS));

        return (b);
    }

    // Cal fer un pending intent, no sabem quan ho seleccionarà l'usuari.
    private PendingIntent buildPendingIntent(String action) {
        Intent i = new Intent(action);

        return (PendingIntent.getActivity(this, 0, i, 0));
    }
}