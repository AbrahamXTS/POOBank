package DTO;

/**
 * UserDTO una clase auxiliar la cual contiene la información del cliente.
 */

public class UserDTO {
	
	private String username;

	/**
	 * Constructor vacio que crea un UserDTO.
	 */
	public UserDTO() {}

	/**
	 * Constructor que crea un UserDTO recibiendo como parámetros el username del cliente 
	 * @param username Es el username del cliente
	 */
	public UserDTO(String username) {
		this.username = username;
	}

	/**
	 * Método que devuelve el username del cliente
	 * @return Devuelve el username del cliente
	 */
	public	String getUsername(){
		return this.username;
	}

	/**
	 * Método que cambia el username del cliente
	 * @param username Es el username del cliente
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
}
