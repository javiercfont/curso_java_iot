package com.jcf.principal;

import java.util.HashSet;

import model.Contacto;

public class Test {

	public static void main(String[] args) {
		
		HashSet<Contacto> contactos = new HashSet<Contacto>();
		
		contactos.add(new Contacto("Contacto1", "jj@jj", "4567"));
		contactos.add(new Contacto("Contacto2", "ff@ff", "4217"));
		contactos.add(new Contacto("Contacto3", "hh@hh", "1117"));
		contactos.add(new Contacto("Contacto4", "jj@jj", "6547"));
		contactos.add(new Contacto("Contacto4", "jj@jj", "6547"));
		
		// Como no se ha sobreescrito el equals para Contacto, agrega contactos con la misma
		// información
		
		for (Contacto c : contactos) {
			
			System.out.println(c);
		}

	}

}
