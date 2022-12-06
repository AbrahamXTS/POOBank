package services.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import services.validations.exceptions.CustomException;

public class ClientValidation{
    
    
    // Valida la entrada del ID
    public static boolean validateID(int ID) throws CustomException{

        String Aux = Integer.toString(ID);

        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(Aux);

        boolean result = matcher.matches();

        if(result == false) {
            throw new CustomException("The ID contains invalid characters");
        }

        return result;

    }

    public static boolean validateNames(String Nombre) throws CustomException{

        Pattern pattern = Pattern.compile("^[a-zA-Z(áéíóúñ)]*");
        Matcher matcher = pattern.matcher(Nombre);

        boolean result = matcher.matches();

        if(result == false) {
            throw new CustomException("No es un nombre válido");
        }

        return result;

    }

    public static boolean validateCurp(String Curp) throws CustomException{

        Pattern pattern = Pattern.compile("^[A-Z0-9]*");
        Matcher matcher = pattern.matcher(Curp);

        boolean result = matcher.matches();

        if(result == false) {
            throw new CustomException("El formato de la CURP no es valido");
        }

        return result;

    }

}