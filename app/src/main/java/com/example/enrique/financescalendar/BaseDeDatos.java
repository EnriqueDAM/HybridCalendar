package com.example.enrique.financescalendar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.CalendarContract;
import android.widget.Toast;

/**
 * Created by Sheila on 31/05/2016.
 */
public class BaseDeDatos extends SQLiteOpenHelper {
    Context context;

    public BaseDeDatos(Context context) {

        super(context, "FINANZAS", null, 1);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("DROP TABLE IF EXISTS PAGOS");
            db.execSQL("CREATE TABLE PAGOS(id INTEGER PRIMARY KEY AUTOINCREMENT, cantidad INTEGER, dia INTEGER,mes INTEGER, anyo INTEGER, desc TEXT)");

        }

    public void guardarBaseDatos() {
        SQLiteDatabase bd = getWritableDatabase();
        bd.execSQL("DELETE FROM PAGOS");

        for (int pos = 0; pos < CalendarActivity.finanzas.size(); pos++) {
            bd.execSQL("INSERT INTO PAGOS VALUES ( null, '"
                    + CalendarActivity.finanzas.get(pos).getCantidad() + "','" +CalendarActivity.finanzas.get(pos).getDia() + "','" + CalendarActivity.finanzas.get(pos).getMes()+ "','" + CalendarActivity.finanzas.get(pos).getAnyo()+ "','" + CalendarActivity.finanzas.get(pos).getDescripcion()+"')");
        }
        bd.close();
    }

    public void recuperarBaseDatos(int mesPulsado) {
       Finanzas finan;
        if (CalendarActivity.finanzas.size() > 0) {

            Toast.makeText(context, "No recuperamos los datos de la base de datos ya que no se han perdidio", Toast.LENGTH_LONG).show();
        } else {

            SQLiteDatabase db = getReadableDatabase();
        /* Se obtienen una referencia a la base de datos para poder leer. */
            Cursor cursor = db.rawQuery("SELECT cantidad, dia, mes, anyo, desc FROM "
                    + "PAGOS WHERE mes = "+mesPulsado, null);

            while (cursor.moveToNext()) {
                finan=new Finanzas(cursor.getInt(0),cursor.getInt(1),cursor.getInt(2),cursor.getInt(3),cursor.getString(4));
                CalendarActivity.finanzas.add(finan);

            }
            cursor.close();
            db.close();

        }}



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

