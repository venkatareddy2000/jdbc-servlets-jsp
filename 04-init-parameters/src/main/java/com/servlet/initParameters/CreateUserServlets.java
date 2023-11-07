package com.servlet.initParameters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlets
 */
/* creating the init params using the @WebInitParam annotation */
@WebServlet(urlPatterns = "/addServlet", initParams = {
		@WebInitParam(name = "dbUrl", value = "jdbc:mysql://localhost:3306/VenkataReddy"),
		@WebInitParam(name = "dbUser", value = "root"), @WebInitParam(name = "password", value = "Venk0907") })
public class CreateUserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;

	public void init(ServletConfig config) {
		try {
			/* Retrieving the Init params using the getInitParameter method */
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost()");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			statement = (Statement) connection.createStatement();
			int result = ((java.sql.Statement) statement).executeUpdate("insert into user values('" + firstName + "','"
					+ lastName + "','" + email + "','" + password + "')");
			PrintWriter out = response.getWriter();
			if (result > 0) {
				out.println("<h1>User Added Successfully</h1>");
			} else {
				out.println("<h1>error in user creation</h1>");
			}
		} catch (Exception e) {

		}
	}

	public void destroy() {
		try {
			System.out.println("destroy()");
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
