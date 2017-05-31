package com.example.edgar.cerclesmoviment;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Edgar on 19/05/2017.
 */

public class Grafic extends Shape {

    Bitmap bmp;
    int width;
    int height;

    public Grafic(Bitmap bmp, int width, int height) {
        this.bmp = bmp;
        this.width = width;
        this.height = height;
    }

    @Override
    public void mou() {
        this.setY(getY() + getVelocitatY());
        this.setX(getX() + getVelocitatX());
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(bmp, width, height, getEstil());
    }
}
