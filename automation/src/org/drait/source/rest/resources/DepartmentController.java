/**
 * 
 */
package org.drait.source.rest.resources;

import org.drait.source.domain.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DEEPAK
 * 
 */
@Controller
@RequestMapping(value = "/departments")
public class DepartmentController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Department[]> getAllDepartments() {

		Department[] department = Department.values();

		return new ResponseEntity<Department[]>(department, HttpStatus.OK);

	}
}
