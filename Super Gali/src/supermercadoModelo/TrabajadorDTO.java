package supermercadoModelo;

public class TrabajadorDTO {
	
	private Integer codEmpleado;
	private String usuario;
	private String contrase�a;
	private String nombre;
	private String dni;
	private Integer caja;
	

	public TrabajadorDTO (Integer codEmpleado, String usuario,  String contrase�a,Integer caja, String nombre, String dni) {
		
		this.codEmpleado = codEmpleado;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.nombre = nombre;
		this.dni = dni;
		this.caja = caja;
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


	public String getContrase�a() {
		return contrase�a;
	}


	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCaja() {
		return caja;
	}


	public void setCaja(Integer caja) {
		this.caja = caja;
	}
}
