package com.example.alumne.marvelwebservice;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

import com.example.alumne.marvelwebservice.marvel.CharacterComic;
import com.example.alumne.marvelwebservice.marvel.CharacterMarvelRestClient;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView txtView;
    CharacterComic characterComics[] = new CharacterComic[0];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = (TextView) findViewById(R.id.tvinfo);
        new loadDataWebService().execute("");
    }

    /**
     * Get character list from Marvel Api
     * @return Characters list
     */
    public CharacterComic[] getCharacterComics() {
        CharacterComic characterComicsLocal[] = new CharacterComic[0];
        String marvelPublicKey = "b6aec6f6d66e3026db1bea85ba6dbfce";
        String marvelPrivateKey = "8038f55dc1188291e07c6143427ccc75bdd4c14b";
        CharacterMarvelRestClient restClient = new CharacterMarvelRestClient(marvelPublicKey, marvelPrivateKey);
        try {
            characterComicsLocal = restClient.ListCharacters();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return characterComicsLocal;
    }



    private class loadDataWebService extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
           characterComics = getCharacterComics();
            return "";
        }

        @Override
        protected void onPostExecute(String result) {

            fillListView(characterComics);
            txtView.setText("characterComics loaded");

            //txtView.setText("ID" + characterComics[0].id + " Name: " + characterComics[0].name);

        }
        @Override
        protected void onPreExecute() {
            txtView.setText("Loading characterComics");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            txtView.setText(" ...  downloading characterComics  ... ");
        }
    }

    /**
     * Fill ListView with data of array characterComics
     *
     * @param characterComics array of CharacterComic
     */
    public void fillListView(CharacterComic characterComics[]) {
        if (characterComics != null) {
            List<String> sList = new ArrayList<String>();
            for (int i = 0; i < characterComics.length; i++) {
                sList.add(characterComics[i].name);
            }
            listView = (ListView) findViewById(R.id.listview);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                    R.layout.listitem,
                    sList);
            listView.setAdapter(arrayAdapter);
            listView.setOnItemClickListener(listener);
        }
    }

    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            startCardActivity(characterComics[position]);
        }
    };

    public void startCardActivity(CharacterComic characterComic) {
        Intent intent = new Intent(this, CardActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("description", characterComic.name + " : " + characterComic.description);
        bundle.putString("imagename", characterComic.name + ".jpg" );
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
