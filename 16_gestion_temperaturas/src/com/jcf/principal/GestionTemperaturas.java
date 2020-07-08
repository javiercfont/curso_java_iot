package com.jcf.principal;

import java.util.ArrayList;
import java.util.Scanner;

import model.Ciudad;

public class GestionTemperaturas {
	
	private static Scanner sc;
	
	// Presenta un menú de opciones
	
	static void presentarMenu() {
		
		System.out.println("----- MENÚ OPCIONES -----");
		System.out.println();
		System.out.println("1.- Nueva temperatura");
		System.out.println("2.- Media temperaturas");
		System.out.println("3.- Temperaturas extremas");
		System.out.println("4.- Mostrar temperaturas");
		System.out.println("5.- Salir");
		System.out.println();
	}

	// Lee la opción elegida
	
	static int leerOpcionMenu() {
		
		sc = new Scanner(System.in);
		
		return sc.nextInt();
	}
	
	// Cierra el scanner
	
	static void cerrarScanner() {
		
		sc.close();
	}
	
	// Comprueba si existe la ciudad
	
	static boolean compruebaCiudad(ArrayList<Ciudad> datos, String ciudad) {
		
		for (Ciudad dato : datos) {
			
			if (dato.getNombre().equalsIgnoreCase(ciudad)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	// Agrega nueva temperatura
	
	static void agregarTemperatura(ArrayList<Ciudad> datos) {
		
		Ciudad datoUsuario = new Ciudad();
		String ciudad;
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce nueva ciudad: ");
		
		ciudad = sc.nextLine();
		
		if (!compruebaCiudad(datos, ciudad)) {
		
			datoUsuario.setNombre(ciudad);
			
			sc = new Scanner(System.in);
			
			System.out.println("Introduce nueva temperatura: ");
			
			datoUsuario.setTemperatura(sc.nextDouble());
			
			datos.add(datoUsuario);
			
		} else {
			
			System.out.println("La ciudad ya existe\r\n");
		}
	}
	
	
	// Calcula la media
	
	static void calcularMedia(ArrayList<Ciudad> datos) {
		
		if (!datos.isEmpty()) {
			
			double suma = 0.0;
			
			for (Ciudad elemento : datos) {
				
				suma += elemento.getTemperatura();
			}
			
			System.out.printf("La media de las temperaturas es: %2.2f\r\n\r\n", (suma / datos.size()));
			
		} else {
			
			System.out.println("No hay datos guardados\r\n");
		}
	}
	
	// Calcular las temperaturas extremas
	
	static void calcularExtremas(ArrayList<Ciudad> datos) {
		
		if (!datos.isEmpty()) {
			
			Ciudad max = datos.get(0);
			Ciudad min = datos.get(0);
			
			for (Ciudad elemento : datos) {
				
				if (elemento.getTemperatura() > max.getTemperatura()) {
					
					max = elemento;
				}
				
				if (elemento.getTemperatura() < min.getTemperatura()) {
					
					min = elemento;
				}
			}
			
			System.out.println("Temperatura más alta en " + max);
			System.out.println("Temperatura más baja en " + min);
			
		} else {
			
			System.out.println("No hay datos guardados\r\n");
		}
	}
	
	// Mostrar temperaturas
	
	static void mostrarTemperaturas(ArrayList<Ciudad> datos) {
		
		if (!datos.isEmpty()) {
			
			for (Ciudad elemento : datos) {
				
				System.out.println(elemento);
			}
			
		} else {
			
			System.out.println("No hay datos guardados\r\n");
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Ciudad> datosTemperatura = new ArrayList<>();
		
		int opcion;
		
		do {
			
			opcion = 0;
			
			presentarMenu();
			
			/* Captura el error de usuario al marcar una opción distinta
			   de int y evita que el programa caiga */
			
			try {
				
				opcion = leerOpcionMenu();
				
			} catch (java.util.InputMismatchException e) {
				
				System.out.println();
			}
			
			switch(opcion) {
			
				case 1:
				
					agregarTemperatura(datosTemperatura);
					break;
					
				case 2:
					
					calcularMedia(datosTemperatura);
					break;
					
				case 3:
					
					calcularExtremas(datosTemperatura);
					break;
					
				case 4:
					
					mostrarTemperaturas(datosTemperatura);
					break;
					
				case 5:
					
					System.out.println("BYE!\r\n");
					break;
					
				default:
					
					System.out.println("\r\nLa opción no es válida. Prueba otra vez\r\n");
					break;
			}
			
		} while (opcion != 5);
		
		// Ya no vamos a usar el scanner
		
		cerrarScanner();

	}

}
