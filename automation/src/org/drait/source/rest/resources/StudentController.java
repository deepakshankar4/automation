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

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

/**
 * @author UC167163
 * 
 */
@Controller
@RequestMapping(value = "/students")
public class StudentController {

	private static final String MAXRESULT = "50";

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get students by name", notes = "Search input student name in the STUDENT table and returns students starting with the given name.", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = StatusCodes.OK, message = "SUCCESS"),
			@ApiResponse(code = StatusCodes.BAD_REQUEST, message = "Invalid input type student name"),
			@ApiResponse(code = StatusCodes.NO_CONTENT, message = "Please provide a inputt student name") })
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
