package com.example.alumne.exercicislayout;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    String tag = "Events";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.layout5eventos);
        Log.d(tag, "In the onCreate() event");

    }




    /*
    public void onStart(){
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }
*/
    /*public void onRestart(){
        super.onRestart();
        setContentView(R.layout.activity_second);
        Log.d(tag, "In the onRestart() event");
    }*/


}
