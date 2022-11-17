package models;
import java.io.*;
import java.sql.SQLException;

import models.database.DB_query;
import utilities.Utileria;

public abstract class Transaccion {
    protected DB_query nube = new DB_query();
    protected int id;
    protected String fecha;
    protected double monto;
    protected int numeroDeCuenta;

    protected Transaccion() {  } //Constructor vacio

    protected Transaccion(Integer numeroDeCuenta, double monto) {
        this.fecha = Utileria.generarFecha();
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
    }

    public int getId() {
        return id;
    } 

    public String getfecha() {
        return fecha;
    } 

    public double getmonto() {
        return monto;
    } 

    public int getcuenta() {
        return numeroDeCuenta;
    } 
    
}