/**
 * 
 */
package org.drait.source.service;

import java.util.List;

import org.drait.source.domain.Student;

/**
 * @author DEEPAK
 * 
 */
public interface StudentService {

	List<Student> getStudentByFirstName(String fName);

	List<Student> getStudentByLastName(String lName);

	Student createNewStudent(Student inputStudent);

	List<Student> getAllStudents();

	List<Student> getStudentByUsn(String usn);
	
	Student getStudentByUuid(String uuid);

	Student findOne(Student student);

	void softDelete(Student deletingStudent);

	void delete(Student deletingStudent);

	Student activateStudent(Student activateStudent);

}
