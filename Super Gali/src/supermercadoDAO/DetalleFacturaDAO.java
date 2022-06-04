package supermercadoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import supermercadoModelo.DetalleFacturaDTO;
import supermercadoModelo.FacturaDTO;

public class DetalleFacturaDAO {
	
	private ArrayList <DetalleFacturaDTO> detallesFactura;

	public void nuevaDetalleFactura (DetalleFacturaDTO dto) {
		
		try {
			Conectar con = new Conectar();
			PreparedStatement consulta = con.getConnect().prepareStatement("INSERT INTO DetallesFacturas VALUES (?,?,?,?);");
			
			consulta.setString(1, dto.getCodigoFactura());
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

	public ArrayList<DetalleFacturaDTO> buscarDetalleFactura (DetalleFacturaDTO dto) {
	
		DetalleFacturaDTO detalleFactura = null;
		detallesFactura = new ArrayList <DetalleFacturaDTO>();
		
		try {
			
			Conectar con = new Conectar();
			Statement consulta = con.getConnect().createStatement();
			
			ResultSet resultado = consulta.executeQuery("SELECT * FROM DetallesFacturas WHERE CodigoFactura = '"+dto.getCodigoFactura()+"';");
			
			if (resultado.next()==true) {
				
				do {
					
					String codFactura= resultado.getString(1);
					Integer codProducto = resultado.getInt(2);
					Integer cantidad = resultado.getInt(3);
					Double precio = resultado.getDouble(4);
					
					detalleFactura = new DetalleFacturaDTO (codFactura,codProducto,cantidad,precio);
					detallesFactura.add(detalleFactura);
					
				} while(resultado.next());
				
			}
		} catch (Exception e) {
			System.out.println("Error al buscar la factura: "+e.getLocalizedMessage());
		}
		
		return detallesFactura;
	}
}
