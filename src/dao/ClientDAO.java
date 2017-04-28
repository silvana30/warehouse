package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;

public class ClientDAO {

	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private final static String printStatementString = "SELECT * FROM client";
	private final static String findStatementString = "SELECT * FROM client where ID = ?";
	private static final String insertStatementString = "INSERT INTO client (name,address,email) VALUES (?,?,?)";
	private final static String deleteStatementString = "DELETE FROM client WHERE ID = ?";
	private final static String updateStatementString = "UPDATE client SET name = ?,address = ?, email = ? WHERE ID = ? ";
	private final static String deleteFromOrder = "DELETE FROM OrderProduct WHERE IDc = ?";

	public static Client findById(int Id) {
		Client toReturn = null;

		Connection Connection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = Connection.prepareStatement(findStatementString);
			findStatement.setLong(1, Id);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			toReturn = new Client(Id, name, address, email);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(Connection);
		}
		return toReturn;
	}

	public static int insert(Client client) {
		Connection Connection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = Connection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, client.getName());
			insertStatement.setString(2, client.getAddress());
			insertStatement.setString(3, client.getEmail());

			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(Connection);
		}
		return insertedId;
	}

	public static void update(Client client, int id) {

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(updateStatementString);
			findStatement.setString(1, client.getName());
			findStatement.setString(2, client.getAddress());
			findStatement.setString(3, client.getEmail());
			findStatement.setInt(4, id);
			findStatement.executeUpdate();

			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		PreparedStatement statement_delete = null;

		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(deleteStatementString);
			statement_delete = (PreparedStatement) dbConnection.prepareStatement(deleteFromOrder);//comanda sql de stergere
			findStatement.setInt(1, id);
			statement_delete.setInt(1, id);
			statement_delete.executeUpdate();
			findStatement.executeUpdate();

			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(statement_delete);
			ConnectionFactory.close(dbConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<Client> getClients() {
		ArrayList<Client> list = new ArrayList<Client>();
		Client temp;
		Connection dbConnection = ConnectionFactory.getConnection();///conexiunea
		Statement findStatement = null;//initializare
		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(printStatementString);//codul SQL
			rs = findStatement.executeQuery(printStatementString);//executa comanda sql
			while (rs.next()) {
				temp = new Client();
				temp.setID(rs.getInt("ID"));
				temp.setName(rs.getString("name"));
				temp.setAddress(rs.getString("address"));
				temp.setEmail(rs.getString("email"));
				list.add(temp);
			}
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
