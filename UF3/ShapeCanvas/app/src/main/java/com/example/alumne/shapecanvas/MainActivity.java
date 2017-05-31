package com.example.alumne.shapecanvas;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    ExempleView vistaExemple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vistaExemple = (ExempleView) this.findViewById(R.id.ExempleView);
    }
}
