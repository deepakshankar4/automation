/**
 * 
 */
var app = angular.module("student", []);

app.controller('getController', function StudentDetailsConttroller($scope,
		$http) {
	$http.get('/automation/students').success(
			function(students, status, headers, config) {
				$scope.students = students;

			});
});

app.controller('createController', function CreateNewStudentController($scope,
		$http) {

	$scope.newStudent = {};
	$scope.newStudent.studentFirstName = '';
	$scope.newStudent.lastName = '';
	$scope.newStudent.usn = '';

	$scope.addStudent = function() {

		$http({
			method : 'POST',
			url : '/automation/students',
			data : $scope.newStudent,
			headers : {
				'Content-Type' : 'application/json'
			}
		}).success(function(data, status, headers, config) {
			$scope.createStatus = 'success';

		}).error(function(data, status, headers, config) {
			$scope.createStatus = 'failure';

		});

		if($scope.createStatus == "success"){
			$scope.errorClass = '';
		}
		else{
			$scope.errorClass = '';
		}
	};
});