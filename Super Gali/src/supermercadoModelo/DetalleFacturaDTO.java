package supermercadoModelo;

public class DetalleFacturaDTO {

	private String codigoFactura;
	private Integer codigoProducto;
	private Integer cantidad;
	private Double precio;
	
	public DetalleFacturaDTO (String string, Integer codigoProducto, Integer cantidad, Double precio) {
		
		this.codigoFactura = string;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public DetalleFacturaDTO(String codigoFactura) {

		this.codigoFactura = codigoFactura;
	}

	public String getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
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
