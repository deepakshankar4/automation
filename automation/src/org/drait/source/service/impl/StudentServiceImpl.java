/**
 * 
 */
package org.drait.source.service.impl;

import java.util.List;

import org.drait.source.dao.StudentDao;
import org.drait.source.domain.Student;
import org.drait.source.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author DEEPAK
 * 
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getStudentByFirstName(String fName) {
		List<Student> studentList = studentDao
				.getStudentDetailsByFirstName(fName);
		if (studentList.size() == 0) {
			throw new IllegalArgumentException("No students with name " + fName
					+ " found!");
		}

		return studentList;
	}

	@Override
	public List<Student> getStudentByLastName(String lName) {
		List<Student> studentList = studentDao
				.getStudentDetailsByLastName(lName);
		if (studentList.size() == 0) {
			throw new IllegalArgumentException("No students with name " + lName
					+ " found!");
		}

		return studentList;
	}

}
