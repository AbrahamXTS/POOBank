package models;

import java.sql.ResultSet;

public class Deposito extends Transaccion {

    public Deposito(int numeroDeCuenta, double monto, String concepto) {
        super(numeroDeCuenta, monto);
        try {
            nube.GenerarDeposito(numeroDeCuenta, monto,concepto);
            
        } catch (Exception e) {
            //mandar mensaje de que no tiene conexion
        }
    
    }

    public ResultSet getDepositos(int no_Cuenta){
        return nube.DevolverDepositosPorCuenta(no_Cuenta);
    }
}
