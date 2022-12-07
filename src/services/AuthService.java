package services;

import DTO.*;
import models.Cliente;
import models.database.DB_query;
import utilities.WrapperResponse;
import utilities.Utileria;

/**
 * AuthService es una clase auxiliar donde realizan los servicios de login y logout de clientes.
 * @author Elías Madera
 * */

public class AuthService {

	private DB_query nube = new DB_query();

	public AuthService() {}

	/** Método donde se realiza el  login dado un usuario y contraseña. Se verifica la existencia del usuario con ese username
	 * y que la contraseña le pertenezca. Si el login es exitoso se guarda un token en el cliente para posterior guardarse en la
	 * base de datos.
     * 
     * @param user LoginRequestDTO que contiene los atributos de username y password con el que se pretende hacer login.
     * 
     * @return Devuelve un WrapperResponse con un body null.
     */

	public WrapperResponse<LoginResponseDTO> login(LoginRequestDTO user) {

		if (nube.GetByUSERNAME(user.getUsername()) == null) { // No Existe el usuario
			
			return new WrapperResponse<LoginResponseDTO>(false, "No existe el usuario.", null);
		}
		if (nube.GetByUSERNAME(user.getUsername()).getPassword() != user.getPassword()){ // La contraseña no es correcta

			return new WrapperResponse<LoginResponseDTO>(false,"Contraseña incorrecta",null);

		}
		String token = Utileria.generarId(); // generar token 
		Cliente cliente = nube.GetByUSERNAME(user.getUsername());
		cliente.setToken(token); // guardar token 
		nube.ActualizarCliente(cliente);
		return new WrapperResponse<LoginResponseDTO>(true, "Inicio de sesión correcto.", new LoginResponseDTO(new UserDTO(user.getUsername()),token));
	}

	/** Método donde se realiza el  logout dado un token. Se verifica la existencia del usuario con ese token.
	 * Si el logout es exitoso se borra el token en el cliente para posterior actualizarse en la
	 * base de datos.
     * 
     * @param user LogoutRequestDTO que contiene los atributos de username y password con el que se pretende hacer logout.
     * 
     * @return Devuelve un WrapperResponse con un body true or false.
     */

	public WrapperResponse<Boolean> logout(LogoutRequestDTO user){

		if(nube.GetByTOKEN(user.getToken()) != null){ // Verifica el token existe

			return new WrapperResponse<Boolean>(false, "Cierre de sesión incorrecto", true);

		}
		Cliente cliente = nube.GetByTOKEN(user.getToken());
		cliente.setToken(null); // remueve el token		
		nube.ActualizarCliente(cliente);
		return new WrapperResponse<Boolean>(true, "Cierre de sesión correcto", true);

	} 


}
