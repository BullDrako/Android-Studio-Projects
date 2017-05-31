package com.example.alumne.triler;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    int rnd;
    ImageView cube1;
    ImageView cube2;
    ImageView cube3;
    TextView txt;
    TextView txt2;
    Button b;
    ImageView imagenFondo;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
       // imagenFondo.setImageResource(R.drawable.fondo);
        generaLayout();
        prepareListener();

        cube1.setOnClickListener(listener);
        cube2.setOnClickListener(listener);
        cube3.setOnClickListener(listener);
        b.setOnClickListener(listener);

    }

    private void generaLayout(){

        LinearLayout principal = new LinearLayout(this);
        principal.setOrientation(LinearLayout.VERTICAL);
        principal.setBackgroundColor(Color.GRAY);

        //Create parameters of layout
        LinearLayout.LayoutParams paramLayout =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout.LayoutParams paramObject =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams paramSecondLayout =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(360, 360);

        //Create objects
        b = new Button(this);
        b.setGravity(Gravity.CENTER);
        b.setText("Start the Game");


        txt = new TextView(this);
        txt.setText("Guess the little ball");

        txt2 = new TextView(this);
        txt2.setText("Second TextView");


        //Add objects to layout
        //añade el primer TextView
        principal.addView(txt, paramObject);


        //Create second layout
        LinearLayout secondLayout = new LinearLayout(principal.getContext()); //incluir el segundo layout al primero
        secondLayout.setOrientation(LinearLayout.HORIZONTAL);

        //Objetcs of Second Layout
       cube1 = new ImageView(secondLayout.getContext());
        cube1.setImageResource(R.drawable.cubilete);
        //cube1.setLayoutParams(layoutParams);
        secondLayout.addView(cube1, layoutParams);

        cube2 = new ImageView(secondLayout.getContext());
        cube2.setImageResource(R.drawable.cubilete);
       // cube2.setLayoutParams(layoutParams);
        secondLayout.addView(cube2, layoutParams);

        cube3 = new ImageView(secondLayout.getContext());
        cube3.setImageResource(R.drawable.cubilete);
        //cube3.setLayoutParams(layoutParams);
        secondLayout.addView(cube3, layoutParams);

       /*No va bien
       //Modify size of ImageView
        cube1.requestLayout();// fa un refres del layout
        // get and change params height and width
        cube1.getLayoutParams().height = 150;
        cube1.getLayoutParams().width = 150;
        //scaled type
        cube1.setScaleType(ImageView.ScaleType.FIT_XY);
        */


        //afegir segon layout al primer
        principal.addView(secondLayout, paramSecondLayout);
        //Show main layout
        setContentView(principal, paramLayout);

        //añade boton
        principal.addView(b, paramObject);

        //añade segundo textview
        principal.addView(txt2, paramObject);

    }

    private void prepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (view.getId() == b.getId()){
                    reinicia();
                }

                if (view.getId() == cube1.getId()){
                    if (rnd == 1){
                        cube1.setImageResource(R.drawable.levantaok);
                        txt2.setText("You are the winner!!");
                    }else{
                        cube1.setImageResource(R.drawable.levantako);
                        txt2.setText("You've lost!!");
                    }
                }

                if (view.getId() == cube2.getId()){
                    if (rnd == 2){
                        cube2.setImageResource(R.drawable.levantaok);
                        txt2.setText("You are the winner!!");
                    }else{
                        cube2.setImageResource(R.drawable.levantako);
                        txt2.setText("You've lost!!");
                    }
                }

                if (view.getId() == cube3.getId()){
                    if (rnd == 3){
                        cube3.setImageResource(R.drawable.levantaok);
                        txt2.setText("You are the winner!!");
                    }else{
                        cube3.setImageResource(R.drawable.levantako);
                        txt2.setText("You've lost!!");
                    }
                }

            }
        };
    }

    public void reinicia(){
        cube1.setImageResource(R.drawable.cubilete);
        cube1.setId(1);
        cube2.setImageResource(R.drawable.cubilete);
        cube2.setId(2);
        cube3.setImageResource(R.drawable.cubilete);
        cube3.setId(3);
        txt.setText("Guess the little ball");
        b.setId(4);
        calcularRandom();
    }

    public void calcularRandom(){
        Random r = new Random();
        rnd = r.nextInt(3)+1;
    }
}
