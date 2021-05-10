package ws.proyecto.tienda.webservice;

import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.BoardGame;
import ws.proyecto.tienda.persistence.DataServicesFactory;
import ws.proyecto.tienda.persistence.SimpleDataServicesFactory;
import ws.proyecto.tienda.persistence.boardgame.BoardGameDataService;

@WebService(endpointInterface = "ws.proyecto.tienda.webservice.IBoardGameWS")
public class BoardGameWS implements IBoardGameWS {

	Logger logger = Logger.getLogger(this.getClass());

	private DataServicesFactory dataServicesFactory;
	private BoardGameDataService boardGameDataService;

	public BoardGameWS() {
		dataServicesFactory = new SimpleDataServicesFactory();
		boardGameDataService = dataServicesFactory.getBoardGameDataService();
	}

	@Override
	public boolean create(BoardGame boardGame) {
		logger.debug("Asking for storing a board game");
		// Store the new board game in the database if it does not exist
		boolean result = boardGameDataService.create(boardGame);
		// True if it is stored, False otherwise
		return result;
	}

	@Override
	public BoardGame read(String id) {
		logger.debug("Asking for board game with id " + id);
		// Get the board game from database if is exists
		BoardGame boardGame = boardGameDataService.read(id);
		// BoardGame if it exists, null otherwise
		return boardGame;
	}

	@Override
	public List<BoardGame> readAll() {
		logger.debug("Asking for board games");
		// Get all board games from database
		List<BoardGame> boardGame = boardGameDataService.readAll();
		// List with all board games
		return boardGame;
	}

	@Override
	public boolean update(BoardGame boardGame) {
		logger.debug("Asking for updating a user");
		// Update the board game in the database if it exists
		boolean result = boardGameDataService.update(boardGame);
		// True if it is updated, False otherwise
		return result;
	}

	@Override
	public boolean delete(String id) {
		logger.debug("Asking for deleting a user");
		// Remove the board game from the database if it exists
		boolean result = boardGameDataService.delete(id);
		// List with all board games
		return result;
	}

	@Override
	public List<BoardGame> findByName(String name) {
		logger.debug("Asking for board games that contain in the name the string passed");
		// Get board games that contain in the name the string passed from database
		List<BoardGame> result = boardGameDataService.findByName(name);
		// List with board games that contain in the name the string passed
		return result;
	}

}
