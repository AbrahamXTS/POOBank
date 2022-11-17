package controllers;

import services.ClientService;
import utilities.WrapperResponse;
import DTO.ClientDTO;

public class ClientController {
    
    ClientService clientService;

    public ClientController(ClientService cs){
      this.clientService = cs;
    }

    public WrapperResponse<Boolean> addClient(ClientDTO cdto) {
      return clientService.addClient(cdto);
	  }

    public WrapperResponse<Boolean> updateClient(ClientDTO cdto){
      return clientService.updateClient(cdto);
    }

    public WrapperResponse<Boolean> deleteClient(int ID){
      return clientService.deleteClient(ID);
    }
    
}
