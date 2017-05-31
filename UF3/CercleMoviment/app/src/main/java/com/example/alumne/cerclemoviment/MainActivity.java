package com.example.alumne.cerclemoviment;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity {

    ExempleView vistaExemple;
    Button button;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vistaExemple = (ExempleView) this.findViewById(R.id.ExempleView);
        button = (Button) this.findViewById(R.id.button1);

        prepareListener();

        button.setOnClickListener(listener);
    }


    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.button1:
                        Toast.makeText(getApplicationContext(), "boton", Toast.LENGTH_LONG).show();

                        break;
                }
            }
        };
    }
}
