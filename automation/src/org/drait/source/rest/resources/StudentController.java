/**
 * 
 */
package org.drait.source.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.drait.headers.errorandstatuscodes.StatusCodes;
import org.drait.source.domain.Liveliness;
import org.drait.source.domain.Student;
import org.drait.source.exception.AutomationBusinessException;
import org.drait.source.service.StudentDepartmentService;
import org.drait.source.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author DEEPAK
 * 
 */
@Controller
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentDepartmentService studentDepartmentService;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get all students from STUDENT table", notes = "fetch all the student records from the STUDENT table.")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = new ArrayList<>();
		students = studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}

	@RequestMapping(value = "/{studentFirstName}", method = RequestMethod.GET)
	@ApiOperation(value = "Get student list by first name", notes = "Search input student first name in the STUDENT table and returns student names having the given first name")
	public ResponseEntity<List<Student>> getStudentsByFirstName(
			@ApiParam(value = "Student first name", required = true) @RequestParam(value = "studentFirstName", required = true) final String studentFirstName) {
		if (StringUtils.isBlank(studentFirstName)) {
			throw new IllegalArgumentException("invalid input student name");
		}
		List<Student> studentList = new ArrayList<>();
		studentList = studentService.getStudentByFirstName("%"
				+ studentFirstName.toUpperCase() + "%");

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{studentLastName}", method = RequestMethod.GET)
	@ApiOperation(value = "Get student list by last name", notes = "Search input student last name in the STUDENT table and returns student names having the given last name")
	public ResponseEntity<List<Student>> getStudentsByLastName(
			@ApiParam(value = "Student last name", required = true) @RequestParam(value = "studentLastName", required = true) final String studentLastName) {
		if (StringUtils.isBlank(studentLastName)) {
			throw new IllegalArgumentException("invalid input student name");
		}
		List<Student> studentList = new ArrayList<>();
		studentList = studentService.getStudentByLastName("%"
				+ studentLastName.toUpperCase() + "%");

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Student", notes = "new student is added to the STUDENT table.")
	public ResponseEntity<Student> addStudent(@RequestBody final Student student) {
		Student newStudent = null;

		try {
			newStudent = studentService.createNewStudent(student);

		} catch (DataIntegrityViolationException ex) {
			List<Student> studentList = studentService.getStudentByUsn(student
					.getUsn());
			for (Student students : studentList) {
				students = studentList.get(0);
				newStudent = students;
			}

			return new ResponseEntity<Student>(newStudent, HttpStatus.OK);

		}
		return new ResponseEntity<Student>(newStudent, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Student operation", notes = "perform a soft delete on an existing student.")
	@ApiResponses(value = {
			@ApiResponse(code = StatusCodes.OK, message = "successful delete"),
			@ApiResponse(code = StatusCodes.BAD_REQUEST, message = "Could not perform the operation") })
	public ResponseEntity<String> deleteStudent(
			@RequestBody final Student student)
			throws AutomationBusinessException {

		// check if student exists
		Student deletingStudent = studentService.findOne(student);

		if (null == deletingStudent) {
			throw new IllegalArgumentException("Not a valid Student component");
		}

		if (deletingStudent.getStatus() == Liveliness.INACTIVE) {
			studentService.delete(deletingStudent);
			return new ResponseEntity<String>("delete successful",
					HttpStatus.OK);
		}
		// delete the association with department against the student

		try {

			studentDepartmentService.deleteAssociation(deletingStudent);

		} catch (Exception ex) {
			throw new AutomationBusinessException(
					"Could not perform the operation", ex);
		}

		try {
			studentService.softDelete(deletingStudent);
		} catch (Exception ex) {

			throw new AutomationBusinessException(
					"Could not perform the operation", ex);
		}

		return new ResponseEntity<String>("success", HttpStatus.OK);

	}

	@RequestMapping(value = "/activate", method = RequestMethod.PUT)
	@ApiOperation(value = "Activate Student operation", notes = "perform activation on inactive student component.")
	@ApiResponses(value = {
			@ApiResponse(code = StatusCodes.OK, message = "successful activation"),
			@ApiResponse(code = StatusCodes.BAD_REQUEST, message = "Could not perform the operation") })
	public ResponseEntity<Student> activateStudent(
			@RequestBody final Student student)
			throws AutomationBusinessException {
		Student activateStudent;

		/* check for valid student component */

		activateStudent = studentService.findOne(student);
		if (null == activateStudent) {
			throw new IllegalArgumentException(
					"Invalid student component detected!");
		}

		/*
		 * check the validity of student status. allow only inactive student
		 * component for activation
		 */

		if (activateStudent.getStatus() != Liveliness.INACTIVE) {
			throw new IllegalArgumentException(
					"not a valid student component for activation! confirm student component first");

		}

		try {

			activateStudent = studentService.activateStudent(activateStudent);
		} catch (Exception ex) {
			throw new AutomationBusinessException("Could not perform action!",
					ex);
		}
		return new ResponseEntity<Student>(activateStudent, HttpStatus.OK);
	}
}
