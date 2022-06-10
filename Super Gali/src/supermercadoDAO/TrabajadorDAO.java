package supermercadoDAO;

import java.sql.ResultSet;
import java.sql.Statement;

import supermercadoModelo.TrabajadorDTO;

/**
* Clase que representa los diferentes metodos para obtener la informacion de los Trabajadores de la base de datos
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class TrabajadorDAO {
	
	private String suceso;
	
	/**
	 * Metodo que busca un trabajador en la base de datos
	 * @param dto dto del trabajador que se quiere buscar
	 * @return trabajador regresa el trabajador encontrado
	 */

	public TrabajadorDTO buscarTrabajador (TrabajadorDTO dto) {
		
		TrabajadorDTO trabajador = null;
		
		setSuceso("Trabajador encontrado");
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
			
			if (dto.getCodEmpleado() != null) {
				
				ResultSet resultado = consulta.executeQuery("SELECT * FROM Trabajadores WHERE CodigoEmpleado = '"+dto.getCodEmpleado()+"';");
				
				if (resultado.next()==true) {
					System.out.println("El personaje se encuentra en la base de datos.");
					
					Integer codigoEmpleado = resultado.getInt(1);
					String usuario = resultado.getString(2);
					String contrasena = resultado.getString(3);
					String nombre = resultado.getString(4);
					String dni = resultado.getString(5);
					
					trabajador = new TrabajadorDTO(codigoEmpleado,usuario,contrasena,nombre,dni);
					
				}else {
					System.out.println("El personaje no se encuentra en la base de datos.");
					setSuceso("Trabajador no encontrado");
				}
				
				resultado.close();
			}else {
				setSuceso("Trabajador no encontrado");
			}
			consulta.close();
			con.cerrarConexion(con.getConnect());
	
			
		} catch (Exception e) {
			System.out.println("Error en la consulta: "+e.getLocalizedMessage());
			setSuceso("Error");
		}
		
		return trabajador;
	}
	
	/**
	 * Metodo que comprueba la contraseña y el usuario del trabajador
	 * @param dto dto del trabajador al que se le quiere comprobar la contraseña y el usuario
	 * @return comp regresa el booleano con el resultado
	 */
	
	public boolean comprobarContrasenaUsuario (TrabajadorDTO dto) {
		
		boolean comp = false;
		
		try {
			
			Conectar con = new Conectar ();
			Statement consulta = con.getConnect().createStatement();
			
			if (!dto.getUsuario().equals("")) {
				
				ResultSet resultado = consulta.executeQuery("SELECT * FROM Trabajadores WHERE Usuario = '"+dto.getUsuario()+"';");

				if (resultado.next()==true) {
					
					if (resultado.getString(2).equalsIgnoreCase(dto.getUsuario())) {
						if(resultado.getString(3).equalsIgnoreCase(dto.getContraseña())) {
							comp = true;
							
						}else{
							comp = false;
						}
					}
				} 
				
				resultado.close();
			}
			consulta.close();
			con.cerrarConexion(con.getConnect());
	
			
		} catch (Exception e) {
			System.out.println("Error en la consulta: "+e.getLocalizedMessage());
		}
		
		return comp;
	}

	public String getSuceso() {
		return suceso;
	}

	public void setSuceso(String suceso) {
		this.suceso = suceso;
	}
}
