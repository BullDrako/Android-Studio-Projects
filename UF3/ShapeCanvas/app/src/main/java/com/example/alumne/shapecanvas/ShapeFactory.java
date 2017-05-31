package com.example.alumne.shapecanvas;

/**
 * Created by alumne on 4/05/17.
 */

public class ShapeFactory  {

    public ShapeFactory(){}

    public Shape getCircle(float rd){
        return new Cercle(rd);
    }

    public Shape getRectangle(int x, int y){
        return new Rectangle(x,y);
    }

    public Shape getText(String text){
        return new Text(text);
    }
}

