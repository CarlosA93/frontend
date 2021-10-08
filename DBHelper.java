package com.example.lenovo.marketparadise;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "administracion", factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE articulos(codigo INTEGER PRIMARY KEY,descripcion TEXT,precio REAL)");
        db.execSQL("CREATE TABLE cl(codigo INTEGER PRIMARY KEY,descripcion TEXT,precio REAL)");
    }

    public void onUpgrade(SQLiteDatabase db, int versionAnte, int versionNue) {
        db.execSQL("DROP TABLE if exists articulos");
        db.execSQL("DROP TABLE if exists cl");
        onCreate(db);
    }
}
