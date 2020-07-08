package service;

import java.util.ArrayList;

import model.Ciudad;

public class TemperaturasService {
	
	private ArrayList<Ciudad> datosTemperatura = new ArrayList<>();

	private boolean comprobarCiudad(String nombre) {
		
		for (Ciudad dato : datosTemperatura) {
			
			if (dato.getNombre().equalsIgnoreCase(nombre)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	public boolean agregarCiudad(Ciudad ciudad) {
		
		if (!comprobarCiudad(ciudad.getNombre())) {
			
			datosTemperatura.add(ciudad);
			
			return true;
		}
		
		return false;
	}
	
	public double media() {
		
		if (!datosTemperatura.isEmpty()) {
			
			double suma = 0.0;
			
			for (Ciudad elemento : datosTemperatura) {
				
				suma += elemento.getTemperatura();
			}
			
			return suma / datosTemperatura.size();
			
		} else {
			
			return 0;
		}
	}
	
	public Ciudad mayor() {
		
		if (!datosTemperatura.isEmpty()) {
			
			Ciudad max = datosTemperatura.get(0);
			
			for (Ciudad elemento : datosTemperatura) {
				
				if (elemento.getTemperatura() > max.getTemperatura()) {
					
					max = elemento;
				}
			}
			
			return max;
			
		} else {
			
			return null;
		}
	}
	
	public Ciudad menor() {
		
		if (!datosTemperatura.isEmpty()) {
			
			Ciudad min = datosTemperatura.get(0);
			
			for (Ciudad elemento : datosTemperatura) {
				
				if (elemento.getTemperatura() < min.getTemperatura()) {
					
					min = elemento;
				}
			}
			
			return min;
			
		} else {
			
			return null;
		}
	}

	public Ciudad[] devolverCiudades() {
		
		return datosTemperatura.toArray(new Ciudad[0]);
	}

}
