package com.example.alumne.examen1edgarcabeza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alumne on 15/12/16.
 */
public class JocActivity extends Activity {

    View.OnClickListener listener;

    TextView textViewNivel;

    ImageView imageView;

    Carta cartas[] = new Carta[8];

    Button conf;
    Button restart;
    Button sortir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);

        conf = (Button) findViewById(R.id.button_conf);
        restart = (Button) findViewById(R.id.button_restart);
        sortir = (Button) findViewById(R.id.button_sortir);

        Bundle bundle = this.getIntent().getExtras();
        StringBuilder s = new StringBuilder();


        if (bundle != null) {
            textViewNivel = (TextView) findViewById(R.id.textViewNivel);


            s.append("Nivel: " + bundle.get("textview") + "\n");
            textViewNivel.setText(s.toString());


        }

        initCards();

        prepareListener();
        conf.setOnClickListener(listener);
        restart.setOnClickListener(listener);
        sortir.setOnClickListener(listener);

        //for
        for (int i = 0; i < cartas.length; i++) {
            imageView = (ImageView) findViewById(cartas[i].getIdImatgeView());
            imageView.setOnClickListener(listener);
        }


    }


    private void initCards() {
        cartas[0] = new Carta(false, R.id.back1, R.drawable.chiquito, 1);
        cartas[1] = new Carta(false, R.id.back2, R.drawable.chiquito, 1);
        cartas[2] = new Carta(false, R.id.back3, R.drawable.eugenio, 2);
        cartas[3] = new Carta(false, R.id.back4, R.drawable.eugenio, 2);
        cartas[4] = new Carta(false, R.id.back5, R.drawable.faemino, 3);
        cartas[5] = new Carta(false, R.id.back6, R.drawable.faemino, 3);
        cartas[6] = new Carta(false, R.id.back7, R.drawable.rubianes, 4);
        cartas[7] = new Carta(false, R.id.back8, R.drawable.rubianes, 4);


    }

    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()) {
                    case R.id.button_conf:
                        callConfActivity();
                        break;

                    case R.id.button_sortir:
                        sortir();
                        break;

                    case R.id.button_restart:
                        //onRestart();
                        restart();
                        break;

                    case R.id.back1:
                        cambioCarta(0);


                        break;
                    case R.id.back2:
                        cambioCarta(1);


                        break;
                    case R.id.back3:
                        cambioCarta(2);


                        break;
                    case R.id.back4:
                        cambioCarta(3);


                        break;
                    case R.id.back5:
                        cambioCarta(4);


                        break;
                    case R.id.back6:
                        cambioCarta(5);


                        break;
                    case R.id.back7:
                        cambioCarta(6);


                        break;
                    case R.id.back8:
                        cambioCarta(7);


                        break;
                }
            }
        };
    }

    private void cambioCarta(int pos) {

        if (!cartas[pos].isVisible()) {

            imageView = (ImageView) findViewById(cartas[pos].getIdImatgeView());
            imageView.setImageResource(cartas[pos].getIdDrawable());
            cartas[pos].setVisible(true);

        } else {
            imageView = (ImageView) findViewById(cartas[pos].getIdImatgeView());
            imageView.setImageResource(R.drawable.back);
            cartas[pos].setVisible(false);
        }
    }

    private void showMessage(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void callConfActivity() {
        Intent intent = new Intent(this,
                ConfigActivity.class);
        Bundle bundle = new Bundle();

        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }

    //public void onRestart(){
        /*super.onRestart();
        setContentView(R.layout.activity_joc);*/
    public void restart(){
        Intent intent = new Intent(this,
                ConfigActivity.class);
        Bundle bundle = new Bundle();

        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();

    }

    public void sortir() {
        super.finish();
        this.finish();

    }
}
