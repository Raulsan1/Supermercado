package supermercadoModelo;

public class TipoIvaDTO {

	private String tipo;
	private Double porcentaje;
	
	public TipoIvaDTO (String tipo, Double porcentaje) {
		
		this.tipo = tipo;
		this.porcentaje = porcentaje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
