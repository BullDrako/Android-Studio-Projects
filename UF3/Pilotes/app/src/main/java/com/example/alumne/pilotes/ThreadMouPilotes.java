package com.example.alumne.pilotes;

/**
 * Created by Edgar on 15/05/2017.
 */

public class ThreadMouPilotes extends Thread {
    EscenaView pView;
    Circle pilota;

    public ThreadMouPilotes(EscenaView v) {
        pView = v;
    }

    public void run() {
        try {
            while (true) {
                sleep(25);
                pView.mouObject();
                //pView.nau.mou();
                //pView.colisions();
                pView.postInvalidate();
            }

        } catch (Exception e) {

        }
    }
}
