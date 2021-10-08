package com.example.lenovo.marketparadise;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class aseoyhogar extends AppCompatActivity {
    public EditText et1;
    public EditText et2;
    public EditText et3;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0266R.layout.aseoyhogar);
        this.et1 = (EditText) findViewById(C0266R.C0268id.editText11);
        this.et2 = (EditText) findViewById(C0266R.C0268id.editText22);
        this.et3 = (EditText) findViewById(C0266R.C0268id.editText33);
    }

    public void alta(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String cod = this.et1.getText().toString();
        String descri = this.et2.getText().toString();
        String pre = this.et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        db.insert("cl", (String) null, registro);
        db.close();
        this.et1.setText("");
        this.et2.setText("");
        this.et3.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo", 0).show();
    }

    public void consultaporcodigo(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String cod = this.et1.getText().toString();
        Cursor fila = db.rawQuery("SELECT descripcion,precio FROM cl WHERE codigo=" + cod, (String[]) null);
        if (fila.moveToFirst()) {
            this.et2.setText(fila.getString(0));
            this.et3.setText(fila.getString(1));
        } else {
            Toast.makeText(this, "No existe un artículo con dicho código", 0).show();
        }
        db.close();
    }

    public void consultapordescripcion(View v) {
        SQLiteDatabase bd = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String descri = this.et2.getText().toString();
        Cursor fila = bd.rawQuery("SELECT codigo,precio FROM cl WHERE descripcion='" + descri + "'", (String[]) null);
        if (fila.moveToFirst()) {
            this.et1.setText(fila.getString(0));
            this.et3.setText(fila.getString(1));
        } else {
            Toast.makeText(this, "No existe un artículo con dicha descripción", 0).show();
        }
        bd.close();
    }

    public void bajaporcodigo(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String cod = this.et1.getText().toString();
        int cant = db.delete("cl", "codigo=" + cod, (String[]) null);
        db.close();
        this.et1.setText("");
        this.et2.setText("");
        this.et3.setText("");
        if (cant == 1) {
            Toast.makeText(this, "Se borró el artículo con dicho código", 0).show();
        } else {
            Toast.makeText(this, "No existe un artículo con dicho código", 0).show();
        }
    }

    public void modificacion(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String cod = this.et1.getText().toString();
        String descri = this.et2.getText().toString();
        String pre = this.et3.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("codigo", cod);
        registro.put("descripcion", descri);
        registro.put("precio", pre);
        int cant = db.update("cl", registro, "codigo=" + cod, (String[]) null);
        db.close();
        if (cant == 1) {
            Toast.makeText(this, "se modificaron los datos", 0).show();
        } else {
            Toast.makeText(this, "no existe un artículo con el código ingresado", 0).show();
        }
    }

    public void listado(View view) {
        startActivity(new Intent(this, listado2.class));
    }
}
