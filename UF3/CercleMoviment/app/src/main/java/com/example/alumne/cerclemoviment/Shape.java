package com.example.alumne.cerclemoviment;

/**
 * Created by alumne on 27/04/17.
 */

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape {

    private int x;
    private int y;
    private Paint paint;

    private boolean direccioHoritzontal;
    private boolean direccioVertical;
    private int velocitat;

    public Shape(){

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

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public boolean getDireccioHoritzontal() {
        return direccioHoritzontal;
    }

    public void setDireccioHoritzontal(boolean direccioHoritzontal) {
        this.direccioHoritzontal = direccioHoritzontal;
    }

    public boolean getDireccioVertical() {
        return direccioVertical;
    }

    public void setDireccioVertical(boolean direccioVertical) {
        this.direccioVertical = direccioVertical;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public abstract void onDraw(Canvas canvas);

    public abstract void mou(Canvas canvas);

}
