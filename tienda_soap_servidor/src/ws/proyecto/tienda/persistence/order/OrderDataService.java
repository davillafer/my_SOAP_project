package ws.proyecto.tienda.persistence.order;

import ws.proyecto.tienda.model.Order;

public interface OrderDataService {

	public boolean createOrder(Order order);

	public int maxId();

}
