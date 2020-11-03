package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Usuario extends AppCompatActivity {
    TextView tvNombre,tvUsuario,tvEdad,tvPassword,tv12;
    RequestQueue requestQueue;
    Button btnBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        tvNombre=   (TextView) findViewById(R.id.PersonalEntrega);
        tvUsuario=  (TextView) findViewById(R.id.txtUsuario);
        tvEdad= (TextView)  findViewById(R.id.txtEdad);
        tvPassword= (TextView)  findViewById(R.id.txtPassword);

        btnBuscar = (Button) findViewById(R.id.btn_buscar);


tv12 = findViewById(R.id.txtbuscar);


btnBuscar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        buscarUsuario("http://192.168.43.220/Registro_usuario_Prueba/buscar.php?usuario="+tv12.getText());
    }
});

    }
    private void buscarUsuario(String URL){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        tvNombre.setText(jsonObject.getString("name"));
                        tvUsuario.setText(jsonObject.getString("username"));
                        tvPassword.setText(jsonObject.getString("password"));
                        tvEdad.setText(jsonObject.getString("age"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"error conexion",Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }



}