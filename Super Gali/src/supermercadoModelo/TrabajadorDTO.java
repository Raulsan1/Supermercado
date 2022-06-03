package supermercadoModelo;

public class TrabajadorDTO {
	
	private Integer codEmpleado;
	private String usuario;
	private String contraseña;
	private String nombre;
	private String dni;
	

	public TrabajadorDTO (Integer codEmpleado, String usuario,  String contraseña, String nombre, String dni) {
		
		this.codEmpleado = codEmpleado;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.dni = dni;
	}


	public TrabajadorDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public Integer getCodEmpleado() {
		return codEmpleado;
	}


	public void setCodEmpleado(Integer codEmpleado) {
		this.codEmpleado = codEmpleado;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
