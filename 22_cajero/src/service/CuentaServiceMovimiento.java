package service;

import java.util.ArrayList;

import model.Movimiento;

public class CuentaServiceMovimiento extends CuentaServiceLimite {
	
	private String ingreso = "Ingreso";
	private String extracto = "Extracto";
	
	private ArrayList<Movimiento> movimientos = new ArrayList<>();
	
	public CuentaServiceMovimiento(double saldo, double limite) {
		
		super(saldo, limite);
	}

	public ArrayList<Movimiento> obtenerMovimientos() {
		
		return this.movimientos;
	}

	@Override
	public void ingresar(double cantidad) {
		
		Movimiento operacion = new Movimiento(cantidad>=getLimite()?getLimite():cantidad, ingreso);
		
		super.ingresar(cantidad);
		
		movimientos.add(operacion);
	}

	@Override
	public void extraer(double cantidad) {

		Movimiento operacion = new Movimiento(cantidad>=getLimite()?getLimite():cantidad, extracto);
		
		super.extraer(cantidad);
		
		movimientos.add(operacion);
	}
}
