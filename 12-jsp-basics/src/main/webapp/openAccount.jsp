<%@ page import="java.sql.*" language="java"
				contentType="text/html; charset=ISO-8859-1"
				pageEncoding="ISO-8859-1"%>
<%!Connection connection;
	PreparedStatement statement;

	public void jspInit() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/VenkataReddy", "root", "Venk0907");
			statement = connection.prepareStatement("insert into account values(?,?,?,?)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void jspDestroy() {
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}%>

<%
int accno = Integer.parseInt(request.getParameter("accno"));
String lastname = request.getParameter("lastname");
String firstname = request.getParameter("firstname");
int bal = Integer.parseInt(request.getParameter("bal"));

statement.setInt(1, accno);
statement.setString(2, lastname);
statement.setString(3, firstname);
statement.setInt(4, bal);

int result = statement.executeUpdate();
%>
<h1>The balance is : <%=bal%></h1>

<%@ include file = "openAccount.html" %>