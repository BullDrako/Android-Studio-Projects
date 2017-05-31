package com.example.alumne.broadcastreceiverpropio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by alumne on 19/01/17.
 */
public class MYACTION extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        String ACTION = intent.getAction();

        Toast.makeText(context, "Esta es la acción:\n" + ACTION,
                Toast.LENGTH_LONG).show();

        Intent s1 = new Intent(context, MYSERVICE.class);
        context.startService(s1);
    }

}
