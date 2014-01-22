<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WELCOME TO SECURE AREA</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
</head>
<body text="green" bgcolor="#F2F5A9">
	<h1>Message : ${message}</h1>
	<h1>Author : ${author}</h1>
	<table align="center">
		<!--  <tr align="center">
			<td><h3>
					<a href='<c:url value="index.html" />'
						style="color: grey; text-decoration: none; font-size: 30px;">Admin
						options</a>
				</h3></td>
		</tr>
		<tr align="center">
			<td><h3>
					<a href='<c:url value="ticketuser.html" /> '
						style="color: grey; text-decoration: none; font-size: 30px;">User
						options</a>
				</h3></td>
		</tr> -->
		<tr align="center">
			<td><h2>
					<a href='<c:url value="/j_spring_security_logout" />'> Logout</a>
				</h2></td>
		</tr>
	</table>
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
