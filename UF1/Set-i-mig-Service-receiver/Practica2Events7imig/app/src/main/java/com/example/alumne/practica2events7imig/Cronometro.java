package com.example.alumne.practica2events7imig;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro extends Service {

    private Timer temporizador = new Timer();
    private static final long INTERVALO_ACTUALIZACION = 10; // En ms
    public static MainActivity UPDATE_LISTENER;//
    private double cronometro = 0; //actualizará activity principal
    private Handler handler;


    /***
     * Establece la activity que va a recibir los datos del servico (las actualizaciones del cronometro)
     *
     * @param M1
     */
    public static void setUpdateListener(MainActivity M1) {
        UPDATE_LISTENER = M1;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                UPDATE_LISTENER.actualizarCronometro(cronometro);//llamada desde el servicio a la activity
            }

        };
        incrementaCronometro();
    }

    @Override
    public void onDestroy() {
        pararCronometro();
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    public Cronometro() {
    }


    private void incrementaCronometro() {
        temporizador.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                cronometro += 0.01;//suma
                handler.sendEmptyMessage(0);//Desde el hilo enviamos una señal al handler cuando
                // ha finalizado la tarea (incrementar un valor) para que actualize la activity
            }
        }, 0, INTERVALO_ACTUALIZACION);
    }

    private void pararCronometro() {
        if (temporizador != null)
            temporizador.cancel();
    }

}
