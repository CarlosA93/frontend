package com.example.lenovo.marketparadise;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;
import java.util.ArrayList;

public class listado extends alimentosybebidas {
    private ArrayAdapter<String> adapter;
    private GridView gridView;
    private ArrayList<String> list;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0266R.layout.activity_listado);
        this.gridView = (GridView) findViewById(C0266R.C0268id.gridView1);
        this.list = new ArrayList<>();
        this.adapter = new ArrayAdapter<>(getApplicationContext(), 17367048, this.list);
        try {
            SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
            Cursor cr = db.rawQuery("SELECT * FROM articulos ORDER BY codigo", (String[]) null);
            if (cr == null || !cr.moveToFirst()) {
                db.close();
            }
            do {
                String cod = cr.getString(0);
                String nom = cr.getString(1);
                String prec = cr.getString(2);
                this.list.add(cod);
                this.list.add(nom);
                this.list.add(prec);
                this.gridView.setAdapter(this.adapter);
            } while (cr.moveToNext());
            db.close();
        } catch (Exception e) {
            Toast.makeText(this, "error al eliminar ", 0).show();
        }
    }

    public void eliminartodo(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        try {
            db.execSQL("DELETE FROM articulos WHERE 1");
            Toast.makeText(this, "se eliminaron todos los registros", 0).show();
            startActivity(new Intent(this, alimentosybebidas.class));
        } catch (SQLException e) {
            Toast.makeText(this, "error al eliminar", 0).show();
        }
        db.close();
    }
}
