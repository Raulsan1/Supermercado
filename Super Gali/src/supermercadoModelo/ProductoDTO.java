package supermercadoModelo;

public class ProductoDTO {
	
	private Integer codProducto;
	private String nombreProd;
	private Double precio;
	private Double tipoIva;
	private Integer stock;

	public ProductoDTO(Integer codProducto, String nombreProd, Double precio, Double tipoIva,Integer stock) {
		
		this.codProducto = codProducto;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.tipoIva = tipoIva;
		this.stock = stock;
	}
	
	public ProductoDTO (String nombreProd, Double precio, Double tipoIva, Integer stock) {
		
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.tipoIva = tipoIva;
		this.stock = stock;
	}
	
	public ProductoDTO (Integer codProducto) {
		this.codProducto = codProducto;
	}

	public ProductoDTO(String nombreProd) {
		this.nombreProd = nombreProd;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Double getTipoIva() {
		return tipoIva;
	}

	public void setTipoIva(Double tipoIva) {
		this.tipoIva = tipoIva;
	}
}
