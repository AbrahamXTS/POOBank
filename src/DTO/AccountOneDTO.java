
package DTO;

public class AccountOneDTO{

    private int numeroDeCuenta;
    private int numeroDeCliente;
    private double saldo;
    
    protected AccountOneDTO(Integer numeroDeCliente) {
        this.numeroDeCliente = numeroDeCliente;
        this.saldo = 0;
        // this.numeroDeCuenta = nube.NuevaCuenta(numeroDeCliente);
    }

    // public Account getCuentas(int IdCliente) { 
    // }

    public int getNumeroDeCliente(int no_cuenta) {
        return new Integer(0);
    }

    public double getSaldo(int saldo) {
        return new Double(0);
    }    
 

}