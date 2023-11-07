package com.jdbc.basics;

import java.sql.*;

public class AccountDAO {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/VenkataReddy";
		String uname = "root";
		String password = "Venk0907";

		/* Creates a connection to the database */
		Connection connection = DriverManager.getConnection(url, uname, password);
		Statement statement = connection.createStatement();

		/* The below two lines of code help us to insert the data into the table */

		/*
		 * int result = statement.
		 * executeUpdate("insert into account values(4,'Gopi','Reddy',1000000)");
		 * System.out.println(result + " Row got inserted into table account");
		 */

		/* Updating the balance in account table */

		/*
		 * int executeUpdate =
		 * statement.executeUpdate("update account set accno=1 where accno= 2");
		 * System.out.println(executeUpdate + " rows got updated in account table");
		 */

		/* Deleting a particular row from a table using delete query */

		/*
		 * int executeUpdate =
		 * statement.executeUpdate("delete from account where accno= 1");
		 * System.out.println(executeUpdate+" rows got deleted in account table");
		 */

		ResultSet resultSet = statement.executeQuery("select * from account");
		while (resultSet.next()) {
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getInt(4));
		}
		resultSet.close();
		statement.close();
		connection.close();
	}

}
