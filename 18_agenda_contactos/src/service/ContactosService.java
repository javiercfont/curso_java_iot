package service;

import java.util.Collection;
import java.util.HashMap;

import model.Contacto;

public class ContactosService {

	HashMap<String, Contacto> contactos = new HashMap<>();
	
	
	public boolean agregarContacto(Contacto contacto) {
		
		if (!contactos.containsKey(contacto.getEmail())) {
			
			contactos.put(contacto.getEmail(), contacto);
			
			return true;
		}
		
		return false;
	}
	
	public Contacto mostrarContacto(String email) {
		
		return contactos.get(email);
	}
	
	public boolean borrarContacto(String email) {
		
		if (contactos.containsKey(email)) {
		
			contactos.remove(email);
			
			return true;
		}
		
		return false;
	}
	
	public Contacto[] verTodos() {
		
		Collection<Contacto> datos = contactos.values();
		
		return datos.toArray(new Contacto[0]);
		
	}

}
