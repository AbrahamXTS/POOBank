package DTO;
/**
 * LoginRequestDTO es una clase auxiliar la cual contiene la información 
 * necesaria para el login.
 * @author Elias Madera
 */
public class LoginRequestDTO {

	private String username;
	private String password;

	/**
     * Constructor vacío que crea un LoginRequestDTO.
     */
	public LoginRequestDTO() {}

	/**
	 * Constructor que crea un LoginRequestDTO recibiendo como parámetros datos sobre el cliente.
	 * @param username Es el username del cliente.
	 * @param password Es el password del cliente.
	 */
	public LoginRequestDTO(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Método que devuelve el username del cliente
	 * @return Devuelve el username del cliente
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Método que cambia el username del cliente 
	 * @param username Es el username del cliente
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Método que devuelve el password del cliente
	 * @return Devuelve el password del cleinte
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Método que cambia el password del cliente
	 * @param password Es el password del cliente
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
