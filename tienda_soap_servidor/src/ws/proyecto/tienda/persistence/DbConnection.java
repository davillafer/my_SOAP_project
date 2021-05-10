package ws.proyecto.tienda.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DbConnection {

	Logger logger = Logger.getLogger(this.getClass());

	private static final String myDriver = "com.mysql.jdbc.Driver";
	private static final String myUrl = "jdbc:mysql://mysql:3306/tienda_ws";
	private Connection connection;

	private void connect() {
		logger.debug("Connecting to database");
		try {
			Class.forName(myDriver);
			this.connection = DriverManager.getConnection(myUrl, "root", "");
			logger.debug("Connected to database");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			logger.debug("Error connecting to database");
		}
	}

	public Connection getConnection() {
		connect();
		return this.connection;
	}

}
