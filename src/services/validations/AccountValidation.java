package services.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import services.validations.exceptions.CustomException;

public class AccountValidation{

    public static boolean validateAccountNumber(int numeroDeCuenta) throws CustomException{

        String Aux = Integer.toString(numeroDeCuenta);

        Pattern pattern = Pattern.compile("^\\d+$"); //Preguntar formato
        Matcher matcher = pattern.matcher(Aux);

        boolean result = matcher.matches();

        if(result == false) {
            throw new CustomException("El numero de cuenta no tiene el formato adecuado");
        }

        return result;

    }

    public static boolean validateAccountClient(int numeroDeCliente) throws CustomException{

        String Aux = Integer.toString(numeroDeCliente);

        Pattern pattern = Pattern.compile("^\\d+$"); //Preguntar formato
        Matcher matcher = pattern.matcher(Aux);

        boolean result = matcher.matches();

        if(result == false) {
            throw new CustomException("El numero de cliente no tiene el formato adecuado");
        }

        return result;

    }




}