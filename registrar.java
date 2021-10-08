package com.example.lenovo.marketparadise;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrar extends AppCompatActivity {
    Button btngrabarUsu;
    EditText txtPass;
    EditText txtUsuario;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0266R.layout.activity_registrar);
        this.btngrabarUsu = (Button) findViewById(C0266R.C0268id.registrarse);
        this.txtUsuario = (EditText) findViewById(C0266R.C0268id.nom_usuario);
        this.txtPass = (EditText) findViewById(C0266R.C0268id.pass);
    }

    public void registrar(View v) {
        SQLiteDatabase db = new DBHelper(this, "administracion", (SQLiteDatabase.CursorFactory) null, 1).getWritableDatabase();
        String usu = this.txtUsuario.getText().toString();
        String pass = this.txtPass.getText().toString();
        ContentValues registro = new ContentValues();
        registro.put("usuario", usu);
        registro.put("contraseña", pass);
        db.insert("registro", (String) null, registro);
        db.close();
        this.txtUsuario.setText("");
        this.txtPass.setText("");
        Toast.makeText(getApplicationContext(), "su registro fue exitoso", 0).show();
    }
}
