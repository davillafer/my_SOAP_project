package ws.proyecto.tienda.persistence.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.Order;
import ws.proyecto.tienda.persistence.DbConnection;
import ws.proyecto.tienda.util.QueriesReader;

public class OrderDAO implements OrderDataService {

	Logger logger = Logger.getLogger(this.getClass());
	QueriesReader queriesReader = QueriesReader.getQueriesReader();
	private DbConnection db = new DbConnection();

	@Override
	public boolean createOrder(Order order) {
		logger.debug("Storing a new order in database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("ORDER_INSERT", String.valueOf(order.getUser_id()),
						order.getCountry(), order.getProvince(), order.getLocation(), order.getPostal_code(), order.getAddress(), order.getStatus(), String.valueOf(order.getPrice())));
				ps.executeUpdate();
				logger.debug("Inserting new order");
			} catch (SQLException e) {
				logger.debug("Error inserting order to database");
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
	public int maxId() {
		Connection conn = db.getConnection();
		if (conn == null) {
			return 0;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("ORDER_MAXID"));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					return result.getInt(1);
				}
			} catch (SQLException e) {
				logger.debug("Error");
				e.printStackTrace();
				return 0;
			}
			try {
				logger.debug("Closing the connection to the database");
				conn.close();
			} catch (SQLException e) {
				logger.debug("Error closing the connection");
				e.printStackTrace();
				return 0;
			}
			return 0;
		}
	}
}
