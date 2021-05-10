package ws.proyecto.tienda.persistence.user;

import java.util.List;

import ws.proyecto.tienda.model.User;

public interface UserDataService {

	public boolean create(User user);

	public User read(String id);

	public List<User> readAll();

	public boolean update(User user);

	public boolean delete(String id);

	public List<User> findByUsernamePassword(String username, String password);
	
	public List<User> findByUsername(String username);

}
