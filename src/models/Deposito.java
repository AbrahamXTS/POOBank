package models;
import java.util.List;

public class Deposito extends Transaccion {

    public Deposito(){}

    public Deposito(int numeroDeCuenta, double monto, String concepto) {
        super(numeroDeCuenta, monto,concepto);
    }

    public boolean SubirDepositos(){
        return nube.RegistrarDeposito(numeroDeCuenta, monto, concepto);
    }

    public List<Deposito> getDepositos(int no_Cuenta){
        return nube.DevolverDepositosPorCuenta(no_Cuenta);
    }
}
