package com.example.proyecto;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUESTE_URL="http://192.168.43.220/Registro_usuario_Prueba/Register.php";
    private Map<String,String> params;
    public RegisterRequest(String name, String username,  String password,int age, Response.Listener<String> listener){
        super(Request.Method.POST,REGISTER_REQUESTE_URL,listener,null);
        params= new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("age",age+"");
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
