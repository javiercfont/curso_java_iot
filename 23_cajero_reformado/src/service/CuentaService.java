package service;

public class CuentaService {
	
	private double saldo;
	
	
	public CuentaService() {

	}
	
	public CuentaService(double saldo) {
		
		this.saldo = saldo;
	}
	
	public double ingresar(double cantidad) {
		
		this.saldo += cantidad;
		
		return cantidad;
	}
	
	public double extraer(double cantidad) {
		
		this.saldo -= cantidad;
		
		return cantidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
