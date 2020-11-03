package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PedidoExitBrasa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_exit_brasa);

        Button mapa  = (Button) findViewById(R.id.btnmapaB);


        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PedidoExitBrasa.this, mapaBrasaRoja.class);
                PedidoExitBrasa.this.startActivity(intent);
            }
        });




    }
}