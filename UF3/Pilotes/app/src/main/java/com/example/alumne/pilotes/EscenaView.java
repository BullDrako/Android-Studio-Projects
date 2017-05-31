package com.example.alumne.pilotes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

import static android.R.attr.shape;
import static android.R.attr.thickness;
import static android.R.attr.x;

/**
 * Created by alumne on 4/05/17.
 */

public class EscenaView extends View {

    ArrayList<Shape> list = new ArrayList<>();
    ShapeFactory shapeFactory;

    public int ampleView = 0;
    public int altView = 0;

    Drawable drawableNau;
    GraficNau nau;

   /* Drawable nau2;*/

   /* Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.nau);;
    Bitmap ball;
    int mwidth;
    int mheight;*/

    public EscenaView(Context context) {
        super(context);
        /*bmp = BitmapFactory.decodeResource(getResources(),R.drawable.nau);*/
        shapeFactory = new ShapeFactory();
       // nau = context.getResources().getDrawable(R.drawable.nau);
       // nau2 = context.getResources().getDrawable(R.drawable.nau);
    }

    public EscenaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        shapeFactory = new ShapeFactory();

       drawableNau = context.getResources().getDrawable(R.drawable.nau);
        nau = new GraficNau(this,drawableNau);
    }

    public void generaEscena(){

       Shape sh1 = shapeFactory.getCircle(30);
            sh1.setHoritzontal(true);
            sh1.setVertical(false);
            sh1.setVelocitatX(50);
        sh1.setVelocitatY(50);
            sh1.setX(100);
            sh1.setY(200);
            sh1.setEstil(createStyle());

        list.add(sh1);

        Shape s = shapeFactory.getCircle(10);
        s.setHoritzontal(true);
        s.setVertical(false);
        s.setVelocitatX(50);
        s.setVelocitatY(50);
        s.setX(900);
        s.setY(100);
        s.setEstil(createStyle());
        list.add(s);


      Shape sh2 = shapeFactory.getCircle(20);
        sh2.setHoritzontal(true);
        sh2.setVertical(false);
        sh2.setVelocitatX(20);
        //sh1.setVelocitatY(20);
        sh2.setX(500);
        sh2.setY(800);
        sh2.setEstil(createStyle());
        list.add(sh2);

       /*Shape sh3 = shapeFactory.getGraficNau(this, nau2);
        sh3.setHoritzontal(true);
        sh3.setVertical(false);
        sh3.setVelocitatX(20);
        //sh1.setVelocitatY(20);
        sh3.setX(500);
        sh3.setY(800);
        sh3.setEstil(createStyle());
        list.add(sh3);*/

       Shape na = shapeFactory.getGraficNau(this, drawableNau);
        //na.setHoritzontal(true);
       // na.setVertical(false);
        na.setVelocitatX(20);
        na.setX(100);
        na.setY(1480);

        list.add(na);


        Shape i = shapeFactory.getCircle(20);
        i.setHoritzontal(true);
        i.setVertical(false);
        i.setVelocitatX(12);
        //sh1.setVelocitatY(20);
        i.setX(200);
        i.setY(200);
        i.setEstil(createStyle());
        list.add(i);




    }

    int min= 30, max = 50;


    public void creaAlTocar(){
        int r = ((int)(Math.random()*(max-min))+min) +1;
        Shape i = shapeFactory.getCircle(r);
        i.setHoritzontal(true);
        i.setVertical(false);
        i.setVelocitatX(r);
        i.setVelocitatY(r);
        //sh1.setVelocitatY(20);
        i.setX(r);
        i.setY(r);
        i.setEstil(createStyle());
        list.add(i);
    }


    public void mouObject(){
        for(Shape sh : list){
            sh.mou();
            //sh.getX(),sh.getY()
            /*posx ++;
            posy ++;
            if(posx > this.ampleView) posx = 0;
            if(posy > this.altView) posy = 0;*/
            //if(sh.getX() > getWidth() -sh.getVelocitat() || sh.getX() + sh.getVelocitat() <0){

           // this.nau.mou();

           /* if(this.nau.getX() > getWidth() -this.nau.getVelocitatX() || this.nau.getX() + this.nau.getVelocitatX() < 0.5){
                this.nau.velocitatX = -this.nau.getVelocitatX() ;
            }

            if(this.nau.getY() > getHeight() -this.nau.getVelocitatY() || this.nau.getY() + this.nau.getVelocitatY() < 0.5){
                this.nau.velocitatY = -this.nau.getVelocitatY() ;
            }*/



            if(sh.getX() > getWidth() -sh.getVelocitatX() || sh.getX() + sh.getVelocitatX() < 0){
                sh.velocitatX = -sh.getVelocitatX();
            }

            if(sh.getY() > getHeight() -sh.getVelocitatY() || sh.getY() + sh.getVelocitatY() < 0){
                sh.velocitatY = -sh.getVelocitatY() ;
            }

           /* if(sh.getX() + sh.getVelocitatX()  > getWidth() || sh.getX() + sh.getVelocitatX() <0){
                sh.velocitatX = -sh.getVelocitatX();
            }

            if(sh.getY() + sh.getVelocitatY() > getHeight() || sh.getY() + sh.getVelocitatY() <0){
                sh.velocitatY = -sh.getVelocitatY();
            }*/
        }



    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(ball, getX(), getY(), null);
        for(Shape sh : list) {
            sh.onDraw(canvas);
        }

    }

  /*  protected void onSizeChanged(int ample, int alt,int ample_anter, int alt_anter) {
        super.onSizeChanged(ample, alt, ample_anter, alt_anter);

        // Obtenim l'ample i l'altçada de la vista amb la que anem a treballar
        this.ampleView = ample;
        this.altView = alt;

        // Ara que sabem la mida de la vista anem a posicionar la Nau
       // this.nau.setPosX( this.ampleView / 2);
       // this.nau.setPosY( this.altView - 100);

    }*/





    private Paint createStyle(){
        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(20);

        //pincel.setStyle(Paint.Style.STROKE);

        return pincel;

    }



}
