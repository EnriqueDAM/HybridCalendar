package com.example.enrique.financescalendar;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by usuario on 30/05/2016.
 */

/*NO FUNCIONA ESTO !!!!!!!!! ¿POR QUE? implements ItemClickListener*/
public class AdaptadorRV extends RecyclerView.Adapter<AdaptadorRV.MonthViewHolder> {
    private String[] meses;
    private String[] descripcion;
    private Context context;

    public AdaptadorRV(String[] meses, String[] descripcion, Context context) {
        this.meses = meses;
        this.descripcion = descripcion;
        this.context = context;
    }

    @Override
    public MonthViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview, parent, false);
        MonthViewHolder monthHolder = new MonthViewHolder(view);
        return monthHolder;
    }

    @Override
    public void onBindViewHolder(MonthViewHolder holder, int position) {
        holder.monthName.setText(meses[position].toString());
        holder.monthDesc.setText(descripcion[position].toString());

        holder.container.setOnClickListener(onClickListener(position));
    }


    @Override
    public int getItemCount() {
        return meses.length;
    }
/*
    @Override
    public void onItemClick(View view, int position) {
//Toast.makeText(context, "pasa la puta actividad joder para poder trabajar con ella", Toast.LENGTH_SHORT).show();
        Toast.makeText(context, meses[position].toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(view.getContext(), "hola", Toast.LENGTH_SHORT).show();
    }*/

    public static class MonthViewHolder extends RecyclerView.ViewHolder{
        TextView monthName;
        TextView monthDesc;
        View container;
        MonthViewHolder(View itemView) {
            super(itemView);
            monthName = (TextView) itemView.findViewById(R.id.month_name);
            monthDesc = (TextView) itemView.findViewById(R.id.tvContenido);
            container = itemView.findViewById(R.id.cv);
        }

    }


    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),meses[position].toString() +" "+ position, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, ConsultarGastoMes.class);
                context.startActivity(i);
            }
        };
    }

}

/*interface ItemClickListener {
    void onItemClick(View view, int position);
}*/