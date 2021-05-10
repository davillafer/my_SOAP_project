package ws.proyecto.tienda.webservice;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.Order;
import ws.proyecto.tienda.persistence.DataServicesFactory;
import ws.proyecto.tienda.persistence.SimpleDataServicesFactory;
import ws.proyecto.tienda.persistence.order.OrderDataService;

@WebService(endpointInterface = "ws.proyecto.tienda.webservice.IOrderWS")
public class OrderWS implements IOrderWS {

	Logger logger = Logger.getLogger(this.getClass());

	private DataServicesFactory dataServicesFactory;
	private OrderDataService orderDataService;

	public OrderWS() {
		dataServicesFactory = new SimpleDataServicesFactory();
		orderDataService = dataServicesFactory.getOrderDataService();
	}

	@Override
	public boolean createOrder(Order order) {
		logger.debug("Asking for storing an order");
		// Store the new board game in the database if it does not exist
		boolean result = orderDataService.createOrder(order);
		// True if it is stored, False otherwise
		return result;
	}

	@Override
	public int orderId() {
		logger.debug("Asking for max Id");
		return orderDataService.maxId();
	}

}
