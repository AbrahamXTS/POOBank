package DTO;

public class AccountDTO {

    private int numeroDeCuenta;
    private int numeroDeCliente;
    private double saldo;

    public int getNumeroDeCuenta()  {
        return numeroDeCuenta;
    }

    // Preguntar si esto es necesario, no sabemos si el número de cuenta puede cambiar
    public void setNumeroDeCuenta(int numeroDeCuenta){
        this.numeroDeCuenta = numeroDeCuenta;
    }
    
    public int getNumeroDeCliente() {
        
        return numeroDeCliente;
    }
    
    public void setNumeroDeCliente(int numeroDeCliente){
        this.numeroDeCliente = numeroDeCliente;
    }

    public double getSaldo(){
        
        return saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }


    
}