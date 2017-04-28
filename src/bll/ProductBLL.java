package bll;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import dao.ProductDAO;

import model.Product;

public class ProductBLL {

	public ProductBLL() {

	}

	public Product findProductById(int id) {
		Product st = ProductDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}

	public static int insert(Product product) {

		return ProductDAO.insert(product);
	}

	public static void update(Product client, int ID) {
		ProductDAO.update(client, ID);
	}

	public static void deleteById(int id) {
		ProductDAO.delete(id);
	}

	public static ArrayList<Product> getProducts() {
		return ProductDAO.getProducts();

	}
}
