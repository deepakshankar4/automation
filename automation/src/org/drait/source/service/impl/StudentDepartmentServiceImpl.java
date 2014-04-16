/**
 * 
 */
package org.drait.source.service.impl;

import org.drait.source.dao.StudentDepartmentDao;
import org.drait.source.domain.Student;
import org.drait.source.domain.StudentDepartment;
import org.drait.source.exception.AutomationTransactionException;
import org.drait.source.service.StudentDepartmentService;
import org.drait.source.util.uuid.Uuid;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author DEEPAK
 * 
 */
@Service
public class StudentDepartmentServiceImpl implements StudentDepartmentService {

	@Autowired
	private StudentDepartmentDao studentDepartmentDao;

	/*
	 * 
	 * 
	 * @see
	 * org.drait.source.service.StudentDepartmentService#createNewAssociation
	 * (org.drait.source.domain.StudentDepartment)
	 */
	@Override
	@Transactional(rollbackFor = AutomationTransactionException.class)
	public StudentDepartment createNewAssociation(
			StudentDepartment studentDepartment) {
		return studentDepartmentDao.saveAndFlush(studentDepartment);
	}

	@Override
	public StudentDepartment findOneAssociation(Student student) {
		return studentDepartmentDao.findOneStudent(student.getUuid().getUuid());

	}

	@Override
	public StudentDepartment findOne(String uuid) {
		// TODO Auto-generated method stub
		return studentDepartmentDao.findOne(new Uuid(uuid));
	}

	@Override
	@Transactional(rollbackFor = { DataIntegrityViolationException.class,
			AutomationTransactionException.class, HibernateException.class })
	public void deleteAssociation(StudentDepartment association) {

		studentDepartmentDao.delete(association);

	}

	@Override
	@Transactional(rollbackFor = { DataIntegrityViolationException.class,
			AutomationTransactionException.class, HibernateException.class })
	public void deleteAssociation(Student deletingStudent) {

		StudentDepartment studentDepartment = findOneAssociation(deletingStudent);
		if (null == studentDepartment) {
			throw new IllegalArgumentException(
					"no association found for the specified student");
		}
		deleteAssociation(studentDepartment);

	}

}
