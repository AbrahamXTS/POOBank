package repositories;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import models.*;

public interface UserRepository {
	
	//Banco.java


	public String getNombre();
	public void setNombre(String nombre);
	public List<Cliente> getClientes();
	public void setClientes(List<Cliente> Clientes);

	//Cliente.java


	public boolean ActualizarCLiente (Cliente cliente);
	public boolean EliminarCLiente (Cliente cliente);
	public String getApellido();
	public boolean setApellido(String Apellido);
	public String getCURP();
	public boolean setCURP(String cURP);
	public String getPassword();
	public boolean setPassword(String pass);
	public List<Cuenta> getcuentas();
	public void setID(int id);
	public int getID();
	public void setToken(String Token);
	public String gettoken();

	//Cuenta.java

	public void setCuenta(int Cuenta);
	public void setNumeroDeCliente(int no_cliente);
	public void setSaldo(double Saldo);
	public int getCuenta(int IdCliente);
	public int getNumeroDeCliente(int no_cuenta);
	public List<Cuenta> getCuentas(int IdCliente);
	public boolean ActualizarCuenta(int cuenta, int saldo);
	public boolean EliminarCuenta(int no_cuenta);

	//Transsaccion.java

	public void setId(int Id);
	public void setfecha(String Fecha);
	public void setmonto(double Monto);
	public void setcuenta(int no_cuenta);
	public void setConcepto(String Concepto);
	public int getId();
	public String getfecha();
	public double getmonto();
	public int getcuenta();
	public String getConcepto();

	//Retiro.java

	public boolean SubirRetiro();
	public List<Retiro> getRetiros(int no_Cuenta);

	//Deposito.java


	public boolean SubirDepositos();
	public List<Deposito> getDepositos(int no_Cuenta);

	//Transferencia.java

	public boolean SubirTransferencia();
	public List<Transferencia> gettransferencias(int no_Cuenta);
	public void setDestino(int Destino);
	public int getDestino();

	//DB_connect.java

	public Connection Principal_Connection();
	public Connection Alter_Connection();
	public void Finish () throws SQLException;
	public String DBName();

	//DB_query.java


	public List<Cliente> DevolverClientes();
	public List<Cuenta> DevolverCuentas();
	public List<Transferencia> DevolverTransferencias();
	public List<Deposito> DevolverDepositos();
	public List<Retiro> DevolerRetiros();
	public int NuevoCliente(String nombre, String apellido, String Curp, String pass,String tokeen);
	public boolean ActualizarCliente (Cliente cliente);
	public Cliente DatosClienteById(int Id);
	public boolean EliminarCliente(int id);
	// private boolean EliminaAsociasion(int id);
	public boolean SetTOKEN(String token, int id);
	public Cliente GetByTOKEN(String token);
	public int NuevaCuenta(int id_cliente);
	// private boolean CrearAsociacion (int no_cuenta,int numerodeCliente);
	public boolean ActualizarCuenta (int id_cuenta,double saldo);
	public List<Cuenta> CuentasPorCliente(int IdCliente);
	// public boolean EliminarCuenta(int no_cuenta);
	// private boolean QuitarAsociacion (int no_cuenta);
	public double ConsultaSaldo(int no_Cuenta);
	public boolean RegistrarDeposito(int numeroDeCuenta, double monto, String concepto);
	public List<Deposito> DevolverDepositosPorCuenta(int numeroDeCuenta);
	public boolean RegistrarRetiro(int numeroDeCuenta, double monto, String Concepto);
	public List<Retiro> DevolverRetirosPorCuenta(int numeroDeCuenta);
	public boolean RegistrarTransferencia(int cuentaEmisora,int cuentaDestino, double monto, String concepto);
	public List<Transferencia> DevolverTransferenciaPorCuenta(int numeroDeCuenta);

	//Lector.java

	// private String[] leerArchivo(); //No me deja ponerlo, me dice que es un inutil.
	public String[] getDatos();
}
