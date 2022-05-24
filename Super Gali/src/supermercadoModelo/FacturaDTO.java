package supermercadoModelo;

import java.util.ArrayList;

public class FacturaDTO {

	private Integer codFactura;
	private Integer caja;
	private Integer fecha;
	private Integer hora;
	private ArrayList<ProductoDTO> productos;
	
	public FacturaDTO (Integer codFactura, Integer caja, Integer fecha, Integer hora, ArrayList<ProductoDTO> productos) {
		
		this.codFactura = codFactura;
		this.caja = caja;
		this.fecha = fecha;
		this.hora = hora;
		this.productos = productos;
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

	public Integer getFecha() {
		return fecha;
	}

	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public ArrayList<ProductoDTO> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<ProductoDTO> productos) {
		this.productos = productos;
	}
}
