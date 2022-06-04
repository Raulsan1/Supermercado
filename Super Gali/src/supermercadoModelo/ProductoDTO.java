package supermercadoModelo;

/**
* Clase que representa a los productos
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class ProductoDTO {
	
	private Integer codProducto;
	private String nombreProd;
	private Double precio;
	private Double tipoIva;
	private Integer stock;
	
	/**
	 * Constructor de producto
	 * @param codProducto codigo del producto
	 * @param nombreProd nombre del producto
	 * @param precio precio del producto
	 * @param tipoIva tipo de iva aplicado al producto
	 * @param stock stock del producto
	 */

	public ProductoDTO(Integer codProducto, String nombreProd, Double precio, Double tipoIva,Integer stock) {
		
		this.codProducto = codProducto;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.tipoIva = tipoIva;
		this.stock = stock;
	}
	
	/**
	 * Constructor de producto
	 * @param nombreProd nombre del producto
	 * @param precio precio del producto
	 * @param tipoIva tipo de iva aplicado al producto
	 * @param stock stock del producto
	 */
	
	public ProductoDTO (String nombreProd, Double precio, Double tipoIva, Integer stock) {
		
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.tipoIva = tipoIva;
		this.stock = stock;
	}
	
	/**
	 * Constructor de producto
	 * @param codProducto codigo de producto
	 */
	public ProductoDTO (Integer codProducto) {
		this.codProducto = codProducto;
	}

	/**
	 * Constructor del producto
	 * @param nombreProd nombre del producto
	 */
	public ProductoDTO(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	/**
	 * @return del codigo de producto
	 */
	public Integer getCodProducto() {
		return codProducto;
	}

	/**
	 * @param codProducto codigo que se le asigna al producto
	 */
	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	/**
	 * @return del nombre del producto
	 */
	public String getNombreProd() {
		return nombreProd;
	}

	/**
	 * @param nombreProd nombre que se le asigna al producto
	 */
	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	/**
	 * @return del precio del producto
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio precio que se le asigna al producto
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	/**
	 * @return del stock del producto
	 */
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock stock que se le asigna al producto
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return del iva aplicado al producto
	 */
	public Double getTipoIva() {
		return tipoIva;
	}

	/**
	 * @param tipoIva que se le asigna al producto
	 */
	public void setTipoIva(Double tipoIva) {
		this.tipoIva = tipoIva;
	}
}
