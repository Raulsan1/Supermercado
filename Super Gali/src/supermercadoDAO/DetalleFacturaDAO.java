package supermercadoDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import supermercadoModelo.DetalleFacturaDTO;
import supermercadoModelo.FacturaDTO;

/**
* Clase que representa los diferentes metodos para obtener la informacion de las DetalleFactura de la base de datos
* @author Raúl Sanz Andrés
* @version 1.0
*/

public class DetalleFacturaDAO {
	
	private ArrayList <DetalleFacturaDTO> detallesFactura;
	private String suceso;
	
	/**
	 * Metodo que inserta una nueva factura en la base de datos
	 * @param dto dto de la detalleFactura que se va a insertar
	 */

	public void nuevaDetalleFactura (DetalleFacturaDTO dto) {
		
		setSuceso("detalleFactura insertada correctamente");
		
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
			setSuceso("Error");
		}
	}
	
	/**
	 * Metodo que busca una detalleFactura
	 * @param dto dto de la detalleFactura que se quiere buscar en la base de datos
	 * @return detallesFactura regresa un arrayList con los datos de las detallesFactura
	 */

	public ArrayList<DetalleFacturaDTO> buscarDetalleFactura (DetalleFacturaDTO dto) {
	
		DetalleFacturaDTO detalleFactura = null;
		detallesFactura = new ArrayList <DetalleFacturaDTO>();
		
		try {
			setSuceso("detalleFactura encontrada");
			
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
				
			} else {
				setSuceso("La detalleFactura no existe");
			}
		} catch (Exception e) {
			System.out.println("Error al buscar la factura: "+e.getLocalizedMessage());
			setSuceso("Error");
		}
		
		return detallesFactura;
	}

	public String getSuceso() {
		return suceso;
	}

	public void setSuceso(String suceso) {
		this.suceso = suceso;
	}
}
