package ws.proyecto.tienda.persistence;

import ws.proyecto.tienda.persistence.boardgame.BoardGameDataService;
import ws.proyecto.tienda.persistence.boardgameorder.BoardGameOrderDataService;
import ws.proyecto.tienda.persistence.order.OrderDataService;
import ws.proyecto.tienda.persistence.user.UserDataService;

public interface DataServicesFactory {

	public BoardGameDataService getBoardGameDataService();
	
	public UserDataService getUserDataService();
	
	public OrderDataService getOrderDataService();
	
	public BoardGameOrderDataService getBoardGameOrderDataService();
	
}
