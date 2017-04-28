package model;

public class OrderProduct {

	private int ID;
	private int IDc;
	private int IDp;
	private int quantity;

	public OrderProduct(int iD, int iDc, int iDp, int quantity) {
		super();
		ID = iD;
		IDp = iDp;
		IDc = iDc;
		this.quantity = quantity;
	}

	public OrderProduct() {

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getIDp() {
		return IDp;
	}

	public void setIDp(int iDp) {
		IDp = iDp;
	}

	public int getIDc() {
		return IDc;
	}

	public void setIDc(int iDc) {
		IDc = iDc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [ID=" + ID + ", IDc=" + IDc + ", IDp=" + IDp + ", quantity=" + quantity + "]";
	}

}
