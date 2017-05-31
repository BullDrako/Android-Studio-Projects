package com.example.alumne.batterymanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by alumne on 12/01/17.
 */
public class ReceiverBattery extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String ACTION = intent.getAction();

        Toast.makeText(context, "Esta es la acción:\n" + ACTION,
                Toast.LENGTH_LONG).show();

        if(ACTION.equals("android.intent.action.ACTION_BATTERY_LOW")){
            Toast.makeText(context, "Esta es la acción:\n" + ACTION,
                    Toast.LENGTH_LONG).show();

        } else if(ACTION.equals("android.intent.action.ACTION_POWER_CONNECTED")){
            Toast.makeText(context, "Esta es la acción:\n" + ACTION,
                    Toast.LENGTH_LONG).show();
        }

    }
}
