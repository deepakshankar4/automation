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
@Table(name = "STUDENT")
public class Student {

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
		this.usn = usn;
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
		this.studentFirstName = studentFirstName;
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
		this.middleInitial = middleInitial;
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
		this.lastName = lastName;
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
		this.guardianName = guardianName;
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
		this.relationWithGuardian = relationWithGuardian;
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
		this.address = address;
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

}
