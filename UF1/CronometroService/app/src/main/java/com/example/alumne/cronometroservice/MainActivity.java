package com.example.alumne.cronometroservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
SeekBar seekBar;
    private TextView textoCronometro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoCronometro = (TextView) findViewById(R.id.cronometro);

        Button startButton = (Button) findViewById(R.id.btn_iniciar);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                iniciarCronometro();
            }
        });

        Button stopButton = (Button) findViewById(R.id.btn_finalizar);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pararCronometro();
            }
        });
        initSeekBar();


        Cronometro.setUpdateListener(this);

    }
public void initSeekBar()
{
    seekBar= (SeekBar)findViewById(R.id.seekBar);
    seekBar.setMax(100);
    seekBar.setProgress(50);
    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

            Toast.makeText(getApplicationContext(),"mueves",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
}

    /**
     * Inicia el servicio
     */
    private void iniciarCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        startService(service);
    }

    /**
     * Finaliza el servicio
     */
    private void pararCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        stopService(service);
        Toast.makeText(getApplicationContext(),"la cuenta final es "+textoCronometro.getText(),Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        // Antes de cerrar la aplicacion se para el servicio
        // ya que el servicio está asociado a está activity y necesita utilizat los métodos que implementa
        pararCronometro();
        super.onDestroy();
    }
    /**
     * Actualiza en la UI el tiempo que se cronometra, la llamada se realiza en el servicio
     *
     * @param tiempo
     */
    public void actualizarCronometro(double tiempo) {
        textoCronometro.setText(String.format("%.2f", tiempo) + "s");
    }
}