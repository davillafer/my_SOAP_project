package ws.proyecto.tienda.model;

public class Order {

	private int id, user_id;
	private String country, province, location, postal_code, address, status;
	private double price;
	
	public Order() {
		super();

	}
	
	public Order(int user_id, String country, String province, String location, String postal_code,
			String address, String status, double price) {
		super();
		this.user_id = user_id;
		this.country = country;
		this.province = province;
		this.location = location;
		this.postal_code = postal_code;
		this.address = address;
		this.status = status;
		this.price = price;
	}
	
	public Order(int id, int user_id, String country, String province, String location, String postal_code,
			String address, String status, double price) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.country = country;
		this.province = province;
		this.location = location;
		this.postal_code = postal_code;
		this.address = address;
		this.status = status;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", user_id=" + user_id + ", country=" + country + ", province=" + province
				+ ", location=" + location + ", postal_code=" + postal_code + ", address=" + address + ", status="
				+ status + ", price=" + price + "]";
	}

	
	
	
	
}
