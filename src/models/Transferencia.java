package models;

import java.sql.ResultSet;

public class Transferencia extends Transaccion {
    
    private int destino;
    private String concepto;

    public Transferencia(){} // Constructor vacio

    public Transferencia(int numeroDeCuenta, int destino, double monto, String concepto) {
        super(numeroDeCuenta, monto);
        boolean paso;
        try {
            paso =nube.Generartransferencia(numeroDeCuenta,destino, monto,concepto); //usen el booleano para validar
            
        } catch (Exception e) {
            //mandar mensaje de que no tiene conexion
        }
    }

    public ResultSet gettransferencias(int no_Cuenta){
        return nube.DevolverTransferenciaPorCuenta(no_Cuenta);
    }

    public int getDestino() {
        return destino;
    }

    public String getConcepto() {
        return concepto;
    }
}
