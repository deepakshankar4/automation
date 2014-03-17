/**
 * 
 */
package org.drait.source.dao;

import java.util.List;

import org.drait.source.domain.Student;
import org.drait.source.util.uuid.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 
 * @author DEEPAK
 * 
 */

public interface StudentDao extends JpaRepository<Student, Uuid> {

	/**
	 * 
	 * @param fname
	 * @return list of students having first name like the specified fname
	 */
	@Query(value = "SELECT * FROM STUDENT WHERE FIRST_NAME LIKE ?1", nativeQuery = true)
	List<Student> getStudentDetailsByFirstName(String fname);

	/**
	 * 
	 * @param lname
	 * @return list of students having last name like the specified lname
	 */
	@Query(value = "SELECT * FROM STUDENT WHERE LAST_NAME LIKE ?1", nativeQuery = true)
	List<Student> getStudentDetailsByLastName(String lname);

	@Query(value = "SELECT * FROM STUDENT", nativeQuery = true)
	List<Student> getAllStudents();
}
