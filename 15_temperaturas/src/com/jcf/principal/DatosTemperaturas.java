package com.jcf.principal;

public class DatosTemperaturas {

	public static void main(String[] args) {
		
		String temps = "24.3,26.7,31.4,22.9,10.3,17.8";

		double media = 0;
		
		String[] datos = temps.split(",");
		
		for (String dato : datos) {
			
			media += Double.parseDouble(dato);
		}
		
		System.out.printf("La media de temperatura es: %2.2f", (media / datos.length));
	}
}
