package supermercadoModelo;

public class ProductoDTO {
	
	private Integer codProducto;
	private String nombreProd;
	private Double precio;

	public ProductoDTO(Integer codProducto, String nombreProd, Double precio) {
		
		this.codProducto = codProducto;
		this.nombreProd = nombreProd;
		this.precio = precio;
	}

	public Integer getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
}
