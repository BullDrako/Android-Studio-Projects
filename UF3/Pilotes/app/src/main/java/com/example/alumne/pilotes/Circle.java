package com.example.alumne.pilotes;

import android.graphics.Canvas;

/**
 * Created by alumne on 4/05/17.
 */

public class Circle extends Shape {

    int radi;



    public Circle(int radi) {
        this.radi = radi;
    }


    public void mou(){//int x,int y

      /* int x2 = x + getVelocitat();
       int y2 = y + getVelocitat();*/

       this.setY(getY() + getVelocitatY());
       this.setX(getX() + getVelocitatX());

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getX(),getY(),radi,getEstil());
    }


}
