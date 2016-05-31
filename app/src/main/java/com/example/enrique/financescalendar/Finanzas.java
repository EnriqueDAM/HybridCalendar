package com.example.enrique.financescalendar;

/**
 * Created by usuario on 31/05/2016.
 */
public class Finanzas {

    int cantidad,dia,mes, anyo;
    String descripcion;

    public  Finanzas(int cant,int day,int month,int year,String desc){
        this.cantidad=cant;
        this.dia=day;
        this.mes=month;
        this.anyo =year;
        this.descripcion=desc;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
