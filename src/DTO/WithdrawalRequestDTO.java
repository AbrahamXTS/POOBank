package DTO;

 /**
 * WithdrawalRequestDTO se trata de una clase auxiliar que contiene la información 
 * de las transacciones realizadas en el sistema adquiriendo de la 
 * base de datos datos como Numero de Cuenta y el monto de algún depósito.
 * 
 * @author Pablo Gamboa
 */

public class WithdrawalRequestDTO {
    
    private int numeroDeCuenta;
    private double monto;
	private String concepto;

	/**
	 * Constructor vacío que crea un DepositRequestDTO.
	 */
    public WithdrawalRequestDTO() {}

	/**
	 * El constructor recibe como parámetros los datos requeridos para
	 * la realización de un retiro bancario. 
	 * @param numeroDeCuenta Es el numero de la cuenta al cual se le retiraran los fondos.
	 * @param monto Es la cantidad de dinero que se va a retirar de la cuenta. 
	 */
	public WithdrawalRequestDTO(int numeroDeCuenta, double monto) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.monto = monto;
	}

	/**
	 * Método que retorna el número de cuenta en la que se esta realizando el retiro.
	 * @return devuelve el numero de la cuenta a la cual se le realiza el retiro. 
	 */
    public int getNumeroDeCuenta() {
		return this.numeroDeCuenta;
	}

	/**
	 * Método que cambia el número de cuenta donde se realiza el retiro. 
	 * @param numeroDeCuenta recibe el nuevo número de cuenta en la cual se realizará el retiro.
	 */
	public void setNnumeroDeCuenta(int numeroDeCuenta) {
		this.numeroDeCuenta = numeroDeCuenta;
	}
    
	/**
	 * Método que retorna la cantidad de dinero por el cual se realiza el retiro.
	 * @return devuelve el monto por el cual se realiza el retiro. 
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * Método que cambia la cantidad de dinero que se retira de la cuenta. 
	 * @param monto recibe el nuevo número para monto correspondiente al retiro.
	 */
	public void setMonto(float monto) {
		this.monto = monto;
	}

	public void setConcepto(String concepto){

		this.concepto = concepto;

	}

	public String getConcepto(){

		return this.concepto;

	}

}
