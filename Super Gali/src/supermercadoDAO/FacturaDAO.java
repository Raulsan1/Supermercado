package supermercadoDAO;

import java.sql.*;

import supermercadoModelo.FacturaDTO;

/**
* Clase que representa los diferentes metodos para obtener la informacion de las Facturas de la base de datos
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class FacturaDAO {
	
	/**
	 * Metodo que inserta en la base de datos una nueva factura
	 * @param dto
	 */
	
	public void nuevaFactura (FacturaDTO dto) {
		
		try {
			Conectar con = new Conectar();
			PreparedStatement consulta = con.getConnect().prepareStatement("INSERT INTO Facturas (CodigoFactura,CodigoCaja,FechaHora,PrecioTotal,DineroPagado) VALUES (?,?,?,?,?);");
			
			consulta.setString(1, dto.getCodFactura());
			consulta.setInt(2, dto.getCaja());
			consulta.setString(3, dto.getFechaHora());
			consulta.setDouble(4, dto.getPrecioTotal());
			consulta.setDouble(5, dto.getDinero());
			consulta.execute();
			
			con.cerrarConexion(con.getConnect());
			consulta.close();
			
		} catch (Exception e) {
			System.out.println("Error al registrar la factura: "+e.getLocalizedMessage());
		}
	}
	
	/**
	 * Metodo que busca una factura en la base de datos
	 * @param dto dto de la factura que se quiere buscar
	 * @return factura regresa la factura que se ha encontrado
	 */
	
	public FacturaDTO buscarFactura (FacturaDTO dto) {
		
		FacturaDTO factura = null;
		
		try {
			
			Conectar con = new Conectar();
			Statement consulta = con.getConnect().createStatement();
			
			ResultSet resultado = consulta.executeQuery("SELECT * FROM Facturas WHERE CodigoFactura = '"+dto.getCodFactura()+"';");
			
			if (resultado.next()==true) {
				
				String codFactura= resultado.getString(1);
				Integer caja = resultado.getInt(2);
				String fechaHora = resultado.getString(3);
				Double precioTotal = resultado.getDouble(4);
				Double dinero = resultado.getDouble(5);
				
				factura = new FacturaDTO (codFactura,caja,fechaHora,precioTotal,dinero);
				
			}
		} catch (Exception e) {
			System.out.println("Error al buscar la factura: "+e.getLocalizedMessage());
		}
		
		return factura;
	}

}
