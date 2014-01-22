<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee login</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
</head>
<body background="C:\Users\c167165\Pictures\cloudlight.jpg">
	<h2>
		<marquee behavior="scroll" direction="right" scrollamount="8"
			width="100%" height="100%"
			style="color: #610B38; font-family: fantasy; font-size: 40px; font-stretch: extra-expanded; text-shadow: 5px 5px 5px grey;">
			WELCOME TO EMPLOYEE APPLICATION </marquee>
	</h2>

	<h1 align="center" style="color: #0A122A; font-family: sans-serif;">HELLO
		ADMIN!!!</h1>
	<br />
	<br />
	<br />
	<table align="center">
		<tr align="center">
			<td><h2>PLEASE CHOOSE AN OPTION</h2></td>
		</tr>
		<tr align="center">
			<td><h2>
					<a href="add.html" style="color: blue; text-decoration: none;">ADD
						NEW EMPLOYEE</a>
				</h2></td>
		</tr>
		<tr align="center">
			<td><h2>
					<a href="employees.html"
						style="color: blue; text-decoration: none;">EMPLOYEE LIST</a>
				</h2></td>
		</tr>

	</table>

	<table align="center">
		<tr align="center">
			<td><h2>OPTIONS FOR TICKET</h2></td>
		</tr>
		<tr align="center">
			<td><h2>
					<a href="addticket.html"
						style="color: blue; text-decoration: none;">SERVICE TICKET</a>
				</h2></td>
		</tr>
		<tr align="center">
			<td><h2>
					<a href="tickets.html" style="color: blue; text-decoration: none;">TICKET
						LIST</a>
				</h2></td>
	</table>
	<h1 align="left">
		<b><i> <a href="logout.html"
				style="color: black; font-size: 50px; text-decoration: none;">LOGOUT</a></i></b>
	</h1>
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>