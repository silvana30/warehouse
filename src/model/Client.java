package model;

public class Client {

	private int ID;
	private String name;
	private String address;
	private String email;

	public Client(int iD, String name, String address, String email) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public Client(String name, String address, String email) {
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public Client() {

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [ID=" + ID + ", name=" + name + ", address=" + address + ", email=" + email + "]";
	}

}
