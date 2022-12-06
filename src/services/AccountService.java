package services;

import models.database.DB_query;
import utilities.WrapperResponse;
import DTO.AccountDTO;

public class AccountService {
    
    DB_query query;

    public AccountService(DB_query query) {
        this.query = query;
    }

    public WrapperResponse<Boolean> addAccount(int ID) {
        
        boolean ok = false;
        String message = "";
        boolean added = false;
        
        try {
            
            query.NuevaCuenta(ID);
            
            ok = true;
            message = "Account added correctly";
            added = true;

        } catch (Exception e) {

            ok = false;
            message = "Error, Account was not added";
            added = false;
        }

		return new WrapperResponse<>(ok, message, added);
	}

    public WrapperResponse<Boolean> updateAccountBalance(int balance){
        boolean ok = false;
        String message = "";
        boolean updated = false;

        try {
            query.ActualizarSaldo(balance, 1);
            ok = true;
            message = "Updated account balance";
            updated = true;
        }  catch (Exception e) {
            ok = false;
            message = "Account balance not updated :c";
            updated = false;
        }
        
        return new WrapperResponse<>(ok, message, updated);
    }


    public WrapperResponse<Boolean> deleteAccount(int ID_Cuenta){
        
        boolean ok = false;
        String message = "";
        boolean deleted = false;
        String id_Cuenta = String.valueOf(ID_Cuenta);

        try {

            deleted = query.EliminarCuenta(id_Cuenta);

            ok = true;
            message = "Account was deleted";

        } catch (Exception e){
            
            ok = false;
            message = "Error, Account wasn't deleted";
            deleted =  false; 
        }
                
        return new WrapperResponse<Boolean>(ok, message, deleted);
    }

}
