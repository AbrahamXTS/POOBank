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
    protected String concepto;

    protected Transaccion() {  } //Constructor vacio

    protected Transaccion(Integer numeroDeCuenta, double monto, String Concepto) {
        this.fecha = Utileria.generarFecha();
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
        this.concepto = Concepto;
    }

    public void setId(int Id) {
        this.id = Id;
    }
    
    public void setfecha(String Fecha) {
        this.fecha = Fecha;
    } 

    public void setmonto(double Monto) {
        this.monto = Monto;
    } 

    public void setcuenta(int no_cuenta) {
        this.numeroDeCuenta = no_cuenta;
    } 

    public void setConcepto(String Concepto) {
        this.concepto = Concepto;
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

    public String getConcepto() {
        return concepto;
    }
    
}