/**
 * 
 */
package org.drait.source.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.drait.source.domain.Student;
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

/**
 * @author UC167163
 * 
 */
@Controller
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

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
}
