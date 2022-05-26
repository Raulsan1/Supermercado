package supermercadoModelo;

import java.sql.Timestamp;

public class FacturaDTO {

	private Integer codFactura;
	private Integer caja;
	private Timestamp fechaHora;
	
	
	public FacturaDTO (Integer codFactura, Integer caja, Timestamp fechaHora) {
		
		this.codFactura = codFactura;
		this.caja = caja;
		this.fechaHora = fechaHora;

	}

	public Integer getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(Integer codFactura) {
		this.codFactura = codFactura;
	}

	public Integer getCaja() {
		return caja;
	}

	public void setCaja(Integer caja) {
		this.caja = caja;
	}

	public Timestamp getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Timestamp fechaHora) {
		this.fechaHora = fechaHora;
	}
	
}

