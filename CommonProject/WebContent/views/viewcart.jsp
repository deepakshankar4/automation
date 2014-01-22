<%@page import="com.tr.model.Inventory"%>

<%@page import="org.hibernate.Hibernate"%>
<%@page import="com.tr.model.Cart"%>
<%@ page import="org.hibernate.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html >
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css" />
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Cart</title>
</head>
<body>

	<header>
		<jsp:include page="header.jsp" />
	</header>

	<div data-role="page" id="page-1" data-theme="d">
		<div data-role="header" data-theme="d">
			<a href="#" data-role="button" data-rel="back" data-icon="back"
				data-iconpos="notext">Back</a>
			<h1 style="">Your Cart</h1>
		</div>
		<div align="center" data-role="content">
			<%
				@SuppressWarnings("unchecked")
				List<Cart> lis = (List<Cart>) request.getAttribute("cartitems");
				Iterator<Cart> it = lis.iterator();
				Cart cart = null;
				@SuppressWarnings("unchecked")
				List<Inventory> books = (List<Inventory>) request
						.getAttribute("book");
				Iterator<Inventory> bit = null;
				Inventory bookinv = null;
				if (books != null) {
					bit = books.iterator();

				}
			%>
			<%
				if (bit != null) {
					if (bit.hasNext()) {

						bookinv = bit.next();
			%>
			<fieldset data-role="collapsible" id="collapsible-1"
				data-collapsed-icon="alert" data-expanded-icon="alert"
				data-iconpos="left" data-theme="e" data-content-theme="e">
				<legend>New book added to your cart!!!</legend>
				<p>
					<a href="booksdesc/<%=bookinv.getBookName()%>"><%=bookinv.getBookName()%></a>
				</p>
				<p><%=bookinv.getPrice()%>
			</fieldset>
			<%
				}
				}
			%>
			<br> <br>
			<table style="padding: 20pt;" data-role="table" id="table-1"
				class="ui-body-a ui-responsive table-stripe">
				<thead>
					<tr class="ui-bar-a">
						<th>Item Name</th>
						<th data-priority="1">Quantity</th>
						<th data-priority="2">Price(Rs)</th>
					</tr>
				</thead>
				<tbody>
					<%
						while (it.hasNext()) {

							cart = it.next();
					%>

					<tr>
						<td><a href="booksdesc/<%=cart.getInven().getBookName()%>"><img
								id="cover_image" alt="cover image" height="50px" width="40px"
								src="/CommonProject/DisplayImage?bookName=<%=cart.getInven().getBookName()%>"
								style="width: 77px; height: 82px;"> </a></td>
						<td><%=cart.getQty()%></td>
						<td><%=cart.getInven().getPrice() * cart.getQty()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
		<div align="center" data-role="content">
			<form name="placeorder" id="form-1" action="order" method="post">
				<a href="placeorder" id="button-1" data-rel="popup"
					data-role="button" data-inline="true" data-corners="false"
					data-theme="a">Check Out</a>

			</form>
		</div>
	</div>


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
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>