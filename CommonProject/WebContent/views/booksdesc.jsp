
<%@page import="java.util.List"%>
<%@page import="com.tr.model.CommentBox"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html >

<html>
<head>


<title>${bookName}</title>



<style type="text/css">
.button_example {
	border: 10px solid #ffad41;
	-webkit-box-shadow: #B4B5B5 12px 12px 12px;
	-moz-box-shadow: #B4B5B5 12px 12px 12px;
	box-shadow: #B4B5B5 12px 12px 12px;
	-webkit-border-radius: 50px;
	-moz-border-radius: 50px;
	border-radius: 50px;
	font-size: 8px;
	font-family: comic sans, comic sans ms, cursive, verdana, arial,
		sans-serif;
	padding: 7px 7px 7px 7px;
	text-decoration: none;
	display: inline-block;
	text-shadow: 0px 0px 0 rgba(0, 0, 0, 0.3);
	font-weight: bold;
	color: #FFFFFF;
	background-color: #ffc579;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ffc579),
		to(#fb9d23));
	background-image: -webkit-linear-gradient(top, #ffc579, #fb9d23);
	background-image: -moz-linear-gradient(top, #ffc579, #fb9d23);
	background-image: -ms-linear-gradient(top, #ffc579, #fb9d23);
	background-image: -o-linear-gradient(top, #ffc579, #fb9d23);
	background-image: linear-gradient(to bottom, #ffc579, #fb9d23);
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,
		startColorstr=#ffc579, endColorstr=#fb9d23);
}

.button_example:hover {
	border: 10px solid #D6921C;
	background-color: #ffaf46;
	background-image: -webkit-gradient(linear, left top, left bottom, from(#ffaf46),
		to(#e78404));
	background-image: -webkit-linear-gradient(top, #ffaf46, #e78404);
	background-image: -moz-linear-gradient(top, #ffaf46, #e78404);
	background-image: -ms-linear-gradient(top, #ffaf46, #e78404);
	background-image: -o-linear-gradient(top, #ffaf46, #e78404);
	background-image: linear-gradient(to bottom, #ffaf46, #e78404);
	filter: progid:DXImageTransform.Microsoft.gradient(GradientType=0,
		startColorstr=#ffaf46, endColorstr=#e78404);
}
</style>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>

	<h1 align="center">Complete details of the item</h1>

	<a href="/CommonProject/DisplayImage?bookName=${bookName}"> <img
		id="cover_image" alt="cover image" height="350px" width="350px"
		style="float: left;"
		src="/CommonProject/DisplayImage?bookName=${bookName}">
	</a>





	<div>
		<h3>
			Book Name : ${bookName} <br>Author : ${bookAuthor}<br>
			Publisher : ${bookPub}<br> ISBN: ${bookISBN}<br>
			Description : ${bookDesc}<br>GENRE : ${bookGenre} <br>PRICE
			: ${bookPrice}
		</h3>
	</div>






	<br>







	<br>
	<br>
	<br>
	<br>



	<br>
	<br>
	<br>

	<br>
	<br>
	<div align="left">
		<form action="/CommonProject/AddToCart" method="post"
			accept-charset="utf-8">
			<input type="hidden" name="bookname" value=${bookName } /> <input
				type="hidden" name="bookprice" value=${bookPrice } /> <input
				type="hidden" name="bookisbn" value=${bookISBN } /><input
				type="submit" name="add to cart" class="button_example"
				value="Add to cart" />
		</form>

	</div>
	<br>
	<br>
	<br>
	<br>

	<div align="center">

		<%
			if (request.getAttribute("user_comments") != null) {
				@SuppressWarnings("unchecked")
				List<CommentBox> usrcomments = (List<CommentBox>) request
						.getAttribute("user_comments");
		%>

		<div align="left">
			<script type="text/javascript">
				(function(d, t, e, m) {
					// Async Rating-Widget initialization.
					window.RW_Async_Init = function() {
						RW.init({
							huid : "136825",
							uid : "5285cf6cc918a8f2fd915a1f33865ccb",
							options : {
								"size" : "medium",
								"type" : "nero",
								"style" : "thumbs"
							},
							source : "website"
						});
						RW.render();
					};

					// Append Rating-Widget JavaScript library.
					var rw, s = d.getElementsByTagName(e)[0], id = "rw-js", p = d.location.protocol, a = ("https:" == p ? "secure."
							+ m + "js/"
							: "js." + m), ck = "Y" + t.getFullYear() + "M"
							+ t.getMonth() + "D" + t.getDate();
					if (d.getElementById(id))
						return;
					rw = d.createElement(e);
					rw.id = id;
					rw.async = true;
					rw.type = "text/javascript";
					rw.src = p + "//" + a + "external.min.js?ck=" + ck;
					s.parentNode.insertBefore(rw, s);
				}(document, new Date(), "script", "rating-widget.com/"));
			</script>
			<div class="rw-ui-container"></div>
		</div>
		<br> <br>
		<!-- AddThis Button BEGIN -->
		<div class="addthis_toolbox addthis_default_style ">
			<a class="addthis_button_facebook_like" fb:like:layout="button_count"></a>
			<a class="addthis_button_tweet"></a> <a
				class="addthis_button_pinterest_pinit" pi:pinit:layout="horizontal"></a>
			<a class="addthis_counter addthis_pill_style"></a>
		</div>
		<script type="text/javascript">
			var addthis_config = {
				"data_track_addressbar" : true
			};
		</script>
		<script type="text/javascript"
			src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-529c28c57dbb303c"></script>
		<!-- AddThis Button END -->
		<table align="left">
			<%
				for (CommentBox comments : usrcomments) {
			%>
			<tr>
				<td><em><%=comments.getCommenter().getUsername()
							.toUpperCase()%></em> says<br> <%=comments.getCommenter_comment()%></td>
			</tr>

			<%
				}
			%>


		</table>

		<%
			} else {
		%>

		<form action="/CommonProject/RedirectBooksdesc" method="post">
			<input type="hidden" name="bookname" value="${bookName}"> <input
				type="submit" name="view comments" value="View Comments">
		</form>

		<%
			}
		%>

		<form action="/CommonProject/AddComments" method="post">
			<input type="hidden" name="bookname" value="${bookName}">
			<textarea rows="5" cols="100" name="commentbox"
				placeholder="Please enter your comments..."></textarea>
			<br> <input type="submit" class="button_example"
				name="AddComment" value="Add Comment">
		</form>

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