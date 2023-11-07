package com.jdbc.advancedJDBC.JDBCTransactionManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManagement {

	public static void main(String[] args) 
	{
		Connection connection=null;
		try 
		{	
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VenkataReddy","root","Venk0907");
			Statement statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.executeUpdate("update account set bal=bal-5000 where accno=1");
			statement.executeUpdate("update account set bal=bal+5000 where accno=2");
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.close();
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}	
	
}
