package com.javapassion;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MyContextMenu extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Register Button view to the context menu.
        // When button is long-pressed, context menu gets displayed.
        Button button = (Button)findViewById(R.id.myButton);
        button.setOnCreateContextMenuListener(this);
    }
    
    // Creates the menu items  
    @Override
    public void onCreateContextMenu(
    		ContextMenu menu, 			// Context menu that is being built
    		View view, 					// The view for which the context menu is being built
    		ContextMenuInfo menuInfo) {
    	
    	super.onCreateContextMenu(menu, view, menuInfo);
    	menu.setHeaderTitle("Context menu");
      	menu.add(0, Menu.FIRST,   Menu.NONE, "menu #1");
    	menu.add(0, Menu.FIRST+1, Menu.NONE, "menu #2");
    	menu.add(0, Menu.FIRST+2, Menu.NONE, "menu #3");
    	menu.add(0, Menu.FIRST+3, Menu.NONE, "menu #4");
    }
    
    // Handles item selections
    @Override
    public boolean onContextItemSelected(MenuItem item) {
		Toast.makeText(
				MyContextMenu.this,		// Qualify 'this" with Activity class
				"You selected menu item #" + String.valueOf(item.getItemId()),		
				Toast.LENGTH_LONG).show();	// Make sure you call show() method
    	return true;
    }
}