package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import connection.ConnectionFactory;



public class OrderProductDAO {

	
	final static String createOrder = "call orderP(?,?,?);";
	final static String stockOrder = "SELECT quantity FROM Product WHERE ID = ?";
	final static String printStatementString = "SELECT * FROM OrderProduct";

	public static int getQuantity(int id) {
		int toReturn = 0;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(stockOrder);
			findStatement.setInt(1, id);
			rs = findStatement.executeQuery();
			rs.next();
			toReturn = rs.getInt("quantity");
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toReturn;
	}

	public static void createOrder(int id_client, int id_product, int quantity) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = (PreparedStatement) dbConnection.prepareStatement(createOrder);
			findStatement.setInt(1, id_client);
			findStatement.setInt(2, id_product);
			findStatement.setInt(3, quantity);
			findStatement.executeUpdate();

			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
