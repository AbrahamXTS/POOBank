package models;

import java.util.List;

public class Retiro extends Transaccion {

    public Retiro(){}

    public Retiro(int numeroDeCuenta, double monto, String Concepto) {
        super(numeroDeCuenta, monto,Concepto);
    }

    public boolean SubirRetiro(){
        return nube.RegistrarRetiro(numeroDeCuenta, monto, concepto);
    }


    public List<Retiro> getRetiros(int no_Cuenta){
        return nube.DevolverRetirosPorCuenta(no_Cuenta);
    }
}
