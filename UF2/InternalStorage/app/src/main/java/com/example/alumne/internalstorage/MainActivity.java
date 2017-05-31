package com.example.alumne.internalstorage;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends Activity {


    private static final String FILENAME = "hello_file";
    private static final String test_string = "Life is good!";

    //View.OnClickListener listener;

    Button buttonWrite;
    Button buttonRead;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create Button objects from layout definition file.
        buttonWrite = (Button) findViewById(R.id.button1);
        buttonRead = (Button) findViewById(R.id.button2);


        /*prepare();

        buttonWrite.setOnClickListener(listener);
        buttonRead.setOnClickListener(listener);*/

        // Event handler - when this button is clicked, write to a file
        buttonWrite.setOnClickListener(new View.OnClickListener() {

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
        buttonRead.setOnClickListener(new View.OnClickListener() {

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

/*
    public void write(){
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

    public void read(){
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

    public void prepare(){
        listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                switch (v.getId()){
                    case R.id.button1: // Event handler - when this button is clicked, write to a file
                        Toast.makeText(getApplicationContext(), "boton write", Toast.LENGTH_LONG).show();
                        write();
                    case R.id.button2: // Event handler - when this button is clicked, read the file
                        Toast.makeText(getApplicationContext(), "boton read", Toast.LENGTH_LONG).show();
                        read();
                }
            }
        };
    }*/
}