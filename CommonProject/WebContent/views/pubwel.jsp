<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
<meta charset="ISO-8859-1">
<%
	if (session.getAttribute("publisher") == null) {
		session.setAttribute("publisher", "guest");

	}

	String name = (String) session.getAttribute("publisher");
%>
<title>welcome <%=name%></title>
<!-- CSS styles for standard search box -->
<style type="text/css">
#tfheader {
	background-color: #c3dfef;
}

#tfnewsearch {
	float: right;
	padding: 20px;
}

.tftextinput {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	border: 1px solid #0076a3;
	border-right: 0px;
	border-top-left-radius: 5px 5px;
	border-bottom-left-radius: 5px 5px;
}

.tfbutton {
	margin: 0;
	padding: 5px 15px;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 14px;
	outline: none;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	color: #ffff;
	border: solid 1px #0076a3;
	border-right: 0px;
	background: orange;
	border-top-right-radius: 5px 5px;
	border-bottom-right-radius: 5px 5px;
}

.tfbutton:hover {
	text-decoration: none;
	background: threedlightshadow;
}
/* Fixes submit button height problem in Firefox */
.tfbutton::-moz-focus-inner {
	border: 0;
}

.tfclear {
	clear: both;
}
</style>
</head>
<body bgcolor="beige" background="resources/ecommbackgrnd.jpg">



	<!-- HTML for SEARCH BAR -->




	<a href="index"> <img alt="ecomm Home"
		src="resources/ecommlogo.JPG" style="float: left;" height="100"
		width="150">
	</a>

	<%
		if (session.getAttribute("publisher") == "guest"
				|| session.getAttribute("publisher") == null) {
	%>

	<div align="right" style="float: right;">
		<font color="sky blue"> Welcome <%=name%></font> | <a href="login"
			style="color: white;">Login</a> | <a href="pubregister"
			style="color: white;"> Register as a new publisher</a> | <a
			href="publisherlogin" style="color: white;"> publisher login</a>
		<form id="tfnewsearch" method="get" action="Search">
			<input type="text" class="tftextinput" name="q" size="21"
				maxlength="120"><input type="submit" value="search"
				class="tfbutton">
		</form>
	</div>






	<%
		} else if (session.getAttribute("publisher") != null
				&& name != "guest") {
	%>


	<div align="right" style="float: right; color: gray;">

		<font color="sky blue"> Welcome publisher <a href="pubwel"
			style="color: white;"> <%=name%></a></font> | <a href="PubLogout"
			style="color: white;">Logout</a>

		<form id="tfnewsearch" method="get" action="Search">
			<input type="text" class="tftextinput" name="q" size="21"
				maxlength="120"><input type="submit" value="search"
				class="tfbutton">
		</form>
	</div>

	<%
		}
	%>

	<div align="center" style="azimuth: center-left; display: block;">
		<p>

			<a href="inventory"> Add your product</a>

		</p>

		<p>

			<a href="category"> Add new genre</a>
		</p>



		<p>

			<a href=""> See your products</a>
		</p>
	</div>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>