package ws.proyecto.tienda.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import ws.proyecto.tienda.model.Order;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IOrderWS {

	@WebMethod
	public boolean createOrder(Order order);
	
	@WebMethod
	public int orderId();


}
