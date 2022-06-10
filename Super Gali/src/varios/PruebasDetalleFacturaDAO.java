package varios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supermercadoDAO.DetalleFacturaDAO;
import supermercadoModelo.DetalleFacturaDTO;

class PruebasDetalleFacturaDAO {

	private static DetalleFacturaDAO dao;
	private static DetalleFacturaDTO dto;
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Ejecutando beforeClass...");
		dao = new DetalleFacturaDAO();		
	}
	
	
	@BeforeEach
	public void before() {
		System.out.println("Ejecutando before...");
		dto = new DetalleFacturaDTO("T1",0,0,0.0);
	}

	@Test
	public void testNuevaDetalleFactura() {
		System.out.println("Ejecutando testNuevaDetalleFactura...");
		dao.nuevaDetalleFactura(dto);
		String resultado = dao.getSuceso();
		String esperado = "detalleFactura insertada correctamente";
		assertEquals("Error nueva detalle factura", esperado, resultado);
	}
	
	@Test
	public void testBuscarDetalleFactura() {
		System.out.println("Ejecutando testBuscarDetalleFactura...");
		dao.buscarDetalleFactura(dto);
		String resultado = dao.getSuceso();
		String esperado = "detalleFactura encontrada";
		assertEquals("Error nueva detalle factura", esperado, resultado);
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
