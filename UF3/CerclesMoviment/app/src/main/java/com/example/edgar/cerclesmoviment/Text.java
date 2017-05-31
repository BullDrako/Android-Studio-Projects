package com.example.edgar.cerclesmoviment;

import android.graphics.Canvas;

/**
 * Created by alumne on 27/04/17.
 */

public class Text extends Shape {

    //setSize
    int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Text(int size) {
        this.size = size;
    }

    @Override
    public void mou() {
        this.setY(getY() + getVelocitatY());
        this.setX(getX() + getVelocitatX());
    }

    @Override
    public void onDraw(Canvas canvas) {
        String string = "";
        canvas.drawText(string, x, y, getEstil());
    }

}
