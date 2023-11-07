package com.jdbc.advancedJDBC.JDBCBatching;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VenkataReddy", "root",
				"Venk0907"); Statement statement = connection.createStatement();) {
			/* To insert multiple data into dataBase at a time we use addBatch method */
			statement.addBatch("insert into account values(1,'Venkata','Reddy',10000)");
			statement.addBatch("insert into account values(2,'Gopi','Reddy',10000)");
			/* calling the executeBatch method to insert the rows into the table */
			int[] executeBatch = statement.executeBatch();
			for (int i = 0; i < executeBatch.length; i++) {
				System.out.println(executeBatch[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
