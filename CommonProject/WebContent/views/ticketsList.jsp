<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Tickets</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
</head>
<body bgcolor="lightblue">
	<h1>List Tickets</h1>

	<c:if test="${!empty tickets}">
		<table align="center" border="2">
			<tr>
				<th class="title">TICKET ID</th>
				<th class="title">TICKET NAME</th>
				<th class="title">STATUS</th>

				<th class="title">EMPLOYEE ID</th>
			</tr>

			<c:forEach items="${tickets}" var="ticket">
				<tr>
					<td><c:out value="${ticket.ticketid}" /></td>
					<td><c:out value="${ticket.ticketname}" /></td>
					<td><c:out value="${ticket.service}" /></td>
					<td><c:out value="${ticket.tempID}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />
	<br />
	<br />
	<h2>
		<a href="index.html">HOME PAGE</a>
	</h2>
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>