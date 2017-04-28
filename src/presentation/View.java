package presentation;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import bll.ClientBLL;

import bll.OrderProductBLL;
import bll.ProductBLL;
import dao.ClientDAO;

import dao.ProductDAO;
import model.Client;
import model.Product;

import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.Color;

public class View {

	public JFrame frame;

	private JTextField email;
	private JTextField address;
	private JTextField name;
	private JTextField priceP;
	private JTextField quantityP;
	private JTextField nameP;
	private JTable tableProduct;
	private JTable tableP;
	private JTable tableC;
	private JTextField cantitateO;

	private JTable tableClient;
	private JTextField txtId;
	private JTextField txtId_1;
	private JTextField client;
	private JTextField product;

	private int counter = 0;
	private PrintWriter writer;

	private JLabel lblNewLabel_3;

	private JButton btnEnter;

	private JLabel lblIdClient;

	private JLabel lblIdProduct;

	private JButton btnShow_1;

	private JButton button_2;

	private JButton button_1;

	private JButton button;

	private JLabel lblQuantity;

	private JLabel label_1;

	private JLabel lblPrice;

	private JButton btnShow;

	private JButton btnDelete;

	private JButton btnUpdate;

	private JButton btnNewButton;

	private JLabel lblNewLabel_2;

	private JLabel lblNewLabel_1;

	private JLabel lblNewLabel;

	private JScrollPane scrollPane_2;

	private JScrollPane scrollPane_3;

	private JPanel panelOrder;

	private JPanel panelProduct;

	private JScrollPane scrollPane_1;

	private JScrollPane scrollPane;

	private JTabbedPane taburi;

	private JPanel panelClient;;

	public View() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Warehouse");
		frame.setBackground(new Color(255, 228, 181));
		frame.setBounds(100, 100, 459, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		taburi = new JTabbedPane(JTabbedPane.TOP);
		taburi.setBackground(new Color(230, 230, 250));
		taburi.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		taburi.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(taburi);

		panelClient = new JPanel();
		panelClient.setBackground(new Color(255, 239, 213));
		taburi.addTab("Client", null, panelClient, null);
		panelClient.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 409, 103);
		panelClient.add(scrollPane);

		tableClient = new JTable();
		DefaultTableModel defm = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Address", "Email" });

		scrollPane.setViewportView(tableClient);

		////////////////////////////////////////////////
		tableClient.setModel(defm);
		ArrayList<Client> clientList = new ArrayList<Client>();
		clientList = ClientBLL.getClients();
		for (Client c : clientList) {
			Object[] row = { "" + c.getID() + "", c.getName(), c.getAddress(), c.getEmail() };

			defm.addRow(row);

		}

