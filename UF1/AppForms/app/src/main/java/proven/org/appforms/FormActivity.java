package proven.org.appforms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class FormActivity extends Activity {

    OnClickListener listener;
    RadioGroup.OnCheckedChangeListener listenerRadio;
    CheckBox.OnCheckedChangeListener listenerCheckbox;

    RadioGroup radioGroup;
    CheckBox checkbox;
    ToggleButton toggleButton;
    EditText editText;
    Button bsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_form);
        // Instanciem els elements del form
        toggleButton = (ToggleButton)
                findViewById(R.id.toggleButton);
        //toggleButton.setChecked(false);
        checkbox = (CheckBox) findViewById(R.id.checkBox);
        checkbox.setChecked(true);
        radioGroup = (RadioGroup) findViewById(R.id.gruporb);
        radioGroup.check(R.id.radiob2);
        editText = (EditText) findViewById(R.id.editText);
        editText.setText("HOLA");  // editText.getText();
        bsubmit =  (Button) findViewById(R.id.bsubmit);
        // prepare Listeners
        prepareListener();
        prepareListenerRadio();
        // Add listener to elements (add Observer
        //                           to elements Observables)
        toggleButton.setOnClickListener(listener);
        bsubmit.setOnClickListener(listener);
        checkbox.setOnClickListener(listener);
        radioGroup.setOnCheckedChangeListener(listenerRadio);
    }

    /**
     * Prepare listener to RadioGroup
     */
    private void prepareListenerRadio() {
        listenerRadio = new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group
                                        , int checkedId) {
                switch (checkedId) {
                    case R.id.radiob1:
                        showMessage("RB1 selected");
                        break;
                    case R.id.radiob2:
                        showMessage("RB2 selected");
                        break;
                }
            }
        };
    }

    /**
     * Prepare Listener to events
     */
    private void prepareListener() {
        listener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // toggleButton
                    case R.id.toggleButton:
                        if (toggleButton.isChecked()) {
                            showMessage("Checked"
                                        + editText.getText());
                        } else {
                            showMessage("toggle Button NOT!!! Checked"
                                    + editText.getText());
                        }
                        break;
                    case R.id.checkBox:
                        if(checkbox.isChecked()) {
                            showMessage("CB is checked");
                        }else{
                            showMessage("CB NOT!!! checked");
                        }
                        break;
                    case R.id.bsubmit:
                        callSecondActivity();
                        break;

                }
            }
        };
    }

    public void callSecondActivity() {
        Intent intent = new Intent(this,
                                ReceiveParametersActivity.class);
        Bundle bundle = new Bundle();
        if(checkbox.isChecked()) {
            bundle.putString("checkbox","Checked");
            bundle.putBoolean("cb", true);
        }else{
            bundle.putString("checkbox","Not Checked");
            bundle.putBoolean("cb", false);
        }
        bundle.putString("edittext", editText.getText().toString());
        int checkedId = radioGroup.getCheckedRadioButtonId();
        switch (checkedId) {
            case R.id.radiob1:
                bundle.putString("radio","RB1 selected");
                break;
            case R.id.radiob2:
                bundle.putString("radio","RB2 selected");
                break;
        }
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg,
                Toast.LENGTH_LONG).show();
    }
}
