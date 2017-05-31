package com.example.alumne.notificacionprueba;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Created by alumne on 26/01/17.
 */
public class SecondActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(),"Second Activity",Toast.LENGTH_SHORT).show();
    }
}
