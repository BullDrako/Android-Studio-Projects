package com.example.edgar.practicasimon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Edgar on 12/04/2017.
 */

public class InstruccionsActivity extends Activity {

    VideoView videoViewer, videoViewer2;
    MediaController videoViewerController, videoViewerController2;



    //MENU
    final static int JOC = 1;
    final static int CONFIGURACIO = 2;
    final static int INSTRUCCIONS_JOC =3;
    final static int SORTIR = 4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instruccions_activity);

        prepareSurface();
    }

    private void prepareSurface() {
        videoViewer = (VideoView) findViewById(R.id.videoView);

        videoViewerController = new MediaController(this, true);
        videoViewerController.setEnabled(false);

        videoViewer.setMediaController(videoViewerController);
        videoViewer.setVideoURI(Uri.parse("android.resource://com.example.edgar.practicasimon/raw/instruccions"));

    }

    //menu option que apareix a dalt amb 3 opcions
    public boolean onCreateOptionsMenu(Menu menu) {
        // The add() method used in this sample takes four arguments:
        // groupId, itemId, order, and title.
        menu.add(0, JOC, 0, "Joc");
        menu.add(0, CONFIGURACIO, 0, "Configuracio");
        menu.add(0, INSTRUCCIONS_JOC, 0, "Instruccions del joc");
        menu.add(0, SORTIR, 0, "Sortir");
        return true;
    }

    //menu option segons quina opció s'ha triat redirigeix a un activity o un altre
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case JOC:
                startJocActivity();
                return true;
            case CONFIGURACIO:
                startConfiguracioActivity();
                return true;
            case INSTRUCCIONS_JOC:
                startInstruccionsActivity();
                return true;
            case SORTIR:
                sortirAplicacio();
                return true;
        }
        return false;
    }

    private void startJocActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void startConfiguracioActivity(){
        Intent intent = new Intent(this,ConfiguracioActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void startInstruccionsActivity(){
        Intent intent = new Intent(this,InstruccionsActivity.class);
        startActivity(intent);
        this.finish();
    }

    private void sortirAplicacio() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Sortir de l'aplicació");
        builder.setMessage("Vols sorir de joc?")
                .setCancelable(false)
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        InstruccionsActivity.this.finish();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
