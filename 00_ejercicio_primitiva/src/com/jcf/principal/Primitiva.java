package com.jcf.principal;

import java.util.ArrayList;

public class Primitiva {
	
	// Ordena el boleto
	
	public static void ordenarBoleto(ArrayList<Integer> datos) {
		
		// Verifica que hay datos disponibles
		
		if (!datos.isEmpty()) {
			
			// ArrayList para guardar los elementos ordenados
			
			ArrayList<Integer> ordenado = new ArrayList<>();
			
			// Representa el valor mínimo encontrado
			
			int min = 0;
			
			// Guarda el número de datos que contiene el ArrayList
			
			int numDatos = datos.size();
			
			// Se ejecuta hasta que llegamos al número de datos requerido
			
			do {
			
				// Se busca el valor mínimo
				
				for (int i : datos) {
					
					min = i;
					
					for (int j : datos) {
						
						min = Math.min(min, j);
					}
				}
				
				/* Se elimina el valor mínimo encontrado en los datos
				   para evitar que se encuentre otra vez */
				
				datos.remove(datos.indexOf(min));
				
				// Se añade el valor mínimo encontrado en el ArrayList ordenado
			
				ordenado.add(min);
			
			} while (ordenado.size() < numDatos);
			
			// Se añaden todos los datos del array ordenado en los datos de entrada
			
			datos.addAll(ordenado);

		} else {
			
			System.out.println("El boleto no contiene datos");
		}
	}
	
	
	
	public static void main(String[] args) {
		
		final int maxNumeros = 49;  	// Valor máximo permitido del número
		final int maxSeleccion = 6;		// Total de números en la apuesta
		final int maxReintegro = 9;     // Valor máximo del reintegro
		
		int numero = 0;					// Número seleccionado
		
		// Colección de números del boleto de apuesta
		
		ArrayList<Integer> boleto = new ArrayList<>();
		
		// Genera números hasta alcanzar el total de números por apuesta
		
		do {
			
			// Genera un número en los límites establecidos
			
			numero = (int) ((Math.random() * maxNumeros) + 1);
			
			/* Comprueba si el boleto contiene el número generado.
			   Si no existe lo añade */
			
			if (!boleto.contains(numero)) {
				
				boleto.add(numero);
			}
			
		} while (boleto.size() < maxSeleccion);
		
		// Ordena el boleto resultante
		
		// boleto.sort(null); Se usa el método de la colección
		
		// Se usa el método creado en la clase
		
		ordenarBoleto(boleto);
		
		// Presenta el resultado
		
		System.out.println("Combinación del boleto: " + boleto);
		System.out.println("Reintegro: " + (int)((Math.random() * maxReintegro) + 1));
	}
}
