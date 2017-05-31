package com.example.alumne.bbddagenda;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    BBDDAgenda agenda;
    SQLiteDatabase dbAgenda;
    String instrSQL;

    Button consulta;
    Button inserir;


    View.OnClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consulta = (Button) findViewById(R.id.buttonConsulta);
        inserir = (Button) findViewById(R.id.buttonInserir);


        this.agenda = new BBDDAgenda(this.getApplicationContext(), "Agenda", null, 1);

        prepareListener();

        consulta.setOnClickListener(listener);
        inserir.setOnClickListener(listener);


      borrar();


    }


public void insertar(){
        Bundle bundle = this.getIntent().getExtras();
        StringBuilder s = new StringBuilder();

        if(bundle != null) {
            String dato = "";
            s.append(bundle.get("edittextnom"));
            dato = s.toString();
            insertarRegistre(dato);

        }

}


    public void borrar(){
        Bundle bundle = this.getIntent().getExtras();
        StringBuilder s = new StringBuilder();

        if(bundle != null) {
            String dato = "";
            s.append(bundle.get("edittextnom"));
            dato = s.toString();
            eliminarRegistre(dato);


        }

    }

    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.buttonConsulta:
                        //showMessage(" "+editTextNombre.getText());
                        consultar();
                        break;
                    case R.id.buttonInserir:
                        callFormActivity();
                        break;
                }
            }
        };
    }

    public void callFormActivity(){
        Intent intent = new Intent(this,
                FormActivity.class);
        Bundle bundle = new Bundle();


        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();//cerrar activity vacia el historial de navegacion
    }

    // 2- Afegeix el mètode per inserir registres
    private void insertarRegistre(String nom) {
        this.dbAgenda = this.agenda.getWritableDatabase();

        if (this.dbAgenda != null)
        {
            this.dbAgenda.execSQL("INSERT INTO Contacto (Nombre) VALUES ('" + nom + "')");

            //this.messageBox("Registro grabado");
            Toast.makeText(getApplicationContext(), "Registro grabado", Toast.LENGTH_LONG).show();

        }

        this.dbAgenda.close();
    }


    //3- Afegeix un mètode per consultar una taula
    private void consultar()
    {
        Cursor c;

        //Abrir para leer.
        this.dbAgenda = this.agenda.getReadableDatabase();

        c = this.dbAgenda.rawQuery("SELECT * FROM Contacto", null);

        //c.getCount()

        //Detectar si hay registros y nos movemos al 1?.
        if (c.moveToFirst())
        {
            do
            {
                int pk = c.getInt(0);
                String nombre = c.getString(1);

               // this.messageBox(pk + " - " + nombre);
                Toast.makeText(getApplicationContext(), pk + " - " + nombre, Toast.LENGTH_LONG).show();

            } while (c.moveToNext());

            c.close();
        }
        else
        {
            //this.messageBox("No hay registros");
            Toast.makeText(getApplicationContext(), "No hay registros", Toast.LENGTH_LONG).show();
        }

        this.dbAgenda.close();
    }


    //3- Afegeix un mètode per actualitzar un registre
    private void actualitzarRegistre(String oldName, String newName) {
        this.dbAgenda = this.agenda.getWritableDatabase();

        if (this.dbAgenda != null)
        {
            this.dbAgenda.execSQL("UPDATE Contacto SET Nombre = '" + newName
                    + "' where Nombre='" + oldName + "'");
            //this.messageBox("Registro grabado");
            Toast.makeText(getApplicationContext(), "Registro grabado", Toast.LENGTH_LONG).show();
        }

        this.dbAgenda.close();
    }


   // 4- Afegeix un mètode per eliminar un registre
    private void eliminarRegistre(String name) {
        this.dbAgenda = this.agenda.getWritableDatabase();

        if (this.dbAgenda != null)
        {
            this.dbAgenda.execSQL("DELETE Contacto WHERE Nombre = '" + name + "'");
            //this.messageBox("Registro grabado");
            Toast.makeText(getApplicationContext(), "Registro grabado", Toast.LENGTH_LONG).show();
        }

        this.dbAgenda.close();
    }




}
