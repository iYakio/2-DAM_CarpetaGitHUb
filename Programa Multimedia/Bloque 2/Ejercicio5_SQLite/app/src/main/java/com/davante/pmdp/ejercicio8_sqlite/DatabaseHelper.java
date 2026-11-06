package com.davante.pmdp.ejercicio8_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // ==== Configuración básica ====
    private static final String DATABASE_NAME = "DBProfesores.db";
    private static final int DATABASE_VERSION = 2;


    // ==== Esquema de la tabla ====
    private static final String TBL_PROFESORES = "Profesores";
    private static final String COL_ID = "id";
    private static final String COL_NOMBRE = "nombre";
    private static final String COL_APELLIDO = "apellido";


    // Sentencia SQL para crear la tabla
    private static final String SQL_CREATE =
            "CREATE TABLE " + TBL_PROFESORES + " (" +
                    COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COL_NOMBRE + " TEXT, " +
                    COL_APELLIDO + " TEXT" +
                    ")";


    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Metodo obligatorio: se ejecuta la primera vez que se crea la BD
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos la tabla
        db.execSQL(SQL_CREATE);

        // Inserta profesores de ejemplo
        insertarProfesor(db, "Daniel", "Perez");
        insertarProfesor(db, "Jose", "Lopez");
        insertarProfesor(db, "Ana", "Garcia");
    }







    // Metodo obligatorio: se ejecuta al subir DATABASE_VERSION.
    // Aquí se borra todo y se vuelve a crear: vale para clase, no para una app con datos reales
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBL_PROFESORES);
        onCreate(db);
    }











    // ==== Datos de ejemplo ====

    // Dentro de onCreate() no se puede llamar a getWritableDatabase(): ya nos dan la BD abierta
    private void insertarProfesor(SQLiteDatabase db, String nombre, String apellido) {
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APELLIDO, apellido);
        db.insert(TBL_PROFESORES, null, valores);
    }











    // ==== CRUD ====

    // CREATE: devuelve el id nuevo, o -1 si ha fallado
    public long insertar(String nombre, String apellido) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APELLIDO, apellido);
        return db.insert(TBL_PROFESORES, null, valores);
    }


    // READ: todos los profesores, ordenados por apellido
    public List<Profesor> obtenerTodos() {
        List<Profesor> lista = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        try (Cursor c = db.query(
                TBL_PROFESORES,
                new String[]{COL_ID, COL_NOMBRE, COL_APELLIDO},
                null, null,           // sin WHERE: todas las filas
                null, null,           // sin GROUP BY ni HAVING
                COL_APELLIDO + ", " + COL_NOMBRE   // ORDER BY
        )) {
            // El cursor empieza ANTES de la primera fila: moveToNext() avanza y dice si hay fila
            while (c.moveToNext()) {
                int id = c.getInt(c.getColumnIndexOrThrow(COL_ID));
                String nombre = c.getString(c.getColumnIndexOrThrow(COL_NOMBRE));
                String apellido = c.getString(c.getColumnIndexOrThrow(COL_APELLIDO));
                lista.add(new Profesor(id, nombre, apellido));
            }
        }
        return lista;
    }


    // UPDATE: devuelve cuántas filas ha cambiado (1 si ha ido bien)
    public int actualizar(int id, String nombre, String apellido) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(COL_NOMBRE, nombre);
        valores.put(COL_APELLIDO, apellido);
        return db.update(TBL_PROFESORES, valores,
                COL_ID + " = ?", new String[]{String.valueOf(id)});
    }


    // DELETE: devuelve cuántas filas ha borrado
    public int borrar(int id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TBL_PROFESORES,
                COL_ID + " = ?", new String[]{String.valueOf(id)});
    }


    // Comprueba si existe un profesor con ese nombre y apellido
    public boolean existeProfesor(String nombre, String apellido) {
        SQLiteDatabase db = getReadableDatabase();

        // Los ? se sustituyen por los valores del array, en orden.
        // Si se concatenara el texto del usuario ("... = '" + nombre + "'"), un nombre con
        // comilla rompería la consulta (y es la puerta a la inyección SQL)
        String where = COL_NOMBRE + " = ? AND " + COL_APELLIDO + " = ?";
        String[] args = {nombre, apellido};

        try (Cursor c = db.query(
                TBL_PROFESORES,
                new String[]{COL_ID}, // Solo pedimos el ID
                where,
                args,
                null, null, null,
                "1"                   // LIMIT 1
        )) {
            return c.moveToFirst(); // true si hay al menos un registro
        }
    }

}
