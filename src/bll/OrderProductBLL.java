package bll;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import dao.OrderProductDAO;

public class OrderProductBLL {
	private static PrintWriter writer;


	public OrderProductBLL() {

	}

	
	public static boolean checkQuantity(int ask, int id) {
		if (OrderProductDAO.getQuantity(id) > ask) {
			return true;
		}
		return false;

	}

	public static void createOrder(int idClient, int idProdus, int quantity) {

		OrderProductDAO.createOrder(idClient, idProdus, quantity);
	}

	public static void factura(int counter, String[] dClient, String dProduct, String quantity) {
		try {
			writer = new PrintWriter("D:/an 2/semestrul 2/TP/Assign3/Assign3" + counter + ".txt");
			writer.println("Name: " + dClient[0]);
			writer.println("Address: " + dClient[1]);
			writer.println("Email: " + dClient[2]);
			writer.println("Product: " + dProduct);
			writer.println("Quantity: " + quantity + " sold out");
			writer.println("Price: " + " - order canceled");
			counter++;
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
