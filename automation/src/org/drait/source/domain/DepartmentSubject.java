/**
 * 
 */
package org.drait.source.domain;

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
@Table(name = "DEPARTMENT_SUBJECT")
public class DepartmentSubject {

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@GeneratedValue(generator = "UuidIdentifierGenerator")
	@GenericGenerator(name = "UuidIdentifierGenerator", strategy = "org.drait.source.util.uuid.UuidIdentifierGenerator", parameters = {})
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid uuid;

	@Column(name = "DEPARTMENT_ID", nullable = false)
	@Type(type = "org.drait.source.util.enumtype.EnumUserType", parameters = @Parameter(name = "enumClass", value = "org.drait.source.domain.Department"))
	private Department department;

	@Column(name = "SUBJECT_UUID")
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid subjectUuid;

	/**
	 * @return the uuid
	 */
	public Uuid getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(Uuid uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @return the subjectUuid
	 */
	public Uuid getSubjectUuid() {
		return subjectUuid;
	}

	/**
	 * @param subjectUuid the subjectUuid to set
	 */
	public void setSubjectUuid(Uuid subjectUuid) {
		this.subjectUuid = subjectUuid;
	}

}
