package com.proven;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	Button bUsuari,bGuest;
	TextView tvNom, tvUsuari;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.principal);
		
		bUsuari = (Button) findViewById(R.id.bUsuari);
		bGuest = (Button) findViewById(R.id.bGuest);
		
		tvNom = (TextView) findViewById(R.id.tvNom);
		tvUsuari = (TextView) findViewById(R.id.tvUsuari);
		
		SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
		//obtenim les dades que volem, per exemple usuari i password
		String nom = prefs.getString("nom", "");
		String usuari = prefs.getString("usuari", "");
		
		tvNom.setText(nom);
		tvUsuari.setText(usuari);
		
		bUsuari.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				escriureDadesUsuari();
			}
		});
		bGuest.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				escriureDadesGuest();
			}
		});
		
	}
	
	public void escriureDadesUsuari() {
		SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
		//obtenim l'editor
		Editor mEditor = prefs.edit();
		//Escrivim les dades
		mEditor.putString("nom", "DAM2");
		mEditor.putString("usuari", "user dam2");
		//fem un commit
		mEditor.commit(); 
	}
	
	public void escriureDadesGuest() {
		SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
		//obtenim l'editor
		Editor mEditor = prefs.edit();
		//Escrivim les dades
		mEditor.putString("nom", "Anònim");
		mEditor.putString("usuari", "Guest");
		//fem un commit
		mEditor.commit(); 
	}
}
