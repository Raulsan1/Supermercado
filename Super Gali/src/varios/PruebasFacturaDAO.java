package varios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supermercadoDAO.FacturaDAO;
import supermercadoModelo.FacturaDTO;

class PruebasFacturaDAO {

	private static FacturaDAO dao;
	private static FacturaDTO dto;
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Ejecutando beforeClass...");
		dao = new FacturaDAO();		
	}
	
	
	@BeforeEach
	public void before() {
		System.out.println("Ejecutando before...");
		dto = new FacturaDTO("T1",0,"qqq",0.0,0.0);
	}

	@Test
	public void testNuevaFactura() {
		System.out.println("Ejecutando testNuevaFactura...");
		dao.nuevaFactura(dto);
		String resultado = dao.getSuceso();
		String esperado = "Factura creada correctamente";
		assertEquals("Error nueva factura", esperado, resultado);
	}
	
	@Test
	public void testBuscarFactura() {
		System.out.println("Ejecutando testBuscarFactura...");
		dao.buscarFactura(dto);
		String resultado = dao.getSuceso();
		String esperado = "Factura encontrada";
		assertEquals("Error buscar factura", esperado, resultado);
	}
	
	@AfterEach
	public void after() {
		System.out.println("Ejecutando after...");
		dto = null;
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("Ejecutando afterClass...");
		dao = null;
	}

}
