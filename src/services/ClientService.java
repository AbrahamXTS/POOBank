package services;

import controllers.ClientDTO;
import utilities.WrapperResponse;

public class ClientService {
    
    public ClientService() {}

    public WrapperResponse<Boolean> addClient(ClientDTO cdto) {
        boolean ok = false;
        String message = "";
        boolean added = false;


		return new WrapperResponse<>(ok, message, added);
	}

    public WrapperResponse<Boolean> delete(ClientDTO){
        
    }



}
