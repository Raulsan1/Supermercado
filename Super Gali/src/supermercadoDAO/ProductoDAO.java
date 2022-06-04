package supermercadoDAO;

import java.sql.ResultSet;
import java.sql.Statement;

import supermercadoModelo.ProductoDTO;

/**
* Clase que representa los diferentes metodos para obtener la informacion de los Productos de la base de datos
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class ProductoDAO {

	/**
	 * Metodo que busca un producto en la base de datos
	 * @param dto dto que se quiere encontrar
	 * @return producto regresa el producto que se ha encontrado
	 */
	
	public ProductoDTO buscarProducto (ProductoDTO dto) {
		
		ProductoDTO producto = null;
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
				
			ResultSet resultado = consulta.executeQuery("SELECT * FROM Productos WHERE CodigoProducto = '"+dto.getCodProducto()+"' or Nombre = '"+dto.getNombreProd()+"';");		
			
			if (resultado.next()==true) {
				
				Integer codigo = resultado.getInt(1);
				String nombre = resultado.getString(2);
				Double precio = resultado.getDouble(3);
				Double precioIva = resultado.getDouble(4);	
				Integer stock = resultado.getInt(5);
			
				producto = new ProductoDTO(codigo,nombre,precio,precioIva,stock);
				
			}
			
			resultado.close();
			consulta.close();
			con.cerrarConexion(con.getConnect());
	
			
		} catch (Exception e) {
			System.out.println("Error en la consulta: "+e.getLocalizedMessage());
		}
		
		return producto;
	}
	
	/**
	 * Metodo para actualizar el stock en la base de datos
	 * @param dto dto del producto que se quiere actualizar
	 */
	
	public void actualizarStock (ProductoDTO dto) {
		
		try {
			Conectar con = new Conectar();
			Statement consulta = con.getConnect().createStatement();
			ResultSet resultado = consulta.executeQuery("SELECT * FROM Productos WHERE CodigoProducto = '"+dto.getCodProducto()+"';");
			
			if (resultado.next()==true) {
				
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
	
	/**
	 * Metodo para comprobar si un producto existe en la base de datos
	 * @param dto dto del producto que se quiere comprobar
	 * @return comp regresa el booleano con el resultado
	 */
	
	public boolean comprobarPorducto (ProductoDTO dto) {
		boolean comp = false;
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
			
			if (dto!=null){
				ResultSet resultado = consulta.executeQuery("SELECT * FROM Productos WHERE CodigoProducto = '"+dto.getCodProducto()+"';");

				if (resultado.next()==true) {
					
					if (resultado.getInt(1)==dto.getCodProducto()) {
						
						comp = true;
					}else {
						comp = false;
					}
				} 
				
				resultado.close();
			}

			consulta.close();
			con.cerrarConexion(con.getConnect());
	
			
		} catch (Exception e) {
			System.out.println("Error en la consultaa: "+e.getLocalizedMessage());
		}
		
		return comp;
		
	}
	
}
