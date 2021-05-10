package ws.proyecto.tienda.persistence.boardgame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.BoardGame;
import ws.proyecto.tienda.persistence.DbConnection;
import ws.proyecto.tienda.util.QueriesReader;

public class BoardGameDAO implements BoardGameDataService {

	Logger logger = Logger.getLogger(this.getClass());
	QueriesReader queriesReader = QueriesReader.getQueriesReader();
	private DbConnection db = new DbConnection();
	
	@Override
	public boolean create(BoardGame boardGame) {
		logger.debug("Storing a new board game in database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("BG_INSERT", boardGame.getName(),
						boardGame.getDescription(), boardGame.getImageURL(), boardGame.getOfficialURL(), boardGame.getRulesURL(), String.valueOf(boardGame.getPrice()), String.valueOf(boardGame.getStock())));
				ps.executeUpdate();
				logger.debug("Inserting new board game");
			} catch (SQLException e) {
				logger.debug("Error inserting board game to database");
				e.printStackTrace();
				return false;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}

	@Override
	public BoardGame read(String id) {
		logger.debug("Getting the board game with id " + id + " from database");
		Connection conn = db.getConnection();
		BoardGame boardGame = null;
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("BG_SELECT_BY_ID", id));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("BoardGame [id: " + result.getInt(1) + ", name: " + result.getString(2) + "]");
					boardGame = new BoardGame(result.getInt(1), result.getString(2), result.getString(3),
							result.getString(4), result.getString(5), result.getString(6), result.getDouble(7),
							result.getInt(8));
				}
			} catch (SQLException e) {
				logger.debug("Error getting all board games from database");
				e.printStackTrace();
				return null;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return null;
			}
			return boardGame;
		}
	}

	@Override
	public List<BoardGame> readAll() {
		logger.debug("Getting all board games from database");
		Connection conn = db.getConnection();
		List<BoardGame> boardGames = new ArrayList<>();
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("BG_SELECT_ALL"));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("BoardGame [id: " + result.getInt(1) + ", name: " + result.getString(2) + "]");
					boardGames.add(new BoardGame(result.getInt(1), result.getString(2), result.getString(3),
							result.getString(4), result.getString(5), result.getString(6), result.getDouble(7),
							result.getInt(8)));
				}
			} catch (SQLException e) {
				logger.debug("Error getting all board games from database");
				e.printStackTrace();
				return null;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return null;
			}
			return boardGames;
		}
	}

	@Override
	public boolean update(BoardGame boardGame) {
		logger.debug("Updating the board game with id " + boardGame.getId() + " in database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("BG_UPDATE_BY_ID",
						String.valueOf(boardGame.getId()), boardGame.getName(), boardGame.getDescription(),
						boardGame.getImageURL(), boardGame.getOfficialURL(), boardGame.getRulesURL(),
						String.valueOf(boardGame.getPrice()), String.valueOf(boardGame.getStock())));
				ps.executeUpdate();
				logger.debug("Updating board game");
			} catch (SQLException e) {
				logger.debug("Error updating board game from database");
				e.printStackTrace();
				return false;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}

	@Override
	public boolean delete(String id) {
		logger.debug("Deleting the board game with id " + id + " from database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("BG_DELETE_BY_ID", id));
				ps.executeUpdate();
				logger.debug("Deleting the board game from the database");
			} catch (SQLException e) {
				logger.debug("Error deleting the board game from the database");
				e.printStackTrace();
				return false;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return false;
			}
			return true;
		}
	}

	@Override
	public List<BoardGame> findByName(String name) {
		logger.debug("Getting the board games from database that contain in the name the string passed");
		Connection conn = db.getConnection();
		List<BoardGame> boardGames = new ArrayList<>();
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn
						.prepareStatement(queriesReader.getProperty("BG_SELECT_BY_CONTAINS_NAME", name));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("BoardGame [id: " + result.getInt(1) + ", name: " + result.getString(2) + "]");
					boardGames.add(new BoardGame(result.getInt(1), result.getString(2), result.getString(3),
							result.getString(4), result.getString(5), result.getString(6), result.getDouble(7),
							result.getInt(8)));
				}
			} catch (SQLException e) {
				logger.debug("Error getting board games from database");
				e.printStackTrace();
				return null;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return null;
			}
			return boardGames;
		}
	}

}
