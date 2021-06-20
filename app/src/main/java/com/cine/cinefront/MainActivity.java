package com.cine.cinefront;

import  androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ActivityMainBinding;
import com.cine.cinefront.model.Locales;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private LocalesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter=new LocalesAdapter(this);
        binding.rvlocales.setLayoutManager(
                new GridLayoutManager(MainActivity.this,3));
        binding.rvlocales.setAdapter(adapter);
        obtenerLocales( Constante.URL_LIST_API );
    }
    private void obtenerLocales(String url){
        RequestQueue cola= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray=response.getJSONArray("locales");
                    ArrayList<Locales>listaLocal=new ArrayList<>();
                    for(int i=0; i<jsonArray.length();i++){
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        Locales nuevoLocal=new Locales(
                                jsonObject.getLong("id"),
                                jsonObject.getString("nomloc"),
                                jsonObject.getString("foto")
                    );
                    listaLocal.add(nuevoLocal);
                    }
                    adapter.agregarList(listaLocal);
                }catch (JSONException ex){

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