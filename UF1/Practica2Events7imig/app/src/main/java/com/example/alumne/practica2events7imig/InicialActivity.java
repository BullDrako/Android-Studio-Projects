package com.example.alumne.practica2events7imig;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by alumne on 03/11/16.
 */
public class InicialActivity extends Activity {

    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial_layout);

        Button confButton = (Button) findViewById(R.id.configuracio_button);

        prepareListenners();
        confButton.setOnClickListener(listener);
    }

    public void prepareListenners(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.configuracio_button:
                        startActivity(new Intent(InicialActivity.this,
                                ConfiguracioActivity.class));
                        break;
                    case R.id.jugar_button:
                        startActivity(new Intent(InicialActivity.this,
                                MainActivity.class));
                        break;
                }

            }
        };

    }
}
