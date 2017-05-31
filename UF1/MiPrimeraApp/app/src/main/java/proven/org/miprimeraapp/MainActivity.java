package proven.org.miprimeraapp;

import android.app.Activity;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    String tag = "Events";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "In the onCreate() event");

    }
        public void onStart(){
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }

    /*public void onRestart(){
        super.onRestart();
        setContentView(R.layout.activity_second);
        Log.d(tag, "In the onRestart() event");
    }*/

    public void onRestart(){
        super.onRestart();
        setContentView(R.layout.activity_third);
        Log.d(tag, "In the onRestart() event");
    }

    public void onResume(){
        super.onResume();

        Log.d(tag, "In the onResume() event");
    }

    public void onPause(){
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    public void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }
    /*public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }*/
}

