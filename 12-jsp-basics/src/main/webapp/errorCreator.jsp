<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="errorHandler.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Creator</title>
</head>
<%
String name = "Venky123";
int num = Integer.parseInt(name);
%>
</body>
</html>
<!-- Here we are creating two jsp pages one is errorCreator.jsp and the other is errorHandler the jsp. 
Whenever there is any error in the errorCreator.jsp page we are redirecting it to the errorHandler.jsp to print the stacktrace of 
the exception occured. To transfer the exceptions to errorHandler.jsp page we need to use attribute errorPage and the file name of
of the page that is going to handle the error in our case it is errorHandler.jsp(errorPage="errorHandler.jsp) we need to include
the errorPage attribute in the page directive at the top -->