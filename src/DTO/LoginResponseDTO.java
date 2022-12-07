package DTO;
/**
 * LoginResponseDTO es una clase auxiliar que contiene la informacion para confirmar el login.
 */
public class LoginResponseDTO {
	
	private UserDTO user;
	private String token;
	/**
	 * Constructor vacío que crea un LoginResponseDTO.
	 */
	public LoginResponseDTO() {}

	/**
	 * Constructor que crea un LoginResponseDTO recibiendo como parámetros datos para confirmar el login.
	 * @param user Es un cliente
	 * @param token Es la token del cliente generada a partir de realizar el login
	 */
	public LoginResponseDTO(UserDTO user, String token) {
		this.user = user;
		this.token = token;
	}

	/**
	 * Método que devuelve un cliente
	 * @return Devuleve un UserDTO
	 */
	public UserDTO getUserDTO(){
		return this.user;
	}

	/**
	 * Método que cambia un cliente
	 * @param user Es un cliente
	 */
	public void setUserDTO(UserDTO user){
		this.user = user;
	}

	/**
	 * Método que duelve la cadena generada  apartir de la realización del login
	 * @return Devuelve un token
	 */
	public String getToken(){
		return this.token;
	}

	/**
	 * Método que cambia la cadena generada  apartir de la realización del login
	 * @param token Es la cadena generada a partir de realizar el login
	 */
	public void setToken(String token){
		this.token = token;
	}
	// get set
}