package supermercadoDAO;

import java.sql.ResultSet;
import java.sql.Statement;

import supermercadoModelo.TrabajadorDTO;

public class TrabajadorDAO {

	public TrabajadorDTO buscarTrabajador (TrabajadorDTO dto) {
		
		TrabajadorDTO trabajador = null;
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
			
			if (!dto.getCodEmpleado().equals("")) {
				
				ResultSet resultado = consulta.executeQuery("SELECT * FROM Trabajadores WHERE CodigoEmpleado = '"+dto.getCodEmpleado()+"';");
				
				if (resultado.next()==true) {
					System.out.println("El personaje se encuentra en la base de datos.");
					
					Integer codigoEmpleado = resultado.getInt(1);
					String usuario = resultado.getString(2);
					String contrasena = resultado.getString(3);
					Integer caja = resultado.getInt(4);
					String nombre = resultado.getString(5);
					String dni = resultado.getString(6);
					
					trabajador = new TrabajadorDTO(codigoEmpleado,usuario,contrasena,caja,nombre,dni);
					
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
		
		return trabajador;
	}
}
