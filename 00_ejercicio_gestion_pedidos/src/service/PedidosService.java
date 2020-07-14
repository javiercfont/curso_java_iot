package service;

import java.util.LinkedList;

import model.Pedido;

public class PedidosService {
	
	// Representa la lista de pedidos
	// LinkedList funciona como FIFO
	
	private LinkedList<Pedido> pedidos = new LinkedList<>();
	
	// Se registra el pedido si no existe
	
	public boolean registrarPedido(Pedido p) {
		
		/* contains usa el equals sobreescrito de Pedido
		   Por tanto 2 objetos Pedido son iguales si el id es el mismo */
		
		if (!this.pedidos.contains(p)) {
			
			pedidos.add(p);
			
			return true;
		}
		
		return false;
	}
	
	// Se procesa el pedido
	
	public Pedido procesarPedido() {
		
		// Si hay pedidos se procesa el de más prioridad

		if (!this.pedidos.isEmpty()) {
			
			return pedidos.removeFirst();
		}
		
		return null;
	}
	
	// Se busca la posición del pedido por su id
	
	public int buscarPedido(int id) {
		
		if (!this.pedidos.isEmpty()) {
			
			for (Pedido pedido : pedidos) {
				
				if (pedido.getId() == id) {
					
					return pedidos.indexOf(pedido);
				}
			}
			
			return -1;
		}
		
		return -1;
	}

	// Devuelve la facturación pendiente de todos los pedidos
	
	public double facturacionPendiente() {
		
		double facturacion = 0.0;
		
		for (Pedido pedido : pedidos) {
			
			facturacion += pedido.getPrecio();
		}
		
		return facturacion;
	}
	
	// Devuelve todos los pedidos almacenados
	
	public LinkedList<Pedido> getPedidos() {
		
		return pedidos;
	}
}
