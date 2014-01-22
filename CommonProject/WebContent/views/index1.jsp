<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="style/css" href="css/style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<h2 align="center">
	<header> <jsp:include page="header.jsp" /> </header>

	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.10.1.min.js"></script>


	<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
	<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
	<script>
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
</head>
<body bgcolor="#0A0A2A" style="color: 'white';">
	<!--  background="<c:url value='/neha/WebContent/images/cloudlight.jpg' />"> -->
	<!--  background="<c:url value='C:\Users\c167165\Pictures\cloudlight.jpg' />"> -->
	<!--  <div align="right">
		${message} <br> <br> -->
	<div id="result"></div>
	<br>
	<!--  </div> -->
	<table align="center">
		<tr>
			<td><h1>EMPLOYEE APPLICATION-</h1></td>
		</tr>
		<tr>
			<td align="center"><h2>
					<a href="login.html"
						style="color: yellow; text-decoration: none; font-family: fantasy;">HOME
						PAGE</a>
				</h2></td>
		</tr>
	</table>
	<p>
		Date: <input type="text" id="datepicker">
	</p>

</body>
<br>
<br>
<br>
<br>
<br>
</body>
</br>
</br>
</br>
</br>
</br>
</br>
<footer> <jsp:include page="footer.jsp" /> </footer>
</html>