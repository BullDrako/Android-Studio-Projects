package com.example.alumne.bbddagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alumne on 02/03/17.
 */

public class BBDDAgenda extends SQLiteOpenHelper {
    String instrSQL = "CREATE TABLE Contacto (PK_Contacto INTEGER PRIMARY KEY, Nombre TEXT)";

    public BBDDAgenda(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(this.instrSQL);
        db.execSQL("INSERT INTO Contacto (Nombre) VALUES ('Peter')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contacto");
        db.execSQL(this.instrSQL);
    }


}