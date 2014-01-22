<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register urself</title>
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
<body style="background-position: center;">
	<div class="divstyle" style="background-position: center;"
		align="justify">
		<script>
			function validate() {
				var x = document.forms["regform"]["username"].value;
				var y = document.forms["regform"]["password"].value;
				var z = document.forms["regform"]["email"].value;

				if (x == null || x == "" && y == null || y == "" && z == null
						|| z == "") {
					alert("incomplete data!!!!");
					return false;
				}
			}
		</script>

		<form name="regform" action="ManageUser" onsubmit="return validate()"
			method="POST">


			Enter user name<br> <input type="text" name="username">
			<br /> <br> Enter password<br> <input type="password"
				name="password"> <br> <br>please enter email<br>
			<input type="email" name="email"> <br> <br> enter
			the email id of the person who referred you<br> <input
				type="email" name="referrer" placeholder="who referred you?">
			<br> <br>
			<%
				if (request.getAttribute("info") == "invalid captcha!!!") {
			%>
			<input style="font-family: cursive; background-color: red;" id="info"
				name="info" type="text" border="0" value="invalid captcha!!!"
				readonly="readonly">
			<%
				}
			%>


			<script type="text/javascript"
				src="http://www.google.com/recaptcha/api/challenge?k=6LcdmegSAAAAACraLemZ3ApiWKz79gwyacZK_AhT">
				
			</script>
			<noscript>
				<iframe
					src="http://www.google.com/recaptcha/api/noscript?k=6LcdmegSAAAAACraLemZ3ApiWKz79gwyacZK_AhT"
					height="300" width="500" frameborder="0"></iframe>

				<br>

				<textarea name="recaptcha_challenge_field" rows="3" cols="40">
     </textarea>
				<input type="hidden" name="recaptcha_response_field"
					value="manual_challenge">

			</noscript>
			<br> <br> <input type="submit" value="Submit" />


		</form>
	</div>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>