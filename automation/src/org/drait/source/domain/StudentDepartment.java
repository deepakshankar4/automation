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
@Table(name = "STUDENT_DEPARTMENT")
public class StudentDepartment {

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@GeneratedValue(generator = "UuidIdentifierGenerator")
	@GenericGenerator(name = "UuidIdentifierGenerator", strategy = "org.drait.source.util.uuid.UuidIdentifierGenerator", parameters = {})
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid uuid;

	@Column(name = "STUDENT_UUID")
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid studentUuid;

	@Column(name = "DEPARTMENT_ID")
	@Type(type = "org.drait.source.util.enumtype.EnumUserType", parameters = @Parameter(name = "enumClass", value = "org.drait.source.domain.Department"))
	private Department department;

}
