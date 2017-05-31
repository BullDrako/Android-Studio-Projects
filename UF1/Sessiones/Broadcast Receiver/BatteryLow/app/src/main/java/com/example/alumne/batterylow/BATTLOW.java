package com.example.alumne.batterylow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by alumne on 12/01/17.
 */
public class BATTLOW extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Bateria Baja",
                Toast.LENGTH_LONG).show();
    }
}
