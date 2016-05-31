package com.example.enrique.financescalendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public  class MainActivity extends AppCompatActivity {

    public FrameLayout nuevoIngreso;
    public FrameLayout consultarGastos;
    public FrameLayout configuracion;
    Activity acti=this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //recuperamos los frame de la actividad
        nuevoIngreso = (FrameLayout) findViewById(R.id.accesoNuevoIngreso);
        consultarGastos = (FrameLayout) findViewById(R.id.accesoConsulta);
        configuracion = (FrameLayout) findViewById(R.id.accesoConfig);
        //ponemos a la escucha los frames
        nuevoIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // codigo para llamar a la ventana
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        consultarGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // codigo para llamar a la ventana
                Intent i = new Intent(acti, ConsultarGastos.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
        configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // codigo para llamar a la ventana
                Intent i = new Intent(acti, Preferencias.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }

}
