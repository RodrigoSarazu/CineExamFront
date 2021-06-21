package com.cine.cinefront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private Button btnPeliculas;
    private Button btnLocales;
    private Button btnMetodoPago;
    private Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnLocales = findViewById (R.id.btnLocales);
        btnPeliculas = findViewById (R.id.btnPeliculas);
        btnMetodoPago = findViewById (R.id.btnMetodoPago);
        btnSalir = findViewById (R.id.btnSalir);

        btnLocales.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity( new Intent ( MenuActivity.this, MainActivity.class ) );
            }
        } );

        btnPeliculas.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity( new Intent (MenuActivity.this,PeliculasActivity.class) );
            }
        } );

        btnMetodoPago.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity( new Intent (MenuActivity.this,MetodoPagoActivity.class) );
            }
        } );

        btnSalir.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity( new Intent (MenuActivity.this,LoginActivity.class) );
                Toast.makeText(MenuActivity.this,"Finalizó sesión",Toast.LENGTH_SHORT).show();
            }
        } );

    }
}

