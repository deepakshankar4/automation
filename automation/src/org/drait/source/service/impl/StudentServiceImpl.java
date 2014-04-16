/**
 * 
 */
package org.drait.source.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.drait.source.dao.StudentDao;
import org.drait.source.domain.Liveliness;
import org.drait.source.domain.Student;
import org.drait.source.exception.AutomationTransactionException;
import org.drait.source.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DEEPAK
 * 
 */
@Service
public class StudentServiceImpl implements StudentService {

	public static final Logger LOGGER = Logger
			.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> getStudentByFirstName(String fName) {
		List<Student> studentList = studentDao
				.getStudentDetailsByFirstName(fName);
		if (studentList.size() == 0) {
			throw new IllegalArgumentException("No students with name "
					+ StringUtils.remove(fName, "%").toString() + " found!");
		}

		return studentList;
	}

	@Override
	public List<Student> getStudentByLastName(String lName) {
		List<Student> studentList = studentDao
				.getStudentDetailsByLastName(lName);
		if (studentList.size() == 0) {
			throw new IllegalArgumentException("No students with name "
					+ StringUtils.remove(lName, "%").toString() + " found!");
		}

		return studentList;
	}

	@Override
	@Transactional(rollbackFor = AutomationTransactionException.class)
	public Student createNewStudent(Student inputStudent) {

		LOGGER.debug("Trying to create new Student "
				+ inputStudent.getStudentFirstName() + " with USN: "
				+ inputStudent.getUsn());

		Student student = inputStudent;
		student.setStatus(Liveliness.INACTIVE);
		return studentDao.saveAndFlush(student);

	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = studentDao.getAllStudents();
		return students;
	}

	@Override
	public List<Student> getStudentByUsn(String usn) {
		List<Student> students = studentDao.getStudentByUuid(usn);
		return students;
	}

	@Override
	public Student getStudentByUuid(String uuid) {
		Student newStudent = null;
		List<Student> students = studentDao.findOneByUuid(uuid);
		for (Student student : students) {

			newStudent = student;

		}
		return newStudent;
	}

	@Override
	public Student findOne(Student student) {

		return studentDao.findOne(student.getUuid());
	}

	@Override
	@Transactional
	public void softDelete(Student deletingStudent) {

		deletingStudent.setStatus(Liveliness.DELETED);

	}

	@Override
	@Transactional
	public void delete(Student deletingStudent) {

		studentDao.delete(deletingStudent);

	}

	@Override
	@Transactional
	public Student activateStudent(Student activateStudent) {
		activateStudent.setStatus(Liveliness.ALIVE);

		studentDao.saveAndFlush(activateStudent);
		return activateStudent;
	}

}
