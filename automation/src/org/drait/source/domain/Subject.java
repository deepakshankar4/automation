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
import org.hibernate.annotations.Type;

/**
 * @author DEEPAK
 * 
 */
@Entity
@Table(name = "SUBJECT")
public class Subject {
	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@GeneratedValue(generator = "UuidIdentifierGenerator")
	@GenericGenerator(name = "UuidIdentifierGenerator", strategy = "org.drait.source.util.uuid.UuidIdentifierGenerator", parameters = {})
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid uuid;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@Column(name = "SUBJECT_CODE")
	private String subjectCode;

	@Column(name = "SUBJECT_CREDITS")
	private float credits;

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
	 * @return the subjectName
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**
	 * @param subjectName
	 *            the subjectName to set
	 */
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	/**
	 * @return the subjectCode
	 */
	public String getSubjectCode() {
		return subjectCode;
	}

	/**
	 * @param subjectCode
	 *            the subjectCode to set
	 */
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	/**
	 * @return the credits
	 */
	public float getCredits() {
		return credits;
	}

	/**
	 * @param credits
	 *            the credits to set
	 */
	public void setCredits(float credits) {
		this.credits = credits;
	}

}
