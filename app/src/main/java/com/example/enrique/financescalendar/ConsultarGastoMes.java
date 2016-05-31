package com.example.enrique.financescalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by usuario on 31/05/2016.
 */
public class ConsultarGastoMes extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_gasto_mes);
        //

        ArrayList prueba = new ArrayList();
        prueba.add("prueba");
        prueba.add("prueba1");
        prueba.add("prueba2");
        prueba.add("prueba3");
        prueba.add("prueba4");
        prueba.add("prueba5");
        prueba.add("prueba6");
        //
        RecyclerView rv = (RecyclerView)findViewById(R.id.rvgasto);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        //
        AdaptadorRVGastoMes adap = new AdaptadorRVGastoMes(prueba, this);
        rv.setAdapter(adap);
    }
}
