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

import java.util.Random;

public class MainActivity extends Activity {

    int rnd;

    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        generaLayout();
        prepareListener();
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
        Button b = new Button(this);
        b.setGravity(Gravity.CENTER);
        b.setText("Start the Game");


        TextView txt = new TextView(this);
        txt.setText("Guess the little ball");

        TextView txt2 = new TextView(this);
        txt2.setText("Second TextView");


        //Add objects to layout
        //añade el primer TextView
        principal.addView(txt, paramObject);


        //Create second layout
        LinearLayout secondLayout = new LinearLayout(principal.getContext()); //incluir el segundo layout al primero
        secondLayout.setOrientation(LinearLayout.HORIZONTAL);

        //Objetcs of Second Layout
        ImageView cube1 = new ImageView(secondLayout.getContext());
        cube1.setImageResource(R.drawable.cubilete);
        //cube1.setLayoutParams(layoutParams);
        secondLayout.addView(cube1, layoutParams);

        ImageView cube2 = new ImageView(secondLayout.getContext());
        cube2.setImageResource(R.drawable.cubilete);
       // cube2.setLayoutParams(layoutParams);
        secondLayout.addView(cube2, layoutParams);

        ImageView cube3 = new ImageView(secondLayout.getContext());
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


            }
        };
    }

    /*public void reinicia(){
        cube1.setImageResource(R.drawable.cubilete);
        cube1.setId(1);
        cube2.setImageResource(R.drawable.cubilete);
        cube2.setId(2);
        cube3.setImageResource(R.drawable.cubilete);
        cube3.setId(3);
        txt.setText("Guess the little ball");
        b.setId(4);
        calcularRandom();
    }*/

    public void calcularRandom(){
        Random r = new Random();
        rnd = r.nextInt(3)+1;


    }
}
