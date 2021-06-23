package com.cine.cinefront;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cine.cinefront.common.Constante;

import com.cine.cinefront.databinding.ActivityComidasBinding;
import com.cine.cinefront.model.Comidas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ComidasActivity extends AppCompatActivity {

    private ActivityComidasBinding binding;
    private ComidasAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityComidasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter=new ComidasAdapter(this);
        binding.rvcomidas.setLayoutManager(new GridLayoutManager(ComidasActivity.this,3));
        binding.rvcomidas.setAdapter(adapter);
        obtenerComidas(new Constante().URL_LISTCOMIDA_API);
        binding.btnRegresarcomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasActivity.this,MenuActivity.class));
            }
        });
    }
    private void obtenerComidas(String url){
        RequestQueue cola= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("comidas");
                    ArrayList<Comidas> listaComidas = new ArrayList<>();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Comidas nuevaComida = new Comidas(
                                jsonObject.getInt("idcom"),
                                jsonObject.getString("nomcom"),
                                jsonObject.getString("precio"),
                                jsonObject.getString("fotocom")
                        );
                        listaComidas.add(nuevaComida);
                    }
                    adapter.agregarListcom(listaComidas);
                } catch (JSONException ex) {

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        cola.add(jsonObjectRequest);
    }
}