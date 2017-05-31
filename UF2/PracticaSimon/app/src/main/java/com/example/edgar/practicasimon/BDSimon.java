package com.example.edgar.practicasimon;

/**
 * Created by Edgar on 13/04/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class BDSimon extends SQLiteOpenHelper {
    String instrSQL = "CREATE TABLE Jugador (PK_Jugador INTEGER PRIMARY KEY, Nombre TEXT, Puntuacion INTEGER)";

    public BDSimon(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.instrSQL);
        db.execSQL("INSERT INTO Jugador (Nombre, Puntuacion) VALUES ('Peter', 140)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Jugador");
        db.execSQL(this.instrSQL);
    }
}
