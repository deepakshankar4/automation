<%@page import="java.util.Iterator"%>
<%@page import="com.tr.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add to our repo</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>

<style type="text/css">
table {
	-webkit-box-shadow: #bbb 4px 4px 6px;
	-moz-box-shadow: #bbb 4px 4px 6px;
	border-color: #AAA;
	border-collapse: collapse;
	box-shadow: #bbb 4px 4px 6px;
	font-size: 110%;
	border: window;
	border-style: solid;
}

.simple-input {
	display: block;
	padding: 5px;
	border: 4px solid #F1B720;
	border-radius: 5px;
	color: #333;
	transition: all 0.3s ease-out;
	width: 360px;
}

.simple-input:hover {
	border-radius: 8px;
}

.simple-input:focus {
	outline: none;
	border-radius: 8px;
	border-color: #EBD292;
}
</style>
</head>
<body background="resources/background.jpg">
	<%
		@SuppressWarnings("unchecked")
		List<Category> catlist = (List<Category>) request
				.getAttribute("catlist");
		Iterator<Category> catlistit = catlist.iterator();
		Category cat = null;
	%>



	<form action="ManageInventory" enctype="multipart/form-data"
		method="POST">
		<h1 align="center" style="color: orange;">Add a new item</h1>
		<table cellpadding="100" align="center"
			style="background-color: inactiveborder; border-style: groove;">
			<tr align="center">
				<td align="center"><br> <input type="text" name="bookname"
					class="simple-input" placeholder="Enter Book name"> <br />
					<br> <br> <input type="text" class="simple-input"
					name="authorname" placeholder="Enter Author name"> <br />
					<br> <br> <input type="number" class="simple-input"
					name="isbn" placeholder="Enter ISBN"> <br /> <br> <br>
					<select name="genre">

						<%
							while (catlistit.hasNext()) {

								cat = catlistit.next();
						%>
						<option value="<%=cat.getCategoryName()%>">
							<%=cat.getCategoryName()%>
						</option>



						<%
							}
						%>

				</select> <br /> <br> <br> <input type="number"
					class="simple-input" name="price"
					placeholder="Enter price of this item"> <br /> <br> <textarea
						name="description" class="simple-input" rows="10" cols="50"
						placeholder="please give a brief description of the item being added"></textarea><br>
					<br> <input type="file" name="coverimg" multiple="multiple">
					<br> <br> <input type="submit" value="Submit" /><input
					type="reset" value="Clear" /></td>
			</tr>
		</table>
	</form>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
    </html>