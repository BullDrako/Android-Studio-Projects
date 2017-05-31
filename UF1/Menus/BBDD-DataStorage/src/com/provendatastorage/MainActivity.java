package com.provendatastorage;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//crear objecte sharedpreferences, especifiquemm el nom del fitxer (dades) i el mode d'accés
		//si no existeix el fitxer, el crea
		SharedPreferences prefs = getSharedPreferences("dades", MODE_PRIVATE);
		//obtenim les dades que volem, per exemple usuari i password
		String username = prefs.getString("usuari", "");
		String password = prefs.getString("password", "");
		
		
		// Generem un List View		
		ListView listView = (ListView) findViewById(R.id.mylist);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		  "Linux", "OS/2" };
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				  android.R.layout.simple_list_item_1, android.R.id.text1, values);


		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		
		listView.setOnItemClickListener(new OnItemClickListener() { 	  
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// Select an Item from ListView
				Toast.makeText(getApplicationContext(),
					      "Click ListItem Number " + position, Toast.LENGTH_LONG)
					      .show();
			}
			}); 
		
		/** Registering context menu for the listview */
		registerForContextMenu(listView);
	}
	
	//onPause() desarà el fitxer.
	//el fitxer es pot veure amb l'eina ddms que es troba a sdk/tools
	//també amb open perspective DDMS amb l'eclipse i File Explorer
	@Override
	protected void onPause() {
		
		super.onPause();
		//obtenim el fitxer de preferències
		SharedPreferences prefs = getSharedPreferences("dades", MODE_PRIVATE);
		//obtenim l'editor
		Editor mEditor = prefs.edit();
		//Escrivim les dades
		mEditor.putString("usuari", "jordi");
		mEditor.putString("password", "1234");
		//fem un commit
		mEditor.commit(); 
		
	}

	
	/** 
	 * Accions que fem quan cliquem alguna opció del menú per botó */
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
		//crear objecte sharedpreferences, especifiquemm el nom del fitxer (dades) i el mode d'accés
		//si no existeix el fitxer, el crea
		SharedPreferences prefs = getSharedPreferences("dades", MODE_PRIVATE);
		//obtenim les dades que volem, per exemple usuari i password
		String username = prefs.getString("usuari", "");
		String password = prefs.getString("password", "");
	    switch (item.getItemId()) {
	        case R.id.menu_settings:
	        	Toast.makeText(this.getApplicationContext(), 
     				   "menu_settings" + username, Toast.LENGTH_SHORT).show();
	            return true;
	        case R.id.menu_a:
	        	Toast.makeText(this.getApplicationContext(), 
	        				   "Menu botó: A", Toast.LENGTH_SHORT).show();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	/** 
	 * Accions que fem quan cliquem alguna opció del menú Flotant */
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
			switch(item.getItemId()){
			case R.id.menu_a:
				Toast.makeText(this, "Menú Flotant : A"  , Toast.LENGTH_SHORT).show();
				break;
			}
			return true;
		}
	
	// Menú que accedim pel botó de Menú descrit a res/menu
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	
	// Menú flotant descrit a res/menu
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		getMenuInflater().inflate(R.menu.activity_main , menu);
		
	}
	
	

}
