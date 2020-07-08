package com.jcf.principal;

import java.util.Scanner;

import model.Contacto;
import service.ContactosService;

public class GestionContactos {
	
	private static Scanner sc;
	
	// Presenta un menú de opciones
	
	static void presentarMenu() {
		
		System.out.println("----- MENÚ OPCIONES -----");
		System.out.println();
		System.out.println("1.- Nuevo contacto");
		System.out.println("2.- Ver contacto");
		System.out.println("3.- Borrar contacto");
		System.out.println("4.- Mostrar todos");
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
	
	// Agrega un contacto
	
	static void agregar(ContactosService service) {
	
		String nombre;
		String email;
		String telefono;
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce nombre: ");
		
		nombre = sc.nextLine();
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce email: ");

		email = sc.nextLine();
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce teléfono: ");

		telefono = sc.nextLine();

		Contacto datoUsuario = new Contacto(nombre, email, telefono);
		
		if (service.agregarContacto(datoUsuario)) {
			
			System.out.println("El contacto se a añadido\r\n");
			
		} else {
			
			System.out.println("El contacto ya existe\r\n");
		}
	}
	
	// Muestra un contacto
	
	public static void mostrar(ContactosService service) {
		
		String email;
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce email: ");

		email = sc.nextLine();
		
		Contacto dato = service.mostrarContacto(email);
		
		if (dato != null) {
			
			System.out.println(dato);
			
		} else {
			
			System.out.println("No existe en la agenda\r\n");
		}
	}
	
	// Borrar un contacto
	
	public static void borrar(ContactosService service) {
	
		String email;
		
		sc = new Scanner(System.in);
		
		System.out.println("Introduce email: ");

		email = sc.nextLine();
		
		if (service.borrarContacto(email)) {
			
			System.out.println("El contacto se ha borrado\r\n");
			
		} else {
			
			System.out.println("El contacto no existe\r\n");
		}
	}
	
	// Ver datos
	
	public static void ver(ContactosService service) {
		
		Contacto[] datos = service.verTodos();
		
		if (datos.length != 0) {

			for (Contacto dato : datos) {
				
				System.out.println(dato);
			}
			
		} else {
			
			System.out.println("No hay datos en la agenda\r\n");
		}
	}

	public static void main(String[] args) {

		// Se crea un objeto de la capa de servicio
		
		ContactosService service = new ContactosService();
		
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
				
					agregar(service);
					break;
					
				case 2:
					
					mostrar(service);
					break;
					
				case 3:
					
					borrar(service);
					break;
					
				case 4:
					
					ver(service);
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
