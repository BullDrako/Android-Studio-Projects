package com.example.edgar.practicasimon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Edgar on 12/04/2017.
 */

public class ConfiguracioActivity extends Activity {

    View.OnClickListener listener;
    EditText editTextNombre;

    RadioGroup radioGroup;
    RadioGroup.OnCheckedChangeListener listenerRadio;

    RadioButton rb_fondo1;
    RadioButton rb_fondo2;
    RadioButton rb_fondo3;

    RadioGroup radioGroupCanciones;
    RadioButton rb_cancion1;
    RadioButton rb_cancion2;
    RadioButton rb_cancion3;


    Button buttonOk;

    //MENU
    final static int JOC = 1;
    final static int CONFIGURACIO = 2;
    final static int INSTRUCCIONS_JOC =3;
    final static int SORTIR = 4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracio_layout);

        editTextNombre = (EditText) findViewById(R.id.EditText_Nombre);
        editTextNombre.setText(" ");


        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        rb_fondo1 = (RadioButton) findViewById(R.id.rb_fondo1);
        rb_fondo2 = (RadioButton) findViewById(R.id.rb_fondo2);
        rb_fondo3 = (RadioButton) findViewById(R.id.rb_fondo3);

        radioGroupCanciones = (RadioGroup) findViewById(R.id.radioGroupCanciones);

        rb_cancion1 = (RadioButton) findViewById(R.id.rb_cancion1);
        rb_cancion2 = (RadioButton) findViewById(R.id.rb_cancion2);
        rb_cancion3 = (RadioButton) findViewById(R.id.rb_cancion3);

        buttonOk = (Button) findViewById(R.id.button_ok);

        prepareListenerRadio();
        prepareListeners();
        radioGroup.setOnCheckedChangeListener(listenerRadio);
        radioGroupCanciones.setOnCheckedChangeListener(listenerRadio);
        buttonOk.setOnClickListener(listener);
    }

    private void prepareListeners() {
            listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case R.id.button_ok:
                            showMessage(" "+editTextNombre.getText());
                            callSecondActivity();
                            break;
                    }
                }
            };
        }


    /**
     * Prepare listener to RadioGroup
     */
    private void prepareListenerRadio() {
        listenerRadio = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_fondo1:
                        showMessage("Fondo 1 selected");
                        break;
                    case R.id.rb_fondo2:
                        showMessage("Fondo 2 selected");
                        break;
                    case R.id.rb_fondo3:
                        showMessage("Fondo 3 selected");
                        break;
                    case R.id.rb_cancion1:
                        showMessage("Cancion 1 selected");
                        break;
                    case R.id.rb_cancion2:
                        showMessage("Cancion 2 selected");
                        break;
                    case R.id.rb_cancion3:
                        showMessage("Cancion 3 selected");
                        break;
                }
            }
        };

    }

    public void callSecondActivity() {
        Intent intent = new Intent(this,
                MainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("edittext", editTextNombre.getText().toString());

        //Fondos
        if(rb_fondo1.isChecked()){
            bundle.putString("radioButton1","Selected");
            bundle.putBoolean("rb1", true);
        }else{
            bundle.putString("radioButton1","Not Selected");
            bundle.putBoolean("rb1", false);
        }

        if(rb_fondo2.isChecked()){
            bundle.putString("radioButton2","Selected");
            bundle.putBoolean("rb2", true);
        }else{
            bundle.putString("radioButton2","Not Selected");
            bundle.putBoolean("rb2", false);
        }

        if(rb_fondo3.isChecked()){
            bundle.putString("radioButton3","Selected");
            bundle.putBoolean("rb3", true);
        }else{
            bundle.putString("radioButton3","Not Selected");
            bundle.putBoolean("rb3", false);
        }

        //Canciones
        if(rb_cancion1.isChecked()){
            bundle.putString("radioButton4","Selected");
            bundle.putBoolean("rb4", true);
        }else{
            bundle.putString("radioButton4","Not Selected");
            bundle.putBoolean("rb4", false);
        }

        if(rb_cancion2.isChecked()){
            bundle.putString("radioButton5","Selected");
            bundle.putBoolean("rb5", true);
        }else{
            bundle.putString("radioButton5","Not Selected");
            bundle.putBoolean("rb5", false);
        }

        if(rb_cancion3.isChecked()){
            bundle.putString("radioButton6","Selected");
            bundle.putBoolean("rb6", true);
        }else{
            bundle.putString("radioButton6","Not Selected");
            bundle.putBoolean("rb6", false);
        }



        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();//cerrar activity vacia el historial de navegacion
    }

    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }


    //menu option que apareix a dalt amb 3 opcions
    public boolean onCreateOptionsMenu(Menu menu) {
        // The add() method used in this sample takes four arguments:
        // groupId, itemId, order, and title.
        menu.add(0, JOC, 0, "Joc");
        menu.add(0, CONFIGURACIO, 0, "Configuracio");
        menu.add(0, INSTRUCCIONS_JOC, 0, "Instruccions del joc");
        menu.add(0, SORTIR, 0, "Sortir");
        return true;
    }

    //menu option segons quina opció s'ha triat redirigeix a un activity o un altre
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case JOC:
                startJocActivity();
                return true;
            case CONFIGURACIO:
                startConfiguracioActivity();
                return true;
            case INSTRUCCIONS_JOC:
                startInstruccionsActivity();
                return true;
            case SORTIR:
                sortirAplicacio();
                return true;
        }
        return false;
    }

    private void startJocActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void startConfiguracioActivity(){
        Intent intent = new Intent(this,ConfiguracioActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void startInstruccionsActivity(){
        Intent intent = new Intent(this,InstruccionsActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void sortirAplicacio() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Sortir de l'aplicació");
        builder.setMessage("Vols sorir de joc?")
                .setCancelable(false)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ConfiguracioActivity.this.finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
