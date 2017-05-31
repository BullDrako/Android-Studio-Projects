package com.example.alumne.shapecanvas;

/**
 * Created by alumne on 27/04/17.
 */

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

public abstract class Shape {

    int x;
    int y;
    Paint paint;

    public Shape(){

    }

    public Shape(int x, int y, Paint paint){
        this.x = x;
        this.y = y;
        this.paint = paint;
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

    void draw(Canvas canvas) {

    }
}
