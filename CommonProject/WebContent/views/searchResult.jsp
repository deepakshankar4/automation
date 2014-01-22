<%@page import="org.springframework.ui.Model"%>
<%@page import="com.tr.model.Inventory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search page</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
<style type="text/css">
.CSSTableGenerator {
	margin: 0px;
	padding: 0px;
	width: 100%;
	box-shadow: 10px 10px 5px #888888;
	border: 1px solid #aa2c2c;
	-moz-border-radius-bottomleft: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-bottom-left-radius: 0px;
	-moz-border-radius-bottomright: 0px;
	-webkit-border-bottom-right-radius: 0px;
	border-bottom-right-radius: 0px;
	-moz-border-radius-topright: 0px;
	-webkit-border-top-right-radius: 0px;
	border-top-right-radius: 0px;
	-moz-border-radius-topleft: 0px;
	-webkit-border-top-left-radius: 0px;
	border-top-left-radius: 0px;
}

.CSSTableGenerator table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
}

.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright: 0px;
	-webkit-border-bottom-right-radius: 0px;
	border-bottom-right-radius: 0px;
}

.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft: 0px;
	-webkit-border-top-left-radius: 0px;
	border-top-left-radius: 0px;
}

.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright: 0px;
	-webkit-border-top-right-radius: 0px;
	border-top-right-radius: 0px;
}

.CSSTableGenerator tr:last-child td:first-child {
	-moz-border-radius-bottomleft: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-bottom-left-radius: 0px;
}

.CSSTableGenerator tr:hover td {
	
}

.CSSTableGenerator tr:nth-child(odd) {
	background-color: #fffffe;
}

.CSSTableGenerator tr:nth-child(even) {
	background-color: #ffffff;
}

.CSSTableGenerator td {
	vertical-align: middle;
	border: 1px solid #aa2c2c;
	border-width: 0px 1px 1px 0px;
	text-align: center;
	padding: 7px;
	font-size: 18px;
	font-family: Trebuchet MS;
	font-weight: normal;
	color: #edd417;
}

.CSSTableGenerator tr:last-child td {
	border-width: 0px 1px 0px 0px;
}

.CSSTableGenerator tr td:last-child {
	border-width: 0px 0px 1px 0px;
}

.CSSTableGenerator tr:last-child td:last-child {
	border-width: 0px 0px 0px 0px;
}

.CSSTableGenerator tr:first-child td {
	background: -o-linear-gradient(bottom, #9b6c41 5%, #bf5f00 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #9b6c41
		), color-stop(1, #bf5f00));
	background: -moz-linear-gradient(center top, #9b6c41 5%, #bf5f00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#9b6c41",
		endColorstr="#bf5f00");
	background: -o-linear-gradient(top, #9b6c41, bf5f00);
	background-color: #9b6c41;
	border: 0px solid #aa2c2c;
	text-align: center;
	border-width: 0px 0px 1px 1px;
	font-size: 21px;
	font-family: Comic Sans MS;
	font-weight: bold;
	color: #ffff00;
}

.CSSTableGenerator tr:first-child:hover td {
	background: -o-linear-gradient(bottom, #9b6c41 5%, #bf5f00 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #9b6c41
		), color-stop(1, #bf5f00));
	background: -moz-linear-gradient(center top, #9b6c41 5%, #bf5f00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#9b6c41",
		endColorstr="#bf5f00");
	background: -o-linear-gradient(top, #9b6c41, bf5f00);
	background-color: #9b6c41;
}

.CSSTableGenerator tr:first-child td:first-child {
	border-width: 0px 0px 1px 0px;
}

.CSSTableGenerator tr:first-child td:last-child {
	border-width: 0px 0px 1px 1px;
}
</style>

</head>
<body>

	<%
		@SuppressWarnings("unchecked")
		List<Inventory> searchList = (List<Inventory>) request
				.getAttribute("result");
	%>

	<h1 align="center"
		style="font-family: cursive; font: sans-serif; color: gray;">
		Your search fetched
		<%=searchList.size()%>
		results
	</h1>
	<table class="CSSTableGenerator" cellpadding="20" border="5"
		align="left" style="padding: 10px; speak: normal;"
		title="complete details of the item">
		<tr align="left">


		</tr>
		<tr align="left">
			<%
				//String bookName = "HELLO ANDROID";

				for (Inventory book : searchList) {

					//bookName = book.getBookName();
			%>


			<td bordercolor="#000000"><a
				href="booksdesc/<%=book.getBookName()%>"><img id="cover_image"
					alt="cover image" height="250px" width="200px"
					src="/CommonProject/DisplayImage?bookName=<%=book.getBookName()%>"></a></td>



			<%
				}
			%>
		</tr>




	</table>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>