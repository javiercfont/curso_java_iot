package com.jcf.principal;

import java.util.ArrayList;

public class Primitiva {
	
	// Ordena el boleto
	
	public static void ordenarBoleto(ArrayList<Integer> datos) {
		
		// Verifica que hay datos disponibles
		
		if (!datos.isEmpty()) {
			
			// ArrayList para guardar los elementos ordenados
			
			ArrayList<Integer> ordenado = new ArrayList<>();
			
			// Representa el valor m�nimo encontrado
			
			int min = 0;
			
			// Guarda el n�mero de datos que contiene el ArrayList
			
			int numDatos = datos.size();
			
			// Se ejecuta hasta que llegamos al n�mero de datos requerido
			
			do {
			
				// Se busca el valor m�nimo
				
				for (int i : datos) {
					
					min = i;
					
					for (int j : datos) {
						
						min = Math.min(min, j);
					}
				}
				
				/* Se elimina el valor m�nimo encontrado en los datos
				   para evitar que se encuentre otra vez */
				
				datos.remove(datos.indexOf(min));
				
				// Se a�ade el valor m�nimo encontrado en el ArrayList ordenado
			
				ordenado.add(min);
			
			} while (ordenado.size() < numDatos);
			
			// Se a�aden todos los datos del array ordenado en los datos de entrada
			
			datos.addAll(ordenado);

		} else {
			
			System.out.println("El boleto no contiene datos");
		}
	}
	
	
	
	public static void main(String[] args) {
		
		final int maxNumeros = 49;  	// Valor m�ximo permitido del n�mero
		final int maxSeleccion = 6;		// Total de n�meros en la apuesta
		final int maxReintegro = 9;     // Valor m�ximo del reintegro
		
		int numero = 0;					// N�mero seleccionado
		
		// Colecci�n de n�meros del boleto de apuesta
		
		ArrayList<Integer> boleto = new ArrayList<>();
		
		// Genera n�meros hasta alcanzar el total de n�meros por apuesta
		
		do {
			
			// Genera un n�mero en los l�mites establecidos
			
			numero = (int) ((Math.random() * maxNumeros) + 1);
			
			/* Comprueba si el boleto contiene el n�mero generado.
			   Si no existe lo a�ade */
			
			if (!boleto.contains(numero)) {
				
				boleto.add(numero);
			}
			
		} while (boleto.size() < maxSeleccion);
		
		// Ordena el boleto resultante
		
		// boleto.sort(null); Se usa el m�todo de la colecci�n
		
		// Se usa el m�todo creado en la clase
		
		ordenarBoleto(boleto);
		
		// Presenta el resultado
		
		System.out.println("Combinaci�n del boleto: " + boleto);
		System.out.println("Reintegro: " + (int)((Math.random() * maxReintegro) + 1));
	}
}
