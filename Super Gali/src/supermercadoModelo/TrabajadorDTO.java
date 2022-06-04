package supermercadoModelo;

/**
* Clase que representa al trabajador
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class TrabajadorDTO {
	
	private Integer codEmpleado;
	private String usuario;
	private String contraseña;
	private String nombre;
	private String dni;
	

	/**
	 * Constructor del trabajador
	 * @param codEmpleado codigo del trabajador
	 * @param usuario usuario del trabajador
	 * @param contraseña contraseña del trabajador
	 * @param nombre nombre del trabajador
	 * @param dni dni del trabajador
	 */
	public TrabajadorDTO (Integer codEmpleado, String usuario,  String contraseña, String nombre, String dni) {
		
		this.codEmpleado = codEmpleado;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.dni = dni;
	}

	/**
	 * @return del dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni dni asignado al trabajador
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return del usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario usuario que se le asigna al trabajador
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return del codigo del trabajador
	 */
	public Integer getCodEmpleado() {
		return codEmpleado;
	}

	/**
	 * @param codEmpleado codigo del trabajador asignado
	 */
	public void setCodEmpleado(Integer codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	/**
	 * @return de la contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña contraseña del trabajador
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return del nombre del trabajador
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre nombre del trabajador
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
