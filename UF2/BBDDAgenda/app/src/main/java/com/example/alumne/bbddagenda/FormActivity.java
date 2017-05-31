package com.example.alumne.bbddagenda;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alumne on 02/03/17.
 */

public class FormActivity extends Activity {

    BBDDAgenda agenda;
    SQLiteDatabase dbAgenda;

    View.OnClickListener listener;

    Button insert;
    Button update;
    Button delete;

    EditText editTextNom;
    EditText editTextNouNom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_layout);


        insert = (Button) findViewById(R.id.buttonInsert);
        update = (Button) findViewById(R.id.buttonUpdate);
        delete = (Button) findViewById(R.id.buttonDelete);

        editTextNom = (EditText) findViewById(R.id.editTextNom);
        editTextNouNom = (EditText) findViewById(R.id.editTextNomNou);

        prepareListener();

        insert.setOnClickListener(listener);
        update.setOnClickListener(listener);
        delete.setOnClickListener(listener);

        //editTextNom.setOnClickListener(listener);
    }

    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String dato = editTextNom.getText().toString();
                switch (v.getId()) {
                    case R.id.buttonInsert:
                        callMainActivity();
                        break;
                    case R.id.buttonUpdate:
                        //callFormActivity();
                        break;
                    case R.id.buttonDelete:
                        callMainActivity();
                        break;
                }
            }
        };
    }


    public void callMainActivity(){
        Intent intent = new Intent(this,
                MainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("edittextnom", editTextNom.getText().toString());


        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();//cerrar activity vacia el historial de navegacion
    }

}
