package ws.proyecto.tienda.webservice;

import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import ws.proyecto.tienda.model.User;
import ws.proyecto.tienda.persistence.DataServicesFactory;
import ws.proyecto.tienda.persistence.SimpleDataServicesFactory;
import ws.proyecto.tienda.persistence.user.UserDataService;

@WebService(endpointInterface = "ws.proyecto.tienda.webservice.IUserWS")
public class UserWS implements IUserWS {

	Logger logger = Logger.getLogger(this.getClass());

	private DataServicesFactory dataServicesFactory;
	private UserDataService userDataService;

	public UserWS() {
		dataServicesFactory = new SimpleDataServicesFactory();
		userDataService = dataServicesFactory.getUserDataService();
	}

	@Override
	public boolean createUser(User user) {
		logger.debug("Asking for storing a user");
		// Store the new user in the database if it does not exist
		boolean result = userDataService.create(user);
		// True if it is stored, False otherwise
		return result;
	}

	@Override
	public User readUser(String id) {
		logger.debug("Asking for user with id " + id);
		// Get the user from database if is exists
		User user = userDataService.read(id);
		// BoardGame if it exists, null otherwise
		return user;
	}

	@Override
	public List<User> readAllUsers() {
		logger.debug("Asking for users");
		// Get all users from database
		List<User> users = userDataService.readAll();
		// List with all users
		return users;
	}

	@Override
	public boolean updateUser(User user) {
		logger.debug("Asking for updating a user");
		// Update the user in the database if it exists
		boolean result = userDataService.update(user);
		// True if it is updated, False otherwise
		return result;
	}

	@Override
	public boolean deleteUser(String id) {
		logger.debug("Asking for deleting a user");
		// Remove the user from the database if it exists
		boolean result = userDataService.delete(id);
		// True if it is deleted, False otherwise
		return result;
	}

	@Override
	public List<User> findByUsernamePassword(String username, String password) {
		logger.debug("Asking for authentication check");
		// Ask for an authentication check
		List<User> result = userDataService.findByUsernamePassword(username, password);
		// True if credentials are correct.
		return result;
	}
	
	@Override
	public List<User> findByUsername(String username) {
		logger.debug("Asking for authentication check");
		// Ask for an authentication check
		List<User> result = userDataService.findByUsername(username);
		// True if credentials are correct.
		return result;
	}

}
