package com.example.alumne.examenm8uf2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    VideoView videoViewer;
    MediaController videoViewerController;

    Button buttonAnarAudio;
    Button buttonAnarServeiWeb;

    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAnarAudio = (Button) findViewById(R.id.buttonAnarAudio);
        buttonAnarServeiWeb = (Button) findViewById(R.id.buttonAnarServeiWeb);

        prepareSurface();

        prepareListeners();

        buttonAnarAudio.setOnClickListener(listener);
        buttonAnarServeiWeb.setOnClickListener(listener);
    }

    private void prepareSurface() {
        videoViewer = (VideoView) findViewById(R.id.videoView);


        videoViewerController = new MediaController(this, true);
        videoViewerController.setEnabled(false);


        videoViewer.setMediaController(videoViewerController);
        videoViewer.setVideoURI(Uri.parse("android.resource://com.example.alumne.examenm8uf2/raw/moon"));


    }

    public void prepareListeners(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.buttonAnarAudio:
                        startActivity(new Intent(MainActivity.this,
                                AudioActivity.class));
                        break;
                    case R.id.buttonAnarServeiWeb:
                        startActivity(new Intent(MainActivity.this,
                                WebServiceActivity.class));
                        break;
                }
            }
        };
    }
}
