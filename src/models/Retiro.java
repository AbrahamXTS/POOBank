package models;

import java.sql.ResultSet;

public class Retiro extends Transaccion {

    public Retiro(int numeroDeCuenta, double monto) {
        super(numeroDeCuenta, monto);
        boolean paso;
        try {
            paso = nube.GenerarRetiro(numeroDeCuenta, monto); //para obtener si paso o no el retiro
            
        } catch (Exception e) {
            //mandar mensaje de que no tiene conexion
        }
    }


    public ResultSet getRetiros(int no_Cuenta){
        return nube.DevolverRetirosPorCuenta(no_Cuenta);
    }
}
