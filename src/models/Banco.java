package models;

import java.util.ArrayList;
import java.util.List;

class Banco {

    private String nombre;
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> Clientes) {
        this.clientes = Clientes;
    }
}