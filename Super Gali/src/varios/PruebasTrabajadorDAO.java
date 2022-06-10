package varios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import supermercadoDAO.TrabajadorDAO;
import supermercadoModelo.TrabajadorDTO;

class PruebasTrabajadorDAO {

	private static TrabajadorDAO dao;
	private static TrabajadorDTO dto;
	
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Ejecutando beforeClass...");
		dao = new TrabajadorDAO();		
	}
	
	
	@BeforeEach
	public void before() {
		System.out.println("Ejecutando before...");
		dto = new TrabajadorDTO(1,"Administrador","bc7a844476607e1a59d8eb1b1f311830","raul","28945094H");
	}

	@Test
	public void testBuscarTrabajador() {
		System.out.println("Ejecutando testBuscarTrabajador...");
		dao.buscarTrabajador(dto);
		String resultado = dao.getSuceso();
		String esperado = "Trabajador encontrado";
		assertEquals("Error buscar trabajador", esperado, resultado);
	}
	
	@Test
	public void testBuscarFactura() {
		System.out.println("Ejecutando testBuscarFactura...");
		boolean resultado = dao.comprobarContrasenaUsuario(dto);
		assertTrue(resultado);
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
