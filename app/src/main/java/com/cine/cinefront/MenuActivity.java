package com.cine.cinefront;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cine.cinefront.common.Constante;
import com.cine.cinefront.common.SharedPreferencesManager;
import com.cine.cinefront.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private Button btnPeliculas;
    private Button btnLocales;
    private Button btnMetodoPago;
    private Button btnComidas;
    private Button btnSalir;
    private TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnLocales = findViewById(R.id.btnLocales);
        btnPeliculas = findViewById(R.id.btnPeliculas);
        btnSalir = findViewById(R.id.btnSalir);
        txtNombre = findViewById(R.id.tvBienvenida);
        btnMetodoPago = findViewById(R.id.btnMetodoPago);
        btnComidas=findViewById(R.id.btnComidas);

        txtNombre.setText("Bienvenido " + SharedPreferencesManager.getSomeStringValue(Constante.PREF_NOMBRES) + " "
                + SharedPreferencesManager.getSomeStringValue(Constante.PREF_APELLIDOS) + "!");

        btnLocales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });

        btnPeliculas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, PeliculasActivity.class));
            }
        });

        btnMetodoPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MetodoPagoActivity.class));
            }
        });

        btnComidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent (MenuActivity.this,ComidasActivity.class) );
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogCerrarSesion();
            }
        });


    }

    //Implementar toast cerrar sesi??n y cerrar app
    private void mostrarDialogCerrarSesion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
        builder.setTitle("Cerrar Sesi??n");
        builder.setMessage("Est??s seguro de cerrar sesi??n?")
                .setPositiveButton("S??", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferencesManager.setSomeStringValue(Constante.PREF_NOMBRES, null);
                        SharedPreferencesManager.setSomeStringValue(Constante.PREF_APELLIDOS, null);
                        finishAffinity();
                    }
                }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}

