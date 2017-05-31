package com.example.alumne.pilotes;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alumne on 27/04/17.
 */

public class Rectangle extends Shape {

    int x2;
    int y2;

    public Rectangle(int x, int y, int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }


    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void mou() {
        this.setY(getY() + getVelocitatY());
        this.setX(getX() + getVelocitatX());
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawRect(x, y, x2, y2, getEstil());
    }
}
