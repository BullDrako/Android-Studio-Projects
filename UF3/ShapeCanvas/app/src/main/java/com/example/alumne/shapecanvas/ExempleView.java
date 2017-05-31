package com.example.alumne.shapecanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alumne on 27/04/17.
 */

public class ExempleView extends View {

    //arraylist de shapes
    /*
    * Metode generaShapes()->afegir shapes a l'arraylist
    *
    * draw(canvas)->recorrer la llista i obtenir Shape i cridar a daw();
    *
    * */

    ArrayList<Shape> shapes = new ArrayList<Shape>();


    public ExempleView(Context context) {
        super(context);
    }

    public ExempleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Dibuixar aquí

       /* PintaQuadrat(canvas);
        PintaCercleOmplert(canvas);
        PintaCercleContorn(canvas);
        PintaText(canvas);*/
        Cercle(canvas);
    }

    public void PintaCercleBlau(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(100, 100, 50, pincel);

    }

    public void PintaCercleVerd(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(300, 300, 50, pincel);

    }

    public void PintaQuadrat(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.RED);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        //canvas.drawRect(10, 50, 70, 110, pincel);
        canvas.drawRect(10, 50, 70, 110, pincel);

    }

    public void PintaText(Canvas canvas) {

        Paint pincel =  new Paint();
        pincel.setColor(Color.BLACK);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setTextSize(80);
        canvas.drawText("Texto", 400, 200, pincel);

    }

    public void PintaCercleContorn(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(10);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(600, 500, 70, pincel);


    }

    public void PintaCercleOmplert(Canvas canvas) {

        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setStyle(Paint.Style.FILL);
        canvas.drawCircle(600, 900, 70, pincel);

    }

    public void generarShapes(Shape shape){
        shapes.add(shape);
        //Toast.makeText(getContext(),  shapes.size() , Toast.LENGTH_LONG).show();

    }

    public void Cercle(Canvas canvas){
        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(10);
        pincel.setStyle(Paint.Style.STROKE);

        Shape shape1= new Cercle(300, 400, pincel, 50);
        Shape shape2= new Cercle(400, 500, pincel, 10);
        shape1.draw(canvas);
        shape2.draw(canvas);
        generarShapes(shape1);
       // generarShapes(shape2);


    }



}
