package com.cine.cinefront;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ActivityPeliculasBinding;
import com.cine.cinefront.model.Peliculas;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PeliculasActivity extends AppCompatActivity {


    private ActivityPeliculasBinding binding;
    private PeliculasAdapter adapter;





    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate ( savedInstanceState );
        binding=ActivityPeliculasBinding.inflate( getLayoutInflater () );
        setContentView ( binding.getRoot ());
        adapter=new PeliculasAdapter ( this );
        binding.rvpeliculas.setLayoutManager(
                new GridLayoutManager ( PeliculasActivity.this, 1) );
        binding.rvpeliculas.setAdapter(adapter);
        obtenerPeliculas(new Constante().URL_LIST_API_PELI );
        binding.btnRegresar.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent (PeliculasActivity.this,MenuActivity.class) );
            }
        } );

    }
    private void obtenerPeliculas(String url){
        RequestQueue cola= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray=response.getJSONArray("peliculas");
                    ArrayList<Peliculas>ListaPelicula=new ArrayList<> ();
                    for(int i=0; i<jsonArray.length();i++){
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        Peliculas nuevoPeliculas=new Peliculas(
                                jsonObject.getLong("idpeli"),
                                jsonObject.getString("nompeli"),
                                jsonObject.getString ( "infopeli" ),
                                jsonObject.getString("fotopeli")
                        );
                        ListaPelicula.add(nuevoPeliculas);
                        
                        }
                    adapter.agregarList ( ListaPelicula );

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