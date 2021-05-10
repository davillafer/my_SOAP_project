package ws.proyecto.tienda.model;

public class BoardGame {

	private String name, description, imageURL, officialURL, rulesURL;
	private int id, stock;
	private double price;


	public BoardGame() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardGame(int id, String name, String description, String imageURL, String officialURL, String rulesURL, double price, int stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.officialURL = officialURL;
		this.rulesURL = rulesURL;
		this.price = price;
		this.stock = stock;
	}
	
	public BoardGame(String name, String description, String imageURL, String officialURL, String rulesURL, double price, int stock) {
		super();
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.officialURL = officialURL;
		this.rulesURL = rulesURL;
		this.price = price;
		this.stock = stock;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getOfficialURL() {
		return officialURL;
	}

	public void setOfficialURL(String officialURL) {
		this.officialURL = officialURL;
	}

	public String getRulesURL() {
		return rulesURL;
	}

	public void setRulesURL(String rulesURL) {
		this.rulesURL = rulesURL;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "BoardGame [name=" + name + ", description=" + description + ", imageURL=" + imageURL + ", officialURL="
				+ officialURL + ", rulesURL=" + rulesURL + ", id=" + id + ", stock=" + stock + ", price=" + price + "]";
	}

	
	
}
