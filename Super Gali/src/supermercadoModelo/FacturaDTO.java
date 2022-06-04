package supermercadoModelo;

/**
* Clase que representa a las facturas
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class FacturaDTO {

	private String codFactura;
	private Integer caja;
	private String fechaHora;
	private Double precioTotal;
	private Double dinero;
	
	/**
	 * Constructor de las facturas
	 * @param codFactura codigo de la factura
	 * @param caja caja en la que se ha generado la factura
	 * @param fechaHora fecha y hora en la que se ha generado la factura
	 * @param precioTotal precioTotal de la compra
	 * @param dinero cantidad de dinero con la que se ha pagado
	 */
	public FacturaDTO (String codFactura, Integer caja, String fechaHora, Double precioTotal, Double dinero) {
		
		this.codFactura = codFactura;
		this.caja = caja;
		this.fechaHora = fechaHora;
		this.precioTotal = precioTotal;
		this.dinero = dinero;

	}

	/**
	 * @return dinero pagado
	 */
	public Double getDinero() {
		return dinero;
	}

	/**
	 * @param dinero dinero que se ha pagado
	 */
	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}

	/**
	 * Constructor de la factura
	 * @param codFactura codigo de la factura 
	 */
	public FacturaDTO(String codFactura) {

		this.codFactura = codFactura;
		
	}
	
	/**
	 * @return del codigo de la factura
	 */
	public String getCodFactura() {
		return codFactura;
	}

	/**
	 * @param codFactura codigo de la factura que se le asigna a la factura
	 */
	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	/**
	 * @return de el codigo de la caja
	 */
	public Integer getCaja() {
		return caja;
	}

	/**
	 * @param caja caja en la que se a generado la factura
	 */
	public void setCaja(Integer caja) {
		this.caja = caja;
	}

	/**
	 * @return de la fecha y hora
	 */
	public String getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora en la que se ha generado la factura
	 */
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	/**
	 * @return del precio total 
	 */
	public Double getPrecioTotal() {
		return precioTotal;
	}
	
	/**
	 * @param precioTotal precio total que ha costado la compra
	 */
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}

