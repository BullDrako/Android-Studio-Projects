package proven.org.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class PrincipalActivity extends Activity {

    String tag  = "Event";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCanvi = (Button) findViewById(R.id.ButtonCanvi);
        buttonCanvi.setText("Canvi de text");

        // Event Listenner
        OnClickListener listener = new OnClickListener(){

            @Override
         public void onClick(View view) {
          switch(view.getId()) {
             case R.id.ButtonCanvi:
                 // CODI
                 startActivity(new Intent(PrincipalActivity.this,
                         SegonaActivity.class));

                  //Toast.makeText(getBaseContext(),"Click",
                  //              Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

        buttonCanvi.setOnClickListener(listener);

    }

    public void obreActivity() {

    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(tag," Event onResume");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(tag," Event onStart");
    }

    @Override
    public void onRestart() {
        super.onStart();
        //setContentView(R.layout.activity_third);
        Log.d(tag," Event onRestart");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(tag," Event onStop");
    }

    @Override
    public void onPause() {
        super.onResume();
        Log.d(tag," Event onPause");
    }
}
