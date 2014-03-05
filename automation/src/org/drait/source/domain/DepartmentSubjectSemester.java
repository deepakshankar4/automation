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
@Table(name = "DEPARTMENT_SUBJECT_SEMESTER")
public class DepartmentSubjectSemester {

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@GeneratedValue(generator = "UuidIdentifierGenerator")
	@GenericGenerator(name = "UuidIdentifierGenerator", strategy = "org.drait.source.util.uuid.UuidIdentifierGenerator", parameters = {})
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid uuid;

	@Column(name = "DEPARTMENT_SUBJECT")
	private Uuid departmentSubjectUuid;

	@Column(name = "SEMESTER")
	@Type(type = "org.drait.source.util.enumtype.EnumUserType", parameters = @Parameter(name = "enumClass", value = "org.drait.source.domain.Semester"))
	private Semester semester;

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
	 * @return the departmentSubjectUuid
	 */
	public Uuid getDepartmentSubjectUuid() {
		return departmentSubjectUuid;
	}

	/**
	 * @param departmentSubjectUuid the departmentSubjectUuid to set
	 */
	public void setDepartmentSubjectUuid(Uuid departmentSubjectUuid) {
		this.departmentSubjectUuid = departmentSubjectUuid;
	}

	/**
	 * @return the semester
	 */
	public Semester getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(Semester semester) {
		this.semester = semester;
	}

}
