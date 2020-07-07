package com.jcf.principal;

import java.util.Scanner;

public class Buscador {
	
	private static StringBuilder titulos = new StringBuilder("");
	private static Scanner sc;
	
	// Presenta un men� de opciones
	
	static void presentarMenu() {
		
		System.out.println("----- MEN� OPCIONES -----");
		System.out.println();
		System.out.println("1.- A�adir t�tulo");
		System.out.println("2.- Buscar t�tulo");
		System.out.println("3.- Eliminar t�tulo");
		System.out.println("4.- Ver t�tulos");
		System.out.println("5.- Salir");
		System.out.println();
	}
	
	// Lee la opci�n elegida
	
	static int leerOpcionMenu() {
		
		sc = new Scanner(System.in);
		
		sc.useDelimiter("\r");
		
		return sc.nextInt();
	}
	
	// Cierra el scanner
	
	static void cerrarScanner() {
		
		sc.close();
	}
	
	// A�ade un t�tulo
	
	static void agregarTitulo() {
		
		System.out.println("Introduce el nuevo t�tulo:\r\n");
		
		sc = new Scanner(System.in);
		
		sc.useDelimiter("\r");
			
		titulos.append(sc.nextLine().toString());
		
		titulos.append(",");
	}
	
	// Realiza una b�squeda de un t�tulo que contenga el texto introducido
	
	static void buscarTitulo() {
		
		if (titulos.length() != 0) {
		
			System.out.println("Introduce el t�tulo a buscar:\r\n");
			
			sc = new Scanner(System.in);
			
			sc.useDelimiter("\r");
			
			String titulo = sc.nextLine().toUpperCase();
			
			titulos.deleteCharAt(titulos.toString().length() - 1);
			
			String[] resultados = titulos.toString().split(",");
			
			System.out.println("Resultado de t�tulos que contienen: " + titulo + "\r\n");
			
			for (String res : resultados) {
				
				if (res.toUpperCase().contains(titulo)) {
					
					System.out.println(res);
				}
			}
			
			System.out.println();
		
		} else {
			
			System.out.println("\r\nLa biblioteca est� VAC�A\r\n");
		}
	}
	
	// Muestra los t�tulos que contiene la biblioteca
	
	static void verTitulos() {
		
		if (titulos.length() != 0) {
		
			System.out.println("T�TULOS DISPONIBLES:  ");
			
			for (String res : titulos.toString().split(",")) {
				
				System.out.println(res);
			}
			
			System.out.println();
			
		} else {
			
			System.out.println("\r\nLa biblioteca est� VAC�A\r\n");
		}
	}
	
	// Borra un t�tulo de la biblioteca. Debe coincidir todo el t�tulo y no es case-sensitive
	
	static void eliminarTitulo() {
		
		if (titulos.length() != 0) {
			
			verTitulos();
			
			System.out.println("Introduce el t�tulo a eliminar:\r\n");
			
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
			
			System.out.println("\r\nLa biblioteca est� VAC�A\r\n");
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
					
					System.out.println("\r\nLa opci�n no es v�lida. Prueba otra vez\r\n");
					break;
			}
			
		} while (opcion != 5);
		
		// Ya no vamos a usar el scanner
		
		cerrarScanner();
	}
}
