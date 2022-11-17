package controllers;

import services.ClientService;
import utilities.WrapperResponse;

public class ClientController {
    
    ClientService clientService;

    public WrapperResponse<Boolean> addClient(ClientDTO cdto) {
        
    

		return new WrapperResponse<Boolean>(null, null, null);
	}



}
