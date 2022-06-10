package varios;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supermercadoDAO.ProductoDAO;
import supermercadoModelo.ProductoDTO;

class PruebasProductoDAO {

	private static ProductoDAO dao;
	private static ProductoDTO dto;
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Ejecutando beforeClass...");
		dao = new ProductoDAO();		
	}
	
	
	@BeforeEach
	public void before() {
		System.out.println("Ejecutando before...");
		dto = new ProductoDTO(1,"AAA",0.0,0.0,0);
	}

	@Test
	public void testBuscarProducto() {
		System.out.println("Ejecutando testBuscarProducto...");
		dao.buscarProducto(dto);
		String resultado = dao.getSuceso();
		String esperado = "Producto encontrado";
		assertEquals("Error buscar producto", esperado, resultado);
	}
	
	@Test
	public void testActualizarStock() {
		System.out.println("Ejecutando testActualizarStock...");
		dao.actualizarStock(dto);
		String resultado = dao.getSuceso();
		String esperado = "Stock actualizado correctamente";
		assertEquals("Error nueva detalle factura", esperado, resultado);
	}
	
	@Test
	public void testComprobarProducto() {
		System.out.println("Ejecutando testComprobarProducto...");
		dao.comprobarPorducto(dto);
		String resultado = dao.getSuceso();
		String esperado = "El producto existe";
		assertEquals("Error comprobar producto", esperado, resultado);
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
