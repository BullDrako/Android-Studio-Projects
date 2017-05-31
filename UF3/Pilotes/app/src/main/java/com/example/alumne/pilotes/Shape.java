package com.example.alumne.pilotes;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alumne on 4/05/17.
 */

public abstract class Shape {

    boolean Horitzontal;//direccio (dreta = true // esquerra = false)
    boolean Vertical;//direccio (dalt = true // baix = false)
    int velocitatX;//velocitat
    int velocitatY;
    Paint estil;//estil
    int x,y;//posicio
    int limitX, limitY;


    public Shape() {

    }

    public abstract void mou();
    public abstract void onDraw(Canvas canvas);

    public boolean isHoritzontal() {
        return Horitzontal;
    }

    public void setHoritzontal(boolean horitzontal) {
        Horitzontal = horitzontal;
    }

    public boolean isVertical() {
        return Vertical;
    }

    public void setVertical(boolean vertical) {
        Vertical = vertical;
    }

    public int getVelocitatX() {
        return velocitatX;
    }

    public void setVelocitatX(int velocitatX) {
        this.velocitatX = velocitatX;
    }

    public int getVelocitatY() {
        return velocitatY;
    }

    public void setVelocitatY(int velocitatY) {
        this.velocitatY = velocitatY;
    }

    public Paint getEstil() {
        return estil;
    }

    public void setEstil(Paint estil) {
        this.estil = estil;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLimitY() {
        return limitY;
    }

    public void setLimitY(int limitY) {
        this.limitY = limitY;
    }

    public int getLimitX() {
        return limitX;
    }

    public void setLimitX(int limitX) {
        this.limitX = limitX;
    }

}

