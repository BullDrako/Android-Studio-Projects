package proven.org.storage;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StorageActivity extends Activity {

    Button bUsuari, bGuest, bWrite, bWriteInt;
    TextView tvNom, tvUsuari;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        //checkWriteStatePermission();

        bUsuari = (Button) findViewById(R.id.bUsuari);
        bGuest = (Button) findViewById(R.id.bGuest);
        bWrite = (Button) findViewById(R.id.bWrite);
        bWriteInt = (Button) findViewById(R.id.bWriteInt);

        tvNom = (TextView) findViewById(R.id.tvNom);
        tvUsuari = (TextView) findViewById(R.id.tvUsuari);


        SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
        //obtenim les dades que volem, per exemple usuari i password
        String nom = prefs.getString("nom", "");
        String usuari = prefs.getString("usuari", "");

        tvNom.setText(nom);
        tvUsuari.setText(usuari);
        prepare();
        bUsuari.setOnClickListener(listener);
        bGuest.setOnClickListener(listener);
        bWrite.setOnClickListener(listener);
        bWriteInt.setOnClickListener(listener);

    }


    public void prepare() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bUsuari:
                        escriureDadesUsuari();
                        break;
                    case R.id.bGuest:
                        escriureDadesGuest();
                        break;
                    case R.id.bWrite:
                        writeExternal();
                        break;
                    case R.id.bWriteInt:
                        writeInternal();
                        break;
                }
            }
        };

    }

    public void escriureDadesUsuari() {
        SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
        //obtenim l'editor
        SharedPreferences.Editor mEditor = prefs.edit();
        //Escrivim les dades
        mEditor.putString("nom", "DAM2");
        mEditor.putString("usuari", "user dam2");
        //fem un commit
        mEditor.commit();
        Toast.makeText(getBaseContext(), "NOMAAAA",
                Toast.LENGTH_LONG).show();
    }

    public void escriureDadesGuest() {
        SharedPreferences prefs = getSharedPreferences("infoUsuari", MODE_PRIVATE);
        //obtenim l'editor
        SharedPreferences.Editor mEditor = prefs.edit();
        //Escrivim les dades
        mEditor.putString("nom", "Anònim");
        mEditor.putString("usuari", "Guest");
        //fem un commit
        mEditor.commit();
    }


    public void writeExternal() {
        File path = Environment
                .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = new File(path, "DemoPicture2.jpg");
        try {
            // Make sure the Pictures directory exists.
            Boolean result = path.mkdirs();
            if (result) {
                Toast.makeText(
                        getApplicationContext(), "Directory is newly created", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(
                        getApplicationContext(), "Directory already exists" + path, Toast.LENGTH_LONG).show();
            }
            InputStream is = getResources()
                    .openRawResource(R.raw.balloons);
            OutputStream os = new FileOutputStream(file);
            byte[] data = new byte[is.available()];
            is.read(data);
            os.write(data);
            is.close();
            os.close();
        } catch (Exception e) {
            Toast.makeText(
                    getApplicationContext(), "Error" + e.toString(), Toast.LENGTH_LONG).show();
        }

    }


    public void writeInternal() {
        try {
            Toast.makeText(
                    getApplicationContext(), "Escriu", Toast.LENGTH_LONG).show();
            String s = "Text a escriure";
            FileOutputStream fos = openFileOutput("fitxerIntern.txt",
                    Context.MODE_PRIVATE);
            fos.write(s.getBytes());

            fos.close();
        }catch(Exception e){
                Toast.makeText(
                        getApplicationContext(), "Error" + e.toString(), Toast.LENGTH_LONG).show();
            }
        }

    }
