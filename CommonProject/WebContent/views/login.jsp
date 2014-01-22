<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Login Page For Security</title>
<h2 align="center">
<header>
        <jsp:include page="header.jsp"/>
    </header>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<link type="text/css"
	href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" />


</head>
<body bgcolor="#ffEEEE" onload='document.f.j_username.focus();'>

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<fieldset>
					<!--  <legend>Bootstrap Form With Spring Mvc Example</legend> -->

					<h3>Login with Username and Password</h3>

					<c:if test="${not empty error}">
						<div class="errorblock">Your login attempt was not
							successful, try again. Caused :
							${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</div>
					</c:if>

					<form name='f' action="<c:url value='j_spring_security_check' />"
						method='POST'>

						<table>
							<tr>
								<td>User:</td>
								<td><input type='text' name='j_username' value=''></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type='password' name='j_password' /></td>
							</tr>
							<tr>
								<td><div class="form-actions">
										<button type="submit" class="btn btn-success" btn-lg>SUBMIT</button>
									</div></td>

								<!--  <td colspan='2'><input name="submit" type="submit"
					value="submit" class="btn btn-success" /></td> -->

							</tr>
							<tr>
								<td colspan='2'><input name="reset" type="reset" /></td>
							</tr>
						</table>


					</form>
				</fieldset>
			</div>
		</div>
	</div>
</body>
<br><br><br><br><br></body>
</br></br></br></br></br></br>
<footer>
        <jsp:include page="footer.jsp"/>
    </footer>
</html>
