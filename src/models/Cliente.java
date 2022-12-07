package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.database.DB_query;

public class Cliente {
    private DB_query nube = new DB_query();

    private int Id;
    private String nombre;
    private String apellido;
    private String CURP;
    private List<Cuenta> cuentas = new ArrayList<Cuenta>();
    private String tooken = null;
    private String Password = null;

    public Cliente(){ } // utilizado para declararlo en los querys

    public Cliente(String nombre, String apellido, String CURP, String password){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CURP = CURP;
        this.Password = password;
        this.Id = nube.NuevoCliente(nombre, apellido, CURP,password,tooken); 
    }

    public boolean ActualizarCLiente (Cliente cliente){
        return nube.ActualizarCliente(cliente); //devuelve un mensaje de aprovacion o rechazo.
    }

    public boolean EliminarCLiente (Cliente cliente){
        return nube.EliminarCliente(Id); //devuelve un mensaje de aprovacion o rechazo.
    }

    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        this.nombre = nombre;
        return true;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean setApellido(String Apellido) {
        this.apellido = Apellido;
        return true;
    }

    public String getCURP() {
        return CURP;
    }

    public boolean setCURP(String cURP) {
        this.apellido = cURP;
        return true;
    }

    public String getPassword(){
        return Password;
    }

    public boolean setPassword(String pass){ 
        this.Password = pass;
        return true;
    }

    public List<Cuenta> getcuentas(){
        return cuentas;
    }

    public void setID(int id) {
        this.Id = id;
    }

    public int getID() {
        return Id;
    }

    public void setToken(String Token) {
        this.tooken = Token;
    }

    public String gettoken() {
        return tooken;
    }


    /*

    No funcionara de esta forma, devolvere un resultset de las cuentas que tiene relacionada.

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    Nunca se hara un set directo, siempre se crearan individualmente las cuentas asosiadas con el id del cliente
    public Cuenta[] getCuentas() {
        return cuentas;
    }
    
    */

}
