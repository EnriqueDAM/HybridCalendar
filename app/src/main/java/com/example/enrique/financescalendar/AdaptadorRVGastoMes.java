package com.example.enrique.financescalendar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by usuario on 30/05/2016.
 */

/*NO FUNCIONA ESTO !!!!!!!!! ¿POR QUE? implements ItemClickListener*/

public class AdaptadorRVGastoMes extends RecyclerView.Adapter<AdaptadorRVGastoMes.MonthViewHolder> {
    private ArrayList p;
    private Context context;

    public AdaptadorRVGastoMes(ArrayList p, Context context) {
        this.p = p;
        this.context = context;
    }

    @Override
    public MonthViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_gasto, parent, false);
        MonthViewHolder monthHolder = new MonthViewHolder(view);
        return monthHolder;
    }

    @Override
    public void onBindViewHolder(MonthViewHolder holder, int position) {
        //holder.monthName.setText(meses[position].toString());
        holder.fecha.setText(p.get(position).toString());
        holder.container.setOnClickListener(onClickListener(position));
    }


    @Override
    public int getItemCount() {
        return p.size();
    }
/*
    @Override
    public void onItemClick(View view, int position) {
//Toast.makeText(context, "pasa la puta actividad joder para poder trabajar con ella", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, meses[position].toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(view.getContext(), "hola", Toast.LENGTH_SHORT).show();
    }*/

    public static class MonthViewHolder extends RecyclerView.ViewHolder{
        TextView fecha;
        TextView precio;
        View container;
        MonthViewHolder(View itemView) {
            super(itemView);
            fecha = (TextView) itemView.findViewById(R.id.tvDate);
            precio = (TextView) itemView.findViewById(R.id.tvPrecio);
            container = itemView.findViewById(R.id.cvgasto);
        }

    }


    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(),meses[position].toString() +" "+ position, Toast.LENGTH_SHORT).show();
                //Intent i = new Intent(context, MainActivity.class);
                //context.startActivity(i);
            }
        };
    }

}

/*interface ItemClickListener {
    void onItemClick(View view, int position);
}*/