		//////////////////////////////////////////////////////////////////////////////////////////////////////
		panelProduct = new JPanel();
		panelProduct.setBackground(new Color(255, 239, 213));
		taburi.addTab("Product", null, panelProduct, null);
		panelProduct.setLayout(null);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 409, 104);
		panelProduct.add(scrollPane_1);

		tableProduct = new JTable();

		DefaultTableModel defm2 = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Quantity", "Price" });

		scrollPane_1.setViewportView(tableProduct);
		///////////////////////////////////////////////////
		tableProduct.setModel(defm2);
		ArrayList<Product> productList = new ArrayList<Product>();
		productList = ProductBLL.getProducts();
		for (Product p : productList) {
			Object[] row = { "" + p.getID() + "", p.getName(), p.getQuantity(), p.getPrice() };

			defm2.addRow(row);

		}
		////////////////////////////////////////////////////

		panelOrder = new JPanel();
		panelOrder.setBackground(new Color(255, 239, 213));
		taburi.addTab("Order", null, panelOrder, null);
		panelOrder.setLayout(null);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(222, 11, 197, 165);
		panelOrder.add(scrollPane_3);

		tableP = new JTable();
		tableP.setBackground(new Color(245, 255, 250));
		scrollPane_3.setViewportView(tableP);
		tableP.setModel(defm2);
		ArrayList<Product> pList = new ArrayList<Product>();
		productList = ProductBLL.getProducts();
		for (Product p : pList) {
			Object[] row = { "" + p.getID() + "", p.getName(), p.getQuantity(), p.getPrice() };

			defm2.addRow(row);

		}

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 197, 165);
		panelOrder.add(scrollPane_2);

		tableC = new JTable();
		tableC.setBackground(new Color(245, 255, 250));
		scrollPane_2.setViewportView(tableC);

		tableC.setModel(defm);
		ArrayList<Client> cList = new ArrayList<Client>();
		clientList = ClientBLL.getClients();
		for (Client c : cList) {
			Object[] row = { "" + c.getID() + "", c.getName(), c.getAddress(), c.getEmail() };

			defm.addRow(row);

		}

		email = new JTextField();
		email.setBounds(216, 150, 104, 20);
		panelClient.add(email);
		email.setColumns(10);

		lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(216, 125, 46, 14);
		panelClient.add(lblNewLabel);

		address = new JTextField();
		address.setBounds(106, 150, 86, 20);
		panelClient.add(address);
		address.setColumns(10);

		name = new JTextField();
		name.setBounds(10, 150, 86, 20);
		panelClient.add(name);
		name.setColumns(10);

		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(10, 125, 46, 14);
		panelClient.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setBounds(106, 125, 63, 14);
		panelClient.add(lblNewLabel_2);

		btnNewButton = new JButton("ADD");
		btnNewButton.setBackground(new Color(221, 160, 221));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tableClient.setModel(defm);
				Client temp = new Client();
				temp.setName(name.getText());
				temp.setAddress(address.getText());
				temp.setEmail(email.getText());
				ClientBLL.insertClient(temp);

				ArrayList<Client> clientList = new ArrayList<Client>();
				clientList = ClientBLL.getClients();
				for (Client c : clientList) {
					Object[] row = { "" + c.getID() + "", c.getName(), c.getAddress(), c.getEmail() };

					defm.addRow(row);

				}

			}
		});
		btnNewButton.setBounds(10, 199, 89, 23);
		panelClient.add(btnNewButton);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBackground(new Color(240, 230, 140));
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				tableClient.setModel(defm);

				Client temp = new Client();
				temp.setName(name.getText());
				temp.setAddress(address.getText());
				temp.setEmail(email.getText());
				ClientBLL.update(temp, Integer.parseInt(txtId.getText()));

				ArrayList<Client> clientList = new ArrayList<Client>();
				clientList = ClientBLL.getClients();
				for (Client c : clientList) {
					Object[] row = { "" + c.getID() + "", c.getName(), c.getAddress(), c.getEmail() };

					defm.addRow(row);

				}

			}
		});
		btnUpdate.setBounds(213, 199, 89, 23);
		panelClient.add(btnUpdate);

		btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 99, 71));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableClient.setModel(defm);

				ClientBLL.delete(Integer.parseInt(txtId.getText()));

				ArrayList<Client> clientList = new ArrayList<Client>();
				clientList = ClientBLL.getClients();
				for (Client c : clientList) {
					Object[] row = { "" + c.getID() + "", c.getName(), c.getAddress(), c.getEmail() };

					defm.addRow(row);

				}

			}
		});
		btnDelete.setBounds(330, 199, 89, 23);
		panelClient.add(btnDelete);

		btnShow = new JButton("SHOW");
		btnShow.setBackground(new Color(205, 92, 92));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tableClient.setModel(defm);
				ArrayList<Client> clientList = new ArrayList<Client>();
				clientList = ClientBLL.getClients();
				for (Client c : clientList) {
					Object[] row = { "" + c.getID() + "", c.getName(), c.getAddress(), c.getEmail() };

					defm.addRow(row);

				}

			}
		});
		btnShow.setBounds(330, 149, 89, 23);
		panelClient.add(btnShow);

		txtId = new JTextField();
		txtId.setForeground(new Color(0, 0, 139));
		txtId.setBackground(new Color(255, 255, 255));
		txtId.setText("ID?");
		txtId.setBounds(129, 200, 63, 20);
		panelClient.add(txtId);
		txtId.setColumns(10);

		priceP = new JTextField();
		priceP.setColumns(10);
		priceP.setBounds(202, 150, 86, 20);
		panelProduct.add(priceP);

		lblPrice = new JLabel("Price");
		lblPrice.setBounds(202, 126, 59, 14);
		panelProduct.add(lblPrice);

		quantityP = new JTextField();
		quantityP.setColumns(10);
		quantityP.setBounds(106, 150, 86, 20);
		panelProduct.add(quantityP);

		nameP = new JTextField();
		nameP.setColumns(10);
		nameP.setBounds(10, 150, 89, 20);
		panelProduct.add(nameP);

		label_1 = new JLabel("Name");
		label_1.setBounds(10, 126, 59, 14);
		panelProduct.add(label_1);

		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(106, 126, 68, 14);
		panelProduct.add(lblQuantity);

		button = new JButton("ADD");
		button.setBackground(new Color(221, 160, 221));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableProduct.setModel(defm2);

				Product temp = new Product();
				temp.setName(nameP.getText());
				temp.setQuantity(Integer.parseInt((String) quantityP.getText()));
				temp.setPrice(Double.parseDouble((String) priceP.getText()));
				ProductBLL.insert(temp);

				ArrayList<Product> productList = new ArrayList<Product>();
				productList = ProductBLL.getProducts();
				for (Product p : productList) {
					Object[] row = { "" + p.getID() + "", p.getName(), p.getQuantity(), p.getPrice() };

					defm2.addRow(row);

				}
			}
		});
		button.setBounds(10, 199, 89, 23);
		panelProduct.add(button);

		button_1 = new JButton("UPDATE");
		button_1.setBackground(new Color(240, 230, 140));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tableProduct.setModel(defm2);
				Product temp = new Product();
				temp.setName(nameP.getText());
				temp.setPrice(Double.parseDouble((String) priceP.getText()));
				temp.setQuantity(Integer.parseInt((String) quantityP.getText()));
				ProductBLL.update(temp, Integer.parseInt(txtId_1.getText()));

				ArrayList<Product> productList = new ArrayList<Product>();
				productList = ProductBLL.getProducts();
				for (Product p : productList) {
					Object[] row = { "" + p.getID() + "", p.getName(), p.getQuantity(), p.getPrice() };

					defm2.addRow(row);

				}
			}
		});
		button_1.setBounds(220, 199, 89, 23);
		panelProduct.add(button_1);

		button_2 = new JButton("DELETE");
		button_2.setBackground(new Color(255, 99, 71));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tableProduct.setModel(defm2);

				ProductBLL.deleteById(Integer.parseInt(txtId_1.getText()));

				ArrayList<Product> productList = new ArrayList<Product>();
				productList = ProductBLL.getProducts();
				for (Product p : productList) {
					Object[] row = { "" + p.getID() + "", p.getName(), p.getQuantity(), p.getPrice() };

					defm2.addRow(row);

				}
			}
		});
		button_2.setBounds(330, 199, 89, 23);
		panelProduct.add(button_2);

		btnShow_1 = new JButton("SHOW");
		btnShow_1.setBackground(new Color(205, 92, 92));
		btnShow_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tableProduct.setModel(defm2);
				ArrayList<Product> productList = new ArrayList<Product>();
				productList = ProductBLL.getProducts();
				for (Product p : productList) {
					Object[] row = { "" + p.getID() + "", p.getName(), p.getQuantity(), p.getPrice() };

					defm2.addRow(row);

				}

			}
		});
		btnShow_1.setBounds(330, 149, 89, 23);
		panelProduct.add(btnShow_1);

		txtId_1 = new JTextField();
		txtId_1.setForeground(new Color(0, 0, 128));
		txtId_1.setText("ID?");
		txtId_1.setBounds(124, 200, 86, 20);
		panelProduct.add(txtId_1);
		txtId_1.setColumns(10);

		cantitateO = new JTextField();
		cantitateO.setBounds(223, 202, 86, 20);
		panelOrder.add(cantitateO);
		cantitateO.setColumns(10);

		lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setBounds(222, 190, 63, 14);
		panelOrder.add(lblNewLabel_3);

		btnEnter = new JButton("ENTER");
		btnEnter.setBackground(new Color(255, 69, 0));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int idProduct = Integer.parseInt(product.getText());
				int idClient = Integer.parseInt(client.getText());

				Client c = ClientDAO.findById(idClient);
				Product p = ProductDAO.findById(idProduct);

				String[] dateC = { c.getName(), c.getAddress(), c.getEmail() };
				String dateP = p.getName();
				Double price = p.getPrice();

				try {
					writer = new PrintWriter("D:/an 2/semestrul 2/TP/Assign3/Assign3" + counter + ".txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if (!OrderProductBLL.checkQuantity(Integer.parseInt(cantitateO.getText()), idProduct)) {

					JOptionPane.showMessageDialog(null, "Sorry, we do not have enough products");
					OrderProductBLL.factura(counter, dateC, dateP, cantitateO.getText());

					counter++;

				} else {

					OrderProductBLL.createOrder(idClient, idProduct, Integer.parseInt(cantitateO.getText()));
					writer.println("Nume: " + dateC[0]);
					writer.println("Adresa: " + dateC[1]);
					writer.println("Email: " + dateC[2]);

					writer.println("Produs: " + dateP);
					writer.println("Bucati: " + cantitateO.getText());
					writer.println("De plata: " + price * Integer.parseInt(cantitateO.getText()));
					counter++;
					writer.close();
				}
			}

		});
		btnEnter.setBounds(340, 210, 79, 23);
		panelOrder.add(btnEnter);

		client = new JTextField();
		client.setBounds(104, 187, 55, 20);
		panelOrder.add(client);
		client.setColumns(10);

		product = new JTextField();
		product.setBounds(104, 211, 55, 20);
		panelOrder.add(product);
		product.setColumns(10);

		lblIdClient = new JLabel("ID Client:");
		lblIdClient.setBounds(20, 190, 63, 14);
		panelOrder.add(lblIdClient);

		lblIdProduct = new JLabel("ID Product:");
		lblIdProduct.setBounds(20, 214, 74, 14);
		panelOrder.add(lblIdProduct);

	}
}
