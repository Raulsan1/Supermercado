package supermercadoModelo;

/**
* Clase que representa a los tipos de iva
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class TipoIvaDTO {

	private String tipo;
	private Double porcentaje;
	
	/**
	 * Constructor de los tipos de iva
	 * @param tipo tipo del iva
	 * @param porcentaje porcentaje de iva
	 */
	
	public TipoIvaDTO (String tipo, Double porcentaje) {
		
		this.tipo = tipo;
		this.porcentaje = porcentaje;
	}

	/**
	 * @return del tipo de iva
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo tipo de iva asignado
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return del porcentaje
	 */
	public Double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje porcentaje asignado
	 */
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
