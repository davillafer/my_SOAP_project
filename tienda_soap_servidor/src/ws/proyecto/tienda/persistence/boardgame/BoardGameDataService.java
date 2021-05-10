package ws.proyecto.tienda.persistence.boardgame;

import java.util.List;

import ws.proyecto.tienda.model.BoardGame;

public interface BoardGameDataService {

	public boolean create(BoardGame boardGame);

	public BoardGame read(String id);

	public List<BoardGame> readAll();

	public boolean update(BoardGame boardGame);

	public boolean delete(String id);

	public List<BoardGame> findByName(String name);

}
