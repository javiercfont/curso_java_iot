package com.jcf.principal;

public class LanzarDado {

	public static void main(String[] args) {
		
		final int numeroLanzamientos = 100_000;
		final int numeroCaras = 6;
		
		double[] carasDado = new double[numeroCaras];
		
		int dado = 0;
		
		for (int i = 0; i < numeroLanzamientos; i++) {
			
			dado = (int) ((Math.random() * numeroCaras) + 1);
			
			carasDado[dado - 1]++;
		}
		
		for (int i = 0; i < numeroCaras; i++) {
		
			System.out.printf("Porcentaje %d: %2.2f %c\r\n", (i + 1), ((carasDado[i] / numeroLanzamientos) * 100), '%');
		}
	}
}
