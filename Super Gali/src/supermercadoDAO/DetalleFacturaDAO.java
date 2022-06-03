package supermercadoDAO;

import java.sql.PreparedStatement;

import supermercadoModelo.DetalleFacturaDTO;

public class DetalleFacturaDAO {

public void nuevaDetalleFactura (DetalleFacturaDTO dto) {
		
		try {
			Conectar con = new Conectar();
			PreparedStatement consulta = con.getConnect().prepareStatement("INSERT INTO DetallesFacturas VALUES (?,?,?,?);");
			
			consulta.setString(1, dto.getCodigoFatura());
			consulta.setInt(2, dto.getCodigoProducto());
			consulta.setInt(3, dto.getCantidad());
			consulta.setDouble(4, dto.getPrecio());
			consulta.execute();
			
			con.cerrarConexion(con.getConnect());
			consulta.close();
			
		} catch (Exception e) {
			System.out.println("Error al registrar la detalle factura: "+e.getLocalizedMessage());
		}
	}
}
