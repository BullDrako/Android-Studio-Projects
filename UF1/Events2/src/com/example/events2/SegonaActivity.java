package com.example.events2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class SegonaActivity  extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segona); 
		
		Bundle mbundle = this.getIntent().getExtras();
		
		String s = mbundle.getString("toggle");
		int i = mbundle.getInt("cb");
		Toast.makeText(getApplicationContext(),
				s + " - " + i, 
								Toast.LENGTH_LONG).show();
	}

}
