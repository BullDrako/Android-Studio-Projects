package com.example.events2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	ToggleButton btnBoton2;
	CheckBox cbMarcame;
	RadioGroup rgOpciones;
	Bundle mBundle;
	Button btnBoton1; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mBundle = new Bundle();
		mBundle.putString("toggle", "ON");
		mBundle.putInt("cb", 1);
		
		controlToggleButton();
		controlCheckBox();
		controlRadio();
		controlButton();
	}
	
	public void controlToggleButton() {
		btnBoton2 = (ToggleButton)findViewById(R.id.BtnBoton2);
		btnBoton2.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View arg0) {
		        if(btnBoton2.isChecked()) {
		        	mBundle.putString("toggle", "ON");
		        	Toast.makeText(getApplicationContext(),
							"ToggleButton ON !!!!", 
											Toast.LENGTH_LONG).show();
		        } else {
		        	mBundle.putString("toggle", "OFF");
		        	Toast.makeText(getApplicationContext(),
							"ToggleButton OFF !!!!", 
											Toast.LENGTH_LONG).show();
		        }
		    }
		});
	}
	
	public void controlCheckBox() {
		cbMarcame = (CheckBox)findViewById(R.id.ChkMarcame);
		 
		cbMarcame.setOnCheckedChangeListener(
		    new CheckBox.OnCheckedChangeListener() {
		        public void onCheckedChanged(CompoundButton buttonView,
		                                            boolean isChecked) {
		            if (isChecked) {
		            	mBundle.putInt("cb", 1);
		                cbMarcame.setText("Checkbox marcado!");
		            }
		            else {
		            	mBundle.putInt("cb", 0);
		                cbMarcame.setText("Checkbox desmarcado!");
		            }
		        }
		    });
	}
	
	public void controlRadio() {
		rgOpciones = (RadioGroup)findViewById(R.id.gruporb);
		 
		rgOpciones.setOnCheckedChangeListener(
		    new RadioGroup.OnCheckedChangeListener() {
		        public void onCheckedChanged(RadioGroup group, int checkedId) {
		        	Toast.makeText(getApplicationContext(),
							"ID seleccionat" + checkedId, 
											Toast.LENGTH_SHORT).show();
		        	if(checkedId == R.id.radio1) {
		        		Toast.makeText(getApplicationContext(),
								"Opció A seleccionada", 
												Toast.LENGTH_SHORT).show();
		        	}else if(checkedId == R.id.radio2) {
		        		Toast.makeText(getApplicationContext(),
								"Opció B seleccionada", 
												Toast.LENGTH_SHORT).show();
		        	}
		        }
		    });
		
	}
	
	public void controlButton() {
		btnBoton1 = (Button)findViewById(R.id.BtnBoton1);
		 
		btnBoton1.setOnClickListener(new View.OnClickListener() {
		    public void onClick(View v){
		    	cridaSegonaActivity();
		    }
		});
	}
	
	public void cridaSegonaActivity() {
		Intent intent = new Intent(this, SegonaActivity.class);
		intent.putExtras(mBundle);
		startActivity(intent);
	}
}
