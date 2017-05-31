package com.example.alumne.exam2mobils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by alumne on 16/02/17.
 */
public class MYACTION extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        String ACTION = intent.getAction();

        Toast.makeText(context, "Broadcast receiver:\n" + ACTION,
                Toast.LENGTH_LONG).show();

        Intent s1 = new Intent(context, MYACTION.class);
        context.startService(s1);
    }
}
