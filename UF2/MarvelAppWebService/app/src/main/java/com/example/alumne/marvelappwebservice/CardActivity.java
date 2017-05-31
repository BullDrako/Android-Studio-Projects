package com.example.alumne.marvelappwebservice;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.alumne.marvelappwebservice.R.id.imageView;

public class CardActivity extends Activity {

    String urlString;
    String nameFileOutput;
    String description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fitxa_layout);
        Bundle bundle = getIntent().getExtras();
        urlString = bundle.getString("urlImage");
        nameFileOutput = bundle.getString("imagename");
        description = bundle.getString("description");

        new loadDataWebServiceTask().execute("");


    }

    private class loadDataWebServiceTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            readHttpWriteFile(urlString,nameFileOutput);
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            carregaImatge(nameFileOutput);
        }

        @Override
        protected void onPreExecute() {


        }

        @Override
        protected void onProgressUpdate(Void... values) {


        }
    }

    /**
     * Reads Http File and writes in internal Storage
     *
     * @param urlString      : Url to read File
     * @param nameFileOutput : name of file to write in Internal Storage
     */
    private void readHttpWriteFile(String urlString, String nameFileOutput) {
        int i = 0;
        try {
            FileOutputStream fos = openFileOutput(nameFileOutput, Context.MODE_PRIVATE);
            //fos.write(test_string.getBytes());
            // Petició HTTP
            // Prepare a request object
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release
            if (connection != null) {
                // Read Stream
                InputStream inputStream = connection.getInputStream();
                // agafar els bytes del InputStream i escriure'ls al fitxer
                i = 5;
                byte[] buf = new byte[512];
                int size;
                while ((size = inputStream.read(buf)) != -1) {
                    fos.write(buf, 0, size);
                }
                // tanquem la petició http
                inputStream.close();
            }
            // tanquem el fitxer al que estem escrivint
            fos.close();
            Toast.makeText(getApplicationContext(), "Audio file is written to "
                    + nameFileOutput, Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            System.out.println("Ex: " + i + e.toString());
        }
    }



    public void carregaImatge(String fileName) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        File directoryInternalStorage = this.getBaseContext().getApplicationContext().getFilesDir();
        File file = new File(directoryInternalStorage.getAbsolutePath() + "/" + fileName);
        //System.out.println(file.getAbsolutePath());
        // Mostrem la imatge a l'imageView
        if (file.exists()) {
            Uri uri = Uri.fromFile(file);
            imageView.setScaleType(ImageView.ScaleType.FIT_START);
            imageView.getLayoutParams().width = 800;
            imageView.setImageURI(uri);
        }
    }
}
