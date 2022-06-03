package supermercadoDAO;

import java.sql.*;

import supermercadoModelo.FacturaDTO;

public class FacturaDAO {
	
	public void nuevaFactura (FacturaDTO dto) {
		
		try {
			Conectar con = new Conectar();
			PreparedStatement consulta = con.getConnect().prepareStatement("INSERT INTO Facturas (CodigoFactura,CodigoCaja,FechaHora,PrecioTotal) VALUES (?,?,?,?);");
			
			consulta.setString(1, dto.getCodFactura());
			consulta.setInt(2, dto.getCaja());
			consulta.setString(3, dto.getFechaHora());
			consulta.setDouble(4, dto.getPrecioTotal());
			consulta.execute();
			
			con.cerrarConexion(con.getConnect());
			consulta.close();
			
		} catch (Exception e) {
			System.out.println("Error al registrar la factura: "+e.getLocalizedMessage());
		}
	}

}
