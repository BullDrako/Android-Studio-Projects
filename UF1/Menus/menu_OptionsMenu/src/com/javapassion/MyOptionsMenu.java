package com.javapassion;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyOptionsMenu extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    // Creates the menu items
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, Menu.FIRST,   Menu.NONE, "menu #1").setIcon(R.drawable.duke1);
    	menu.add(0, Menu.FIRST+1, Menu.NONE, "menu #2").setIcon(R.drawable.duke2);
    	menu.add(0, Menu.FIRST+2, Menu.NONE, "menu #3").setIcon(R.drawable.duke3);
    	menu.add(0, Menu.FIRST+3, Menu.NONE, "menu #4").setIcon(R.drawable.duke4);
    	menu.add(0, Menu.FIRST+4, Menu.NONE, "menu #5").setIcon(R.drawable.duke5);
    	menu.add(0, Menu.FIRST+5, Menu.NONE, "menu #6").setIcon(R.drawable.duke6);
    	menu.add(0, Menu.FIRST+6, Menu.NONE, "menu #7").setIcon(R.drawable.duke7);
    	return true;
    }
    
    // Handles item selections
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {  	
		Toast.makeText(
				MyOptionsMenu.this,		// Qualify 'this" with Activity class
				"You selected menu item #" + String.valueOf(item.getItemId()),		
				Toast.LENGTH_LONG).show();	// Make sure you call show() method
    	return true;
    }
}