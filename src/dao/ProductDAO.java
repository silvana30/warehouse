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
import model.Product;

public class ProductDAO {

	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product(name,quantity,price) VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM product where ID = ?";

	private final static String deleteStatementString = "DELETE FROM product WHERE ID = ?";
	private final static String deleteFromOrder = "DELETE FROM OrderProduct WHERE IDp = ?";
	private final static String updateStatementString = "UPDATE product SET name = ?,quantity= ?, price = ? WHERE ID = ? ";
	private final static String printStatementString = "SELECT * FROM product";

	public static Product findById(int Id) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, Id);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			int quantity = rs.getInt("quantity");
			double price = rs.getDouble("price");

			toReturn = new Product(Id, name, quantity, price);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public static int insert(Product product) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, product.getName());
			insertStatement.setInt(2, product.getQuantity());
			insertStatement.setDouble(3, product.getPrice());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}

	public static void update(Product product, int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(updateStatementString);
			findStatement.setString(1, product.getName());
			findStatement.setInt(2, product.getQuantity());
			findStatement.setDouble(3, product.getPrice());
			findStatement.setInt(4, id);
			findStatement.executeUpdate();

			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		Product temp;
		Connection dbConnection = ConnectionFactory.getConnection();
		Statement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(printStatementString);
			rs = findStatement.executeQuery(printStatementString);
			while (rs.next()) {
				temp = new Product();
				temp.setID(rs.getInt("ID"));
				temp.setName(rs.getString("name"));
				temp.setQuantity(rs.getInt("quantity"));
				temp.setPrice(rs.getFloat("price"));

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

	public static void delete(int id) {

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		PreparedStatement statement_delete = null;
		ResultSet rs = null;
		try {
			statement_delete = (PreparedStatement) dbConnection.prepareStatement(deleteFromOrder);
			findStatement = (PreparedStatement) dbConnection.prepareStatement(deleteStatementString);
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
}
