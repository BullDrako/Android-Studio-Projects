package com.example.alumne.cerclemoviment;

/**
 * Created by alumne on 4/05/17.
 */

public class ShapeFactory {
    public ShapeFactory(){}

    public Shape getCercle(float radi){
        return new Cercle(radi);
    }

    /*public Shape getRectangle(float x, float y){
        return new Rectangle(x,y);
    }

    public Shape getText(String text){
        return new Text(text);
    }*/
}
