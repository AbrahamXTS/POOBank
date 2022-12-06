package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.database.DB_query;

public class Cliente {
    private DB_query nube = new DB_query();

    private int Id;
    private String nombre;
    private String apellido;
    private String CURP;
    private Cuenta[] cuentas = new Cuenta[3];
    private boolean tooken = false;

    public Cliente(String nombre, String apellido, String CURP){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CURP = CURP;
        //subimos al nuevo cliente y damos el nuevo id generado
        this.Id = nube.NuevoCliente(nombre, apellido, CURP, tooken); 
    }

    public String getNombre() {
        return nube.GetNombreCliente(Id);
    }

    public boolean setNombre(String nombre) {
        boolean set = nube.SetNombreCliente(nombre,Id);
        this.nombre = nombre;
        return set;
    }

    public String getApellido() {
        return nube.GetApellidoCliente(Id);
    }

    public boolean setApellido(String Apellido) {
        boolean set = nube.SetApellidoCliente(Apellido,Id);
        this.apellido = Apellido;
        return set;
    }

    public String getCURP() {
        return nube.GetCURPCliente(Id);
    }

    public boolean setCURP(String cURP) {
        boolean set = nube.SetApellidoCliente(cURP,Id);
        this.apellido = cURP;
        return set;
    }

    public ResultSet getcuentas(int id){
        return nube.CuentasPorCliente(id);
    }

    public int getID() {
        return Id;
    }

    public boolean gettokeen() {
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
