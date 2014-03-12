/**
 * 
 */
package org.drait.source.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.drait.headers.errorandstatuscodes.StatusCodes;
import org.drait.source.domain.Student;
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

	private static final String MAXRESULT = "50";

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get entity by name", notes = "Search input entity name in the ENTITY table and returns entities starting with the given name")
	@ApiErrors(value = {
			@ApiError(code = StatusCodes.OK, reason = "Success"),
			@ApiError(code = StatusCodes.BAD_REQUEST, reason = "Bad request due to invalid input") })
	public ResponseEntity<List<Student>> getStudentsByName(
			@ApiParam(value = "Student name", required = true) @RequestParam(value = "studentFirstName", required = true) final String studentName,
			@ApiParam(value = "Maximum number of entities to return.") @RequestParam(value = "count", required = false, defaultValue = MAXRESULT) final int count) {
		if (StringUtils.isBlank(studentName)) {
			throw new IllegalArgumentException("invalid input student name");
		}
		Student s1 = new Student();
		Student s2 = new Student();
		List<Student> studentList = new ArrayList<>();

		studentList.add(s1);
		studentList.add(s2);

		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
	}
}
