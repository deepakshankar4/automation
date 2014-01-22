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
	<h2>Add Employee Data</h2>
	<form:form method="POST" action="/sdnext/save.html">
		<table>
			<tr>
				<td><form:label path="id">Employee ID:</form:label></td>
				<td><form:input path="id" value="${employee.id}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Employee Name:</form:label></td>
				<td><form:input path="name" value="${employee.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">Employee lastName:</form:label></td>
				<td><form:input path="lastname" value="${employee.lastname}" /></td>
			</tr>
			<tr>
				<td><form:label path="age">Employee Age:</form:label></td>
				<td><form:input path="age" value="${employee.age}" /></td>
			</tr>
			<tr>
				<td><form:label path="salary">Employee Salary:</form:label></td>
				<td><form:input path="salary" value="${employee.salary}" /></td>
			</tr>

			<tr>
				<td><form:label path="address">Employee Address:</form:label></td>
				<td><form:input path="address" value="${employee.address}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty employees}">
		<u><h2 align="center">EMPLOYEE LIST</h2></u>
		<table align="center" border="2">
			<tr>
				<th>Employee ID</th>
				<th>Employee Name</th>
				<th>Employee LastName</th>

				<th>Employee Age</th>
				<th>Employee Salary</th>
				<th>Employee Address</th>

				<th>Actions on Row</th>
			</tr>
			<tr>
				<h2>THE LIST IS:</h2>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td><c:out value="${employee.id}" /></td>
					<td><c:out value="${employee.name}" /></td>
					<td><c:out value="${employee.lastname}" /></td>

					<td><c:out value="${employee.age}" /></td>
					<td><c:out value="${employee.salary}" /></td>
					<td><c:out value="${employee.address}" /></td>


					<td align="center"><a href="edit.html?id=${employee.id}">Edit</a>
						| <a href="delete.html?id=${employee.id}"
						onclick="return confirm('Delete an employee?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="tickets.html">LIST TICKETS</a>
	<br />
	<h2>
		<a href="index.html">HOME PAGE</a>
	</h2>

	<br />
	<!--  <a href="logout.html">LOGOUT</a> -->

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>