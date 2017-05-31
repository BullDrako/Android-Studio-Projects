package com.example.quadresdialeg;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button bAlert, bPick, bCustom;
	LinearLayout linearL;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		bAlert = (Button) findViewById(R.id.balert);
		bPick = (Button) findViewById(R.id.bpick);
		bCustom = (Button) findViewById(R.id.bcustom);
		linearL = (LinearLayout)
							findViewById(R.id.layoutprincipal);
		eventButton();
	}
	
	public void eventButton() {
		bAlert.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				obreQuadreDialeg();				
			}
		});
		bPick.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				obrePickDialog();				
			}
		});
		bCustom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				obreCustomDialog();				
			}
		});
	}
	
	public void obreQuadreDialeg() {
		AlertDialog.Builder builder = 
								new AlertDialog.Builder(this);
		builder.setTitle("Títol del Quadre");
		builder.setMessage("Are you sure you want to exit?")
		.setCancelable(false)
		.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id) {
			
		}
		})
		.setPositiveButton("NO", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id) {
			dialog.cancel();
		}
		})
		.setNegativeButton("YES", new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, int id) {
			MainActivity.this.finish();
		}
		});
		
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public void obrePickDialog() {
		final CharSequence[] items = {"Red", "Green", "Blue"};
		AlertDialog.Builder builder = 
							new AlertDialog.Builder(this);
		builder.setTitle("Pick a color");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		public void onClick(DialogInterface dialog, 
											int posicio) {
			Toast.makeText(getApplicationContext(), 
									items[posicio],
									Toast.LENGTH_LONG).show();
			switch(posicio) {
				case 	0:	
						linearL.setBackgroundColor(Color.RED);
						break;
				case 	1:	
						linearL.setBackgroundColor(Color.GREEN);
						break;
				case 	2:	
						linearL.setBackgroundColor(Color.BLUE);
						break;
			}
		}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public void obreCustomDialog() {
		//Context mContext = getApplicationContext();
		Dialog dialog = new Dialog(this);
		dialog.setContentView(R.layout.custom_layout);
		dialog.setTitle("Custom Dialog");
		TextView text = (TextView) 
							dialog.findViewById(R.id.text);
		text.setText("Hello, this is a custom dialog!");
		ImageView image = (ImageView) 
								dialog.findViewById(R.id.image);
		image.setImageResource(R.drawable.ic_launcher);
		dialog.show();
	}
}
