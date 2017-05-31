package com.example.alumne.examen1edgarcabeza;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConfigActivity extends Activity {


    View.OnClickListener listener;

    Spinner spinner;
    SeekBar seekbar;
    Button buttonOk;



    int svalue = 0;

    int[] fondos = {R.drawable.fondo1, R.drawable.fondo2, R.drawable.fondo3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spinner = (Spinner) findViewById(R.id.idspinner);
        buttonOk = (Button) findViewById(R.id.button_ok);


        prepareListener();
        controlSpinner();
        initSeekbar();

        buttonOk.setOnClickListener(listener);
    }

    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_ok:
                        callJocActivity();
                        break;
                }
            }
        };
    }


    private void initSeekbar() {

        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(100);
        //svalue = 0;
        seekbar.setProgress(0);


        seekbar.setProgress(svalue);

        seekbar.setOnSeekBarChangeListener(list);
    }

    private void controlSpinner(){
        spinner = (Spinner) findViewById(R.id.idspinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fondos, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(listener2);
    }

    SeekBar.OnSeekBarChangeListener list = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {//cuando canvio de valor en seekbar

            if(seekBar.getId() == R.id.seekBar) {


                if (svalue < 25){
                    showMessage("Nivel facil");
                    //bundle.putString("texview", "Nivel facil");
                } else if (svalue > 26 || svalue < 75){
                    showMessage("Nivel medio");
                    //bundle.putString("texview", "Nivel medio");
                } else {
                    showMessage("Nivel dificil");
                    //bundle.putString("texview", "Nivel dificil");
                }

            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {//cuando se clica

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {//cuando levantas
        }
    };


    AdapterView.OnItemSelectedListener listener2 = new AdapterView.OnItemSelectedListener() { //alt + enter
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            if(parent.getId() == R.id.idspinner){
                showMessage("Spinner2: " + fondos[position]);
                //layout.setBackgroundResource(R.drawable.fondo3);

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }



    public void callJocActivity() {
        Intent intent = new Intent(this,
                JocActivity.class);
        Bundle bundle = new Bundle();

       if (svalue < 25){
            //showMessage("Nivel facil");
            bundle.putString("textview", "Nivel facil");
       } else if (svalue > 26 || svalue < 75){
            //showMessage("Nivel medio");
            bundle.putString("textview", "Nivel medio");
        } else {
           // showMessage("Nivel dificil");
            bundle.putString("textview", "Nivel dificil");
        }


        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();//cerrar activity vacia el historial de navegacion
    }
}
