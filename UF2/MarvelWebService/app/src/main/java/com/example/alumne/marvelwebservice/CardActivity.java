package com.example.alumne.marvelwebservice;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by alumne on 23/03/17.
 */

public class CardActivity extends Activity {

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
}
