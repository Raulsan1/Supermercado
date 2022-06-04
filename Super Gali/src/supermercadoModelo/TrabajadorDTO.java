package supermercadoModelo;

/**
* Clase que representa al trabajador
* @author Ra�l Sanz Andr�s
* @version 1.0
*/

public class TrabajadorDTO {
	
	private Integer codEmpleado;
	private String usuario;
	private String contrase�a;
	private String nombre;
	private String dni;
	

	/**
	 * Constructor del trabajador
	 * @param codEmpleado codigo del trabajador
	 * @param usuario usuario del trabajador
	 * @param contrase�a contrase�a del trabajador
	 * @param nombre nombre del trabajador
	 * @param dni dni del trabajador
	 */
	public TrabajadorDTO (Integer codEmpleado, String usuario,  String contrase�a, String nombre, String dni) {
		
		this.codEmpleado = codEmpleado;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
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
	 * @return de la contrase�a
	 */
	public String getContrase�a() {
		return contrase�a;
	}

	/**
	 * @param contrase�a contrase�a del trabajador
	 */
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
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
