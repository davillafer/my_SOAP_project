package ws.proyecto.tienda.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import ws.proyecto.tienda.model.User;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IUserWS {

	@WebMethod
	public boolean createUser(User user);

	@WebMethod
	public User readUser(String id);

	@WebMethod
	public List<User> readAllUsers();

	@WebMethod
	public boolean updateUser(User user);

	@WebMethod
	public boolean deleteUser(String id);
	
	@WebMethod
	public List<User> findByUsernamePassword(String username, String password);
	
	@WebMethod
	public List<User> findByUsername(String username);
	

}
