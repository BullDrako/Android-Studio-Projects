package com.javapassion;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

//  This application shows how to use internal storage. By default, 
//	files saved to the internal storage are private to your application 
//	and other applications cannot access them (nor can the user). 
//	When the user uninstalls your application, these files are 
//	removed.
public class InternalStorageActivity extends Activity {

	private static final String FILENAME = "hello_file";
	private static final String test_string = "Life is good!";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create Button objects from layout definition file.
		Button buttonWrite = (Button) findViewById(R.id.button1);
		Button buttonRead = (Button) findViewById(R.id.button2);

		// Event handler - when this button is clicked, write to a file
		buttonWrite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					FileOutputStream fos = openFileOutput(FILENAME,
					        Context.MODE_PRIVATE);
					fos.write(test_string.getBytes());

					fos.close();
					Toast.makeText(getApplicationContext(),
					        test_string + " is written to " + FILENAME,
					        Toast.LENGTH_SHORT).show();
				} catch (Exception e) {

				}
			}
		});

		// Event handler - when this button is clicked, read the file
		buttonRead.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {
					FileInputStream fis = openFileInput(FILENAME);
					byte[] buffer = new byte[20];
					fis.read(buffer);

					fis.close();
					Toast.makeText(getApplicationContext(), new String(buffer) + " is read",
					        Toast.LENGTH_LONG).show();
				} catch (Exception e) {

				}
			}
		});

	}
}