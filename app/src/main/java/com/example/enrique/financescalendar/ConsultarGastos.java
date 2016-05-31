package com.example.enrique.financescalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by usuario on 30/05/2016.
 */
public class ConsultarGastos extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_gastos);
        //
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        String[] descMeses = {"Gastos realizados en el mes de Enero","Gastos realizados en el mes de Febrero","Gastos realizados en el mes de Marzo","Gastos realizados en el mes de Abril","Gastos realizados en el mes de Mayo","Gastos realizados en el mes de Junio","Gastos realizados en el mes de Julio","Gastos realizados en el mes de Agosto","Gastos realizados en el mes de Septiembre","Gastos realizados en el mes de Octubre","Gastos realizados en el mes de Noviembre","Gastos realizados en el mes de Diciembre"};
        //
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        //
        AdaptadorRV adap = new AdaptadorRV(meses, descMeses, this);
        rv.setAdapter(adap);
    }

}
