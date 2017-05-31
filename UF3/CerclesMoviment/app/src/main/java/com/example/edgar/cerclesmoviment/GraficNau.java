package com.example.edgar.cerclesmoviment;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by alumne on 11/05/17.
 */

public class GraficNau extends Shape{

    private Drawable drawable;   //Imatge que dibuixarem
    private View view;
    private int ampleImg, altImg;     //Dimensions de l'imatge

    private double posX, posY;   //Posició de la Nau al layout (vista)

    // Posició de la Nau a la VISTA
    public void setPosX(double v) {
        this.posX=v;
    }
    public void setPosY(double v) {
        this.posY=v;
    }
    public double getPosX() {
        return this.posX;
    }
    public double getPosY() {
        return this.posY;
    }

    public GraficNau(View viewParam,Drawable drawableNau){
        this.view = viewParam;
        this.drawable = drawableNau;

        // Agafem l'ample i l'alt de la imatge
        this.ampleImg = drawable.getIntrinsicWidth();
        this.altImg = drawable.getIntrinsicHeight();

        // Posició de la nau a la vista inical
        this.x = this.ampleImg + 5;
        this.y = this.altImg + 5;
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.save();

        // definim el rectangle on posicionarem la nau
        drawable.setBounds((int)x, (int)y, (int)x + ampleImg, (int)y + altImg);
        drawable.draw(canvas);
        canvas.restore();
        // Forcem a  que dibuixi el rectangle de la Vista que indiquem
        view.invalidate((int)x, (int)y, (int)x+ampleImg, (int)y+altImg);

    }


    public void mou(){//int x,int y

      /* int x2 = x + getVelocitat();
       int y2 = y + getVelocitat();*/

        this.setY(getY() + getVelocitatY());
        this.setX(getX() + getVelocitatX());

    }




}