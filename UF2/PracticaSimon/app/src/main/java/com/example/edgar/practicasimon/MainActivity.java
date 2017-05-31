package com.example.edgar.practicasimon;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    View.OnClickListener playListener;

    ImageView ibAzul;
    ImageView ibRojo;
    ImageView ibVerde;
    ImageView ibAmarillo;
    ImageView ibPlay;

    TextView tvPuntuacio;
    TextView tvPuntos;

    ArrayList<Integer> tiradesMaquina = new ArrayList<Integer>();
    ArrayList<Integer> tiradesJugador = new ArrayList<Integer>();

    int duracion = 200;
    int tirada;

    Boolean tornJugador;
    Boolean jugando = true;

    SoundPool soundPool;
    int sonAzul;
    int sonVerde;
    int sonRojo;
    int sonAmarillo;
    int sonError;

    //MENU
    final static int JOC = 1;
    final static int CONFIGURACIO = 2;
    final static int INSTRUCCIONS_JOC =3;
    final static int SORTIR = 4;

    RelativeLayout rl;
    TextView textViewNombre;

    BDSimon simon;
    SQLiteDatabase dbSimon;
    String instrSQL;


    Button botonPararMusica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.simon = new BDSimon(this.getApplicationContext(), "Player", null, 1);

        rl = (RelativeLayout) findViewById(R.id.mainActivity);

        botonPararMusica = (Button) findViewById(R.id.buttonPararMusica);

        Bundle bundle = this.getIntent().getExtras();
        StringBuilder s = new StringBuilder();


        if(bundle != null) {
            textViewNombre = (TextView) findViewById(R.id.nombreid);

            s.append("Nombre: " + bundle.get("edittext") + "\n");
            textViewNombre.setText(s.toString());

            if (bundle.getBoolean("rb1")) {
                rl.setBackgroundResource(R.drawable.fondo1);
            }

            if (bundle.getBoolean("rb2")) {
                rl.setBackgroundResource(R.drawable.fondo2);
            }

            if (bundle.getBoolean("rb3")) {
                rl.setBackgroundResource(R.drawable.fondo3);
            }


            if(bundle.getBoolean("rb4")){
                /*startService(new Intent(MainActivity.this,
                        ServicioMusica.class));*/

                Intent intent2 = new Intent(this,
                        ServicioMusica.class);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("uno", true);

                intent2.putExtras(bundle2);
                startService(intent2);
                //this.finish();

            }

            if(bundle.getBoolean("rb5")){
                //rl.setBackgroundResource(R.drawable.fondo2);
                Intent intent3 = new Intent(this,
                        ServicioMusica.class);
                Bundle bundle3 = new Bundle();
                bundle3.putBoolean("dos", true);

                intent3.putExtras(bundle3);
                startService(intent3);
            }

            if(bundle.getBoolean("rb6")){
                //rl.setBackgroundResource(R.drawable.fondo3);
                Intent intent4 = new Intent(this,
                        ServicioMusica.class);
                Bundle bundle4 = new Bundle();
                bundle4.putBoolean("tres", true);

                intent4.putExtras(bundle4);
                startService(intent4);
            }

        }





        tvPuntos = (TextView) findViewById(R.id.tvPuntos);
        tvPuntuacio = (TextView) findViewById(R.id.tvPuntuacio);

        ibPlay = (ImageView) findViewById(R.id.ibPlay);
        ibAzul = (ImageView) findViewById(R.id.ibAzul);
        ibAmarillo = (ImageView) findViewById(R.id.ibAmarillo);
        ibVerde = (ImageView) findViewById(R.id.ibVerde);
        ibRojo = (ImageView) findViewById(R.id.ibRojo);


        createSoundPool();
        sonAzul = soundPool.load(this, R.raw.sounds_01, 1);
        sonVerde = soundPool.load(this, R.raw.sounds_02, 1);
        sonRojo = soundPool.load(this, R.raw.sounds_03, 1);
        sonAmarillo = soundPool.load(this, R.raw.sounds_04, 1);
        sonError = soundPool.load(this, R.raw.error, 1);


        playListener();
        ibPlay.setOnClickListener(playListener);

        botonPararMusica.setOnClickListener(playListener);

        ibRojo.setOnClickListener(listenerColor);
        ibVerde.setOnClickListener(listenerColor);
        ibAmarillo.setOnClickListener(listenerColor);
        ibAzul.setOnClickListener(listenerColor);

    }

    private void insertarRegistre(String nom, Integer puntuacion) {
        this.dbSimon = this.simon.getWritableDatabase();

        if (this.dbSimon != null) {
            this.dbSimon.execSQL("INSERT INTO Jugador (Nombre, Puntuacion) VALUES ('" + nom + "','" + puntuacion + "')");
            Toast.makeText(getApplicationContext(), "Registro grabado", Toast.LENGTH_LONG).show();
        }

        this.dbSimon.close();
    }


    private void consultar()
    {
        Cursor c;

        //Abrir para leer.
        this.dbSimon = this.simon.getReadableDatabase();

        c = this.dbSimon.rawQuery("SELECT * FROM Jugador", null);

        //c.getCount()

        //Detectar si hay registros y nos movemos al 1?.
        if (c.moveToFirst())
        {
            do
            {
                int pk = c.getInt(0);
                String nombre = c.getString(1);
                int pts = c.getInt(2);

                Toast.makeText(getApplicationContext(), pk + " - " + nombre + " pts: " + pts, Toast.LENGTH_LONG).show();
            } while (c.moveToNext());

            c.close();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No hay registros", Toast.LENGTH_LONG).show();
        }

        this.dbSimon.close();
    }


    /**
     * Afegeix un so a la llista de tiradesMaquina i
     * reproduim els sons de la màquina, quan acaba cedim el torn al jugador
     */
    public void reprodueixSonsMaquina() {
        tiradesMaquina.add(azar());
        // activarem el torn del jugador quan acabi de sonar la màquina.
        // Per fer això creem un Handler amb delay
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // es a dir, li toca al jugador quan hagi acabat de reproduir la màquina
                tornJugador = true;
                // buidem la llista per a que comenci a llençar el jugador
                tiradesJugador.clear();
            }
        }, tiradesMaquina.size() * duracion * 2);
        // fem que llenci la màquina
        for (int i = 0; i < tiradesMaquina.size(); i++) {
            tornJugador = false;
            final int valorTirada = tiradesMaquina.get(i).intValue();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    switch(valorTirada) {
                        case 0:
                            azul();
                            break;
                        case 1:
                            rojo();
                            break;
                        case 2:
                            verde();
                            break;
                        case 3:
                            amarillo();
                            break;
                    }
                }
            }, duracion * i * 2);
        }
    }


    /**
     * Exemple de So pel Blue il·luminant una estona el botó
     */
    public void azul() {
        ibAzul.setImageResource(R.drawable.blueimglight);
        if (jugando)
            //sp.play(soundID, leftVolume, rightVolume, priority, loop, rate);
            soundPool.play(sonAzul, 1, 1, 0, 0, 1);
        try {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ibAzul.setImageResource(R.drawable.blueimg);
                }
            }, duracion);
        } catch (Exception e) {
            Log.i("Error azul()",e.toString());
        }
    }

    /**
     * Exemple de So pel Yellow il·luminant una estona el botó
     */
    public void amarillo() {
        ibAmarillo.setImageResource(R.drawable.yellowimglight);
        if (jugando)
            //sp.play(soundID, leftVolume, rightVolume, priority, loop, rate);
            soundPool.play(sonAmarillo, 1, 1, 0, 0, 1);
        try {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ibAmarillo.setImageResource(R.drawable.yellowimg);
                }
            }, duracion);
        } catch (Exception e) {
            Log.i("Error amarillo()",e.toString());
        }
    }

    /**
     * Exemple de So pel Red il·luminant una estona el botó
     */
    public void rojo() {
        ibRojo.setImageResource(R.drawable.redimglight);
        if (jugando)
            //sp.play(soundID, leftVolume, rightVolume, priority, loop, rate);
            soundPool.play(sonRojo, 1, 1, 0, 0, 1);
        try {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ibRojo.setImageResource(R.drawable.redimg);
                }
            }, duracion);
        } catch (Exception e) {
            Log.i("Error rojo()",e.toString());
        }
    }

    /**
     * Exemple de So pel Green il·luminant una estona el botó
     */
    public void verde() {
        ibVerde.setImageResource(R.drawable.greenimglight);
        if (jugando)
            //sp.play(soundID, leftVolume, rightVolume, priority, loop, rate);
            soundPool.play(sonVerde, 1, 1, 0, 0, 1);
        try {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ibVerde.setImageResource(R.drawable.greenimg);
                }
            }, duracion);
        } catch (Exception e) {
            Log.i("Error verde()",e.toString());
        }
    }


    /**
     * Calculate a random value
     *
     * @return random value between 0 and 3
     */
    public int azar() {
        Random rnd = new Random();
        int random = (int) rnd.nextInt(4);
        return random;
    }

    public void playListener() {
        playListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.ibPlay:

                        reprodueixSonsMaquina();
                        ibPlay.setVisibility(View.INVISIBLE);
                        tvPuntuacio.setVisibility(View.VISIBLE);
                        tvPuntos.setVisibility(View.VISIBLE);
                        break;
                    case R.id.buttonPararMusica:
                        stopService(new Intent(MainActivity.this,
                                ServicioMusica.class));
                        break;
                }
            }
        };
    }

    View.OnClickListener listenerColor = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tornJugador == true && jugando == true) {
                if (v.getId() == R.id.ibAzul) {
                    azul();
                    tiradesJugador.add(0);
                } else if (v.getId() == R.id.ibRojo) {
                    rojo();
                    tiradesJugador.add(1);
                } else if (v.getId() == R.id.ibVerde) {
                    verde();
                    tiradesJugador.add(2);
                } else if (v.getId() == R.id.ibAmarillo) {
                    amarillo();
                    tiradesJugador.add(3);
                }
                comprovatirada();
            }
        }
    };

    public void comprovatirada() {
        Handler handler = new Handler();
        // si falla la tirada
        if (tiradesJugador.get(tirada).intValue() != tiradesMaquina.get(tirada)
                .intValue()) {
            jugando = false; // para controlar el boton de play
            int punt = Integer.parseInt(tvPuntos.getText().toString());
            insertarRegistre(textViewNombre.getText().toString(), punt);
            consultar();
            Toast.makeText(this, textViewNombre.getText() + "" + tvPuntos.getText()+ "" + tvPuntuacio.getText().toString() , Toast.LENGTH_LONG).show();
            error();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ibPlay.setVisibility(View.VISIBLE);
                    tvPuntuacio.setVisibility(View.INVISIBLE);
                    tvPuntos.setVisibility(View.INVISIBLE);
                }
            }, 1000);
            tiradesMaquina.clear();
            tiradesJugador.clear();
            tirada = 0;
            // que vuelva a tirar la maquina 1 segundo despues si he completado aciertos
        } else if (tiradesJugador.size() == tiradesMaquina.size() && jugando == true) {
            tornJugador = false; // para controlar los onclick
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvPuntos.setText("" + (tiradesMaquina.size() + 1));
                    reprodueixSonsMaquina();
                    tirada = 0;
                }
            }, 1000);
        } else {
            tirada++;
        }
    }

    /**
     * Para que al equivocarse se pueda volver a jugar
     */
    private void error() {
        soundPool.play(sonError, 1, 1, 0, 0,1);
        jugando = true;
        tvPuntos.setText("1");
    }

    /**
     * How to use SoundPool on all API levels
     */
    protected void createSoundPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool();
        } else {
            createOldSoundPool();
        }
    }

    /**
     * How to use SoundPool on all API levels
     */
    protected void createSoundVISIBLEPool() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            createNewSoundPool();
        } else {
            createOldSoundPool();
        }
    }
    /**
     * Create SoundPool for versions >= LOLLIPOP
     */
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    /**
     * Create SoundPool for deprecated versions < LOLLIPOP
     */
    @SuppressWarnings("deprecation")
    protected void createOldSoundPool() {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
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
                        MainActivity.this.finish();
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


