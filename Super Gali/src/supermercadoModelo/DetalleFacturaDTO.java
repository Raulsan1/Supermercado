package supermercadoModelo;

/**
* Clase que representa a las detalleFactura
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class DetalleFacturaDTO {

	private String codigoFactura;
	private Integer codigoProducto;
	private Integer cantidad;
	private Double precio;
	
	/**
	 * Constructor de las detalleFacturaDTO
	 * @param codigoFactura codigo de la factura 
	 * @param codigoProducto codigo del producto
	 * @param cantidad cantidad del producto
	 * @param precio precio del producto por la cantidad
	 */
	
	public DetalleFacturaDTO (String codigoFactura, Integer codigoProducto, Integer cantidad, Double precio) {
		
		this.codigoFactura = codigoFactura;
		this.codigoProducto = codigoProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	/**
	 * Constructor de las detalleFacturaDTO
	 * @param codigoFactura codigo de la factura 
	 */
	public DetalleFacturaDTO(String codigoFactura) {

		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return del codigo de la factura
	 */
	public String getCodigoFactura() {
		return codigoFactura;
	}

	/**
	 * @param codigoFactura codigo de la factura que se le asigna a la detallefactura
	 */
	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	/**
	 * @return de la cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad cantidad que se le asigna a la detallefactura
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return del precio por la cantidad
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio precio que se le asigna a la detallefactura
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return del codigo del producto
	 */
	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * @param codigoProducto codigo del producto que se le asigna a la detallefactura
	 */
	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
}
