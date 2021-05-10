package ws.proyecto.tienda.model;

public class BoardGameOrder {

	private int id, boardGame_id, order_id, number;

	public BoardGameOrder() {
		super();
	}
	
	public BoardGameOrder(int boardGame_id, int order_id, int number) {
		super();
		this.boardGame_id = boardGame_id;
		this.order_id = order_id;
		this.number = number;
	}
	
	public BoardGameOrder(int id, int boardGame_id, int order_id, int number) {
		super();
		this.id = id;
		this.boardGame_id = boardGame_id;
		this.order_id = order_id;
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardGame_id() {
		return boardGame_id;
	}

	public void setBoardGame_id(int boardGame_id) {
		this.boardGame_id = boardGame_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "BoardGameOrder [id=" + id + ", boardGame_id=" + boardGame_id + ", order_id=" + order_id + ", number="
				+ number + "]";
	}
	
	
}
