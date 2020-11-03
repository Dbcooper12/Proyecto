package com.example.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

public class menuprincipal extends AppCompatActivity {
    TextView  et_usuario, et_password;
    TextView tvNombre,tvUsuario,tvEdad,tvPassword;
    Button cuenta;
    RequestQueue requestQueue;
    ImageButton btnbrasaroja,btnpopeyes,btnpizzahut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);

        et_usuario = (EditText) findViewById(R.id.tv_usuario);
        et_password= (EditText) findViewById(R.id.tv_password);


        btnbrasaroja =  findViewById(R.id.brasaroja);
        btnpopeyes  =  findViewById(R.id.popeyes);
        btnpizzahut = findViewById(R.id.pizzahut);

        cuenta = (Button) findViewById(R.id.cuenta);

        cuenta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(menuprincipal.this,Usuario.class);
               // intent.putExtra("name",name);
                //intent.putExtra("username",username);
               // intent.putExtra("age",age);
              //  intent.putExtra("password",password);
                menuprincipal.this.startActivity(intent);

            }
        });
        //inicializando carwuit brazaroja
        btnbrasaroja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(menuprincipal.this,brazaroja.class);

                menuprincipal.this.startActivity(intent);
            }
        });





    }



}