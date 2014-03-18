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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.drait.source.util.uuid.Uuid;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 * @author DEEPAK
 * 
 */
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

	/**
	 * Generated Serial version ID
	 */
	private static final long serialVersionUID = 4681287195328930320L;

	@Id
	@Column(name = "UUID", unique = true, nullable = false)
	@GeneratedValue(generator = "UuidIdentifierGenerator")
	@GenericGenerator(name = "UuidIdentifierGenerator", strategy = "org.drait.source.util.uuid.UuidIdentifierGenerator", parameters = {})
	@Type(type = "org.drait.source.util.uuid.UuidUserType")
	private Uuid uuid;

	@Column(name = "USN", nullable = false, unique = true)
	private String usn;

	@Column(name = "FIRST_NAME", nullable = false)
	private String studentFirstName;

	@Column(name = "MIDDLE_INITIAL", nullable = true)
	private Character middleInitial;

	@Column(name = "LAST_NAME", nullable = true)
	private String lastName;

	@Column(name = "GUARDIAN_NAME")
	private String guardianName;

	@Column(name = "RELATION_WITH_GUARDIAN")
	private String relationWithGuardian;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE_ADDRESS")
	private int phoneNumber;

	@Column(name = "EMAIL")
	private String email;

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
	 * @return the usn
	 */
	public String getUsn() {
		return usn;
	}

	/**
	 * @param usn
	 *            the usn to set
	 */
	public void setUsn(String usn) {
		this.usn = usn.toUpperCase();
	}

	/**
	 * @return the studentFirstName
	 */
	public String getStudentFirstName() {
		return studentFirstName;
	}

	/**
	 * @param studentFirstName
	 *            the studentFirstName to set
	 */
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName.toUpperCase();
	}

	/**
	 * @return the middleInitial
	 */
	public Character getMiddleInitial() {
		return middleInitial;
	}

	/**
	 * @param middleInitial
	 *            the middleInitial to set
	 */
	public void setMiddleInitial(Character middleInitial) {
		this.middleInitial = Character.toUpperCase(middleInitial);
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName.toUpperCase();
	}

	/**
	 * @return the guardianName
	 */
	public String getGuardianName() {
		return guardianName;
	}

	/**
	 * @param guardianName
	 *            the guardianName to set
	 */
	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName.toUpperCase();
	}

	/**
	 * @return the relationWithGuardian
	 */
	public String getRelationWithGuardian() {
		return relationWithGuardian;
	}

	/**
	 * @param relationWithGuardian
	 *            the relationWithGuardian to set
	 */
	public void setRelationWithGuardian(String relationWithGuardian) {
		this.relationWithGuardian = relationWithGuardian.toUpperCase();
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address.toUpperCase();
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	protected Student() {

	}

	public Student(Student inputStudent) {
		this.address = inputStudent.address;
		this.email = inputStudent.email;
		this.guardianName = inputStudent.guardianName;
		this.lastName = inputStudent.lastName.toUpperCase();

		if (null != inputStudent.middleInitial)
			this.middleInitial = Character
					.toUpperCase(inputStudent.middleInitial);
		this.phoneNumber = inputStudent.phoneNumber;
		this.relationWithGuardian = inputStudent.relationWithGuardian;
		this.studentFirstName = inputStudent.studentFirstName.toUpperCase();
		this.usn = inputStudent.usn.toUpperCase();
	}

	public Student(final String usn, final String firstName,
			final String lastName) {
		this.usn = usn.toUpperCase();
		this.studentFirstName = firstName.toUpperCase();
		this.lastName = lastName.toUpperCase();
	}

	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.append(uuid);

		return hashCodeBuilder.toHashCode();

	}

	@Override
	public boolean equals(final Object object) {

		boolean result = false;

		if (object instanceof Student) {
			final Student other = (Student) object;

			EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder.append(uuid, other.uuid);
			equalsBuilder.append(usn, other.usn);

			result = equalsBuilder.isEquals();

		}

		return result;
	}

	@Override
	public String toString() {

		ToStringBuilder toStringBuilder = new ToStringBuilder(this);
		toStringBuilder.append("Student First Name", studentFirstName);
		toStringBuilder.append("Student Middle Initial", middleInitial);
		toStringBuilder.append("Student Last Name", lastName);
		toStringBuilder.append("Student USN", usn);
		toStringBuilder.append("uuid of tthe student object", uuid);

		return toStringBuilder.toString();
	}
}
