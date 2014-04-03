<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html ng-app="student">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css"
	rel="stylesheet">

<title>View Student Details</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
		<div class="button">
			<a href="/automation/" class="navbar-brand"><span
				class="glyphicon glyphicon-home"></span> Automation home</a>
		</div>
		<div class="navbar-right">
			<ol class="breadcrumb">
				<li><a href="/automation/">Home</a></li>

				<li class="active">Documentation</li>
			</ol>
		</div>
	</nav>

	<h2>Create new student</h2>
	<!-- Button trigger modal -->
	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#createStudentModal">Create new student</button>

	<!-- Modal -->
	<div class="modal fade" id="createStudentModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="createStudentModalLabel">Please enter the
						student details</h4>
				</div>
				<div class="modal-body">

					<form role="form" ng-submit="addStudent()"
						ng-controller="createController">

						<div class="form-group">
							<input type="text" class="form-control"
								ng-model='newStudent.studentFirstName'
								placeholder="enter first name">
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								ng-model='newStudent.lastName' placeholder="enter last name">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" ng-model='newStudent.usn'
								placeholder="enter USN">
						</div>
						<div class="form-group">
							<input type="submit" id="submit" value="Submit"
								class="btn btn-primary"></input>
						</div>

					</form>

				</div>

			</div>
		</div>
	</div>
	<div class="container">
		<div ng-controller="getController">

			<div class="well">
				<div class="row">
					<div class="well" ng-repeat="student in students">
						<span>Student Name: {{student.studentFirstName}}</span><br> <span>Student
							USN: {{student.usn}}</span><br> <span>Student UUID:
							{{student.uuid.uuid}}</span>
					</div>
				</div>
			</div>

		</div>

	</div>

	<script src="https://code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="/automation/automationUI/assets/js/angular.min.js"></script>
	<script type="text/javascript"
		src="/automation/automationUI/assets/js/controllers.js"></script>
</body>
</html>