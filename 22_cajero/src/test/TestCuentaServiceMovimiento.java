package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.Movimiento;
import service.CuentaServiceMovimiento;

public class TestCuentaServiceMovimiento {
	
	CuentaServiceMovimiento cuenta;

	@Before
	public void setUp() throws Exception {
		
		cuenta = new CuentaServiceMovimiento(2000, 300);
	}

	@Test
	public void testObtenerMovimientos() {
		
		ArrayList<Movimiento> operaciones = new ArrayList<>();
		
		cuenta.ingresar(100);
		cuenta.ingresar(100);
		cuenta.ingresar(100);
		
		cuenta.extraer(50);
		cuenta.extraer(50);
		
		operaciones = cuenta.obtenerMovimientos();
	}
	
	@Test
	public void testIngreso() {
		
		cuenta.ingresar(100);
		
		assertEquals(2100, cuenta.getSaldo(), 0);
	}

	@Test
	public void testExtracto() {
		
		cuenta.extraer(100);
		
		assertEquals(1900, cuenta.getSaldo(), 0);
	}
}
