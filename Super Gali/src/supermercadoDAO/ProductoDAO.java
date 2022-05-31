package supermercadoDAO;

import java.sql.ResultSet;
import java.sql.Statement;

import supermercadoModelo.ProductoDTO;

public class ProductoDAO {


	public ProductoDTO buscarProducto (ProductoDTO dto) {
		
		ProductoDTO producto = null;
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
				
			ResultSet resultado = consulta.executeQuery("SELECT * FROM Productos WHERE CodigoProducto = '"+dto.getCodProducto()+"';");
			
			if (resultado.next()==true) {
				
				String nombre = resultado.getString(2);
				Double precio = resultado.getDouble(3);
				Double precioIva = resultado.getDouble(4);	
			
				producto = new ProductoDTO(nombre,precio,precioIva);
				
			}else {
				System.out.println("El producto no se encuentra en la base de datos.");
			}
			
			resultado.close();
		
		consulta.close();
		con.cerrarConexion(con.getConnect());
	
			
		} catch (Exception e) {
			System.out.println("Error en la consulta: "+e.getLocalizedMessage());
		}
		
		return producto;
	}
	
}
