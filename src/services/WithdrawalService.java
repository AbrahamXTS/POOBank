package services;

import java.util.Optional;
import DTO.*;
import models.Cuenta;
import models.Retiro;
import models.database.DB_query;
import utilities.WrapperResponse;

/**
 * WithdrawalService es una clase auxiliar donde realiza un retiro de una cuenta que 
 * se encuentre en el banco.
 * 
 * @author Valentina Ortiz
 * */

public class WithdrawalService {

    private DB_query nube = new DB_query();

    /** Método donde se realiza el retiro de la cuenta, primero verifica si una cuenta es existente, si esto se cumple
     * verifica si el saldo que contiene la cuenta es suficiente al monto que se desea retirar, si cumple con ambos campos,
     * el retiro se realiza y se descuenta el monto que se retiró de la cuenta.
     * 
     * @param retiro Es un objeto creado de WithdrawalRequestDTO con la información del número de cuenta y el monto que se necesita
     * para hacer el retiro.
     * 
     * @return Devuelve un WrapperResponse con un booleano definiendo el estado de la operación y un mensaje describiendo
     * dicha operación
     */

    public WrapperResponse<Boolean> Withdrawal(WithdrawalRequestDTO retiro){

        boolean ok = false;
        String mensaje;
        
        Retiro withdrawal = new Retiro(retiro.getNumeroDeCuenta(), retiro.getMonto(),retiro.getConcepto());
        withdrawal.ActualizarRetiro(withdrawal);
    
        Cuenta cuenta = nube.CuentaPorNumeroDeCuenta(retiro.getNumeroDeCuenta());

        if(cuenta != null){

            if(cuenta.getSaldo(retiro.getNumeroDeCuenta()) >= retiro.getMonto()){

                cuenta.setSaldo(cuenta.getSaldo(retiro.getNumeroDeCuenta())-retiro.getMonto());
                cuenta.ActualizarCuenta(cuenta);

                ok = true;
                mensaje = "El retiro se realizó con éxito";
                  
            }else{
                mensaje = "No hay saldo suficiente para lo que se desea retirar";
            }
        } else{
            mensaje = "El número de cuenta no existe";
        
        }

        return new WrapperResponse<Boolean>(ok, mensaje, null);

    }

    
}
