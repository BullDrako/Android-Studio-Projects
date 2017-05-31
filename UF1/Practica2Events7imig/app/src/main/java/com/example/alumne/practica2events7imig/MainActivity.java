package com.example.alumne.practica2events7imig;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    Carta cartas[] = new Carta[8];

    ImageView imageView;


    TextView textViewNombre;


    OnClickListener listener;

    int total;
    TextView textTotalCifra;
    int utils=0;

    RelativeLayout rl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.mainActivity);

        Bundle bundle = this.getIntent().getExtras();
        StringBuilder s = new StringBuilder();


        if(bundle != null) {
            textViewNombre = (TextView) findViewById(R.id.nombreid);

            s.append("Nombre: " + bundle.get("edittext") + "\n");
            textViewNombre.setText(s.toString());

            if(bundle.getBoolean("cb1")){
                rl.setBackgroundResource(R.drawable.fondo1);
            }

            if(bundle.getBoolean("cb2")){
                rl.setBackgroundResource(R.drawable.fondo2);
            }

            if(bundle.getBoolean("cb3")){
                rl.setBackgroundResource(R.drawable.fondo3);
            }

        }

        textTotalCifra = (TextView) findViewById(R.id.textTotalCifra);

        // llamar a initcards
        initCards();

        prepareListener();

        //for
       for (int i = 0; i < cartas.length; i++ ){
            imageView = (ImageView) findViewById(cartas[i].getIdImatgeView());
            imageView.setOnClickListener(listener);
         }


    }

    private void initCards(){
        cartas[0] = new Carta(false,  R.id.back1, R.drawable.unob, 1); //el uno es el valor de la carta
        cartas[1] = new Carta(false,  R.id.back2, R.drawable.dosy, 2);
        cartas[2] = new Carta(false,  R.id.back3, R.drawable.tresg, 3);
        cartas[3] = new Carta(false,  R.id.back4, R.drawable.cuatror, 4);
        cartas[4] = new Carta(false,  R.id.back5, R.drawable.cincop, 5);
        cartas[5] = new Carta(false,  R.id.back6, R.drawable.unob, 1);
        cartas[6] = new Carta(false,  R.id.back7, R.drawable.dosy, 2);
        cartas[7] = new Carta(false,  R.id.back8, R.drawable.tresg,3);



    }

    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*for (int i = 0; i < cartas.length; i++ ){
                    if(view.getId() == cartas[i].getIdImatgeView());{
                        cambioCarta(i);
                    }

                }*/
                switch (view.getId()) {
                    case R.id.back1://poner id de cartas
                        cambioCarta(0);

                        if(total<7.5 && utils ==0){
                            if(cartas[0].isVisible()){
                                total+=cartas[0].getValor();
                            }else{
                                total-=cartas[0].getValor();
                            }
                        }
                        comprobar7iMedio();
                        textTotalCifra.setText(String.valueOf(total));
                        break;
                    case R.id.back2:
                        cambioCarta(1);

                        if(total<7.5 && utils ==0){
                            if(cartas[1].isVisible()){
                                total+=cartas[1].getValor();
                            }else{
                                total-=cartas[1].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                    case R.id.back3:
                        cambioCarta(2);

                        if(total<7.5 && utils ==0){
                            if(cartas[2].isVisible()){
                                total+=cartas[2].getValor();
                            }else{
                                total-=cartas[2].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                    case R.id.back4:
                        cambioCarta(3);

                        if(total<7.5 && utils ==0){
                            if(cartas[3].isVisible()){
                                total+=cartas[3].getValor();
                            }else{
                                total-=cartas[3].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                    case R.id.back5:
                        cambioCarta(4);

                        if(total<7.5 && utils ==0){
                            if(cartas[4].isVisible()){
                                total+=cartas[4].getValor();
                            }else{
                                total-=cartas[4].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                    case R.id.back6:
                        cambioCarta(5);

                        if(total<7.5 && utils ==0){
                            if(cartas[5].isVisible()){
                                total+=cartas[5].getValor();
                            }else{
                                total-=cartas[5].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                    case R.id.back7:
                        cambioCarta(6);

                        if(total<7.5 && utils ==0){
                            if(cartas[6].isVisible()){
                                total+=cartas[6].getValor();
                            }else{
                                total-=cartas[6].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                    case R.id.back8:
                        cambioCarta(7);

                        if(total<7.5 && utils ==0){
                            if(cartas[7].isVisible()){
                                total+=cartas[7].getValor();
                            }else{
                                total-=cartas[7].getValor();
                            }
                        }
                        textTotalCifra.setText(String.valueOf(total));
                        comprobar7iMedio();
                        break;
                }
            }
        };
    }

    private void cambioCarta(int pos){

        if(!cartas[pos].isVisible()) {

            imageView = (ImageView) findViewById(cartas[pos].getIdImatgeView());
            imageView.setImageResource(cartas[pos].getIdDrawable());
            cartas[pos].setVisible(true);
        }
        else{
            imageView = (ImageView) findViewById(cartas[pos].getIdImatgeView());
            imageView.setImageResource(R.drawable.back);
            cartas[pos].setVisible(false);
        }
    }

    private int comprobar7iMedio() {
        if (total == 7.5){
            textTotalCifra.setText("7.5!!!! CONSEGUIDOOOO!!!");
            return 1;
        }else if (total>7.5){
            textTotalCifra.setText("Puntuación " + String.valueOf(total)+" TE PASASTE!!!");
            return -1;
        }else if(utils == 0){
            textTotalCifra.setText("Puntuación " + String.valueOf(total));
            return -1;
        }else{
            return 0;
        }
    }
}