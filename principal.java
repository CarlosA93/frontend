package com.example.lenovo.marketparadise;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class principal extends AppCompatActivity {
    Button opc;
    Button opc2;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0266R.layout.activity_principal);
        this.opc = (Button) findViewById(C0266R.C0268id.opc);
        this.opc2 = (Button) findViewById(C0266R.C0268id.opc2);
    }

    public void opcion1(View v) {
        startActivity(new Intent(this, alimentosybebidas.class));
    }

    public void opcion2(View v) {
        startActivity(new Intent(this, aseoyhogar.class));
    }
}
