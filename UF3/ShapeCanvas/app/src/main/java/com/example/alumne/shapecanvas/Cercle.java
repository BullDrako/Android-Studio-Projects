package com.example.alumne.shapecanvas;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alumne on 27/04/17.
 */

public class Cercle extends Shape {

    float radi;

    public Cercle(){

    }

    public Cercle(int x, int y, Paint paint, float radi) {
        super(x, y, paint);
        this.radi = radi;
    }

    public float getRadi() {
        return radi;
    }

    public void setRadi(float radi) {
        this.radi = radi;
    }


   /* public int getX() {
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

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }*/

    @Override
    void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawCircle(x, y, radi, paint);
    }
}
