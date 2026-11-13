package com.example.evaluable2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class BasedeDatos extends SQLiteOpenHelper {

    public BasedeDatos(Context context) {
        super(context, "ranking.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE partidas (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, puntos INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS partidas");
        onCreate(db);
    }

    public void guardarPartida(String nombre, int puntos) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO partidas (nombre, puntos) VALUES (?, ?)",
                new Object[]{nombre, puntos});
        db.close();
    }

    public ArrayList<String> obtenerRanking() {
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(
                "SELECT nombre, puntos FROM partidas ORDER BY puntos DESC", null);
        int posicion = 1;
        while (c.moveToNext()) {
            lista.add(posicion + ". " + c.getString(0) + "  —  " + c.getInt(1));
            posicion++;
        }
        c.close();
        db.close();
        return lista;
    }
}