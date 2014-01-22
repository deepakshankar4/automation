<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>
	<a href="ecomm_index"> <img alt="ecomm Home"
		src="resources/ecommlogo.JPG" style="float: left;" height="100"
		width="150">
	</a>

	<%
		//HttpSession mysession;
		if ((session = request.getSession(false)) != null
				&& session.getAttribute("user") == null) {
			//session.invalidate();
	%>

	<div align="right" style="float: right;">

		<form id="search" method="get" action="Search">


			<input type="text" size="120" autocomplete="on"
				style="font-family: cursive; padding: 4px;" name="q"
				placeholder="Search" x-webkit-speech> <font color="sky blue">
				Welcome guest</font> | <a href="ecomm_usr_login" style="color: white;">Login</a>
			| <a href="register" style="color: white;"> Register as a new
				user</a> | <a href="publisherlogin" style="color: white;"> Publisher
				login</a> | <a href="pubregister" style="color: white;"> Register as
				a publisher</a>
		</form>

	</div>






	<%
		}

		else if ((session = request.getSession(false)) != null
				&& session.getAttribute("user") != null) {
	%>


	<div align="right" style="float: right; color: gray;">
		<form id="search" method="get" action="Search">
			<input type="text" size="120" autocomplete="on"
				style="font-family: cursive; padding: 4px;" name="q"
				placeholder="Search" x-webkit-speech><font color="sky blue">
				Welcome </font><a href="ecomm_welcome" style="color: white;"><img
				width="50" height="50" style="position: relative; float: right;"
				alt="profile pic" src="ProfilePic"> <%
 	String name = (String) session.getAttribute("user");
 		String referrer = (String) session.getAttribute("referrer");
 %> <%=name%> </a>
			<%
				// 			System.out.println(session.getAttribute("user"));
					if (referrer != null) {
			%>
			referred by
			<%=referrer%>
			<%
				}
			%>| <a href="Logout" style="color: white;">Logout</a>


		</form>
	</div>

	<%
		}
	%>





	<br>
	<br>
	<br>
	<div style="float: right;" align="right">
		<form action="ViewCart" method="post" accept-charset="utf-8">
			<input type="image" src="resources/cart-icon.png" alt="Submit"
				width="48" height="48">

		</form>
	</div>
	<br>
	<br>
	<br>
	<div>

</body>

</html>