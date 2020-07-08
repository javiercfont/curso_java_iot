package com.jcf.principal;

import java.util.Scanner;

import model.Ciudad;
import service.TemperaturasService;

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
		
		return Integer.parseInt(sc.nextLine());
	}
	
	// Cierra el scanner
	
	static void cerrarScanner() {
		
		sc.close();
	}
	
	
	// Agrega nueva temperatura
	
	static void altaTemperatura(TemperaturasService service) {
		
		String ciudad;
		Double temperatura;
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce nueva ciudad: ");
		
		ciudad = sc.nextLine();
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce nueva temperatura: ");

		temperatura = sc.nextDouble();

		Ciudad datoUsuario = new Ciudad(ciudad, temperatura);
		
		if (service.agregarCiudad(datoUsuario)) {
			
			System.out.println("La ciudad se a añadido\r\n");
			
		} else {
			
			System.out.println("La ciudad ya existe\r\n");
		}
	}
	
	// Mostrar temperaturas
	
	static void mostrarTemperaturas(TemperaturasService service) {
		
		for (Ciudad dato : service.devolverCiudades()) {
			
			System.out.println(dato);
		}
		
	}
	
	public static void main(String[] args) {
		
		// Se crea un objeto de la capa de servicio
		
		TemperaturasService service = new TemperaturasService();
		
		int opcion;
		
		do {
			
			opcion = 0;
			
			presentarMenu();
			
			/* Captura el error de usuario al marcar una opción distinta
			   de int y evita que el programa caiga */
			
			try {
				
				opcion = leerOpcionMenu();
				
			} catch (NumberFormatException e) {
				
				System.out.println();
			}
			
			switch(opcion) {
			
				case 1:
				
					altaTemperatura(service);
					break;
					
				case 2:
					
					System.out.printf("La media es: %2.2f\r\n\r\n", service.media());
					break;
					
				case 3:
					
					System.out.println("La máxima temperatura en " + service.mayor());
					System.out.println("La mínima temperatura en " + service.menor());
					System.out.println();
					break;
					
				case 4:
					
					mostrarTemperaturas(service);
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
