package models;

import java.sql.ResultSet;
import java.util.List;

import models.database.DB_query;

public abstract class Cuenta {
    private DB_query nube = new DB_query();
    
    private int numeroDeCuenta;
    private int numeroDeCliente;
    private double saldo;

    public Cuenta(){} //constructor vacio
    
    protected Cuenta(Integer numeroDeCliente) { //terminado 2.0
        this.numeroDeCliente = numeroDeCliente;
        this.saldo = 0;
        this.numeroDeCuenta = nube.NuevaCuenta(numeroDeCliente);
    }

    public void setCuenta(int Cuenta) { 
        this.numeroDeCuenta = Cuenta;
    }


    public void setNumeroDeCliente(int no_cliente) {
        this.numeroDeCliente = no_cliente;
    }


    public void setSaldo(double Saldo) {
        this.saldo = Saldo;
    }


    public int getCuenta(int IdCliente) { 
        return numeroDeCuenta;
    }


    public int getNumeroDeCliente(int no_cuenta) {
        return numeroDeCliente;
    }


    public double getSaldo(int no_cuenta) {
        return saldo;
    }


    public List<Cuenta> getCuentas(int IdCliente) { //Devuelvo todas las cuentas asosiadas al cliente. Revisado 2.0
        return nube.CuentasPorCliente(IdCliente);
    }


    public boolean ActualizarCuenta(int cuenta, int saldo) { //Usa esta funcion para lo que hayas afectado, se actualice en la base de datos. terminado 2.0
        return nube.ActualizarCuenta(cuenta, saldo);
    }

 
    public boolean EliminarCuenta(int no_cuenta) {// terminado 2.0
        return nube.EliminarCuenta(no_cuenta);
    }


}