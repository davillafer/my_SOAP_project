package ws.proyecto.tienda.webservice;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.BoardGameOrder;
import ws.proyecto.tienda.persistence.DataServicesFactory;
import ws.proyecto.tienda.persistence.SimpleDataServicesFactory;
import ws.proyecto.tienda.persistence.boardgameorder.BoardGameOrderDataService;

@WebService(endpointInterface = "ws.proyecto.tienda.webservice.IBoardGameOrderWS")
public class BoardGameOrderWS implements IBoardGameOrderWS {

	Logger logger = Logger.getLogger(this.getClass());

	private DataServicesFactory dataServicesFactory;
	private BoardGameOrderDataService boardgameorderDataService;

	public BoardGameOrderWS() {
		dataServicesFactory = new SimpleDataServicesFactory();
		boardgameorderDataService = dataServicesFactory.getBoardGameOrderDataService();
	}

	@Override
	public boolean createBoardGameOrder(BoardGameOrder order) {
		logger.debug("Asking for storing a board game order");
		// Store the new board game in the database if it does not exist
		boolean result = boardgameorderDataService.createBoardGameOrder(order);
		// True if it is stored, False otherwise
		return result;
	}

}
