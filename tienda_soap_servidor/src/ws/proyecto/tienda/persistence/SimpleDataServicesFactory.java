package ws.proyecto.tienda.persistence;

import ws.proyecto.tienda.persistence.boardgame.BoardGameDAO;
import ws.proyecto.tienda.persistence.boardgame.BoardGameDataService;
import ws.proyecto.tienda.persistence.boardgameorder.BoardGameOrderDAO;
import ws.proyecto.tienda.persistence.boardgameorder.BoardGameOrderDataService;
import ws.proyecto.tienda.persistence.order.OrderDAO;
import ws.proyecto.tienda.persistence.order.OrderDataService;
import ws.proyecto.tienda.persistence.user.UserDAO;
import ws.proyecto.tienda.persistence.user.UserDataService;

public class SimpleDataServicesFactory implements DataServicesFactory {

	public BoardGameDataService getBoardGameDataService() {
		return new BoardGameDAO();
	}

	public UserDataService getUserDataService() {
		return new UserDAO();
	}

	@Override
	public OrderDataService getOrderDataService() {
		return new OrderDAO();
	}

	@Override
	public BoardGameOrderDataService getBoardGameOrderDataService() {
		// TODO Auto-generated method stub
		return new BoardGameOrderDAO();
	}
}
