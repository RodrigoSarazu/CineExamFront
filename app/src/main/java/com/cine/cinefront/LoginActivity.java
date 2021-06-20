package com.cine.cinefront;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLogin.setOnClickListener(v -> {
            if (binding.etEmail.getText().toString().equals("") &&
                    binding.etPassword.getText().toString().equals("")) {
                mostrarMensajeError("Los campos correo y contraseña no pueden estar vacíos");
            } else {
                login();
            }
        });
    }

    private void login() {
        RequestQueue colaPeticiones = Volley.newRequestQueue(this);
        Map<String, String> parametros = new HashMap<>();
        parametros.put("email", binding.etEmail.getText().toString());
        parametros.put("password", binding.etPassword.getText().toString());
        JSONObject jsonObjectParametro = new JSONObject(parametros);
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                Constante.URL_LOGIN_API,
                jsonObjectParametro,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            if(response.getInt("id_usuario")>0){
                                //Acá deben cambiar el MainActivity por el menú que van a crear
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }else{
                                mostrarMensajeError(response.getString("mensaje"));
                            }
                        }catch (JSONException ex) {
                            mostrarMensajeError("Error en el servidor, inténtelo de nuevo.");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        NetworkResponse networkResponse = error.networkResponse;
                        String jsonResponse = new String(networkResponse.data);
                        try {
                            JSONObject jsonError = new JSONObject(jsonResponse);
                            String msj = jsonError.getString("mensaje");
                            mostrarMensajeError(msj);
                        } catch (JSONException exception) {
                            exception.printStackTrace();
                        }
                    }
                }
        );
        colaPeticiones.add(request);
    }

    private void mostrarMensajeError(String mensaje) {
        Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG).show();
    }
}