package models.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Cliente;
import models.Cuenta;
import models.Transaccion;

public class DB_query {
    private static DB_connect dataBase = new DB_connect();

    public DB_query(){}

    ////////////////////  Consultas Globales /////////////////////

    public ResultSet DevolverClientes(){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente");
            res = ps.executeQuery();
            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null;
        }
    }


    public ResultSet DevolverCuentas(){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente");
            res = ps.executeQuery();   
            dataBase.Finish();

            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null; //Si es null, es error
        }
    }


    public ResultSet DevolverTransferencias(){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Transferencia");
            res = ps.executeQuery();
            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null; // si es null, es error
        }
    }


    public ResultSet DevolverDepositos(){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Deposito");
            res = ps.executeQuery();  

            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
           // System.out.println(e);
            return null; //si es null, es error
        }
    }


    public ResultSet DevolerRetiros(){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Retiro");
            res = ps.executeQuery();    

            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null; //si es vacio, es error
        }
    }


    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Clientes  /////////////////////
    ///////////////////////////////////////////////////////////////

    // Genera un nuevo cliente y le asigna un id
    public int NuevoCliente(String nombre, String apellido, String Curp, boolean tokeen){
        int id=0;
        PreparedStatement ps;
        ResultSet res;

        String reg = "INSERT INTO Cliente (Nombre, Apellido, CURP, tokeen) VALUES(" + nombre + ","+ apellido + ","+ Curp + "," + tokeen + ")";

        try {
            
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            res = ps.executeQuery();
            id = res.getInt(0);
            dataBase.Finish();
            //System.out.println("Se a generado el nuevo cliente");
        
        } catch (Exception e) {
           System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        return id; //verifiquen que si es 0, es error (para backends)
    }

    //Actualiza la informacion del cliente
    public String ActualizarCliente (Cliente cliente){

        PreparedStatement ps;
        String reg = "UPDATE Cliente SET Nombre = "+cliente.getNombre()+", Apellido = "+cliente.getApellido()+" , CURP = "+cliente.getCURP()+", No_cuentas = "+cliente.gettokeen()+" WHERE Id = "+cliente.getID();

        try {
            dataBase.Generate_Connection();
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            return "Los datos del cliente han sido actualizados ";
            
            
        } catch (Exception e) {
            return ("No se pudieron actualizar los datos");
        }
        

    }

    //Devuelve los datos de un cliente especificado por el id
    public ResultSet DatosCliente(String Id){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente WHERE Id= "+Id);

            res = ps.executeQuery();
     
            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    // Elimina de la base de datos a un cliente
    public String EliminarCliente(String id){
        PreparedStatement ps;
        String reg = "DELETE FROM Cliente WHERE Id = "+id;

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.execute();
            dataBase.Finish();
            return ("Informacion del "+id+" a sido eliminado");
        } catch(Exception e) {
            return ("No se encontro el Id");
        }
    }

    //////////// Devolver datos Individuales ////////////////

    //Devuelve el nombre del cliente con el id especificado
    public String GetNombreCliente(int Id){ 
        String nombre = null;
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT Nombre FROM Cliente WHERE Id= "+Id);

            res = ps.executeQuery();
            nombre = res.getString(0);
     
            dataBase.Finish();
            return nombre;
            
        }catch(Exception e)
        {
            System.out.println(e);
            return nombre;
        }
    }


    //Asigna el nuevo nombre a la base de datos y devuelve un boolean para saber si paso o no
    public boolean SetNombreCliente(String nombre, int id){
        boolean paso;
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("UPDATE Cliente SET Nombre = " +nombre +" WHERE Id= "+id);

            res = ps.executeQuery();
            nombre = res.getString(0);
     
            dataBase.Finish();
            paso =true;
            
        }catch(Exception e)
        {
            System.out.println(e);
            paso = false;
        }

        return paso;
    }


    //Devuelve el Apellido del cliente con el id especificado
    public String GetApellidoCliente(int Id){ 
        String apellido = null;
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT Apellido FROM Cliente WHERE Id= "+Id);
            res = ps.executeQuery();
            apellido = res.getString(0);
     
            dataBase.Finish();
            return apellido;
            
        }catch(Exception e)
        {
            System.out.println(e);
            return apellido;
        }
    }


    //Asigna el nuevo apellido a la base de datos y devuelve un boolean para saber si paso o no
    public boolean SetApellidoCliente(String apellido, int id){
            boolean paso;
            PreparedStatement ps;
            ResultSet res;
            
            try{
                ps = dataBase.Generate_Connection().prepareStatement("UPDATE Cliente SET Apellido = " +apellido +" WHERE Id= "+id);
    
                res = ps.executeQuery();
                apellido = res.getString(0);
         
                dataBase.Finish();
                paso =true;
                
            }catch(Exception e)
            {
                System.out.println(e);
                paso = false;
            }
    
            return paso;
    }


    //Devuelve la CURP del cliente con el id especificado
    public String GetCURPCliente(int Id){ 
        String curp = null;
        PreparedStatement ps;
        ResultSet res;
            
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT CURP FROM Cliente WHERE Id= "+Id);
    
            res = ps.executeQuery();
            curp = res.getString(0);
         
            dataBase.Finish();
            return curp;
                
        }catch(Exception e)
        {
            System.out.println(e);
            return curp;
        }
    }
    
    
    //Asigna el nuevo curp a la base de datos y devuelve un boolean para saber si paso o no
    public boolean SetCURPCliente(String curp, int id){
        boolean paso;
        PreparedStatement ps;
        ResultSet res;
            
            try{
                ps = dataBase.Generate_Connection().prepareStatement("UPDATE Cliente SET CURP = " +curp +" WHERE Id= "+id);
        
               res = ps.executeQuery();
                curp = res.getString(0);
         
                dataBase.Finish();
                paso =true;
                    
            }catch(Exception e)
            {
                System.out.println(e);
                paso = false;
            }
        
            return paso;
    }


    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Cuentas   /////////////////////
    ///////////////////////////////////////////////////////////////

    public int NuevaCuenta(int id_cliente){
        int generado = 0;
        PreparedStatement ps;
        ResultSet res;

        String reg = "INSERT INTO Cuenta (No_cuenta, Saldo) VALUES("+id_cliente +")";

        try {
            
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            res = ps.executeQuery();
            generado = res.getInt(0);
            dataBase.Finish();
            //System.out.println("Se a generado el nuevo cliente");

        
        } catch (Exception e) {
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
            generado = 0;
        }

        return generado;
    }

    public boolean ActualizarSaldo (int saldo, int id_cuenta) { // sin terminar
        boolean paso;
        PreparedStatement ps;
        String reg = "UPDATE Cuenta SET saldo = "+ saldo +" WHERE Id = "+ id_cuenta;

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();

            paso = true;
            
            
        } catch (Exception e) {
            //System.out.println("No se pudieron actualizar los datos");
            //e.printStackTrace();
            paso = false;
        }
        
        return paso;

    }

    public ResultSet CuentasPorCliente(int IdCliente){ 
        PreparedStatement ps;
        ResultSet res = null;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Cliente_Cuentas WHERE Id_Cliente = "+ IdCliente);
            res = ps.executeQuery();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return res;
    }

    public int ClientePorCuenta(int no_Cuenta){ 
        int cliente=0;
        PreparedStatement ps;
        ResultSet res = null;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT Id_Cliente FROM Cliente_Cuentas WHERE No_Cuenta = "+ no_Cuenta);
            res = ps.executeQuery();
            cliente = res.getInt(0);
            dataBase.Finish();
            
        }catch(Exception e)
        {
            cliente=0;
        }
        return cliente;
    }

    public boolean EliminarCuenta(String id){
        boolean paso;
        PreparedStatement ps;
        String reg = "DELETE FROM Cliente WHERE Id = "+id;

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.execute();
            dataBase.Finish();
            paso = true;
        } catch(Exception e) {
            paso = false;
        }
        return paso;
    } 

    public int ConsultaSaldo(int no_Cuenta){ 
        int saldo=0;
        PreparedStatement ps;
        ResultSet res = null;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT Saldo FROM Cuentas WHERE No_cuenta = "+ no_Cuenta);
            res = ps.executeQuery();
            saldo = res.getInt(2);
            dataBase.Finish();
            
        }catch(Exception e)
        {
            saldo=0;
        }
        return saldo;
    }



    ///////////////////////////////////////////////////////////////
    ///////////////////  CRUD para Depositos  /////////////////////
    ///////////////////////////////////////////////////////////////

    public boolean GenerarDeposito(int numeroDeCuenta, double monto, String concepto){
        boolean paso= false;
        PreparedStatement ps;

        String reg = "INSERT INTO Deposito (Cuenta, Monto,Concepto) VALUES("+ numeroDeCuenta+ "," +monto+"," + concepto +")";

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            paso = true;
            dataBase.Finish();
           //System.out.println("Se a registrado el deposito");
        
        } catch (Exception e) {
            paso = false;
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        return paso;
    }

    public ResultSet DevolverDepositosPorCuenta(int numeroDeCuenta){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Deposito WHERE Cuenta = "+ numeroDeCuenta);
            res = ps.executeQuery();
            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null; // si es null, es error
        }
    }



    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Retiros  //////////////////////
    ///////////////////////////////////////////////////////////////


    public boolean GenerarRetiro(int numeroDeCuenta, double monto){
        boolean paso= false;
        PreparedStatement ps;

        String reg = "INSERT INTO Retiro (Cuenta, Monto,Concepto) VALUES("+ numeroDeCuenta+ "," +monto+")";

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            paso = true;
            dataBase.Finish();
           //System.out.println("Se a registrado el deposito");
        
        } catch (Exception e) {
            paso = false;
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        return paso;
    }

    public ResultSet DevolverRetirosPorCuenta(int numeroDeCuenta){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Retiro WHERE Cuenta = "+ numeroDeCuenta);
            res = ps.executeQuery();
            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null; // si es null, es error
        }
    }

    ///////////////////////////////////////////////////////////////
    ///////////////// CRUD para Transferencias  ///////////////////
    ///////////////////////////////////////////////////////////////

    public boolean Generartransferencia(int CuentaEmisora,int cuentaDestino, double monto, String concepto){
        boolean paso= false;
        PreparedStatement ps;

        String reg = "INSERT INTO Transferencia (Cuenta_Emisora,Cuenta_Destino, Monto,Concepto) VALUES("+ CuentaEmisora+ "," +monto+ ","+ concepto+")";

        try {
            ps = dataBase.Generate_Connection().prepareStatement(reg);
            ps.executeUpdate();
            paso = true;
            dataBase.Finish();
           //System.out.println("Se a registrado el deposito");
        
        } catch (Exception e) {
            paso = false;
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        return paso;
    }

    public ResultSet DevolverTransferenciaPorCuenta(int numeroDeCuenta){ 
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Generate_Connection().prepareStatement("SELECT * FROM Transferencia WHERE Cuenta_Emisora = "+ numeroDeCuenta + " OR Cuenta_Destino = "+ numeroDeCuenta);
            res = ps.executeQuery();
            dataBase.Finish();
            return res;
            
        }catch(Exception e)
        {
            //System.out.println(e);
            return null; // si es null, es error
        }
    }



}// fin de la clase DB_query
