package models;

import java.sql.ResultSet;
import java.util.List;

public class Transferencia extends Transaccion {
    
    private int destino;

    public Transferencia(){} // Constructor vacio

    public Transferencia(int numeroDeCuenta, int destino, double monto, String concepto) {
        super(numeroDeCuenta, monto, concepto);
    }

    public List<Transferencia> gettransferencias(int no_Cuenta){
        return nube.DevolverTransferenciaPorCuenta(no_Cuenta);
    }

    public boolean SubirTransferencia(){
        return nube.RegistrarTransferencia(numeroDeCuenta, destino, monto, concepto);
    }

    public void setDestino(int Destino) {
        this.destino = Destino;
    } 


    public int getDestino() {
        return destino;
    }

}
