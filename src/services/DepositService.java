package services;

import java.util.Optional;
import DTO.*;
import models.Deposito;
import models.database.DB_query;
import models.Cuenta;
import utilities.WrapperResponse;

/**
 * DepositService es una clase auxiliar donde se realiza un deposito a una cuenta que 
 * se encuentre en el banco.
 * 
 * @author José Carlos Leo
 */

public class DepositService {

    private DB_query nube = new DB_query();

    /** 
     * Método donde se realiza el deposito a la cuenta, primero verifica si una cuenta es existente, si esto se cumple
     * el deposito se realiza y se aumenta el monto que se depistó a la cuenta.
     * 
     * @param deposito Es un objeto creado de DepositRequestDTO con la información del número de cuenta y el monto que se
     * depositará en la cuenta.
     * 
     * @return Devuelve un WrapperResponse con un booleano definiendo el estado de la operación y un mensaje describiendo
     * dicha operación.
     */

    public DepositService() {}

    public WrapperResponse<Boolean> Deposit(DepositRequestDTO deposito) {

        Boolean ok = false;

        String mensaje;

        Deposito deposit = new Deposito(deposito.getNumeroDeCuenta(), deposito.getMonto(),deposito.getConcepto());
        deposit.GuardarDeposito(deposit);

        Cuenta cuenta = nube.CuentaPorNumeroDeCuenta(deposito.getNumeroDeCuenta());
        
        if (cuenta != null) {
			
            cuenta.setSaldo(cuenta.getSaldo(deposito.getNumeroDeCuenta()) + deposito.getMonto()); // GUARDAR MODELO DESPUES DE EDITAR

            cuenta.ActualizarCuenta(cuenta);

            ok = true;

            mensaje = "El depósito se realizó con éxito.";

		} else {

            mensaje = "El número de cuenta no existe.";
        }

        return new WrapperResponse<Boolean>(ok, mensaje, null);
    }
}
