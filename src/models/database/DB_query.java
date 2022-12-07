package models.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Cliente;
import models.Cuenta;
import models.Deposito;
import models.Retiro;
import models.Transferencia;

public class DB_query {
    private static DB_connect dataBase = new DB_connect();

    public DB_query(){}

    ////////////////////  Consultas Globales /////////////////////

    public List<Cliente> DevolverClientes(){ //Terminado 2.0
        List<Cliente> clientes = new ArrayList<Cliente>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Cliente");
            res = ps.executeQuery();

            while(res.next()){
                Cliente cliente = null;
                cliente.setID(res.getInt(1));
                cliente.setNombre(res.getString(2));
                cliente.setApellido(res.getString(3));
                cliente.setCURP(res.getString(4));
                cliente.setPassword(res.getString(5));
                cliente.setToken(res.getString(6));

                clientes.add(cliente);
            }

            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            //System.out.println(e);
            clientes = null;
        }

        return clientes;
    }


    public List<Cuenta> DevolverCuentas(){ //Terminado 2.0
        List<Cuenta> cuentas = new ArrayList<Cuenta>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Cliente");
            res = ps.executeQuery(); 
            while(res.next()){
                Cuenta cuenta = null;
                cuenta.setCuenta(res.getInt(1));
                cuenta.setSaldo(res.getInt(2));
                cuentas.add(cuenta);
            }
            
            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            //System.out.println(e);
            cuentas = null; //Si es null, es error
        }

        return cuentas;
    }


    public List<Transferencia> DevolverTransferencias(){ 
        List<Transferencia> transferencias = new ArrayList<Transferencia>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Transferencia");
            res = ps.executeQuery();

            while(res.next()){
                Transferencia trans = null; // no me deja declarar new Cuenta(); ayuda porfaaaa
                trans.setId(res.getInt(1));
                trans.setcuenta(res.getInt(2));
                trans.setDestino(res.getInt(3));
                trans.setmonto(res.getDouble(4));
                trans.setConcepto(res.getString(5));
                trans.setfecha(res.getString(6));
                transferencias.add(trans);
            }

            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            //System.out.println(e);
            transferencias = null; // si es null, es error
        }

        return transferencias;
    }


    public List<Deposito> DevolverDepositos(){ 
        List<Deposito> Depositos = new ArrayList<Deposito>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Deposito");
            res = ps.executeQuery();  

            while(res.next()){
                Deposito depo = null; // no me deja declarar new Cuenta(); ayuda porfaaaa
                depo.setId(res.getInt(1));
                depo.setcuenta(res.getInt(2));
                depo.setmonto(res.getDouble(4));
                depo.setConcepto(res.getString(5));
                depo.setfecha(res.getString(6));
                Depositos.add(depo);
            }

            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
           // System.out.println(e);
            Depositos = null; //si es null, es error
        }

        return Depositos;
    }


    public List<Retiro> DevolerRetiros(){ 
        List<Retiro> Retiros = new ArrayList<Retiro>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Retiro");
            res = ps.executeQuery(); 
            
            while(res.next()){
                Retiro retiro = null; // no me deja declarar new Cuenta(); ayuda porfaaaa
                retiro.setId(res.getInt(1));
                retiro.setcuenta(res.getInt(2));
                retiro.setmonto(res.getDouble(4));
                retiro.setConcepto(res.getString(5));
                retiro.setfecha(res.getString(6));
                Retiros.add(retiro);
            }

            ps.close();
            dataBase.Finish();

            
        }catch(Exception e)
        {
            //System.out.println(e);
            Retiros = null; //si es vacio, es error
        }

        return Retiros;
    }


    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Clientes  /////////////////////
    ///////////////////////////////////////////////////////////////

    // Genera un nuevo cliente y le asigna un id. terminado 2.0
    public int NuevoCliente(String nombre, String apellido, String Curp, String pass,String tokeen){
        int id=0;
        PreparedStatement ps;
        ResultSet res;

        String reg = "INSERT INTO Cliente (Nombre, Apellido, CURP,Password, TOKEN) VALUES(" + nombre + ","+ apellido + ","+ Curp + "," + pass + "," + tokeen + ")";

        try {
            
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.executeUpdate();
            res = ps.executeQuery();
            id = res.getInt(1);

            ps.close();
            dataBase.Finish();
            //System.out.println("Se a generado el nuevo cliente");
        
        } catch (Exception e) {
           System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        return id; //verifiquen que si es 0, es error (para backends)
    }


    //Actualiza la informacion del cliente. Revisado 2.0
    public boolean ActualizarCliente (Cliente cliente){

        PreparedStatement ps;
        boolean mensaje = false;
        String reg = "UPDATE Cliente SET Nombre = "+cliente.getNombre()+", Apellido = "+cliente.getApellido()+" , CURP = "+cliente.getCURP()+", Password =  "+cliente.getPassword()+", TOKEN =  "+cliente.gettoken()+" WHERE Id = "+cliente.getID();

        try {
            dataBase.Principal_Connection();
            ps = dataBase.Principal_Connection().prepareStatement(reg);

            ps.executeUpdate();
            ps.close();
            dataBase.Finish();
            mensaje = true;
            
            
        } catch (Exception e) {
            mensaje = false;
        }
    
        return mensaje;
    }


    //Devuelve los datos de un cliente especificado por el id. terminado 2.0
    public Cliente DatosClienteById(int Id){ 
        Cliente cliente = new Cliente();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Cliente WHERE Id= "+Id);

            res = ps.executeQuery();
            cliente.setNombre(res.getString(1));
            cliente.setApellido(res.getString(2));
            cliente.setCURP(res.getString(3));
            cliente.setPassword(res.getString(4));
     
            dataBase.Finish();
            ps.close();
            
        }catch(Exception e)
        {
            System.out.println(e);
            cliente =null;
        }

        return cliente;
    }


    // Elimina de la base de datos a un cliente. Revisado 2.0
    public boolean EliminarCliente(int id){
        boolean paso = false;
        PreparedStatement ps;
        String reg = "DELETE * FROM Cliente WHERE Id = "+id;

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.execute();

            ps.close();
            dataBase.Finish();
            paso = EliminaAsociasion(id);



        } catch(Exception e) {
            paso = false;

        }

        return paso;
    }


    // Elimina de la base de datos a un cliente. Revisado 2.0
    private boolean EliminaAsociasion(int id){
        boolean paso = false;
        PreparedStatement ps;
        String reg = "DELETE * FROM Cliente_Cuentas WHERE Id_Cliente = "+id;

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.execute();

            ps.close();
            dataBase.Finish();
            paso = true;


        } catch(Exception e) {
            paso = false;
        }

        return paso;
    }


    //Asigna el token a la base de datos y devuelve un boolean para saber si paso o no
    public boolean SetTOKEN(String token, int id){
        boolean paso;
        PreparedStatement ps;
            
            try{
                ps = dataBase.Principal_Connection().prepareStatement("UPDATE Cliente SET TOKEN = " +token +" WHERE Id= "+id);
        
                ps.executeQuery();
                
                ps.close();
                dataBase.Finish();
                paso =true;
                    
            }catch(Exception e)
            {
                System.out.println(e);
                paso = false;
            }
        
            return paso;
    }


    //Devuelve el cliente del token 
    public Cliente GetByTOKEN(String token){
        Cliente cliente= new Cliente();
        PreparedStatement ps;
        ResultSet res;
            
            try{
                ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Cliente WHERE TOKEN= "+token);
        
                res = ps.executeQuery();
                cliente.setNombre(res.getString(1));
                cliente.setApellido(res.getString(2));
                cliente.setCURP(res.getString(3));
                cliente.setPassword(res.getString(4));

                ps.close();
                dataBase.Finish();
                    
            }catch(Exception e)
            {
                System.out.println(e);
                cliente = null;
            }
        
            return cliente;
    }


    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Cuentas   /////////////////////
    ///////////////////////////////////////////////////////////////

    public int NuevaCuenta(int id_cliente){ //Revisado 2.0
        int no_cuenta = 999;
        PreparedStatement ps;
        ResultSet res;

        String reg = "INSERT INTO Cuenta (Saldo) VALUES("+ 0 +")"; //hacer una nueva cuenta con el saldo a 0.

        try {
            
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.executeUpdate();
            res = ps.executeQuery();
            no_cuenta = res.getInt(1);

            if(!CrearAsociacion(no_cuenta,id_cliente)){
                no_cuenta = 999; //Si la funcion da falso (entra a la funcion), vuelve a devolver la cuenta como 999 (intepretado como error[trabajo backend])
            }

            ps.close();
            dataBase.Finish();
            //System.out.println("Se a generado el nuevo cliente");

        
        } catch (Exception e) {
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
            no_cuenta = 999;
        }

        return no_cuenta; //si es 999 entonces es error
    }


    private boolean CrearAsociacion (int no_cuenta,int numerodeCliente){ //Quita la asociacion con el cliente. Terminado 2.0
        boolean paso;
        PreparedStatement ps;
        String reg = "INSERT INTO CLiente_Cuentas (Id_CLiente,No_cuenta) VALUES("+ numerodeCliente +" , "+ no_cuenta+")";

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.execute();

            ps.close();
            dataBase.Finish();
            paso = true;
        } catch(Exception e) {
            paso = false;
        }

        return paso;

    }


    public boolean ActualizarCuenta (int id_cuenta,double saldo) { // terminado 2.0
        boolean paso;
        PreparedStatement ps;
        String reg = "UPDATE Cuenta SET saldo = "+ saldo +" WHERE No_cuenta = "+ id_cuenta;

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.executeUpdate();

            paso = true;
            
            ps.close();
            dataBase.Finish();
            
        } catch (Exception e) {
            //System.out.println("No se pudieron actualizar los datos");
            //e.printStackTrace();
            paso = false;
        }
        
        return paso;

    }


    public List<Cuenta> CuentasPorCliente(int IdCliente){ // terminado 2.0
        List<Cuenta> cuentas = new ArrayList<Cuenta>();
        PreparedStatement ps;
        ResultSet res = null;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Cliente_Cuentas WHERE Id_Cliente = "+ IdCliente);
            res = ps.executeQuery();

            while(res.next()){
                Cuenta cuenta = null;
                int no_cuenta = res.getInt(2);

                cuenta.setCuenta(res.getInt(no_cuenta));
                cuenta.setSaldo(ConsultaSaldo(no_cuenta));
                cuentas.add(cuenta);
            }
            //Ciclo while para obtener todas las cuentas
            
            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            cuentas = null;
        }
        return cuentas;
    }


    public boolean EliminarCuenta(int no_cuenta){ //Elimina la cuenta y su informacion. Revisado 2.0
        boolean paso;
        PreparedStatement ps;
        String reg = "DELETE * FROM Cuentas WHERE No_cuenta = "+no_cuenta;

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.execute();

            ps.close();
            dataBase.Finish();
            paso = QuitarAsociacion(no_cuenta);
        } catch(Exception e) {
            paso = false;
        }
        return paso;
    } 


    private boolean QuitarAsociacion (int no_cuenta){ //Quita la asociacion con el cliente. Terminado 2.0
        boolean paso;
        PreparedStatement ps;
        String reg = "DELETE * FROM CLiente_Cuentas WHERE No_cuenta = "+no_cuenta;

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.execute();

            ps.close();
            dataBase.Finish();
            paso = true;
        } catch(Exception e) {
            paso = false;
        }

        return paso;

    }


    public double ConsultaSaldo(int no_Cuenta){ //Revisado 2.0
        double saldo=0;
        PreparedStatement ps;
        ResultSet res = null;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT Saldo FROM Cuentas WHERE No_cuenta = "+ no_Cuenta);
            res = ps.executeQuery();
            saldo = res.getInt(2);

            ps.close();
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

    //De manera local no actualizara el nuevo saldo, deben actualizar la cuenta por aparte (por el momento, actualizar la cuenta desde su objeto cuenta).
    public boolean RegistrarDeposito(int numeroDeCuenta, double monto, String concepto){
        boolean paso= false;
        double nuevoSaldo=0;
        double saldo= 0;
        PreparedStatement ps;


        //Registro del deposito
        String reg = "INSERT INTO Deposito (Cuenta, Monto,Concepto) VALUES("+ numeroDeCuenta+ "," +monto+"," + concepto +")";

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.executeQuery();

            ps.close();
            dataBase.Finish();




           //System.out.println("Se a registrado el deposito");
        
        } catch (Exception e) {
            paso = false;
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        //Generamos el deposito en estas 3 lineas
        //saldo = ConsultaSaldo(numeroDeCuenta);
        //nuevoSaldo = saldo + monto;
        //paso = ActualizarCuenta(numeroDeCuenta, nuevoSaldo);

        return paso;
    }


    public List<Deposito> DevolverDepositosPorCuenta(int numeroDeCuenta){ 
        List<Deposito> Depositos = new ArrayList<Deposito>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Deposito WHERE Cuenta = "+ numeroDeCuenta);
            res = ps.executeQuery();

            while(res.next()){
                Deposito depo = null; // no me deja declarar new Cuenta(); ayuda porfaaaa
                depo.setId(res.getInt(1));
                depo.setcuenta(res.getInt(2));
                depo.setmonto(res.getDouble(4));
                depo.setConcepto(res.getString(5));
                depo.setfecha(res.getString(6));
                Depositos.add(depo);
            }

            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            //System.out.println(e);
             // si es null, es error
        }

        return Depositos;
    }


    ///////////////////////////////////////////////////////////////
    ////////////////////  CRUD para Retiros  //////////////////////
    ///////////////////////////////////////////////////////////////


    public boolean RegistrarRetiro(int numeroDeCuenta, double monto, String Concepto){
        double saldo =0, nuevoSaldo = 0;
        boolean paso= false;
        PreparedStatement ps;

        String reg = "INSERT INTO Retiro (Cuenta, Monto,Concepto) VALUES("+ numeroDeCuenta+ "," +monto+"," +Concepto+")";

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.executeUpdate();
            paso = true;

            ps.close();
            dataBase.Finish();
           //System.out.println("Se a registrado el deposito");
        
        } catch (Exception e) {
            paso = false;
            // implementar estado si paso o no.
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        //saldo = ConsultaSaldo(numeroDeCuenta);
        //nuevoSaldo = saldo - monto;
        //paso = ActualizarCuenta(numeroDeCuenta, nuevoSaldo);

        return paso;
    }


    public List<Retiro> DevolverRetirosPorCuenta(int numeroDeCuenta){ 
        List<Retiro> Retiros = new ArrayList<Retiro>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Retiro WHERE Cuenta = "+ numeroDeCuenta);
            res = ps.executeQuery();

            while(res.next()){
                Retiro retiro = null; // no me deja declarar new Cuenta(); ayuda porfaaaa
                retiro.setId(res.getInt(1));
                retiro.setcuenta(res.getInt(2));
                retiro.setmonto(res.getDouble(4));
                retiro.setConcepto(res.getString(5));
                retiro.setfecha(res.getString(6));
                Retiros.add(retiro);
            }

            res.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            //System.out.println(e);
            Retiros = null; // si es null, es error
        }



        return Retiros;
    }

    ///////////////////////////////////////////////////////////////
    ///////////////// CRUD para Transferencias  ///////////////////
    ///////////////////////////////////////////////////////////////


    public boolean RegistrarTransferencia(int cuentaEmisora,int cuentaDestino, double monto, String concepto){
        double saldoEmisor =0, nuevoSaldoEmisor = 0, saldoDestino = 0, nuevoSaldoDestino = 0;
        boolean paso= false;
        PreparedStatement ps;

        String reg = "INSERT INTO Transferencia (Cuenta_Emisora,Cuenta_Destino, Monto,Concepto) VALUES("+ cuentaEmisora+ "," +monto+ ","+ concepto+")";

        try {
            ps = dataBase.Principal_Connection().prepareStatement(reg);
            ps.executeUpdate();

            ps.close();
            dataBase.Finish();
           //System.out.println("Se a registrado el deposito");
        
        } catch (Exception e) {
            //System.out.println("El registro no funciono correctamente");
            //e.printStackTrace();
        }

        //Se genera la transferencia
        //saldoEmisor = ConsultaSaldo(cuentaEmisora);
        //saldoDestino = ConsultaSaldo(cuentaDestino);
        //nuevoSaldoEmisor = saldoEmisor - monto;
        //nuevoSaldoDestino = saldoDestino + monto;

        //Verificamos que se realizo correctamente
        if(ActualizarCuenta(cuentaEmisora, nuevoSaldoEmisor) && ActualizarCuenta(cuentaDestino, nuevoSaldoDestino) ){
            paso = true;
        }else{
            paso = false;
        }

        return paso;
    }


    public List<Transferencia> DevolverTransferenciaPorCuenta(int numeroDeCuenta){ 
        List<Transferencia> transferencias = new ArrayList<Transferencia>();
        PreparedStatement ps;
        ResultSet res;
        
        try{
            ps = dataBase.Principal_Connection().prepareStatement("SELECT * FROM Transferencia WHERE Cuenta_Emisora = "+ numeroDeCuenta + " OR Cuenta_Destino = "+ numeroDeCuenta);
            res = ps.executeQuery();

            while(res.next()){
                Transferencia trans = null; // no me deja declarar new Cuenta(); ayuda porfaaaa
                trans.setId(res.getInt(1));
                trans.setcuenta(res.getInt(2));
                trans.setDestino(res.getInt(3));
                trans.setmonto(res.getDouble(4));
                trans.setConcepto(res.getString(5));
                trans.setfecha(res.getString(6));
                transferencias.add(trans);
            }

            ps.close();
            dataBase.Finish();
            
        }catch(Exception e)
        {
            //System.out.println(e);
            transferencias = null; // si es null, es error
        }

        return transferencias;
    }


}// fin de la clase DB_query