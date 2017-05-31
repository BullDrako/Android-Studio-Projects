package com.example.alumne.cerclemoviment;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alumne on 27/04/17.
 */

public class Cercle extends Shape {

    float radi;


    public Cercle(){

    }

    public Cercle(float radi){
        this.radi = radi;
    }


    public float getRadi() {
        return radi;
    }

    public void setRadi(float radi) {
        this.radi = radi;
    }


    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getX(), getY(), getRadi(), getPaint());
    }

    @Override
    public void mou(Canvas canvas) {
        canvas.translate(getX(), getY());
    }



}
