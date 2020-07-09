package com.jcf.principal;

import java.util.Arrays;

public class PrimitivaArrays {
	
	// Busca si existe el n�mero en el array
	
	public static boolean buscar(int[] datos, int num) {
		
		for (int n : datos) {
			
			if (num == n) {
				
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		final int maxNumeros = 49;
		final int maxArray = 6;
		final int maxReintegro = 6;
		
		int numero = 0;
		int index = 0;
		
		int[] boleto = new int[maxArray];
		
		// Genera n�meros hasta alcanzar el total de n�meros por apuesta
		
		do {
			
			// Genera un n�mero en los l�mites establecidos
			
			numero = (int) ((Math.random() * maxNumeros) + 1);
			
			/* Comprueba si el boleto contiene el n�mero generado.
			   Si no existe lo a�ade */
			
			for (int dummy : boleto) {
				
				if (!buscar(boleto, numero)) {
				
					boleto[index++] = numero;
					break;
				}
			}
			
		} while (index < maxArray);
		
		// Ordena el boleto
		
		Arrays.sort(boleto);
		
		// Muestra el resultado
		
		for (int n : boleto) {
			
			System.out.print(n + ",");
		}

	}
}
