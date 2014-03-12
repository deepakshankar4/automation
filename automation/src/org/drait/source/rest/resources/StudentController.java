/**
 * 
 */
package org.drait.source.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.drait.headers.errorandstatuscodes.StatusCodes;
import org.drait.source.domain.Student;
import org.drait.source.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordnik.swagger.annotations.ApiError;
import com.wordnik.swagger.annotations.ApiErrors;
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

	@RequestMapping(value = "/{studentFirstName}", method = RequestMethod.GET)
	@ApiOperation(value = "Get entity by name", notes = "Search input entity name in the ENTITY table and returns entities starting with the given name")
	@ApiErrors(value = {
			@ApiError(code = StatusCodes.OK, reason = "Success"),
			@ApiError(code = StatusCodes.BAD_REQUEST, reason = "Bad request due to invalid input") })
	public ResponseEntity<List<Student>> getStudentsByFirstName(
			@ApiParam(value = "Student first name", required = true) @RequestParam(value = "studentFirstName", required = true) final String studentFirstName) {
		if (StringUtils.isBlank(studentFirstName)) {
			throw new IllegalArgumentException("invalid input student name");
		}
		List<Student> studentList = new ArrayList<>();
		studentList = studentService.getStudentByFirstName(studentFirstName);

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}

	@RequestMapping(value = "/{studentLastName}", method = RequestMethod.GET)
	@ApiOperation(value = "Get entity by name", notes = "Search input entity name in the ENTITY table and returns entities starting with the given name")
	@ApiErrors(value = {
			@ApiError(code = StatusCodes.OK, reason = "Success"),
			@ApiError(code = StatusCodes.BAD_REQUEST, reason = "Bad request due to invalid input") })
	public ResponseEntity<List<Student>> getStudentsByLastName(
			@ApiParam(value = "Student first name", required = true) @RequestParam(value = "studentLastName", required = true) final String studentLastName) {
		if (StringUtils.isBlank(studentLastName)) {
			throw new IllegalArgumentException("invalid input student name");
		}
		List<Student> studentList = new ArrayList<>();
		studentList = studentService.getStudentByLastName(studentLastName);

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
}
