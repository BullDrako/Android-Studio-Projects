package com.example.alumne.menucontext;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    final static int SORTIR = 1;
    final static int OPCIO1 = 2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Register Button view to the context menu.
        // When button is long-pressed, context menu gets displayed.
        Button button = (Button)findViewById(R.id.myButton);

        //aparece el menu  contextual al mantener pulsado en el layout
        //LinearLayout l = (LinearLayout) findViewById(R.id.linearLayout);
        //l.setOnCreateContextMenuListener(this);

        button.setOnCreateContextMenuListener(this);
    }

    // Creates the menu items
    //menu COntext
    @Override
    public void onCreateContextMenu(
            ContextMenu menu,            // Context menu that is being built
            View view,                    // The view for which the context menu is being built
            ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, view, menuInfo);
        menu.setHeaderTitle("Context menu");
        menu.add(0, Menu.FIRST,   Menu.NONE, "menu #1");
        menu.add(0, Menu.FIRST+1, Menu.NONE, "menu #2");
        menu.add(0, Menu.FIRST+2, Menu.NONE, "menu #3");
        menu.add(0, Menu.FIRST+3, Menu.NONE, "menu #4");
        /*menu.add(0, OPCIO1,   Menu.NONE, "menu #1");
        menu.add(0, SORTIR, Menu.NONE, "menu #2");*/
    }

    // Handles item selections
    //menuContext
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(
                MainActivity.this,		// Qualify 'this" with Activity class
                "You selected menu item #" + String.valueOf(item.getItemId()),
                Toast.LENGTH_LONG).show();	// Make sure you call show() method
        return true;
    }

    //menu option
    public boolean onCreateOptionsMenu(Menu menu) {
    // The add() method used in this sample takes four arguments:
    // groupId, itemId, order, and title.
        menu.add(0, OPCIO1, 0, "New Game");
        menu.add(0, SORTIR, 0, "Quit");
        return true;
    }

    //menu option
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case OPCIO1:
                Toast.makeText(
                MainActivity.this,
                        "OPCIO 1" , Toast.LENGTH_LONG).show();	// Make sure you call show() method
                return true;
            case SORTIR:
                Toast.makeText(
                        MainActivity.this,
                        "OPCIO 2" , Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }
}