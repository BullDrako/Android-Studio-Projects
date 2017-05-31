package com.example.edgar.cerclesmoviment;

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
    int radi;





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

    public int getRadi() {
        return radi;
    }

    public void setRadi(int radi) {
        this.radi = radi;
    }

    public boolean colisio(Shape shape){
        /*int distancia =

        if(distancia<(shape.getRadi() + this.getRadi())){

            return true;

        } else{

            return false;

        }*/

        double distancia = Math.sqrt(Math.pow(shape.getX()-this.getX(),2) + Math.pow(shape.getY() - this.getY(),2));
        if(distancia <=(this.radi + shape.getRadi())){
            return true;
        } else {
            return false;
        }


    }

/*
    public int distancia(int x2, int y2){

        return (int) Math.sqrt((Math.pow(x2-getX(),2)) + (Math.pow(y2-getY(),2)));

    }
*/


    public void canviDireccio(){
         velocitatX = -getVelocitatX();
         velocitatY = -getVelocitatY();
    }

}

