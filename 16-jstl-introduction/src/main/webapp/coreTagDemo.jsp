<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoreTagDemo</title>
</head>
<body>
	<c:out value="${20+1}" />
	<br>
	<c:set var="testScore" value="${100}" scope="session" />
	<c:out value="${testScore}" />
	<br>
	<c:if test="${testScore==100}">
	Your score is Awesome: <c:out value="${testScore}" />
	</c:if>
	<br>
	<c:choose>
		<c:when test="${testScore==100}">
	      A+ Grade
	    </c:when>
		<c:when test="${testScore<100}">
	      Fail
	    </c:when>
	</c:choose>
	<br>
	<c:forEach var="i" begin="1" end="10">
		<c:out value="${i}" />
		<br>
	</c:forEach>
	<%
	ArrayList<String> names = new ArrayList<String>();
	names.add("Gopi");
	names.add("Reddy");
	names.add("Venkata");
	names.add("Reddy");
	request.setAttribute("name", names);
	%>
	<c:forEach var="Names" items="${name}">
		<c:out value="${Names}" />
		<br>
	</c:forEach>
	<c:set var="accountBalance" value="${123.456}" />
	<fmt:parseNumber var="i" type="number" value="${accountBalance}" />
	<c:out value="${i}" />
	<br> Format Number1:
	<fmt:formatNumber value="${accountBalance}" type="currency" />
	<br> Format Number2:
	<fmt:formatNumber value="${accountBalance}" type="number"
		maxFractionDigits="2" />
	<br> Format Number3:
	<fmt:formatNumber value="${accountBalance}" type="currency"
		maxIntegerDigits="3" />
	<br> Format Number4:
	<fmt:formatNumber value="${accountBalance}" type="percent" />
	<br> Format Number5:
	<fmt:formatNumber value="${accountBalance}" type="number"
		pattern="##.##%" />
	<br>
	<c:set var="date" value="09-20-2023" />
	<fmt:parseDate var="parsedDate" value="${date}" pattern="MM-dd-yyyy" />
	<c:out value="${parsedDate}"/><br>
	<c:remove var="testScore" />
	After testScore removal:
	<c:out value="${testScore}" />
</body>
</html>