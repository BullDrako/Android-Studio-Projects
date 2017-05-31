package com.example.alumne.batterymanager;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkSMSStatePermission();
    }

    private void checkSMSStatePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(
                this, Manifest.permission.RECEIVE_SMS);//CHEQUEAMOS EL PERMISO EN EL SISTEMA PARA PERMITIR SMS
        //
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.i("Mensaje", "No se tiene permiso para enviar/recibir SMS.");
            //Cuando la app llama a requestPermissions(), el sistema muestra al usuario un cuadro de diálogo estándar.
            //la app no puede configurar ni modificar ese cuadro de diálogo. Si hay que proporcionar información o
            // una explicación al usuario, hay que hacerlo antes de llamar a requestPermissions(),
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, 225);
        } else {
            Log.i("Mensaje", "Se tiene permiso para enviar/recibir SMS!");
        }
    }
}
