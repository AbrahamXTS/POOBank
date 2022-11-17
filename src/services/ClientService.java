package services;

import utilities.WrapperResponse;

import java.sql.ResultSet;
import java.util.spi.CurrencyNameProvider;
import models.Cliente;
import DTO.ClientDTO;
import models.database.DB_query;

public class ClientService {
    
    DB_query query;

    public ClientService(DB_query query) {
        this.query = query;
    }

    public WrapperResponse<Boolean> addClient(ClientDTO cdto) {
        
        boolean ok = false;
        String message = "";
        boolean added = false;

        try {
            query.NuevoCliente(cdto.getNombre(), cdto.getApellido(), cdto.getCURP(),cdto.gettokeen());
            ok = true;
            message = "Client added correctly";
            added = true;

        } catch (Exception e) {
            ok = false;
            message = "An error has ocurred :c prro";
            added = false;
        }

		return new WrapperResponse<>(ok, message, added);
	}

    public WrapperResponse<Boolean> updateClient(ClientDTO cdto){
        
        boolean ok = false;
        String message = "";
        boolean updated = false;

        Cliente nuevo_Cliente = cdtoToCliente(cdto);

        try {
            
            query.ActualizarCliente(nuevo_Cliente);

            ok = true;
            message = "Cliente actualizado";
            updated = true;
            
        } catch (Exception e){

            ok = false;
            message = "Error, Client was not Update";
            updated = false;       
        }

        return new WrapperResponse<>(ok, message, updated);
    }

    public WrapperResponse<Boolean> deleteClient(int ID){
        
        boolean ok = false;
        String message = "Client was deleted succesfully";
        boolean deleted = false;
        String id_Cliente = String.valueOf(ID);
        
        try {

            query.EliminarCliente(id_Cliente); //parámetro ID 
            ok = true;
            message = "Client was deleted succesfully :D";
            deleted = true;
                  
        } catch (Exception e) {
            ok = false;
            message = "Error, Client wasn't deleted";
            deleted = false;
        }
     
        return new WrapperResponse<Boolean>(ok, message, deleted);
    }

//Convierte un objeto CLientCDTO a un objeto Cliente
    private Cliente cdtoToCliente(ClientDTO cdto){
        
        Cliente cliente = null;
        // cliente = query.devolverClientePorID(cdto.getID()); 
        return cliente;
    }


}
