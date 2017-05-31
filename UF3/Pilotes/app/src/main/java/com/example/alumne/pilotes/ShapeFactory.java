package com.example.alumne.pilotes;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by Edgar on 15/05/2017.
 */

public class ShapeFactory {

    public ShapeFactory(){}

    public Shape getCircle(int rd){
        return new Circle(rd);
    }

    public Shape getRectangle(int x, int y, int x2, int y2){
        return new Rectangle(x, y, x2, y2);
    }

    public Shape getGraficNau(View v, Drawable d){
        return new GraficNau(v, d);
    }

    public Shape getGrafic(Bitmap bmp, int width, int height){
        return  new Grafic(bmp, width, height);
    }


}
