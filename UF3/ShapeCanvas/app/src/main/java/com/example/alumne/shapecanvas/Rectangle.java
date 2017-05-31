package com.example.alumne.shapecanvas;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alumne on 27/04/17.
 */

public class Rectangle extends Shape {

    int x2;
    int y2;

    public Rectangle() {

    }

    public Rectangle(int x, int y, Paint paint, int x2, int y2) {
        super(x, y, paint);
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
    void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawRect(x, x2, y, y2, paint);
    }
}
