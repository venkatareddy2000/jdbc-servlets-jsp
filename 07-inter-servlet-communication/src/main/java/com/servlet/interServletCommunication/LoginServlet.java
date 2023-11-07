package com.servlet.interServletCommunication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Statement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;
	Statement statement;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Starting init first");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VenkataReddy", "root", "Venk0907");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			((Connection) statement).close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Retrieving the email and password sent by the client */
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {
			/* Checking whether email and password is present in the database */
			ResultSet executeQuery = statement
					.executeQuery("select * from user where email = '" + email + "' and password = '" + password + "'");
			/*
			 * If the email and password is present in the database we are forwarding the
			 * request to the homeServlet
			 */
			if (executeQuery.next()) {
				/*
				 * We need to pass the uri of the servlet to which we want to forward the
				 * request
				 */
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("homeServlet");
				/*
				 * setAttribute takes two parameters and and value, where we can call these name
				 * and value in another servlet using the getAtribute method
				 */
				request.setAttribute("message", "Login successfull" + email);
				/*
				 * We are forwarding the request along with request and response object as a
				 * parameter, because we are trying to invoke the service method of another
				 * servlet.
				 * 
				 * When we forward the request to another servlet, the servlet will generate the
				 * response and will send the response back directly to the client
				 */
				requestDispatcher.forward(request, response);
			} else {
				/*
				 * If email and password is not present in the database, we are showing the same
				 * login page to the html
				 */
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.html");
				/*
				 * Below there is no use of passing the request and response parameters, but if
				 * we don't it will throw an error.
				 * 
				 * When we call the include method the response of the another servlet will be
				 * included in the calling servelt and the calling servlet mergers both the
				 * responses and will send back to the client
				 */
				requestDispatcher.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
