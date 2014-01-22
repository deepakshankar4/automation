
<%@page import="com.tr.model.Inventory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>



<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/ico"
	href="/resources/ecommlogo2.JPG" />

<style type="text/css">
body {
	background-color: #f0f0f2;
	margin: 0;
	padding: 0;
	font-family: "Open Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
	background-image: url("/resources/library-Books.jpg");
}

a:link,a:visited {
	color: #38488f;
	text-decoration: none;
}

.cart {
	background: url("<c:url value="/ resources/ icon_cart.png " />") left
		center no-repeat;
	padding-left: 15px;
}
</style>




<meta charset="ISO-8859-1">
<title>Welcome to eCOMM</title>



</head>
<header>
	<jsp:include page="header.jsp" />
</header>
<body>

	<div>
		<div>

			<%
				@SuppressWarnings("unchecked")
				List<Inventory> books = (List<Inventory>) request
						.getAttribute("books");
				Iterator<Inventory> booksit = books.iterator();
				Inventory lis = null;

				while (booksit.hasNext()) {

					lis = booksit.next();
			%>

			<div>
				<a href="booksdesc/<%=lis.getBookName()%>"><img id="cover_image"
					alt="cover image" height="250px" width="200px"
					src="/CommonProject/DisplayImage?bookName=<%=lis.getBookName()%>"></a>

				<form action="AddToCart" method="post" accept-charset="utf-8">
					<input type="hidden" name="bookname" value=<%=lis.getBookName()%> />
					<input type="hidden" name="bookprice" value=<%=lis.getPrice()%> />
					<input type="hidden" name="bookisbn" value=<%=lis.getIsbn()%> /><input
						type="submit" class="cart" name="add to cart" value="Add to cart"
						style="background-color: orange; font-family: cursive; padding: 4px; border-top-right-radius: 10px 10px; border-bottom-right-radius: 10px 10px; border-top-left-radius: 10px 10px; border-bottom-left-radius: 10px 10px;" />
				</form>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>
<footer>
	<jsp:include page="footer.jsp" />
</footer>
</html>