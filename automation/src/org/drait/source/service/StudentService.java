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

}
