package ws.proyecto.tienda.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import ws.proyecto.tienda.model.BoardGameOrder;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBoardGameOrderWS {

	@WebMethod
	public boolean createBoardGameOrder(BoardGameOrder order);


}
