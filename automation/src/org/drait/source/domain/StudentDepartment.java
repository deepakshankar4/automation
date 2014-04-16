/**
 * 
 */
package org.drait.source.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.drait.source.util.uuid.Uuid;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

/**
 * @author DEEPAK
 * 
 */
@Entity
@Table(name = "STUDENT_DEPARTMENT")
public class StudentDepartment implements Serializable {

	/**
	 * generated serial version id
	 */
	private static final long serialVersionUID = 6089412233125578627L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@GeneratedValue(generator = "UuidIdentifierGenerator")
	@GenericGenerator(name = "UuidIdentifierGenerator", strategy = "org.drait.source.util.uuid.UuidIdentifierGenerator", parameters = {})
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid uuid;

	@Column(name = "STUDENT_UUID", unique = true, nullable = false)
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid studentUuid;

	@Column(name = "DEPARTMENT_ID", nullable = false)
	@Type(type = "org.drait.source.util.enumtype.EnumUserType", parameters = @Parameter(name = "enumClass", value = "org.drait.source.domain.Department"))
	private Department department;

	/**
	 * @return the uuid
	 */
	public Uuid getUuid() {
		return uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(Uuid uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the studentUuid
	 */
	public Uuid getStudentUuid() {
		return studentUuid;
	}

	/**
	 * @param studentUuid
	 *            the studentUuid to set
	 */
	public void setStudentUuid(Uuid studentUuid) {
		this.studentUuid = studentUuid;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	protected StudentDepartment() {

	}

	public StudentDepartment(StudentDepartment studentDepartment) {

		this.uuid = studentDepartment.uuid;
		this.studentUuid = studentDepartment.studentUuid;
		this.department = studentDepartment.department;
	}

	public StudentDepartment(Uuid uuid, Uuid studentUuid) {
		this.uuid = uuid;
		this.studentUuid = studentUuid;
	}

}
