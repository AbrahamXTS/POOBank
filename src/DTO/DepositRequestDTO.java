package DTO;

/**
 * DepsitRequestDTO se trata de una clase auxiliar que contiene la información 
 * de las transacciones realizadas en el sistema adquiriendo de la 
 * base de datos datos como Numero de Cuenta y el monto de algún depósito.
 * 
 * @author Pablo Gamboa
 */

public class DepositRequestDTO {
    
    private int numeroDeCuenta;
    private double monto;
	private String Concepto;

	/**
	 * Constructor vacío que crea un DepositRequestDTO.
	 */
    public DepositRequestDTO() {}

	/**
	 * El constructor recibe como parámetros los datos requeridos para
	 * la realización de un depósito bancario. 
	 * @param numeroDeCuenta Es el numero de la cuenta que recibirá los fondos.
	 * @param monto Es la cantidad de dinero que se va a depositar a la cuenta. 
	 */
	public DepositRequestDTO(int numeroDeCuenta, double monto, String concepto) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
		this.Concepto = concepto;
	}

	/**
	 * Método que retorna el número de cuenta a la que se le esta realizando el depósito.
	 * @return devuelve el numero de la cuenta a la cual se le realiza el depósito. 
	 */
    public int getNumeroDeCuenta() {
		return numeroDeCuenta;
	}

	/**
	 * Método que cambia el número de cuenta que realiza el deposito. 
	 * @param numeroDeCuenta recibe el nuevo número de cuenta al cual se realizará el depósito.
	 */
	public void setNumeroDeCuenta(int numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
    
	/**
	 * Método que retorna la cantidad de dinero por el cual se realiza el depósito.
	 * @return devuelve el monto por el cual se realiza el depósito. 
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * Método que cambia la cantidad de dinero que se traslada en el deposito. 
	 * @param monto recibe el nuevo número para monto correspondiente al depósito.
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getConcepto(){

		return this.Concepto;

	}
	
	public void setConcepto(String concepto){

		this.Concepto = concepto;

	}

}
