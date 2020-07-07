package model;

public class Ciudad {
	
	private String nombre;
	private Double temperatura;
	
	public String getNombre() {
		
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
	}
	
	public Double getTemperatura() {
		
		return temperatura;
	}
	
	public void setTemperatura(Double temperatura) {
		
		this.temperatura = temperatura;
	}

	/* Se modifica el método toString para presentar los datos
	   según nos interesa */
	
	@Override
	public String toString() {
		
		return this.nombre + " : " + this.temperatura + "\r\n";
	}
}
