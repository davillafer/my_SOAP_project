package ws.proyecto.tienda.webservice;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import ws.proyecto.tienda.model.BoardGame;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IBoardGameWS {

	@WebMethod
	public boolean create(BoardGame boardGame);

	@WebMethod
	public BoardGame read(String id);

	@WebMethod
	public List<BoardGame> readAll();

	@WebMethod
	public boolean update(BoardGame boardGame);

	@WebMethod
	public boolean delete(String id);
	
	@WebMethod
	public List<BoardGame> findByName(String name);

}
