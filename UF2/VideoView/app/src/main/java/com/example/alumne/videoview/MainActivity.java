package com.example.alumne.videoview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    VideoView videoViewer, videoViewer2;
    MediaController videoViewerController, videoViewerController2;
    View.OnClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button arrancar = (Button) findViewById(R.id.buttonMusicaOn);

       /* arrancar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startService(new Intent(MainActivity.this,
                        ServicioMusica.class));
            }
        });*/

        Button detener = (Button) findViewById(R.id.buttonMusicaOff);

        /*detener.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this,
                        ServicioMusica.class));
            }
        });*/

        prepareListenners();
        arrancar.setOnClickListener(listener);
        detener.setOnClickListener(listener);
        prepareSurface();


    }

    private void prepareSurface() {
        videoViewer = (VideoView) findViewById(R.id.videoView);
        videoViewer2 = (VideoView) findViewById(R.id.videoView2);

        videoViewerController = new MediaController(this, true);
        videoViewerController.setEnabled(false);

        videoViewerController2 = new MediaController(this, true);
        videoViewerController2.setEnabled(false);

        videoViewer.setMediaController(videoViewerController);
        videoViewer.setVideoURI(Uri.parse("android.resource://com.example.alumne.videoview/raw/moon"));
        //afegim el video tambe podria fer un video local especificant el path

        videoViewer2.setMediaController(videoViewerController2);
        videoViewer2.setVideoURI(Uri.parse("android.resource://com.example.alumne.videoview/raw/moon"));
    }


    public void prepareListenners(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.buttonMusicaOn:
                        startService(new Intent(MainActivity.this,
                                ServicioMusica.class));
                        break;
                    case R.id.buttonMusicaOff:
                        stopService(new Intent(MainActivity.this,
                                ServicioMusica.class));
                        break;
                }
            }
        };

    }
}
