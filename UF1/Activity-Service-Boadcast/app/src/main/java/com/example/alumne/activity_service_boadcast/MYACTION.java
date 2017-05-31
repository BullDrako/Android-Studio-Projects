package com.example.alumne.activity_service_boadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by alumne on 19/01/17.
 */
public class MYACTION extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        String ACTION = intent.getAction();

        Toast.makeText(context, "Accion:\n" + ACTION,
                Toast.LENGTH_LONG).show();

        Intent s1 = new Intent(context, MYACTION.class);
        context.startService(s1);
    }
}
