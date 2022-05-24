package supermercadoModelo;

public class TrabajadorDTO {
	
	private Integer codEmpleado;
	private String usuario;
	private String contrase�a;
	private String nombre;
	

	public TrabajadorDTO (Integer codEmpleado, String usuario,  String contrase�a, String nombre) {
		
		this.codEmpleado = codEmpleado;
		this.usuario = usuario;
		this.contrase�a = contrase�a;
		this.nombre = nombre;
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
}
