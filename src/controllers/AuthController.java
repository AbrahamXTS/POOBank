package controllers;

import DTO.*;
import services.AuthService;
import utilities.WrapperResponse;
/**
 * AuthController es una clase que se encarga de controlar el flujo de información 
 * entre la vista y los servicios de cliente.
 * @author Elias Madera
 */
public class AuthController {

	private AuthService authService = new AuthService();

	/**
	 * Método que se encarga de controlar el login del cliente.
	 * @param user Es un DTO cleinte.
	 * @return Devuelve un LoginResponseDTO sobre el usuario.
	 */
	public WrapperResponse<LoginResponseDTO> login(LoginRequestDTO user) {
		return authService.login(user);
	}

	/**
	 * Método que se encarga de controlar el logout del cliente.
	 * @param user Es un DTO cliente.
	 * @return Devuelve un booleano sobre el logout del cliente.
	 */
	public WrapperResponse<Boolean> logout(LogoutRequestDTO user) {
		return authService.logout(user);
	}
}
