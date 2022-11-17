package models;

import java.sql.ResultSet;

import models.database.DB_query;

public abstract class Cuenta {
    private DB_query nube = new DB_query();
    
    private int numeroDeCuenta;
    private int numeroDeCliente;
    private double saldo;
    
    protected Cuenta(Integer numeroDeCliente) {
        this.numeroDeCliente = numeroDeCliente;
        this.saldo = 0;
        this.numeroDeCuenta = nube.NuevaCuenta(numeroDeCliente);
    }

    public ResultSet getCuentas(int IdCliente) { //no hay forma de encontrar la cuenta en especifica, devolvemos varias
        return nube.CuentasPorCliente(IdCliente);
    }

    public int getNumeroDeCliente(int no_cuenta) {
        return nube.ClientePorCuenta(no_cuenta);
    }

    public double getSaldo(int no_cuenta) {
        return nube.ConsultaSaldo(no_cuenta);
    }
}