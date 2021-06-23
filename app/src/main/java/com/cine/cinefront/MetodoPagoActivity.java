package com.cine.cinefront;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cine.cinefront.common.Constante;
import com.cine.cinefront.databinding.ActivityMetodoPagoBinding;
import com.cine.cinefront.model.MetodoPago;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MetodoPagoActivity extends AppCompatActivity {
    private ActivityMetodoPagoBinding binding;
    private MetodoPagoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMetodoPagoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter=new MetodoPagoAdapter(this);
        binding.rvmetodopago.setLayoutManager(
                new GridLayoutManager(MetodoPagoActivity.this,3));
        binding.rvmetodopago.setAdapter(adapter);
        obtenerMetodoPago(new Constante().URL_LIST_METPAG_API);
        obtenerDatosSharedPreferences();
        binding.btnRegresar.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent(MetodoPagoActivity.this,MenuActivity.class) );
            }
        } );
    }

    private void obtenerDatosSharedPreferences() {
        binding.tvMetodoPago.setText(
                "SELECCIONE EL MÉTODO DE PAGO PARA PAGAR BOLETO"
        );
    }
    private void obtenerMetodoPago(String url){
        RequestQueue cola= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(
                Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray=response.getJSONArray("metodopago");
                    ArrayList<MetodoPago> listaMetodoPago=new ArrayList<>();
                    for(int i=0; i<jsonArray.length();i++){
                        JSONObject jsonObject= jsonArray.getJSONObject(i);
                        MetodoPago nuevoMetodoPago=new MetodoPago(
                                jsonObject.getLong("idmetpago"),
                                jsonObject.getString("tipopago"),
                                jsonObject.getString("imgtipopago")


                        );
                        listaMetodoPago.add(nuevoMetodoPago);
                    }
                    adapter.agregarList(listaMetodoPago);
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