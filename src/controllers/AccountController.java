package controllers;

import services.AccountService;
import utilities.WrapperResponse;
import DTO.AccountDTO;

public class AccountController {
           
    AccountService accountService;

    public AccountController(AccountService as){
      this.accountService = as;
    }

    public WrapperResponse<Boolean> addAccount(int ID) {
      return accountService.addAccount(ID);
	}

    public WrapperResponse<Boolean> updateAccount(int balance){
      return accountService.updateAccountBalance(balance);
    }

    public WrapperResponse<Boolean> deleteClient(int ID){
      return accountService.deleteAccount(ID);
    }

}
