package proven.org.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ActivityEvents extends Activity {
    Button button1, button2;
    TextView tv, tvEt;
    ImageView imgV;
    EditText et;
    boolean b = true;
    boolean bcanvi = true;

    OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        // Instancio objectes del Layout
        tv = (TextView) findViewById(R.id.tvinit);
        button1 = (Button) findViewById(R.id.b1);
        imgV = (ImageView) findViewById(R.id.imageView1);
        et = (EditText) findViewById(R.id.editText1);
        button2 = (Button) findViewById(R.id.buttonet);
        tvEt = (TextView) findViewById(R.id.tvet);
        //Preparem el Listener
        prepareListener();
        //Afegim el listener als elements
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        imgV.setOnClickListener(listener);
    }

    public void prepareListener() {
        listener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.b1:
                        canviText();
                        break;

                    case R.id.buttonet:
                        posoTextEditText();
                        break;

                    case R.id.imageView1:
                        canvioImatge();
                        break;
                }
            }
        };
    }

    public void canviText() {
        if (b) {
            b = false;
            tv.setText("NOU TEXTE !!!!!");
        } else {
            b = true;
            tv.setText("CANVIA !!!!!");
        }
        Toast.makeText(getApplicationContext(),
                "Missatge FLOTANT!!!!",
                Toast.LENGTH_LONG).show();
    }

    public void posoTextEditText() {
        //Agafo el valor del EditText
        String s = et.getText().toString();
        tvEt.setText(s);
    }

    public void canvioImatge() {
        if (bcanvi) {
            bcanvi = false;
            /*imgV.setImageDrawable(getResources()
                     .getDrawable(R.drawable.marmota2));*/
            imgV.setImageResource(R.drawable.marmota2);
        } else {
            bcanvi = true;
            /*Drawable draw = getResources().getDrawable(R.drawable.marmota);
                  imgV.setImageDrawable(draw);*/
            imgV.setImageResource(R.drawable.marmota);
        }
    }
}
