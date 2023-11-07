<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="True"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Sorry, some error occured</h1>
	<%=exception.getMessage()%>
</body>
</html>
<!-- To make a jsp file to handle errors, we need use the attribute isErrorPage and set the value as true (isErrorPage="True") -->