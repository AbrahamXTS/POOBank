package services;

import java.util.Optional;

import DTO.*;
import models.Cuenta;
import models.Transferencia;
import models.database.DB_query;
import utilities.WrapperResponse;

/**
* TransferService es una clase utilizada como servicio para realizar una transferencia entre dos cuentas existentes en el banco

@author Carlos May

*/
public class TransferService {

	
	DB_query nube = new DB_query();

	/**
	 * Método que realiza la transferencia, modifica los saldos de las cuentas y crea la transferencia, si alguna cuenta no existe o 
	 no tiene los fondos suficientes devuelve un WrapperResponse con un mensaje predeterminado, además de un booleano que define 
	 el estado de la operación

	 * @param transfer Objeto de TransferRequestDTO con la información del número de cuenta emisora, receptora, el monto y el concepto de
	 la transferencia
	 * @return Devuelve WrapperResponse con un booleano definiendo el estado de la operación y un mensaje describiendo la situación
	 */
	
    public WrapperResponse<Boolean> transfer(TransferRequestDTO transfer){

		Cuenta cuentaEmisora = nube.CuentaPorNumeroDeCuenta(transfer.getNumeroCuentaEmisora());
		Cuenta cuentaReceptora = nube.CuentaPorNumeroDeCuenta(transfer.getNumeroCuentaDestino());

		boolean ok = false;
		String mensaje;


		Transferencia transferencia = new Transferencia(transfer.getNumeroCuentaEmisora(), transfer.getNumeroCuentaDestino(), transfer.getMonto(), transfer.getConcepto());
		transferencia.GuardarTransferencia(transferencia);

        if ((cuentaEmisora != null)){
			if ((cuentaReceptora != null)){

				if(cuentaEmisora.getSaldo(transfer.getNumeroCuentaEmisora())>=transfer.getMonto()){			
					cuentaEmisora.setSaldo(cuentaEmisora.getSaldo(transfer.getNumeroCuentaEmisora())-transfer.getMonto());
					cuentaReceptora.setSaldo(cuentaReceptora.getSaldo(transfer.getNumeroCuentaDestino())+transfer.getMonto());

					cuentaEmisora.ActualizarCuenta(cuentaEmisora);
					cuentaReceptora.ActualizarCuenta(cuentaReceptora);

					ok = true;
					mensaje = "Transferencia exitosa";
				} else {
					mensaje = "No se pudo sustraer el monto de la cuenta emisora";
				}
			} else {
				mensaje = "La cuenta receptora no existe";
			}
        } else {
			mensaje = "La cuenta emisora no existe";
		}

		return new WrapperResponse<Boolean>(ok, mensaje, null);

    }



}
