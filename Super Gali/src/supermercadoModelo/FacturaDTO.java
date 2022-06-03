package supermercadoModelo;

public class FacturaDTO {

	private String codFactura;
	private Integer caja;
	private String fechaHora;
	private Double precioTotal;
	
	
	public FacturaDTO (String codFactura, Integer caja, String fechaHora, Double precioTotal) {
		
		this.codFactura = codFactura;
		this.caja = caja;
		this.fechaHora = fechaHora;
		this.precioTotal = precioTotal;

	}
	public FacturaDTO (Integer caja,String fechaHora, Double precioTotal) {
		
		this.caja = caja;
		this.fechaHora = fechaHora;
		this.precioTotal = precioTotal;
	}

	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Integer getCaja() {
		return caja;
	}

	public void setCaja(Integer caja) {
		this.caja = caja;
	}

	public String getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
}

