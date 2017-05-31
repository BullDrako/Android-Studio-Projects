package com.example.alumne.practica2events7imig;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by alumne on 03/11/16.
 */
public class ConfiguracioActivity extends Activity {

    View.OnClickListener listener;
    RadioGroup.OnCheckedChangeListener listenerRadio;

    EditText editTextNombre;
    Button buttonOk;

    RadioGroup radioGroup;

    Spinner spinner;

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;


    //LinearLayout  linearLayout = (LinearLayout) findViewById(R.id.confLayout);
    //linearLayout.setBackgroundResource(R.drawable.);

    //RelativeLayout layout =(RelativeLayout)findViewById(R.id.confLayout);





    int[] fondos = {R.drawable.fondo1, R.drawable.fondo2, R.drawable.fondo3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracio_layout);

        editTextNombre = (EditText) findViewById(R.id.EditText_Nombre);
        editTextNombre.setText(" ");

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        buttonOk = (Button) findViewById(R.id.button_ok);

        spinner = (Spinner) findViewById(R.id.idspinner);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);

        prepareListener();
        prepareListenerRadio();
        controlSpinner();

        /*
        * int resourced = this.getResources().getIdentifier("trump", "drawable", this.getPackageName());
        * showMessage()resourceId + " : " + R.drawable.trump;
        *
        * */

        buttonOk.setOnClickListener(listener);
        radioGroup.setOnCheckedChangeListener(listenerRadio);

    }

    private void controlSpinner() {

        spinner = (Spinner) findViewById(R.id.idspinner);
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fondos, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(listener2);*/

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.fondos, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(listener2);
    }

    AdapterView.OnItemSelectedListener listener2 = new AdapterView.OnItemSelectedListener() { //alt + enter
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           /* showMessage("id Spinner: " + view.getId() + " positon: " + position + " id: " + id);*/

            /*showMessage(parent.getId() +" : " + "Spinner2 " + R.id.idspinner2 + " : " +  " Spinner1 " + R.id.idspinner);*/

           /* if(parent.getId() == R.id.idspinner){
                showMessage("Spinner2: " + icons[position]);
            }*/

            if(parent.getId() == R.id.idspinner){
                showMessage("Spinner2: " + fondos[position]);
                //layout.setBackgroundResource(R.drawable.fondo3);

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };




    /**
     * Prepare listener to RadioGroup
     */
    private void prepareListenerRadio() {
        listenerRadio = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_facil:
                        showMessage("Nivel fácil selected");
                        break;
                    case R.id.rb_medio:
                        showMessage("Nivel medio selected");
                        break;
                    case R.id.rb_dificil:
                        showMessage("Nivel dificil selected");
                        break;
                }
            }
        };

    }


    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button_ok:
                        //showMessage(" "+editTextNombre.getText());
                        callSecondActivity();
                        break;
                   case R.id.checkBox1:
                        if (checkBox1.isChecked()) {
                            showMessage("Checkbox1 Checked");
                        } else {
                            showMessage("Checkbox1 NOT Checked");
                        }
                        break;
                    case R.id.checkBox2:
                        if (checkBox2.isChecked()) {
                            showMessage("Checkbox2 Checked");
                        } else {
                            showMessage("Checkbox2 NOT Checked");
                        }
                        break;
                    case R.id.checkBox3:
                        if (checkBox3.isChecked()) {
                            showMessage("Checkbox3 Checked");
                        } else {
                            showMessage("Checkbox3 NOT Checked");
                        }
                        break;
                }
            }
        };
    }



    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }


    public void callSecondActivity() {
        Intent intent = new Intent(this,
                MainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("edittext", editTextNombre.getText().toString());

        if(checkBox1.isChecked()) {
            bundle.putString("checkbox1","Checked");
            bundle.putBoolean("cb1", true);
        }else{
            bundle.putString("checkbox1","Not Checked");
            bundle.putBoolean("cb1", false);
        }

        if(checkBox2.isChecked()) {
            bundle.putString("checkbox2","Checked");
            bundle.putBoolean("cb2", true);
        }else{
            bundle.putString("checkbox2","Not Checked");
            bundle.putBoolean("cb2", false);
        }

        /*if(checkBox3.isChecked()) {
            bundle.putString("checkbox3","Checked");
            bundle.putBoolean("cb2", true);
        }else{
            bundle.putString("checkbox3","Not Checked");
            bundle.putBoolean("cb3", false);
        }*/



        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();//cerrar activity vacia el historial de navegacion
    }
}
