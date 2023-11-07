package com.jdbc.advancedJDBC.JDBCMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MetaDataDAO {

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VenkataReddy", "root",
				"Venk0907"); Statement statement = connection.createStatement();) {
			ResultSet executeQuery = statement.executeQuery("select * from account");
			ResultSetMetaData metaData = executeQuery.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(metaData.getColumnName(i));
				System.out.println(metaData.getColumnTypeName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
