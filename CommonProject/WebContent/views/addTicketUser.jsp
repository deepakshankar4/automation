<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
</head>
<body bgcolor="lightblue">
	<h2>ENTER TICKET INFORMATION</h2>
	<form:form method="POST" action="/sdnext/saveticketuser.html">
		<table>
			<tr>
				<td><form:label path="tempID">EMPLOYEE ID:</form:label></td>
				<td><form:input path="tempID" value="${ticket.tempID}" /></td>
			</tr>
			<tr>
				<td><form:label path="ticketid">TICKET ID:</form:label></td>
				<td><form:input path="ticketid" value="${ticket.ticketid}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="ticketname">REQUEST FOR RESOURCE:</form:label></td>
				<td><form:select path="ticketname">
						<form:option value="printer">Printer</form:option>
						<form:option value="hardware">Hardware</form:option>
					    <form:option value="software installation">Software installation</form:option>
						
					</form:select></td>
				<!--  <td><form:input path="ticketname" value="${ticket.ticketname}" /></td> -->
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<h2>
		<a href="logout.html">LOGOUT</a>
	</h2>
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>