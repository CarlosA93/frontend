package com.example.lenovo.marketparadise;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    /* renamed from: contraseña  reason: contains not printable characters */
    EditText f34contrasea;
    Cursor fila;
    Button ingresar;
    Button registro;
    EditText usuario;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0266R.layout.activity_login);
        this.usuario = (EditText) findViewById(C0266R.C0268id.usuario);
        this.f34contrasea = (EditText) findViewById(C0266R.C0268id.f33contrasea);
        this.ingresar = (Button) findViewById(C0266R.C0268id.ingresar);
        this.registro = (Button) findViewById(C0266R.C0268id.registro);
    }

    public void login_principal(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String usu = this.usuario.getText().toString();
        String con = this.f34contrasea.getText().toString();
        if (!usu.equals("admin") || !con.equals("admin")) {
            Toast.makeText(getApplicationContext(), "usuario y/o contraseña incorrectos", 1).show();
            db.close();
            return;
        }
        Toast.makeText(getApplicationContext(), "bienvenido", 0).show();
        startActivity(new Intent(this, principal.class));
        this.usuario.setText("");
        this.f34contrasea.setText("");
    }

    public void registrar(View v) {
        startActivity(new Intent(this, registrar.class));
    }
}
