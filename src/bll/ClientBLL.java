package bll;

import java.util.ArrayList;

import java.util.NoSuchElementException;

import dao.ClientDAO;

import model.Client;

public class ClientBLL {

	public ClientBLL() {

	}

	public Client findClientById(int id) {
		Client st = ClientDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}

	public static int insertClient(Client client) {

		return ClientDAO.insert(client);
	}

	public static void update(Client client, int id) {

		ClientDAO.update(client, id);
	}

	public static void delete(int id) {
		ClientDAO.delete(id);
	}

	public static ArrayList<Client> getClients() {
		return ClientDAO.getClients();
	}

}
