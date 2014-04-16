/**
 * 
 */
package org.drait.source.dao;

import org.drait.source.domain.StudentDepartment;
import org.drait.source.util.uuid.Uuid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author DEEPAK
 * 
 */
public interface StudentDepartmentDao extends
		JpaRepository<StudentDepartment, Uuid> {

	@Query(value = "SELECT * FROM STUDENT_DEPARTMENT WHERE STUDENT_UUID =?1", nativeQuery = true)
	StudentDepartment findOneStudent(String uuid);

}
