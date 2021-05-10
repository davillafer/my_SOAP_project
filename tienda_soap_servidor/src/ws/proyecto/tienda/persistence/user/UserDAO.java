package ws.proyecto.tienda.persistence.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.User;
import ws.proyecto.tienda.persistence.DbConnection;
import ws.proyecto.tienda.util.QueriesReader;

public class UserDAO implements UserDataService {

	Logger logger = Logger.getLogger(this.getClass());
	QueriesReader queriesReader = QueriesReader.getQueriesReader();
	private DbConnection db = new DbConnection();

	@Override
	public boolean create(User user) {
		logger.debug("Storing a new user in database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_INSERT", user.getName(),
						user.getSurname(), user.getUsername(), user.getPassword(), user.getRole()));
				ps.executeUpdate();
				logger.debug("Inserting new User");
			} catch (SQLException e) {
				logger.debug("Error inserting user to database");
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
	public User read(String id) {
		logger.debug("Getting the user with id " + id + " from database");
		Connection conn = db.getConnection();
		User user = null;
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_SELECT_BY_ID", id));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("User [id: " + result.getInt(1) + ", username: " + result.getString(4) + "]");
					user = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
							result.getString(5), result.getString(6));
				}
			} catch (SQLException e) {
				logger.debug("Error getting all users from database");
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
			return user;
		}
	}

	@Override
	public List<User> readAll() {
		logger.debug("Getting all users from database");
		Connection conn = db.getConnection();
		List<User> users = new ArrayList<>();
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_SELECT_ALL"));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("User [id: " + result.getInt(1) + ", username: " + result.getString(4) + "]");
					users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
							result.getString(5), result.getString(6)));
				}
			} catch (SQLException e) {
				logger.debug("Error getting all users from database");
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
			return users;
		}
	}

	@Override
	public boolean update(User user) {
		logger.debug("Updating the user with id " + user.getId() + " in database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_UPDATE_BY_ID", String.valueOf(user.getId()), user.getName(),
						user.getSurname(), user.getUsername(), user.getPassword(), user.getRole()));
				ps.executeUpdate();
				logger.debug("Updating user");
			} catch (SQLException e) {
				logger.debug("Error updating user to database");
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
		logger.debug("Deleting the user with id " + id + " from database");
		Connection conn = db.getConnection();
		if (conn == null) {
			return false;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_DELETE_BY_ID", id));
				ps.executeUpdate();
				logger.debug("Deleting the user from the database");
			} catch (SQLException e) {
				logger.debug("Error deleting the user from the database");
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
	public List<User> findByUsernamePassword(String username, String password) {
		logger.debug("Authenticating user");
		Connection conn = db.getConnection();
		List<User> users = new ArrayList<>();
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_SELECT_BY_USERNAME_PASSWORD", username, password));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("User [id: " + result.getInt(1) + ", username: " + result.getString(4) + "]");
					users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
							result.getString(5), result.getString(6)));
				}
			} catch (SQLException e) {
				logger.debug("Error authenticating user");
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
			return users;
		}
	}

	@Override
	public List<User> findByUsername(String username) {
		logger.debug("Authenticating user");
		Connection conn = db.getConnection();
		List<User> users = new ArrayList<>();
		if (conn == null) {
			return null;
		} else {
			try {
				PreparedStatement ps = conn.prepareStatement(queriesReader.getProperty("USER_SELECT_BY_USERNAME", username));
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					logger.debug("User [id: " + result.getInt(1) + ", username: " + result.getString(4) + "]");
					users.add(new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
							result.getString(5), result.getString(6)));
				}
			} catch (SQLException e) {
				logger.debug("Error authenticating user");
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
			return users;
		}
	}
}
