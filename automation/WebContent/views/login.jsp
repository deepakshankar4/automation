<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html ">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/automation/non-secure-content/css/login.css"
	rel="stylesheet">
<script type="text/javascript"
	src="/automation/non-secure-content/js/login.js"></script>



<title>Login page</title>
</head>
<body>

	<%
		out.println(session.isNew());
		if (session.isNew())
			response.sendRedirect("/automation/");
	%>

	<div class="container">

		<div class="row" style="margin-top: 20px">


			<br> <br> <img class="pull-left" height="200" width="160"
				src="/automation/non-secure-content/images/LOGO.jpg" alt='' /></a>



			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">

				<form role="form" action="/automation/login" , method="post">
					<fieldset>
						<%-- <div th:if="${param.error }" class="alert alert-danger">Invalid
							username or password</div> --%>

						<h2 class="text-success">Please Sign In</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="email" name="username" id="username"
								class="form-control input-lg" placeholder="Email Address">
						</div>
						<div class="form-group">
							<input type="password" name="password" id="password"
								class="form-control input-lg" placeholder="Password">
						</div>
						<span class="button-checkbox"> <a href=""
							class="btn btn-link pull-right">Forgot Password?</a><br>
						</span>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">

								<%-- <input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" /> --%>
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="Sign In">
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<a href="" class="btn btn-lg btn-primary btn-block">Register</a>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>