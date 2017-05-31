package com.example.alumne.exemplecanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by alumne on 27/04/17.
 */

public class ExempleView extends View {
    public boolean cercleblau = true;

    public ExempleView (Context context) {
        super(context);
    }

    public ExempleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //Dibuixar aquí
        if(cercleblau) {
            cercleblau = false;
            PintaCercleBlau(canvas);
        } else{
            PintaCercleVerd(canvas);
            cercleblau = true;
        }
        PintaQuadrat(canvas);
        PintaCercleOmplert(canvas);
        PintaCercleContorn(canvas);
        PintaText(canvas);
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
}
