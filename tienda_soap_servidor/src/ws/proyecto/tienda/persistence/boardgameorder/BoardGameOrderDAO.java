package ws.proyecto.tienda.persistence.boardgameorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.BoardGameOrder;
import ws.proyecto.tienda.persistence.DbConnection;
import ws.proyecto.tienda.util.QueriesReader;

public class BoardGameOrderDAO implements BoardGameOrderDataService {

	Logger logger = Logger.getLogger(this.getClass());
	QueriesReader queriesReader = QueriesReader.getQueriesReader();
	private DbConnection db = new DbConnection();

	@Override
	public boolean createBoardGameOrder(BoardGameOrder boardgameorder) {
		logger.debug("Storing a new board game order in database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("BOARDGAMEORDER_INSERT", String.valueOf(boardgameorder.getBoardGame_id()),
						String.valueOf(boardgameorder.getOrder_id()), String.valueOf(boardgameorder.getNumber())));
				ps.executeUpdate();
				logger.debug("Inserting new board game order");
			} catch (SQLException e) {
				logger.debug("Error inserting board game order to database");
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
}
