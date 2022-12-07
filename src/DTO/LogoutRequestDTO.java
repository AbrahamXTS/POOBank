package DTO;
/**
 * LogoutRequestDTO es una clase auxiliar la cual contiene la información 
 * necesaria para el logout.
 * @author Elias Madera
 */
public class LogoutRequestDTO {

    private String token;

	/**
     * Constructor vacío que crea un LogoutRequestDTO.
     */
	public LogoutRequestDTO() {}

	/**
	 * Constructor que crea un LogoutRequestDTO recibiendo como parámetros un token.
	 * @param token Es el token de un cliente
	 */
	public LogoutRequestDTO(String token) {
		this.token = token;
	}

	/**
	 * Método que devuelve el token de un cliente
	 * @return Devuelve el token de un cliente
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Método que cambia el token de un cliente
	 * @param token Es un token de un cliente
	 */
	public void setToken(String token) {
		this.token = token;
	}

}
