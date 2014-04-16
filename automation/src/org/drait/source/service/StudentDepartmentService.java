/**
 * 
 */
package org.drait.source.service;

import org.drait.source.domain.Student;
import org.drait.source.domain.StudentDepartment;

/**
 * @author UC167163
 * 
 */
public interface StudentDepartmentService {

	StudentDepartment createNewAssociation(StudentDepartment studentDepartment);
	
	StudentDepartment findOneAssociation(Student student);

	StudentDepartment findOne(String uuid);

	void deleteAssociation(StudentDepartment association);

	void deleteAssociation(Student deletingStudent);

	
}
