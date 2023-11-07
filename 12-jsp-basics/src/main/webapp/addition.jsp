<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorHadler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition of two numbers</title>
</head>
<body>
	<!-- Declaration Tags: Declaration tags are used to declare variables and methods that can be used throughout the JSP page. 
	They are enclosed within <%! %> tags. -->

	<%!int number1;
	int number2;%>
	<!-- Scriptlet Tags: Scriptlet tags are used to embed Java code within JSP pages. They are enclosed within <% %> tags. -->
	<%
	number1 = Integer.parseInt(request.getParameter("number1"));
	number2 = Integer.parseInt(request.getParameter("number2"));
	%>
	<!-- Below we have used expression tags to calculate the sum of two numbers -->
	<h1>Sum of <%=number1%> and <%=number2 %> is : <%=number1+number2 %></h1>
</body>
</html>