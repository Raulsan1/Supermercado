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
				
				Integer codigo = resultado.getInt(1);
				String nombre = resultado.getString(2);
				Double precio = resultado.getDouble(3);
				Double precioIva = resultado.getDouble(4);	
				Integer stock = resultado.getInt(5);
			
				producto = new ProductoDTO(codigo,nombre,precio,precioIva,stock);
				
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
	
	public void actualizarStock (ProductoDTO dto) {
		
		try {
			Conectar con = new Conectar();
			Statement consulta = con.getConnect().createStatement();
			ResultSet resultado = consulta.executeQuery("SELECT * FROM Productos WHERE CodigoProducto = '"+dto.getCodProducto()+"';");
			
			System.out.println(dto.getStock());
			
			if (resultado.next()==true) {
				System.out.println(dto.getStock());
				
				Statement consulta2 = con.getConnect().createStatement();
				consulta2.executeUpdate("UPDATE Productos SET Stock = "+dto.getStock()+" WHERE CodigoProducto = '"+dto.getCodProducto()+"';");
				
				consulta2.close();
			}
			
			consulta.close();
			resultado.close();
			con.cerrarConexion(con.getConnect());
			
		} catch (Exception e) {
			System.out.println("Error en la consulta: "+e.getLocalizedMessage());
		}
	}
	
}
