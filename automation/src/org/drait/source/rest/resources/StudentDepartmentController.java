/**
 * 
 */
package org.drait.source.rest.resources;

import org.drait.source.domain.Liveliness;
import org.drait.source.domain.Student;
import org.drait.source.domain.StudentDepartment;
import org.drait.source.exception.AutomationTransactionException;
import org.drait.source.service.StudentDepartmentService;
import org.drait.source.service.StudentService;
import org.drait.source.util.uuid.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DEEPAK
 * 
 */
@Controller
@RequestMapping(value = "/students/association")
public class StudentDepartmentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentDepartmentService studentDepartmentService;

	@RequestMapping(value = "/add-department", method = RequestMethod.POST)
	public ResponseEntity<StudentDepartment> createStudentDepartmentAssociation(
			@RequestBody final StudentDepartment studentDepartment) {

		StudentDepartment newStudentDepartment;

		// check if the student exists

		Student student = studentService.getStudentByUuid(studentDepartment
				.getStudentUuid().getUuid());

		if (null == student) {

			throw new IllegalArgumentException("No students found!");

		}

		// check the status of student
		if (student.getStatus() == Liveliness.INACTIVE) {
			throw new IllegalArgumentException(
					"cannot create an association with an inactive student! activate student first");
		}

		// check for valid department

		if (null == studentDepartment.getDepartment().getName()) {
			throw new IllegalArgumentException("No such Department");
		}

		// check if the association already exists

		if (null != findOneAssociationAgainstStudent(student)) {
			throw new IllegalArgumentException(
					"cannot create student department association, as "
							+ student.getUsn()
							+ " already present in another association ( "
							+ studentDepartment.getDepartment().getName()
							+ " )");
		}

		try {

			newStudentDepartment = studentDepartmentService
					.createNewAssociation(studentDepartment);

		} catch (DataIntegrityViolationException ex) {

			throw new AutomationTransactionException(
					"cannot create student department association, as "
							+ student.getUsn()
							+ " already present in another association ( "
							+ studentDepartment.getDepartment().getName()
							+ " )", ex);

		}

		return new ResponseEntity<StudentDepartment>(newStudentDepartment,
				HttpStatus.CREATED);
	}

	private StudentDepartment findOneAssociationAgainstStudent(Student student) {

		return studentDepartmentService.findOneAssociation(student);
	}

	private StudentDepartment findOne(Uuid uuid) {

		String studentDepartmentUuid = uuid.getUuid();

		return findOne(studentDepartmentUuid);

	}

	private StudentDepartment findOne(String uuid) {

		return studentDepartmentService.findOne(uuid);

	}

	@RequestMapping(value = "/delete-association", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteStudentDepartmentAssociationByUuid(
			@RequestBody final StudentDepartment studentDepartment) {

		// check if association exists
		StudentDepartment association = findOne(studentDepartment.getUuid());
		if (null == association) {
			throw new IllegalArgumentException("No such association found!");
		}

		studentDepartmentService.deleteAssociation(association);

		return new ResponseEntity<String>("success", HttpStatus.OK);

	}
}
