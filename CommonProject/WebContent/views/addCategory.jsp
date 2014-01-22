<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Category</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
    </h2>
</head>
<body>

	<div align="center">
		<form action="addcategory" method="post">
			<input type="text" name="genre"
				placeholder="Enter the new genre name"></input><br> <br> <input
				type="submit" name="submit" value="Add Genre"> <input
				type="reset" name="reset" value="Clear">

		</form>
	</div>

</body>
</html>