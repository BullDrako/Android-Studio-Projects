package com.example.alumne.practica2events7imig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Edgar on 10/02/2017.
 */

public class Battery extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String ACTION= intent.getAction();
        switch (ACTION) {
            case "android.intent.action.BATTERY_LOW":
                Toast.makeText(context,"Acción:\n" + ACTION, Toast.LENGTH_LONG).show();
                Toast.makeText(context,"Bateria baja:\n" , Toast.LENGTH_LONG).show();
                break;
            case "android.intent.action.ACTION_POWER_CONNECTED":
                Toast.makeText(context,"Bateria Conectada:\n", Toast.LENGTH_LONG).show();
                break;
            case "android.intent.action.AIRPLANE_MODE":
                Toast.makeText(context,"Modo Avión Activado:\n", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
