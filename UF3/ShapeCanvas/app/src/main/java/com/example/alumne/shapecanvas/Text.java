package com.example.alumne.shapecanvas;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by alumne on 27/04/17.
 */

public class Text extends Shape {

    //setSize
    int size;

    public Text(){

    }

    public Text(int x, int y, Paint paint, int size) {
        super(x, y, paint);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    void draw(Canvas canvas) {
        super.draw(canvas);
        String string = "";
        canvas.drawText(string, x, y, paint);
    }
}
