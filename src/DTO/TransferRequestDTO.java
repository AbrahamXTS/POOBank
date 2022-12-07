package DTO;
/**
 * TransferRequestDTO es una clase auxiliar la cual contiene la información necesaria
 * para hacer una transferencia.
 * @author Fernando Joachín Prieto 
 */

public class TransferRequestDTO {
    private int numeroCuentaDestino;
    private int numeroCuentaEmisora;
    private String concepto;
    private double monto;

    /**
     * Constructor vacío que crea un TransferRequestDTO.
     */
	public TransferRequestDTO() {}

    /**
     * Constructor que crea un TransferRequestDTO recibiendo como parámetros datos sobre la transferencia realizada.
     * @param numeroCuentaDestino Es el número de la cuenta que recibe el traslado de los fondos de la cuenta emisora.
     * @param numeroCuentaEmisora Es el número de la cuenta que envia el traslado de fondos a la cuenta destino.
     * @param concepto Es la descripción de la transferencia que se realizo.
     * @param monto Es la cantidad de dinero que se va a trasladar de la cuenta emisora a la cuenta destino.
     */
	public TransferRequestDTO(int numeroCuentaDestino, int numeroCuentaEmisora, String concepto, double monto) {
		this.numeroCuentaDestino = numeroCuentaDestino;   
        this.numeroCuentaEmisora = numeroCuentaEmisora;
        this.concepto = concepto;
        this.monto = monto;
	}

    /**
     * Método que devuelve el número de la cuenta que recibe el traslado de los fondos de la cuenta emisora.
     * @return Devuelve el número de la cuenta destino.
     */
    public int getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    /**
     * Método que cambia el número de la cuenta que recibe el traslado de los fondos de la cuenta emisora.
     * @param numeroCuentaDestino Es el número de la cuenta destino.
     */
    public void setNumeroCuentaDestino(int numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    /**
     * Método que devuelve el número de la cuenta que envia el traslado de fondos a la cuenta destino.
     * @return Devuelve el número de la cuenta emisora.
     */
    public int getNumeroCuentaEmisora() {
        return numeroCuentaEmisora;
    }

    /**
     * Método que cambia el número de la cuenta que envia el traslado de fondos a la cuenta destino.
     * @param numeroCuentaEmisora Es el número de la cuenta emisora
     */
    public void setNumeroCuentaEmisora(int numeroCuentaEmisora) {
        this.numeroCuentaEmisora = numeroCuentaEmisora;
    }

    /**
     * Método que devuelve la descripción de la transferencia que se realizo.
     * @return Devuelve el concepto de la transferencia.
     */
    public String getConcepto() {
        return concepto;
    }
    
    /**
     * Método que cambia la descripción de la transferencia que se realizo.
     * @param concepto Es el concepto de la transferencia.
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * Método que devuelve la cantidad de dinero que se va a trasladar de la cuenta emisora a la cuenta destino.
     * @return Devuelve el monto de la transferencia
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Método que cambia la cantidad de dinero que se va a trasladar de la cuenta emisora a la cuenta destino.
     * @param monto es el monto de la transferencia.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
