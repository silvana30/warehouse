package model;

public class Product {

	private int ID;
	private String name;
	private int quantity;
	private double price;

	public Product(int iD, String name, int quantity, double price) {
		super();
		ID = iD;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Product(String name, int quantity, double price) {

		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Product() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
	}

}