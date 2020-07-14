package model;

public class Pedido {
	
	private int id;
	private String producto;
	private double precio;
	
	public Pedido(int id, String producto, double precio) {
		
		this.id = id;
		this.producto = producto;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		
		// Un pedido con el mismo id tiene el mismo hashCode
		
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {

		Pedido other = (Pedido) obj;
		
		// Un pedido es igual a otro si el id es el mismo
		
		if (this.id != other.id) {
			
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		
		/* Los requisitos de la aplicación indican que sólo se muestre el nombre
		   Para mayor claridad a la hora de ver las prioridades se muestran todos los datos del bean
		   Es una posible mejora */
		
		return "Pedido [id: " + this.id + ", producto: " + this.producto + ", precio: " + this.precio + "]";
	}
}
