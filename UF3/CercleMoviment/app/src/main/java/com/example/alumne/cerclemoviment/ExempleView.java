package com.example.alumne.cerclemoviment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumne on 27/04/17.
 */

public class ExempleView extends View {


    private List<Shape> shapes;
    ShapeFactory shapeFactory;

    public ExempleView(Context context ) {
        super(context);
        shapes = new ArrayList<>();
        shapeFactory = new ShapeFactory();
        generarShapes();
    }

    public ExempleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        shapes = new ArrayList<>();
        shapeFactory = new ShapeFactory();
        generarShapes();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Shape sh : shapes){
            sh.onDraw(canvas);
            sh.mou(canvas);
        }
    }

    public void generarShapes(){

        Shape sh1 = shapeFactory.getCercle(54);
        sh1.setX(100);
        sh1.setY(200);
        sh1.setPaint(createStyleBlue());
        shapes.add(sh1);

        /*Shape sh2 = shapeFactory.getRectangle(300,300);
        sh2.setX(600);
        sh2.setY(600);
        sh2.setStyle(createStyleBlue());
        shapes.add(sh2);

        Shape sh3 = shapeFactory.getText("Hola");
        sh3.setX(100);
        sh3.setY(300);
        sh3.setStyle(createStyleBlue());
        shapes.add(sh3);*/
    }


    protected void mouObjectes(Canvas canvas){
        //super.onDraw(canvas);
        for(Shape sh : shapes){
            sh.mou(canvas);
        }
    }

    private Paint createStyleBlue(){
        Paint pincel = new Paint();
        pincel.setColor(Color.BLUE);
        pincel.setStrokeWidth(20);
        pincel.setStyle(Paint.Style.STROKE);
        pincel.setTextSize(100);

        return pincel;
    }





}
