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
	
	Bundle mBundle;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mBundle = new Bundle();
		mBundle.putString("toggle", "ON");
		mBundle.putInt("cb", 1);
		// start second Activity (do when action like click)
		cridaSegonaActivity();
	}
	
	
	public void cridaSegonaActivity() {
		Intent intent = new Intent(this, SegonaActivity.class);
		// set Bundle to intent
		intent.putExtras(mBundle);
		startActivity(intent);
	}
}
