package com.jcf.principal;

import java.util.Scanner;

public class Buscador {
	
	private static StringBuilder titulos = new StringBuilder("");
	private static Scanner sc;
	
	// Presenta un menú de opciones
	
	static void presentarMenu() {
		
		System.out.println("----- MENÚ OPCIONES -----");
		System.out.println();
		System.out.println("1.- Añadir título");
		System.out.println("2.- Buscar título");
		System.out.println("3.- Eliminar título");
		System.out.println("4.- Ver títulos");
		System.out.println("5.- Salir");
		System.out.println();
	}
	
	// Lee la opción elegida
	
	static int leerOpcionMenu() {
		
		sc = new Scanner(System.in);
		
		sc.useDelimiter("\r");
		
		return sc.nextInt();
	}
	
	// Cierra el scanner
	
	static void cerrarScanner() {
		
		sc.close();
	}
	
	// Añade un título
	
	static void agregarTitulo() {
		
		System.out.println("Introduce el nuevo título:\r\n");
		
		sc = new Scanner(System.in);
		
		sc.useDelimiter("\r");
			
		titulos.append(sc.nextLine().toString());
		
		titulos.append(",");
	}
	
	// Realiza una búsqueda de un título que contenga el texto introducido
	
	static void buscarTitulo() {
		
		if (titulos.length() != 0) {
		
			System.out.println("Introduce el título a buscar:\r\n");
			
			sc = new Scanner(System.in);
			
			sc.useDelimiter("\r");
			
			String titulo = sc.nextLine().toUpperCase();
			
			titulos.deleteCharAt(titulos.toString().length() - 1);
			
			String[] resultados = titulos.toString().split(",");
			
			System.out.println("Resultado de títulos que contienen: " + titulo + "\r\n");
			
			for (String res : resultados) {
				
				if (res.toUpperCase().contains(titulo)) {
					
					System.out.println(res);
				}
			}
			
			System.out.println();
		
		} else {
			
			System.out.println("\r\nLa biblioteca está VACÍA\r\n");
		}
	}
	
	// Muestra los títulos que contiene la biblioteca
	
	static void verTitulos() {
		
		if (titulos.length() != 0) {
		
			System.out.println("TÍTULOS DISPONIBLES:  ");
			
			for (String res : titulos.toString().split(",")) {
				
				System.out.println(res);
			}
			
			System.out.println();
			
		} else {
			
			System.out.println("\r\nLa biblioteca está VACÍA\r\n");
		}
	}
	
	// Borra un título de la biblioteca. Debe coincidir todo el título y no es case-sensitive
	
	static void eliminarTitulo() {
		
		if (titulos.length() != 0) {
			
			verTitulos();
			
			System.out.println("Introduce el título a eliminar:\r\n");
			
			sc = new Scanner(System.in);
			
			sc.useDelimiter("\r");
			
			String titulo = sc.nextLine().toUpperCase();
			
			String[] resultados = titulos.toString().split(",");
			
			titulos.delete(0, (titulos.length()));
		
			for (String res : resultados) {
			
				if (res.toUpperCase().equals(titulo)) {
					
					continue;
				}
				
				titulos.append(res);
				titulos.append(",");
			}
			
			verTitulos();
			
		} else {
			
			System.out.println("\r\nLa biblioteca está VACÍA\r\n");
		}
	}
		
	
	// Programa principal
	
	public static void main(String[] args) {
		
		int opcion;
		
		do {
			
			opcion = 0;
			
			presentarMenu();
			
			try {
				
				opcion = leerOpcionMenu();
				
			} catch (java.util.InputMismatchException e) {
				
				System.out.println();
			}
			
			switch(opcion) {
			
				case 1:
				
					agregarTitulo();
					break;
					
				case 2:
					
					buscarTitulo();
					break;
					
				case 3:
					
					eliminarTitulo();
					break;
					
				case 4:
					
					verTitulos();
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
