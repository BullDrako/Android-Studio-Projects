package com.example.alumne.ejemplobuttonevents;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FormActivity extends Activity {
    EditText editText;

    View.OnClickListener listener;
    RadioGroup.OnCheckedChangeListener listenerRadio;
    CheckBox.OnCheckedChangeListener listenerCheckbox;

    RadioGroup radioGroup;
    CheckBox checkBox;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_form);

        //instanciem els elements del formulari
        toggleButton = (ToggleButton) findViewById(R.id.togglebutton);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.check(R.id.radio1);

        editText = (EditText) findViewById(R.id.editText);
        editText.setText("hola");
        prepareListener();
        prepareListenerRadio();

        //Add listener to elements (add Observer to elements Observables)
        toggleButton.setOnClickListener(listener);
        //toggleButton.setChecked(true); //no hace caso
        checkBox.setOnClickListener(listener);
        //checkBox.setChecked(false); //no hace caso
        radioGroup.setOnClickListener(listener);
        radioGroup.setOnCheckedChangeListener(listenerRadio);



    }

    /**
     * Prepare listener to RadioGroup
     */
    private void prepareListenerRadio() {
        listenerRadio = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio1:
                        showMessage("Radio1 selected");
                        break;
                    case R.id.radio2:
                        showMessage("Radio2 selected");
                        break;
                }
            }
        };
    }

    /**
     * Prepare Listener to events
     */
    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //togglebutton
                    case R.id.togglebutton:
                        if (toggleButton.isChecked()) {
                            showMessage("Toggle button Checked" + editText.getText()) ;
                        } else {
                            showMessage("Toggle button NOT Checked" + editText.getText());
                        }
                        break;
                    case R.id.checkbox:
                        if (checkBox.isChecked()) {
                            showMessage("Checkbox Checked");
                        } else {
                            showMessage("Checkbox NOT Checked");
                        }
                        break;

                }
            }
        };
    }

    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }
}
