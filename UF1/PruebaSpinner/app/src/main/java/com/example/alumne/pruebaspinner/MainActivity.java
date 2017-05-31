package com.example.alumne.pruebaspinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

    Spinner spinner;
    Spinner spinner2;

    String dadesSpinner[];

    String dadesPlanets[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        controlSpinner();
        controlSpinner2();
    }

    //primer spinner
    private void controlSpinner() {
        dadesPlanets = getResources().getStringArray(R.array.planets_array);

        spinner = (Spinner) findViewById(R.id.idspinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_list_item_1);

        // Specify the layout to use when the list of choices appears
        //no es necesario solo canvia el spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(listener);

    }

    //segundo spinner
    private void controlSpinner2(){
        spinner2 = (Spinner) findViewById(R.id.idspinner2);

        dadesSpinner = new String[]{"Elem1", "Elem2", "Elem3", "Elem4"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dadesSpinner);

        spinner2.setAdapter(adaptador);
        spinner2.setOnItemSelectedListener(listener);

    }


    //es del primer spinner
    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() { //alt + enter
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           /* showMessage("id Spinner: " + view.getId() + " positon: " + position + " id: " + id);*/

            /*showMessage(parent.getId() +" : " + "Spinner2 " + R.id.idspinner2 + " : " +  " Spinner1 " + R.id.idspinner);*/

            if(parent.getId() == R.id.idspinner2){
                showMessage("Spinner2: " + dadesSpinner[position]);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg,
                Toast.LENGTH_LONG).show();
    }


}
