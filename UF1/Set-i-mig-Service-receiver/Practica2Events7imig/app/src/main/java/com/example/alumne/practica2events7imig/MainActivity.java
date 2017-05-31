package com.example.alumne.practica2events7imig;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    final static int CONF_ACTIVITY = 1;
    final static int JUGAR_ACTIVITY = 2;
    final static int SORTIR = 3;

    Carta cartas[] = new Carta[8];

    ImageView imageView;
    TextView textViewNombre;

    OnClickListener listener;

    int total;
    TextView textTotalCifra;
    int utils=0;

    RelativeLayout rl;

    TextView crono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rl = (RelativeLayout) findViewById(R.id.mainActivity);

        crono = (TextView) findViewById(R.id.textViewCrono);

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

        iniciarCronometro();

        Cronometro.setUpdateListener(this);

    }

    //mètode que inicia les cartes amb el seu valor. les inicia ocules
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

    //metode que gira les cartes
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

    //mètode per crear la notificació quan es pari el cronòmetre
    private void notificacion(){
        NotificationManager nManager = (NotificationManager) getSystemService(getApplicationContext().NOTIFICATION_SERVICE);

        android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(
                getBaseContext())
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Tiempo final")
                .setContentText(crono.getText());

        //Crear un intent especificando que realizará
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        //Crear del PendingIntent pasando el intent que se realizará, obligatorio usar método para obtener activity’s (getactivity)
        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pi);
        nManager.notify(1, builder.build());
    }

    //mètode que comproba que s'ha fet el 7.5, o que s'ha passat
    private int comprobar7iMedio() {
        if (total == 7.5){
            pararCronometro();
            notificacion();
            textTotalCifra.setText("7.5!!!! CONSEGUIDOOOO!!!");
            return 1;
        }else if (total>7.5){
            pararCronometro();
            notificacion();
            textTotalCifra.setText("Puntuación " + String.valueOf(total)+" TE PASASTE!!!");
            return -1;
        }else if(utils == 0){
            textTotalCifra.setText("Puntuación " + String.valueOf(total));
            return -1;
        }else{
            return 0;
        }
    }

    //menu option que apareix a dalt amb 3 opcions
    public boolean onCreateOptionsMenu(Menu menu) {
        // The add() method used in this sample takes four arguments:
        // groupId, itemId, order, and title.
        menu.add(0, CONF_ACTIVITY, 0, "Configuració");
        menu.add(0, JUGAR_ACTIVITY, 0, "Jugar");
        menu.add(0, SORTIR, 0, "Sortir");
        return true;
    }

    //menu option segons quina opció s'ha triat redirigeix a un activity o un altre
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case CONF_ACTIVITY:
               /* Toast.makeText(
                        InicialActivity.this,
                        "Conf" , Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(MainActivity.this,
                        ConfiguracioActivity.class));
                return true;
            case JUGAR_ACTIVITY:
                /*Toast.makeText(
                        InicialActivity.this,
                        "Jugar" , Toast.LENGTH_LONG).show();*/
                startActivity(new Intent(MainActivity.this,
                        MainActivity.class));
                return true;
            case SORTIR:
                /*Toast.makeText(
                        InicialActivity.this,
                        "sortir" , Toast.LENGTH_LONG).show();*/
                sortirAplicació();
                return true;
        }
        return false;
    }

    //mètode que executa una alerta i dona l'opció de si es vol sortir o no
    public void sortirAplicació(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Set i Mig");
        builder.setMessage("Vols sortir de l'aplicació?")
                .setCancelable(false)//si pones true al clicar fuera del cuadro, el cuadro se quita
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


    /**
     * Inicia el servicio
     */
    private void iniciarCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        startService(service);
    }

    /**
     * Finaliza el servicio
     */
    private void pararCronometro() {
        Intent service = new Intent(this, Cronometro.class);
        stopService(service);
        Toast.makeText(getApplicationContext(),"la cuenta final es "+crono.getText(),Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        // Antes de cerrar la aplicacion se para el servicio
        // ya que el servicio está asociado a está activity y necesita utilizat los métodos que implementa
        pararCronometro();
        super.onDestroy();
        finish();
    }
    /**
     * Actualiza en la UI el tiempo que se cronometra, la llamada se realiza en el servicio
     *
     * @param tiempo
     */
    public void actualizarCronometro(double tiempo) {
        crono.setText(String.format("%.2f", tiempo) + "s");
    }
}