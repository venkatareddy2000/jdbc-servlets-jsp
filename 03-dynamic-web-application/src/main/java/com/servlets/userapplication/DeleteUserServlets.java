package com.servlets.userapplication;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Servlet implementation class CreateUserServlets
 */
@WebServlet(urlPatterns = "/deleteServlet")
public class DeleteUserServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection connection;
	private Statement statement;
	public void init(ServletConfig config)
	{
		ServletContext Context = config.getServletContext();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =DriverManager.getConnection(Context.getInitParameter("dbUrl"),Context.getInitParameter("dbUser"),
					Context.getInitParameter("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		String email = request.getParameter("email");
		try {
			statement = (Statement) connection.createStatement();
			int result = ((java.sql.Statement) statement).executeUpdate("delete from user where email='"+email+"'");
			PrintWriter out = response.getWriter();
			if(result>0)
			{
				out.println("<h1>User deleted Successfully</h1>");
			}
			else
			{
				out.println("<h1>User is not present in the database</h1>");
			}
		} 
		catch (Exception e) {
			
		}
	}
	
	public void destroy()
	{
		try {
			System.out.println("destroy()");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
