package com.javapassion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ExternalStorageActivity extends Activity {
	
	public static final String TAG = "ExternalStorageActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Create Button objects from layout definition file.
		Button buttonCreateStorage = (Button) findViewById(R.id.button1);
		Button buttonDeleteStorage = (Button) findViewById(R.id.button2);
		Button buttonCheckStorage = (Button) findViewById(R.id.button3);
		Button buttonExternalMediaDir = (Button) findViewById(R.id.button4);

		// Create external storage directory and save a picture
		buttonCreateStorage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				createExternalStoragePublicPicture();
				Toast.makeText(getApplicationContext(),
				        "External storage public Picture is created",
				        Toast.LENGTH_SHORT).show();
			}
		});

		// Delete the picture from the external storage
		buttonDeleteStorage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean trueOrFalse = deleteExternalStoragePublicPicture();
				Toast.makeText(getApplicationContext(),
				        "External storage public Picture is deleted? " + trueOrFalse,
				        Toast.LENGTH_LONG).show();
			}
		});

		// Check if the picture is present in the external storage
		buttonCheckStorage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				boolean trueOrFalse = hasExternalStoragePublicPicture();
				Toast.makeText(
				        getApplicationContext(),
				        "Does it has external storage public Picture? "
				                + trueOrFalse, Toast.LENGTH_LONG).show();
			}
		});
		
		// Display the absolute path of the external storage
		buttonExternalMediaDir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				File picturesDir = getApplicationContext().getExternalFilesDir("Pictures");
				Toast.makeText(
				        getApplicationContext(),
				        picturesDir.getAbsolutePath(), Toast.LENGTH_LONG).show();
			}
		});

	}

	// Create "DemoPicture.jpg" in the Pictures directory
	void createExternalStoragePublicPicture() {
		// Create a path where we will place our picture in the user's
		// public pictures directory. Note that you should be careful about
		// what you place here, since the user often manages these files. For
		// pictures and other media owned by the application, consider
		// Context.getExternalMediaDir().
		File path = Environment
		        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		
		try {
			// Make sure the Pictures directory exists.
			Boolean result = path.mkdirs();
			if (result){
				Toast.makeText(
				        getApplicationContext(),"Directory is newly created", Toast.LENGTH_LONG).show();
			}
			else{
				Toast.makeText(
				        getApplicationContext(),"Directory already exists", Toast.LENGTH_LONG).show();
			}

			// Very simple code to copy a picture from the application's
			// resource into the external file. Note that this code does
			// no error checking, and assumes the picture is small (does not
			// try to copy it in chunks). Note that if external storage is
			// not currently mounted this will silently fail.
			InputStream is = getResources()
			        .openRawResource(R.drawable.balloons);
			OutputStream os = new FileOutputStream(file);
			byte[] data = new byte[is.available()];
			is.read(data);
			os.write(data);
			is.close();
			os.close();

			// Tell the media scanner about the new file so that it is
			// immediately available to the user.
			MediaScannerConnection.scanFile(this, new String[] { file
			        .toString() }, null,
			        new MediaScannerConnection.OnScanCompletedListener() {
				        public void onScanCompleted(String path, Uri uri) {
					        Log.i(TAG, "Scanned " + path + ":");
					        Log.i(TAG, "-> uri=" + uri);
				        }
			        });
		} catch (IOException e) {
			// Unable to create file, likely because external storage is
			// not currently mounted.
			Log.w(TAG, "Error writing " + file, e);
		}
	}

	// Delete "DemoPicture.jpg"
	boolean deleteExternalStoragePublicPicture() {
		// Create a path where we will place our picture in the user's
		// public pictures directory and delete the file. If external
		// storage is not currently mounted this will fail.
		File path = Environment
		        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		return file.delete();
	}

	// Check if the "DemoPicture.jpg" is present
	boolean hasExternalStoragePublicPicture() {
		// Create a path where we will place our picture in the user's
		// public pictures directory and check if the file exists. If
		// external storage is not currently mounted this will think the
		// picture doesn't exist.
		File path = Environment
		        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		File file = new File(path, "DemoPicture.jpg");
		return file.exists();
	}
}