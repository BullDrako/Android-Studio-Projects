package com.example.alumne.examen1edgarcabeza;

/**
 * Created by alumne on 20/10/16.
 */
public class Carta {
    //atributs
    boolean visible;
    int idDrawble;
    int idImatgeView;
    float valor;

    //constructor
    public Carta(boolean visible, int idImatgeView, int idDrawable, float v){
        this.visible = visible;
        this.idImatgeView = idImatgeView;
        this.idDrawble = idDrawable;
        valor = v;
    }
    //getter setter
    public boolean isVisible() {
        return visible;
    }
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getIdDrawable() {
        return idDrawble;
    }
    public void setIdDrawable(int idDrawble) {
        this.idDrawble = idDrawble;
    }

    public int getIdImatgeView() {
        return idImatgeView;
    }

    public void setIdImatgeView(int idImatgeView) {
        this.idImatgeView = idImatgeView;
    }
}