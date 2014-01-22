<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
</head>
<body bgcolor="lightblue">
	<h1>List Employees</h1>
	<h3>
		<a href="add.html">ADD MORE EMPLOYEES</a>
	</h3>

	<c:if test="${!empty employees}">
		<table align="center" border="2">
			<tr>
				<th class="title">Employee ID</th>
				<th class="title">Employee FirstName</th>
				<th class="title">Employee LastName</th>
				<th class="title">Employee Age</th>
				<th class="title">Employee Salary</th>
				<th class="title">Employee Address</th>


			</tr>

			<c:forEach items="${employees}" var="employee">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.lastname}" /></td>

					<td><c:out value="${employee.age}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.address}" /></td>


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