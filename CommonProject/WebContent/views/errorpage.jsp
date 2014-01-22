<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error page</title>
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

div {
	width: 600px;
	margin: 5em auto;
	padding: 50px;
	background-color: #fff;
	border-radius: 1em;
}

a:link,a:visited {
	color: #38488f;
	text-decoration: none;
}
</style>
</head>

<body bgcolor="gray">

	<input type="hidden" name="errorStatus" value="">
	<%
		Integer err = (Integer) request.getAttribute("errorStatus");
	%>

	<%
		switch (err) {
		case 1:
	%>
	<div align="center" style="">

		<p>
		<h1>Wrong User Name or Password!!!</h1>

		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" />
				Go to home </a>
		<p>
		<p>
			<a href="login">try again </a>
		<p>
	</div>

	<%
		break;
		case 2:
	%>
	<div align="center" style="">

		<p>
		<h1>Publisher does not exist!!!</h1>
		<p> make sure you entered your publisher name and password properly

		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" />
				Go to home </a>
		<p>
		<p>
			<a href="publisherlogin">try again </a>
		<p>
	</div>
	
	<%
		break;
		case 3:
	%>
	
	<div align="center" style="">

		<p>
		<h1>Improper data</h1>
		<p> you are seeing this page because, the data you entered is clashing with another user's data!!!
		

		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" />
				Go to home </a>
		<p>
		<p>
			<a href="register">try again </a>
		<p>
	</div>
	<%
		break;
		case 4:
	%>
	
	
	<div align="center" style="">

		<p>
		<h1>Improper data</h1>
		<p> you are seeing this page because, the data you entered is clashing with another publisher's data!!!
		

		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" />
				Go to home </a>
		<p>
		<p>
			<a href="pubregister">try again </a>
		<p>
	</div>
	
	<%
		break;
		case 5:
	%>
	
	<div align="center" style="">

		<p>
		<h1>Oops!!!</h1>
		<h2> Broken cart!!!!</h2>
		<p> We are working on it!!! meanwhile, you can go back and try again!!! 
		

		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" />
				Go to home </a>
		<p>
		
	</div>
	
	<%
		break;
		case 6:
	%>
	
	<div align="center" style="">

		<p>
		<h1>Oops!!!</h1>
		<h2> Something went wrong!!!</h2>
		<p> we are putting the wires back together!!!  
		

		<p>
			<a href="index"><img alt="home" src="resources/icon_home.gif" />
				Go to home </a>
		<p>
		
	</div>
	

	<%
		}
	%>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>