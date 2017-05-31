package com.example.edgar.cerclesmoviment;

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

    /*public boolean colisio(Circle circle){
        double distancia = Math.sqrt(Math.pow(circle.getX()-this.getX(),2) + Math.pow(circle.getY() - this.getY(),2));
        if(distancia <=(this.radi + circle.getRadi())){
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(getX(),getY(),radi,getEstil());
    }


}
