package servicio;

public class Punto3d extends Punto {

	private int z;
	
	public Punto3d(int z) {
		
		this(30, 6, z);
	}
	
	public Punto3d(int x, int y, int z) {
		
		super(x, y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public void imprimir() {
		
		System.out.println("X: " + this.getX() + " Y: " + this.getY() + " Z: " + z);
	}

	@Override
	public void desplazar(int v) {

		super.desplazar(v);
		this.z += v;
	}
}
