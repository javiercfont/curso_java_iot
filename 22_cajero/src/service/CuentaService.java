package service;

public class CuentaService {
	
	private double saldo;
	
	
	public CuentaService() {

	}
	
	public CuentaService(double saldo) {
		
		this.saldo = saldo;
	}
	
	public void ingresar(double cantidad) {
		
		this.saldo += cantidad;
	}
	
	public void extraer(double cantidad) {
		
		this.saldo -= cantidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
