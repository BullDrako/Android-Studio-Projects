package docent.prov;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SeekProgressActivity extends Activity {
    
	TextView t;
	TextView t2;
	SeekBar alturaSeekBar = null;
	ProgressBar progressIMC; 
	
	/** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initProgressBar();
        controlSeekBar();
    }
    
    // Inicialitzem el progress Bar a valor 0 i li donem un m�xim de 50
    public void initProgressBar(){
    	progressIMC = (ProgressBar) findViewById(R.id.progressBar1); 
    	progressIMC.setProgress(0); 
    	progressIMC.setMax(50);

    	// Inicialitzem el Text View 2
    	t2=(TextView)findViewById(R.id.text2); 
        t2.setText("Valor inicial : 0"); 
    }
    
    
    public void controlSeekBar(){
    	
    	alturaSeekBar = (SeekBar)findViewById(R.id.seekBar1);
    	// M�xim valor del Seekbar
    	alturaSeekBar.setMax(250);
        //
    	alturaSeekBar.setProgress(100);   
         
        //Inicialitzem el texte a 100
        t=(TextView)findViewById(R.id.text1); 
        t.setText("Valor inical SeekBar 100");

        alturaSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() 
        {
            public void onStopTrackingTouch(SeekBar arg0) 
            {	
            	//t.setText("Valor SeekBar " + arg0.getProgress() + "");
            }

            public void onStartTrackingTouch(SeekBar arg0) 
            {
            }
            
            public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) 
            {
            	// Progres �s el valor del SeekVar
            	// Aqu� hauriem de fer els c�lculs del IMC
            	//Toast.makeText(BotoLayoutActivity.this, "You clicked the button" +progress , Toast.LENGTH_SHORT).show();
            	t.setText("Valor SeekBar " + progress + "");
            	
            	// Actualitzem el progressBar segons el valor del SeekBar
            	if(progress <100) {
            		progressIMC.setProgress(25); 
            		// Inicialitzem el Text View 2
                	t2=(TextView)findViewById(R.id.text2); 
                    t2.setText("Valor ProgressBar: 25");
            	} else{
            		progressIMC.setProgress(50); 
            		// Inicialitzem el Text View 2
                	t2=(TextView)findViewById(R.id.text2); 
                    t2.setText("Valor ProgressBar: 50");
            	}
            	
            }
        });
    }
    
    
    
}