package supermercadoDAO;

import java.sql.ResultSet;
import java.sql.Statement;

import juego.Conectar;
import supermercadoModelo.ProductoDTO;

public class ProductoDAO {


	public void buscarProducto (ProductoDTO dto) {
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
			
			if (!dto.getCodProducto().equals("")) {
				
				ResultSet resultado = consulta.executeQuery("SELECT * FROM Personaje WHERE nombre = '"+dto.getCodProducto()+"';");
				
				if (resultado.next()==true) {
					System.out.println("El personaje se encuentra en la base de datos.");
					
				}else {
					System.out.println("El personaje no se encuentra en la base de datos.");
				}
				
				resultado.close();
			}
			consulta.close();
			con.cerrarConexion(con.getConnect());
	
			
		} catch (Exception e) {
			System.out.println("Error en la consulta: "+e.getLocalizedMessage());
		}
	}
	
}
