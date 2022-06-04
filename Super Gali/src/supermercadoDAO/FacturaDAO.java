package supermercadoDAO;

import java.sql.*;

import supermercadoModelo.FacturaDTO;

public class FacturaDAO {
	
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
