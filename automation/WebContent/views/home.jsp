<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:tiles="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>HOME</title>

</head>
<body>
	<nav class="navbar navbar-default navbar-static-top" role="navigation">
		<div class="button">
			<a href="/automation/" class="navbar-brand"><span
				class="glyphicon glyphicon-home"></span> Automation home</a>
		</div>

		<div class="navbar-right">
			<ol class="breadcrumb">
				<li class="active">Home</li>

				<li><a href="/automation/documentation/">Documentation</a></li>
			</ol>
			<form action="/automation/logout" method="get">
				<button type="submit" class="btn btn-warning">Logout</button>
			</form>
		</div>
	</nav>

	<div class="container">
		<div class="well">
			<div class="row">
				<div class="span12">
					<h2>Resources!</h2>
					<hr>
					<h3>
						<a href="/automation/documentation/"> API <small>Documentation</small></a>
					</h3>
					<h3>
						<a href="/automation/application/automation-ui/"> User
							Interface <small>alpha</small>
						</a>
					</h3>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->

	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

</body>
</html>