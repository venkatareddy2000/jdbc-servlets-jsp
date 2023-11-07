package com.servlet.initParameters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlets
 */

public class ReadUserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;

	public void init(ServletConfig config) {
		/* Retrieving the Init-params configured in the web.xml file */
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(config.getInitParameter("dbUrl"),
					config.getInitParameter("dbUser"), config.getInitParameter("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * Here we are using doGet method because we are trying to get the information
	 * from server
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet()");
		try {
			statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>");
			out.println("FirstName");
			out.println("</th>");
			out.println("<th>");
			out.println("Secondname");
			out.println("</th>");
			out.println("<th>");
			out.println("Email");
			out.println("</th>");
			out.println("<tr>");
			while (result.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.print(result.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.print(result.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.print(result.getString(3));
				out.println("</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		} catch (Exception e) {

		}
	}

	public void destroy() {
		try {
			System.out.println("destroy()");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
