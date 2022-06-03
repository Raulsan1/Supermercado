package supermercadoModelo;

public class DetalleFacturaDTO {

	private String codigoFatura;
	private Integer codigoProducto;
	private Integer cantidad;
	private Double precio;
	
	public DetalleFacturaDTO (String string, Integer codigoProducto, Integer cantidad, Double precio) {
		
		this.codigoFatura = string;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public DetalleFacturaDTO(Integer codigoProducto, Integer cantidad, Double precio) {

		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public String getCodigoFatura() {
		return codigoFatura;
	}

	public void setCodigoFatura(String codigoFatura) {
		this.codigoFatura = codigoFatura;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
}
