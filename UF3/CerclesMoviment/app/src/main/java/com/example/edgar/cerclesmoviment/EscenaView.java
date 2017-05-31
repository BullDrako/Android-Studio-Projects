package com.example.edgar.cerclesmoviment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alumne on 4/05/17.
 */

public class EscenaView extends View {
    private List<Shape> list;
    //ArrayList<Shape> list = new ArrayList<>();
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
       list = new ArrayList<>();
        shapeFactory = new ShapeFactory();
       // nau = context.getResources().getDrawable(R.drawable.nau);
       // nau2 = context.getResources().getDrawable(R.drawable.nau);
    }

    public EscenaView(Context context, AttributeSet attrs) {
        super(context, attrs);
       list = new ArrayList<>();
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


       Shape na = shapeFactory.getGraficNau(this, drawableNau);
        //na.setHoritzontal(true);
       // na.setVertical(false);
        na.setVelocitatX(20);
        na.setX(100);
        na.setY(1480);

        list.add(na);


        Shape i = shapeFactory.getCircle(50);
        i.setHoritzontal(true);
        i.setVertical(false);
        i.setVelocitatX(12);
        i.setVelocitatY(12);
        //sh1.setVelocitatY(20);
        i.setX(200);
        i.setY(200);
        i.setEstil(createStyle());
        list.add(i);




    }

    int min= 30, max = 50;


    public void creaAlTocar(float x, float y){
        int r = ((int)(Math.random()*(max-min))+min) +1;
        Shape i = shapeFactory.getCircle(r);
        i.setHoritzontal(true);
        i.setVertical(false);
        i.setVelocitatX(r);
        i.setVelocitatY(r);
        //sh1.setVelocitatY(20);
        i.setX((int) x);
        i.setY((int) y);
        i.setEstil(createStyle());
        list.add(i);
    }


    public void mouObject(){
        for(Shape sh : list){
           /*for(int i = 0; i < list.size(); i++){
                for(int j = i+1; j < list.size(); j++){
                    if(list.get(i).colisio(list.get(j))){

                        sh.canviDireccio();
                        //Toast.makeText(getContext(), "choca", Toast.LENGTH_LONG).show();
                        //System.out.println("choca");
                    }


                }
            }*/
            sh.mou();


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


    public void calculaColisions(){

        /*for(int i = 0; i < list.size(); i++){
            for(int j = i+1; j < list.size(); j++){

                /*if(list[i].colisio(list[j])){
                    canviDireccio();
                }*/
              /* if(list.get(i).colisio(list.get(j))){
                    //canviDireccio();
                    Toast.makeText(getContext(), "choca", Toast.LENGTH_LONG).show();
                   System.out.println("choca");

                }
            }
        }*/
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
