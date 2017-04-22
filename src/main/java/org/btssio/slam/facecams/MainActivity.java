package org.btssio.slam.facecams;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.btssio.slam.facecams.adapters.EvenementAdapter;

import org.btssio.slam.facecams.objects.Evenement;

import org.btssio.slam.facecams.repository.FluxRepository;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String SERVER_URL = "http://172.20.10.8:3000/android/evenement";
    ListView lv;
    JSONObject jsonResponse;
    JSONArray arrayJson;
    ArrayList<Evenement> items;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.list);
        items = new ArrayList<Evenement>();
    }

    public void onStart() {
        super.onStart();
        // Envoi d'une requete dans la file d'attente
        sendRequest();
    }


    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(SERVER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Log.i("reponse",""+response);
                        parseJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void parseJSON(String leJson){
        // Traitement de la source Json chargée dans onStart()
        try {
            jsonResponse = new JSONObject(leJson);
            // Création du tableau général à partir d'un JSONObject
            JSONArray jsonArray = jsonResponse.getJSONArray("data");
            Evenement currentEvenement = null;

            // Pour chaque élément du tableau
            for (int i = 0; i < jsonArray.length(); i++) {
                currentEvenement = new Evenement();

                // Création d'un tableau élément à  partir d'un JSONObject
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                // Récupération de l'item qui nous intéresse
                String nom = jsonObj.getString("nom");
                String date = jsonObj.getString ("date");
                String list = jsonObj.getString("list");
                String nombre = jsonObj.getString("nombre");
                String type = jsonObj.getString("type");


                currentEvenement.setNom(nom);
                currentEvenement.setDate(date);
                currentEvenement.setList(list);
                currentEvenement.setNombre(nombre);
                currentEvenement.setType(type);
                // Ajout dans l'ArrayList
                items.add(currentEvenement);
            }

            ArrayAdapter<Evenement> objAdapter = new EvenementAdapter(this,R.layout.row, items);
            lv.setAdapter(objAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

