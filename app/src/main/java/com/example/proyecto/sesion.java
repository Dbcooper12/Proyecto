package com.example.proyecto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class sesion extends AppCompatActivity {
    TextView tv_registrar, et_usuario, et_password;
    Button btn_log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        tv_registrar =(TextView) findViewById(R.id.btn_reg);
        et_usuario = (EditText) findViewById(R.id.tv_usuario);
        et_password= (EditText) findViewById(R.id.tv_password);

        tv_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentReg = new Intent(sesion.this,Registro.class);
                sesion.this.startActivity(intentReg);
            }
        });

        btn_log = (Button) findViewById(R.id.btn_iniciar);

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username=et_usuario.getText().toString();
                final String password = et_password.getText().toString();
                Response.Listener<String> responseLister = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                //Intent intent = new Intent(sesion.this,Usuario.class);
                                //intent.putExtra("name",name);
                                //intent.putExtra("username",username);
                                //intent.putExtra("age",age);
                                //intent.putExtra("password",password);

                                //sesion.this.startActivity(intent);
                                Intent intent = new Intent(sesion.this,menuprincipal.class);

                                sesion.this.startActivity(intent);
                                Intent intent1 = new Intent(sesion.this,Usuario.class);
                                intent1.putExtra("name",name);
                                intent1.putExtra("username",username);
                                intent1.putExtra("age",age);
                                intent1.putExtra("password",password);

                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(sesion.this);
                                builder.setMessage("Error Login").setNegativeButton("Retry",null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };


                LoginRequest loginRequest = new LoginRequest(username , password,responseLister);
                RequestQueue queue = Volley.newRequestQueue(sesion.this);
                queue.add(loginRequest);
            }
        });
    }
}