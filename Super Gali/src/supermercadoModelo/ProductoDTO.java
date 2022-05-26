package supermercadoModelo;

public class ProductoDTO {
	
	private Integer codProducto;
	private String nombreProd;
	private Double precio;
	private Double precioIva;

	public ProductoDTO(Integer codProducto, String nombreProd, Double precio, Double precioIva) {
		
		this.codProducto = codProducto;
		this.nombreProd = nombreProd;
		this.precio = precio;
		this.setPrecioIva(precioIva);
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

	public Double getPrecioIva() {
		return precioIva;
	}

	public void setPrecioIva(Double precioIva) {
		this.precioIva = precioIva;
	}
}
