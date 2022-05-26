package supermercadoDAO;

import java.sql.*;

import supermercadoModelo.FacturaDTO;

public class FacturaDAO {
	
	public void nuevaFactura (FacturaDTO dto) {
		
		try {
			Conectar con = new Conectar();
			PreparedStatement consulta = con.getConnect().prepareStatement("INSERT INTO Facturas VALUES (?,?,?);");
			
			consulta.setInt(1, dto.getCaja());
			consulta.setInt(2, dto.getCodFactura());
			consulta.setTimestamp(3, dto.getFechaHora());
			consulta.execute();
			
			con.cerrarConexion(con.getConnect());
			consulta.close();
			
		} catch (Exception e) {
			System.out.println("Error al registrar la factura: "+e.getLocalizedMessage());
		}
	}

}
