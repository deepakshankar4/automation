<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
</head>
<body background="resources/background.jpg">
	<div align="justify">

		<form action="PublisherRegister" method="POST">

			Enter Publisher name<br>
			<input type="text" name="pubname"> <br />
			<br> Enter Owner name<br>
			<input type="text" name="ownname"> <br />
			<br> Enter password for publisher<br>
			<input type="password" name="password" /> <br>
			<br>


			<script type="text/javascript"
				src="http://www.google.com/recaptcha/api/challenge?k=6LcdmegSAAAAACraLemZ3ApiWKz79gwyacZK_AhT">
				
			</script>
			<noscript>
				<iframe
					src="http://www.google.com/recaptcha/api/noscript?k=6LcdmegSAAAAACraLemZ3ApiWKz79gwyacZK_AhT"
					height="300" width="500"></iframe>
				<br>
				<textarea name="recaptcha_challenge_field" rows="3" cols="40">
     </textarea>
				<input type="hidden" name="recaptcha_response_field"
					value="manual_challenge">
			</noscript>
			<br>
			<br> <input type="submit" value="Submit" />

		</form>
	</div>

</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>