<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>welcome</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
<style type="text/css">
body {
	background-color: #f0f0f2;
	margin: 0;
	padding: 0;
	font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
}



a:link,a:visited {
	color: #38488f;
	text-decoration: none;
}
</style>
</head>
<body bgcolor="beige" background="resources/ecommbackgrnd.jpg">
	<%
		if (!(session.getAttribute("user") == "guest" || session
				.getAttribute("user") == null)) {
	%>
	<a href="index.jsp"> <img alt="ecomm Home"
		src="resources/ecommlogo.JPG" height="100" width="150">
	</a>
	<div align="right">
		<%
			String name = (String) session.getAttribute("user");
		%>

		<p>
			Hello
			<%=name%>
			| <a href="manacc">Manage account</a> | <a href="index">Home page
			</a> | <a href="history">View your history</a> |
		<form action="Logout" method="GET">
			<input type="submit" value="Logout" />
		</form>



	</div>
	<%
		} else {
	%>
	<div align="center"
		style="width: 600px; margin: 5em auto; padding: 50px; background-color: #fff; border-radius: 1em;">
		<p>
		<h1>You do not have proper permissions to view this page!!!</h1>
		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" /> Go to home </a>


			<%
				}
			%>
		
	</div>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>